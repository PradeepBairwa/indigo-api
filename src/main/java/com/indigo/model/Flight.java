package com.indigo.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity 
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	
	private String flightNumber;
	private String airline;
	private String departureAirport;
	private String arrivalAirport;
	private String scheduledDeparture;
	private String estimatedDeparture;
	private String scheduledArrival;
	private String estimatedArrival;
	private String status;
	private String gate;
	private int terminal;
	private LocalDateTime lastUpdated;
	
	@PrePersist
    @PreUpdate
    public void prePersistOrUpdate() {
        this.lastUpdated = LocalDateTime.now();
    }
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public String getScheduledDeparture() {
		return scheduledDeparture;
	}
	public void setScheduledDeparture(String scheduledDeparture) {
		this.scheduledDeparture = scheduledDeparture;
	}
	public String getEstimatedDeparture() {
		return estimatedDeparture;
	}
	public void setEstimatedDeparture(String estimatedDeparture) {
		this.estimatedDeparture = estimatedDeparture;
	}
	public String getScheduledArrival() {
		return scheduledArrival;
	}
	public void setScheduledArrival(String scheduledArrival) {
		this.scheduledArrival = scheduledArrival;
	}
	public String getEstimatedArrival() {
		return estimatedArrival;
	}
	public void setEstimatedArrival(String estimatedArrival) {
		this.estimatedArrival = estimatedArrival;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public int getTerminal() {
		return terminal;
	}
	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}
	
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	public Flight(String flightNumber, String airline, String departureAirport, String arrivalAirport,
			String scheduledDeparture, String estimatedDeparture, String scheduledArrival, String estimatedArrival,
			String status, String gate, int terminal, LocalDateTime lastUpdated) {
		super();
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.scheduledDeparture = scheduledDeparture;
		this.estimatedDeparture = estimatedDeparture;
		this.scheduledArrival = scheduledArrival;
		this.estimatedArrival = estimatedArrival;
		this.status = status;
		this.gate = gate;
		this.terminal = terminal;
		this.lastUpdated = lastUpdated;
	}
	
	
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", airline=" + airline + ", departureAirport="
				+ departureAirport + ", arrivalAirport=" + arrivalAirport + ", scheduledDeparture=" + scheduledDeparture
				+ ", estimatedDeparture=" + estimatedDeparture + ", scheduledArrival=" + scheduledArrival
				+ ", estimatedArrival=" + estimatedArrival + ", status=" + status + ", gate=" + gate + ", terminal="
				+ terminal + ", lastUpdated=" + lastUpdated + "]";
	}
	public Flight() {
		
	}
	}
