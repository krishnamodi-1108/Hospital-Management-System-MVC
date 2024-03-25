# Hospital Management System MVC

This project implements a Hospital Management System using the Model-View-Controller (MVC) architecture. It offers a robust set of features for efficiently managing doctors, patients, appointments, and schedules within a hospital environment.

## Features

### Admin Functionalities:
- **Add and Delete Doctors:** Admins can add new doctors to the system and remove existing ones as needed.
- **View Doctor Schedules:** Admins have access to view the schedules of all doctors for efficient management.
- **View All Patients:** Admins can see a comprehensive list of all registered patients.

### Patient Functionalities:
- **View Patient Profile:** Patients can view their profiles, including personal and medical information.
- **Register New Patients:** New patients can easily register themselves into the system.
- **View Available Doctors for Appointments:** Patients can check the availability of doctors for scheduling appointments.

## Technologies Used
- **Java:** The core programming language used for development.
- **Spring MVC:** Provides the framework for building web applications using the MVC design pattern.
- **Hibernate:** Used for mapping Java objects to database tables and vice versa.
- **Lombok:** Helps to reduce boilerplate code in Java classes.
- **MySQL:** The relational database management system used for data storage.

## Project Structure
- `src/main/java/com/controller`: Contains controller classes for handling HTTP requests and responses.
- `src/main/java/com/bean`: Includes Java bean classes representing entities such as Doctor, Patient, Appointment, and Schedule.
- `src/main/java/com/model/service`: Contains service interfaces and implementations for managing business logic related to doctors and appointments.
- `src/main/resources`: Configuration files for Spring MVC and Hibernate.

## Setup Instructions
1. **Clone the Repository:** `git clone https://github.com/krishnamodi-1108/Hospital-Management-System-MVC.git`
2. **Import Project:** Import the project into your preferred Java IDE.
3. **Configure Database Connection:** Update the database connection details in `application.properties`.
4. **Run the Project:** Start the application on a server to launch the Hospital Management System.

## Usage
- **Admin Access:** Use admin credentials to access admin functionalities.
- **Patient Access:** Patients can register/login to access patient functionalities.
- **Perform Actions:** Add doctors, register patients, and schedule appointments as required.

## Contributors
- [Krishna Modi](https://github.com/krishnamodi-1108)
- [Suresh Kumar]()
