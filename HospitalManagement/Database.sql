create database hospitalmanagement;

use hospitalmanagement;

create table patients(
	id int auto_increment PRIMARY KEY,
    name varchar(100) NOT NULL,
    age INT not null,
    gender varchar(100) not null
);

create table doctors(
		id INT auto_increment PRIMARY KEY,
        name varchar(100) NOT NULL,
        specialization varchar(100) NOT NULL,
		contact varchar(100) NOT NULL
); 

create table appointments(
		id int auto_increment PRIMARY KEY,
        patient_id int NOT NULL,
        doctor_id int NOT NULL,
        appointment_date date NOT NULL,
        foreign key (patient_id) REFERENCES patients(id),
        foreign key (doctor_id) REFERENCES doctors(id)
);

