package com.indigo.service;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.indigo.model.Flight;
import com.indigo.repository.FlightRepository;

@Service
public class FlightDataService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RestTemplate restTemplate;

//    private final String airportSystemUrl = "http://mock-airport-system.com/api/flights";
    private final String airportSystemUrl = "http://localhost:8080/flights/getDummyData";
    
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        fetchFlightData();
    }

//    @PostConstruct
    public void fetchFlightData() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String response = restTemplate.getForObject(airportSystemUrl, String.class);
                processFlightData(response);
            }
        }, 0, 300000); // Fetch data every minute
    }

    private void processFlightData(String responseData) {
        // Parse the response and process updates
        // Example: Parse JSON response, identify updates, and store in DB
        List<Flight> flights = parseResponse(responseData);
        flightRepository.saveAll(flights);
    }

    private List<Flight> parseResponse(String response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Create a CollectionType for List<Flight>
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Flight.class);
            // Parse JSON response to a list of Flight objects
            return objectMapper.readValue(response, listType);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately, maybe return an empty list or rethrow it
            return Collections.emptyList();
        }
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    
    public List<Flight> getDummyFlights() {
    	Flight f1= new Flight("AA124", "American Airlines", "Delhi", "LAX", "2024-07-25T10:00:00Z", "2024-07-25T10:15:00Z", "2024-07-25T13:00:00Z", "2024-07-25T13:30:00Z", "Delayed", "22A", 5, null);
    	Flight f2= new Flight("AA124", "American Airlines", "Mumbai", "LAX", "2024-07-25T10:00:00Z", "2024-07-25T10:15:00Z", "2024-07-25T13:00:00Z", "2024-07-25T13:30:00Z", "Delayed", "22A", 5, null);
        List<Flight> list = new ArrayList();
        list.add(f1);
        list.add(f2);
    	return list;
    }
    
    public Flight updateFlightDetails(Flight flightObj ) {
     	Flight flight = flightRepository.findByFlightNumber(flightObj.getFlightNumber());
     	flight.setStatus(flightObj.getStatus());
     	return flightRepository.save(flight);
    	
    }
    
    public List<Flight> saveData(List<Flight> list) {
    	
    		return 	flightRepository.saveAll(list);
  	
    }
}
