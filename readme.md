 🏥 Hospital Management System (Java + SQL)

This is a simple Java-based Hospital Management System that connects to an SQL database. It allows you to enter patient details, view a list of doctors, and check doctor availability based on existing bookings.

 📌 Features

- Add and store patient details into the database.
- Fetch and display a list of doctors from the `doctors` table.
- Check whether a selected doctor is available based on entries in the `bookings` table.

 🛠 Technologies Used

- Java (JDK 8 or later)
- JDBC (Java Database Connectivity)
- MySQL 
- SQL for data operations

  Methodology
   - Set up the Database 
     Create a new MySQL/PostgreSQL database.
     Run the provided SQL script to create tables.
     Insert sample data into doctors.

   - JDBC CONNECTIVITY
     Edit the database URL, username, and password in your Java file (e.g., DBConnection.java):

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "yourpassword";

PROJECT LAYOUT:
HospitalManagement/
├── DBConnection.java         # Handles database connection
├── Patient.java              # Patient data model
├── Doctor.java               # Doctor data model
├── Main.java                 # Main application and booking model
├── README.md
└── Database.sql              # SQL script to create tables        

HOW DOES IT WORK ?
    * The app uses JDBC to connect to the SQL database.
    * Patient data is inserted using SQL INSERT statements.
    * Doctor list is fetched using SELECT * FROM doctors.
    * Availability is determined by checking the bookings table for the selected doctor on the current date.
