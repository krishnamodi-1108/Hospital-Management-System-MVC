create database Hospital;
use Hospital;

drop database Hospital;

-- tables

create table doctor(
doctor_id varchar(5) primary key,
name_of_doctor varchar(25) not null,
specialisation varchar(30) not null,
experience int not null,
gender char(1) not null,
age int not null,
Contact_number varchar(15) not null unique,
Address varchar(100)
);

create table patient(
patient_id varchar(5) primary key,
name_of_patient varchar(50) not null,
gender char(1) not null,
age int not null,
Contact_number varchar(15) not null,
Address varchar(100),
department varchar(50)
);

create table login_credentials(
id varchar(5) not null,
password varchar(15)
);

insert into login_credentials values('A1001', '@dmin$$');
insert into login_credentials values('D1000','D1000');
insert into login_credentials values('P101','P101');

drop table appointments;

create table appointments(
patient_id varchar(5) not null,
name_of_patient varchar(25) not null,
slot time not null,
date_of_appointment date not null,
doctor_id varchar(5) primary key,
name_of_doctor varchar(25) not null,
department varchar(50)
);


-- data

insert ignore into doctor(doctor_id, name_of_doctor, specialisation, experience, gender, age, contact_number, address)
values('D1000','Dr Pullen', 'Cardiologists', 5, 'm', 30 , '+1 582-558-3861', '1128, 3rd Floor, Fat No 13a Wings, Sanjay Society, Prabhadevi'),
	  ('D1001','Dr Fillmore', 'Anesthesiologists', 15, 'f', 50 , '+1 464-485-6722', '91, Shri Krishna Bhavan, Hindu Colony, Dadar(e)'),
      ('D1002','Dr Mangle', 'Dermatologists', 10, 'm', 45 , '+1 312-795-2062', ' 20/1, North Crescent Road, T Nagar'),
      ('D1003','Dr Ken Hurt', 'Neurologists', 8, 'm', 38 , '+1 319-730-5064', '18th Road, Opp Electric Office, Chembur (east)'),
      ('D1004','Dr B. Sick', 'Gastroenterologists', 3, 'f', 34 , '+1 218-654-7743', 'Central Lane, Bengali Market'),
      ('D1005','Dr Watamaniuk', 'Dermatologists', 11, 'm', 45 , '+1 202-411-8219', 'S 614, Nehru Enclave, School Block, Shakarpur'),
      ('D1006','Dr Lipp', 'Cardiologists', 25, 'f', 55 , '+1 305-270-1658', 'A-11, Part 2, Greater Kailash Enclave'),
      ('D1007','Dr Carey', 'Dermatologists', 5, 'f', 40 , '+1 225-897-3950', '106, Sarita Bldg, Near Dahisar Tol Naka, Dahisar'),
      ('D1008','Dr Nervo', 'Neurologists', 11, 'f', 47 , '+1 582-262-9538', 'Opp S B I,dr V S Road, Ambawadi'),
      ('D1009','Dr Hurt', 'Dermatologists', 10, 'm', 50 , '+1 434-723-6523', ' Samta Nagar Tel Exchange, Western Express Highway, Nr Santa');

insert ignore into patient(patient_id, name_of_patient, gender, age, contact_number, address, department)
values('P101','Bhuwnesh', 'm', 24, '9876987655', '11, Welcome Shpg Centre, Old Padra Road, Old Padra Road','Gastroenterologists'),
	  ('P102','Harsha','m', 23, '348628643',' G-3 Anmol, Ground Floor, Grant Road','Anesthesiologists'),
      ('P103','Krishna','f',22,'98647638', '5, Sait Clny 2nd St, Egmore','Cardiologists'),
      ('P104','Suyesh','m',23,'7860992748','20/30/a, Ganga Ind Estate, P L Lokhande Marg, Chembur','Neurologists');




-- appointment

USE `hospital`;
DROP procedure IF EXISTS `book_appointment`;

USE `hospital`;
DROP procedure IF EXISTS `hospital`.`book_appointment`;
;

drop procedure book_appointment;

DELIMITER $$
USE `hospital`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `book_appointment`(in id varchar(5), in doc_id varchar(5))
BEGIN
declare pId varchar(5);
declare pName varchar(25);
declare pDept varchar(50);
declare slot_S time;
declare slot_e time;
declare dId varchar(5);
declare dName varchar(50);

select patient_id, name_of_patient, department into pId, pName, pDept
from patient
where patient_id = id;

select doctor_id, name_of_doctor into dId, dName
from doctor
where doctor_id = doc_id;

select slot_start, slot_end into slot_s, slot_e
from regular_schedule 
where doctor_id = dId;

insert ignore into procedureappointment
value(pId,pName,slot_s,slot_e,dId,dName,pDept);
END$$

DELIMITER ;
;

call book_appointment('P103','D1001');


create table patient_login(
id varchar(10) primary key,
password varchar(30)
);

create table doctor_login(
id varchar(10) primary key,
password varchar(30)
);

create table admin_login(
id varchar(10) primary key,
password varchar(30)
);

insert into patient_login
values("P101","P101");

insert ignore into doctor_login
values("D1000","D1000"),
("D1005","D1005");

insert into admin_login
values("A1001","@dmin$$");

drop table regular_schedule;

create table regular_schedule(
schedule_id int primary key auto_increment,
doctor_id varchar(5) not null,
name_of_doctor varchar(25) not null,
available_day varchar(10) not null,
slot_start time not null,
slot_end time not null,
constraint fk_docId foreign key(doctor_id)
references doctor(doctor_id)
);

insert ignore into regular_schedule(doctor_id,name_of_doctor,available_day,slot_start,slot_end)
values('D1000','Dr Pullen','Monday','10:00','12:00'),
	  ('D1001','Dr Fillmore','Monday','12:00','02:00'),
      ('D1002','Dr Mangle','Tuesday','10:00','1:00'),
      ('D1003','Dr Ken Hurt','Thursday','01:00','05:00'),
      ('D1004','Dr B. Sick','Saturday','12:00','03:00'),
      ('D1005','Dr Watamaniuk','Monday','05:00','08:00'),
      ('D1006','Dr Lipp','Tuesday','12:00','2:00'),
      ('D1007','Dr Carey','Friday','03:00','05:00'),
      ('D1008','Dr Nervo','Wednesday','04:00','06:00'),
      ('D1009','Dr Hurt','Sunday','12:00','2:00');
      
      
create table procedureAppointment(
Procedure_Id int primary key auto_increment,
Patient_id varchar(10),
Patient_Name varchar(30),
Starting_Time time,
Ending_Time time,
Doctor_id varchar(10),
Doctor_Name varchar(30),
Department varchar(30) 
);