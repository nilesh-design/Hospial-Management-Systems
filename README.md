# 🏥 Hospital Management System (Java + AWT + MySQL)

A **desktop-based hospital management system** built using **Java AWT** for the GUI and **MySQL** for data storage.  
This project helps manage hospital operations like patient records, doctor details, add new patietn, search room and appointments etc.

## 📌 Features

- **Patient Management**
  - Add, update, delete, and search patient details.
- **Doctor Management**
  - Maintain doctor profiles, specializations, and schedules.
- **Appointment Scheduling**
  - Book, update, or cancel appointments.
- **Search & Filter**
  - Search records easily by patient name, doctor name, or date.
- **User-Friendly Interface**
  - Built with Java AWT for a simple and intuitive experience.

## 🛠 Tech Stack

- **Programming Language:** Java (AWT, JDBC)
- **Database:** MySQL
- **IDE:** Eclipse 
- **Build Tool:** Manual compilation (no Maven/Gradle)
- **JDBC Driver:** MySQL Connector/J

## 📂 Project Structure

HospitalManagementSystem/
│
├── src/
│ └── hospital.management.system/
│ ├── All_Patient_Info.java # View all patient records
│ ├── Connections.java # Database connection handler
│ ├── Department.java # Department management
│ ├── Employee_Info.java # Employee/Staff details
│ ├── Login.java # Login screen
│ ├── New_Patient.java # Add new patient
│ ├── Patient_Discharge.java # Handle patient discharge process
│ ├── Reception.java # Reception module (main navigation)
│ ├── Room.java # Room management
│ ├── Search_Room.java # Search available rooms
│ ├── Update_Patient_Detail.java # Update existing patient records
│
├── icons/ # UI icons/images
│
├── .classpath
├── .project
├── .gitignore
└── README.md
