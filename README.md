# Online Food Ordering Application

A full-stack Online Food Ordering System built using React.js (Frontend) and Spring Boot (Backend).
This application allows customers to browse food items, add them to the cart, and place orders.
Admins can manage menu items and track/update order statuses.

FEATURES
Customer Features:
- User Registration & Login
- Browse list of available food items
- Add/Remove items from Cart
- Place Orders
- View Order History
- Track Order Status

Admin Features:
- Add / Edit / Delete Menu Items
- View All Orders
- Update Order Status (Accepted / In-progress / Delivered)
- Manage Availability of Items

TECH STACK
Frontend:
- React.js
- Axios
- React Router
- HTML, CSS, JavaScript

Backend:
- Spring Boot
- RESTful API
- Spring Data JPA
- Maven Build Tool

Database:
- MySQL / H2 (configurable)

ARCHITECTURE
Frontend (React) -> Backend (Spring Boot) -> Database (MySQL/H2)

FOLDER STRUCTURE
Online-Food-Ordering-Application/
  springapp/     # Backend - Spring Boot
  reactapp/      # Frontend - React.js

SETUP INSTRUCTIONS
Clone:
git clone https://github.com/Vignesh-Rangaraj/Online-Food-Ordering-Application.git

Backend:
cd springapp
mvn clean install
mvn spring-boot:run
Runs on http://localhost:8080

Frontend:
cd reactapp
npm install
npm start
Runs on http://localhost:3000

API ENDPOINTS
Menu:
GET    /menu
POST   /menu
PUT    /menu/{id}
DELETE /menu/{id}

Orders:
POST   /orders
GET    /orders
GET    /orders/user/{id}

FUTURE ENHANCEMENTS
- JWT Authentication
- Payment Integration
- Real-Time Tracking
- Notifications
- Multi-Restaurant Support
- Mobile App

