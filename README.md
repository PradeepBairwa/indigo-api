# Air IndiGo Flight Data and Notification Service

## Overview

This project consists of two primary services:
- **Flight Data Service**: Pulls data from airport systems, processes updates (such as delays, cancellations, and gate changes), and stores the processed data in the database  PostgreSQL.
- **Notification Service**: Monitors flight data for changes, triggers notifications on status changes, and uses Kafka to handle message queues for notifications.

## Features

- Real-time flight data updates
- Notification service for flight status changes
- Integration with airport systems
- Efficient message queue handling using Kafka 
- Storage support for   PostgreSQL

## Libraries Used

### Backend (Java)
- **Spring Boot**: Application framework
- **Spring Data JPA**: Database interactions
- **Spring Kafka / RabbitMQ**: Messaging
- **Lombok**: Reducing boilerplate code
- **Jackson**: JSON processing

### Frontend (React)
- **React**: JavaScript library for building user interfaces
- **Material-UI (MUI)**: React components for faster and easier web development
- **Axios**: HTTP client for making requests
- **React Router**: Navigation
- **sockjs-client**: Websocket
- **@stomp/stompjs**: Websocket

## Technologies Used

- **Backend**: Java
- **Message Queue**: Kafka 
- **Database**:   PostgreSQL
- **Frontend**: React with Material-UI (MUI)


## Setup and Installation

### Prerequisites

- Java 11+
- Node.js and npm
- PostgreSQL
- Kafka

### Clone the Repository

```bash
git clone https://github.com/PradeepBairwa/indigo-api
cd AirIndiGo
