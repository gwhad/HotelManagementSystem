
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
	serviceID int primary key,
	name varchar(50) null,
	price float  not null
);
end
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Employee')
BEGIN
 create table Employee(
    employeeId  int primary key,
	firstName   varchar(50) null,
	lastName   varchar(50) null,
	email       varchar(255) not null,
	phone       varchar(20)  not null,
	role       varchar(50)   not null

	);
	end
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Guest')
BEGIN
create table Guest(
    idNumber int Unique,
	guestId  int primary key,
	firstName   varchar(50) null,
	lastName   varchar(50) null,
	email       varchar(255) not null,
	phone       varchar(20)  not null,
	address varchar(200) not null
	);
select * from Guest;
end
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Room')
BEGIN
create table Room(
	roomId int primary key,
	roomNum int not null,
	capacity int null,
	isAvailable BIT not null,
	pricePerNight int not null,
	roomDescription varchar(300) null
	
);
end

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Reservation')
BEGIN	
 create table Reservation(
    reservationId int primary key,
	checkInDate  date null,
	checkOutDate date null,
	status   varchar(20) not null,
	roomId		int not null,
	foreign key (roomId) references Room (roomId),
	);
end
select * from Reservation;

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Payment')
BEGIN

create table Payment(
	paymentId int primary key,
	reservationId int not null,
	amount int not null,
	paymentDate date null,
	paymentMethod varchar(20) null,
	status varchar(20) not null
	foreign key (reservationId) references Reservation (reservationId)
);
end


insert into Service(serviceID,name,price)
values
     (20, 'Laundry', 150.0),
	 (21,'Room Service',60.0),
	 (22,'Spa',  5.0),
	 (23, 'Airport Pickup', 300.0),
	 (24, 'Gym Access', 100.0);

go 


INSERT INTO Guest ( guestId,firstName, lastName, phone,email,idNumber,  address)
VALUES
     (1, 'Ahmed', 'Hassan', '01234567890', 'ahmed@example.com',111111111,'Cairo, Egypt'),
     (2, 'Mona', 'Ali', '01122334455', 'mona@example.com',222222222,'Alexandria, Egypt'),
     (3, 'Youssef', 'Ibrahim', '01099887766', 'youssef@example.com',333333333,'Giza, Egypt');

select * from Guest;
GO
insert into Employee(employeeId, firstName, lastName, email, phone, role)
values
      (1, 'Sara', 'Kandil', 'sara.kandil@hotel.com', '01012345678', 'Receptionist'),
      (2, 'Omar', 'Hassan', 'omar.hassan@hotel.com', '01098765432', 'Manager'),
      (3, 'Yasmine', 'Mahmoud', 'yasmine.mahmoud@hotel.com', '01022334455', 'Housekeeping');
go
select * from Employee;
INSERT INTO Room (roomId, roomNum, capacity, isAvailable, pricePerNight, roomDescription )
VALUES
    (10, 101, 1, 1, 500, 'Single room'),
    (11, 202, 2, 0, 800, 'Double room'),
    (12, 303, 6, 0, 1500, 'suite');
select * from Room;
IF NOT EXISTS (SELECT 1 FROM Reservation WHERE reservationId=101)
begin
insert into Reservation(reservationId,checkInDate,checkOutDate,status, roomId )
values
    (101, '2025-01-10', '2025-01-15', 'Checked-In',10);
end
IF NOT EXISTS (SELECT 1 FROM Reservation WHERE reservationId=102)
begin
insert into Reservation(reservationId,checkInDate,checkOutDate,status, roomId )
values
    (102, '2025-02-01', '2025-02-05', 'Booked', 11)
end
SELECT r.reservationId, r.checkInDate, r.checkOutDate, r.status,
       rm.roomId, rm.roomNum, rm.capacity, rm.isAvailable, rm.pricePerNight, rm.roomDescription
FROM Reservation r
JOIN Room rm ON r.roomId = rm.roomId
GO
select * from Reservation;


INSERT INTO Payment (paymentId, reservationId, amount, paymentDate, paymentMethod, status)
VALUES
    (1, 101, 3000, '2025-01-15', 'Credit Card', 'Completed'),
    (2, 102, 2000, '2025-02-01', 'Cash', 'Pending');
select * from Payment;


