# 🚗 Ride-Sharing App (LLD)

This project is a **Low-Level Design (LLD)** implementation of a scalable, extensible **Ride-Sharing Application** (like Uber/Ola) built using **Java**, following **SOLID principles** and leveraging **core design patterns** such as:

- Strategy Pattern (Fare Calculation & Payments)
- Observer Pattern (Ride Status Notifications)
- Mediator Pattern (Ride Coordination)

---

## 📌 Problem Statement

Design and implement a ride-sharing platform where:

- Passengers can request rides.
- Drivers are matched based on proximity and vehicle type.
- The system supports various vehicle types and fare calculation strategies.
- Both driver and passenger receive notifications as the ride progresses.

---

## ✅ Features

### 🚕 Ride Booking
- Matches nearest available driver with same vehicle type
- Allows custom pickup and destination locations

### 🚘 Vehicle Types
- Car
- Bike
- Premium Sedan
- *(Easily extensible to add more types)*

### 💰 Fare Strategies
- Standard
- Shared
- Premium
- Fare is calculated based on `VehicleType` and `Distance`.

### 🔔 Notifications
- Notifies both **passenger** and **driver** on:
  - Ride Started
  - Ride Completed

### 💳 Payments
- Supports:
  - Credit Card
  - Debit Card
  - UPI (Strategy Pattern)

---

## 🔧 Tech Stack

| Layer              | Description                                    |
|-------------------|------------------------------------------------|
| Java (OOP)         | Core language for design                      |
| Design Patterns    | Strategy, Observer, Mediator                  |
| SOLID Principles   | Scalable and maintainable architecture        |
| Command-Line       | Console inputs for driver info      |

---
