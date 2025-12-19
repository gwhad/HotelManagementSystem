
USE master;
GO


ALTER DATABASE HotelDB SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO

DROP DATABASE IF EXISTS HotelDB;
GO

CREATE DATABASE HotelDB;
GO

USE HotelDB;
GO
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Service')
BEGIN
  create table Service(
	service_id int primary key,
	name varchar(50) null,
	price int not null,

);

end
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Employee')
BEGIN
 create table Employee(
    employee_id  int primary key,
	first_name   varchar(50) null,
	last_name   varchar(50) null,
	email       varchar(255) not null,
	phone       varchar(20)  not null,
	employee_role       varchar(50)   not null,

	);
	end
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Guest')
BEGIN
create table Guest(
    id_number int Unique,
	guest_id  int primary key,
	first_name   varchar(50) null,
	last_name   varchar(50) null,
	email       varchar(255) not null,
	phone       varchar(20)  not null,
	guest_address varchar(200) not null,
	);
select * from Guest;
end
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Reservation')
BEGIN	
 create table Reservation(
    reservation_id int primary key,
	guest_id       int not null,
	check_in_date  date null,
	check_out_date date null,
	guest_status   varchar(20) not null,
	room_id		int not null
	foreign key (room_id) references Room (room_id),
	foreign key  (guest_id) references Guest (guest_id),
	);
end
select * from Reservation;
/*IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'ServiceRequest')
BEGIN	
create table ServiceRequest(
	service_req_id int primary key,
	reservation_id int not null,
	notes varchar(300) null,
	req_status varchar(20) not null,
	total_price decimal(10,2) not null, 
	/*reserv_id int not null,*/
	requested_by_employee_id int not null,
	handled_by_employee_id int not null,
	foreign key  (reservation_id) references Reservation (reservation_id),
	foreign key  (requested_by_employee_id) references Employee (employee_id),
	foreign key  (handled_by_employee_id) references Employee (employee_id)
	
	);
	end*/
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Payment')
BEGIN
create table Payment(
	payment_id int primary key,
	res_id int not null,
	amount int not null,
	payment_date date null,
	payment_method varchar(20) null,
	status varchar(20) not null,
	foreign key (res_id) references Reservation (reservation_id),
);
end
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Room')
BEGIN
create table Room(
	room_id int primary key,
	room_number int not null,
	room_availability BIT not null,
	price_per_night int not null,
	room_description varchar(300) null,
	room_capacity int null,
);
end

insert into Service(service_id,name,price)
values
     (20, 'Laundry', 150),
	 (21,'Room Service',60),
	 (22,'Spa',  5),
	 (23, 'Airport Pickup', 300),
	 (24, 'Gym Access', 100);

go 

INSERT INTO Guest (id_number, guest_id, first_name, last_name, phone,email, guest_address)
VALUES
     (111111111,1, 'Ahmed', 'Hassan', '01234567890', 'ahmed@example.com','Cairo, Egypt'),
     (222222222,2, 'Mona', 'Ali', '01122334455', 'mona@example.com','Alexandria, Egypt'),
     (333333333,3, 'Youssef', 'Ibrahim', '01099887766', 'youssef@example.com','Giza, Egypt');

select * from Guest;
GO
insert into Employee(employee_id, first_name, last_name, email, phone, employee_role)
values
      (1, 'Sara', 'Kandil', 'sara.kandil@hotel.com', '01012345678', 'Receptionist'),
      (2, 'Omar', 'Hassan', 'omar.hassan@hotel.com', '01098765432', 'Manager'),
      (3, 'Yasmine', 'Mahmoud', 'yasmine.mahmoud@hotel.com', '01022334455', 'Housekeeping');
go
select * from Employee;
insert into Reservation(reservation_id ,guest_id,check_in_date,check_out_date,guest_status, room_id )
values
    (101, 1, '2025-01-10', '2025-01-15', 'Checked-In',2),
    (102, 2, '2025-02-01', '2025-02-05', 'Booked', 3)
GO
select * from Reservation;


INSERT INTO Payment (payment_id, res_id, amount, payment_date, payment_method, status)
VALUES
    (1, 101, 3000, '2025-01-15', 'Credit Card', 'Completed'),
    (2, 102, 2000, '2025-02-01', 'Cash', 'Pending'),
    (3, 103, 1800, '2025-03-23', 'Credit Card', 'Completed');
select * from Payment;

INSERT INTO Room (room_id, room_number, room_availability, price_per_night, room_description, room_capacity)
VALUES
    (10, 101, 'True', 500, 'Single room',1),
    (11, 202, 'False', 800, 'Double room',2),
    (12, 303, 'False', 1500, 'suite',6);
select * from Room;
/*Can we delete booking from oop code and just transfer the room line to Reservation and edit it here?*/