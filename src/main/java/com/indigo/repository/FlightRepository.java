package com.indigo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.indigo.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	 @Query("SELECT f FROM Flight f WHERE f.lastUpdated > :time")
	 List<Flight> findUpdatedFlights(@Param("time") LocalDateTime time);
	 
	 Flight findByFlightNumber(String flightNumber);
}
