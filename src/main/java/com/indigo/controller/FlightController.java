package com.indigo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indigo.model.Flight;
import com.indigo.service.FlightDataService;
import com.indigo.service.FlightStatusConsumerService;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*")
public class FlightController {

    @Autowired
    private FlightDataService flightDataService;
    
    @Autowired
    private FlightStatusConsumerService consumerService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightDataService.getAllFlights();
    }
    
    @GetMapping("/getDummyData")
    public List<Flight> getDummyFlights() {
        return flightDataService.getDummyFlights();
    }
    
    
    @PostMapping("/add")
    public List<Flight> saveData(@RequestBody List<Flight> list) {
    	
    	return flightDataService.saveData(list);
    }
    
    @PutMapping("/update")
    public Flight saveData(@RequestBody Flight flightObj) {
    	
    	return flightDataService.updateFlightDetails(flightObj);
    }
    

    @GetMapping("/api/latest-flight-status")
    public String getLatestFlightStatus() {
        return consumerService.getLatestMessage();
    }
    
}

