package com.indigo.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.indigo.model.Flight;
import com.indigo.repository.FlightRepository;

@Service
public class NotificationService {

    
    private final FlightRepository flightRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "flight-status";
    private LocalDateTime lastCheckedTime = LocalDateTime.now().minusMinutes(30);

    @Autowired
    public NotificationService(FlightRepository flightRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.flightRepository = flightRepository;
        this.kafkaTemplate = kafkaTemplate;
    }



    @Scheduled(fixedRate = 60000)
    private void sendNotificationsForUpdatedFlights() {
    	System.out.println("Message Produce 1");
        List<Flight> updatedFlights = flightRepository.findUpdatedFlights(lastCheckedTime);
        for (Flight flight : updatedFlights) {
            String message = "Flight " + flight.getFlightNumber() + " status changed to " + flight.getStatus() ;
            kafkaTemplate.send(TOPIC, message);
            String sendEmailNotification = sendEmailNotification(flight);
            System.out.println(sendEmailNotification);
            String sendTextMessageNotification = sendTextMessageNotification(flight);
            System.out.println(sendTextMessageNotification);
        }
        lastCheckedTime = LocalDateTime.now();
    }
    
    public String sendEmailNotification(Flight flight) {	
    	//Write code for send Email Notification
    	return "Email : Flight "+flight.getFlightNumber() + "status changed to "+ flight.getStatus();	
    }
    
    public String sendTextMessageNotification(Flight flight) {
    	//Write Code for Send Text Message Notification 
    	return "Text Message : Flight "+flight.getFlightNumber() + "status changed to "+ flight.getStatus();
    }
    
  
}
