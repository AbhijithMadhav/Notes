drop table Equipment;
drop table Aircraft;
drop table Can_Fly;
drop table Plane;
drop table Pilot;
drop table Assigned_To;
drop table Booked_On;
drop table Departure;
drop table Flight;
drop table Employee;
drop table Person;

			   /* Person Entity Set */

create table Person (
	Name		varchar(15) not null,
	Address		varchar(15) not null,
	Phone		varchar(12),	/* optional */
	primary key (Name)
);


			  /* Employee Entity Set */

create table Employee (
	Name		varchar(15) not null,
	Salary		number(10,2),
	Emp_No		smallint unique not null,
	primary key (Name),
	foreign key (Name) references Person(Name)
);

			    /* Pilot Entity Set */

create table Pilot (
	Emp_No		smallint unique,
	foreign key (Emp_No) references Employee(Emp_No)
);

			    /* Plane Entity Set */

create table Plane (
	Maker		varchar(15) not null,
	Model_No	varchar(15) not null,
	primary key (Model_No)
);

			  /* Aircraft Entity Set */

create table Aircraft (			/* subsumes Type */
	Serial_No	smallint not null,
	Model_No	varchar(15) not null,
	primary key (Serial_No, Model_No),
	foreign key (Model_No) references Plane(Model_No)
);

			   /* Flight Entity Set */

create table Flight (
	Num		smallint not null,
	Origin		varchar(3),
	Dest		varchar(3),
	Dep_Time	varchar(5),
	Arr_Time	varchar(5),
	primary key (Num)
);

			  /* Departure Entity Set */

create table Departure (		/* subsumes Instance_Of */
	Dep_Date	varchar(6) not null,
	Num		smallint not null,
	primary key (Dep_Date, Num),
	foreign key (Num) references Flight(Num)
);

		      /* Booked_On Relationship Sets */

create table Booked_On (
	Name		varchar(15) not null,
	Dep_Date	varchar(6) not null,
	Num		smallint not null,
	primary key (Name, Dep_Date, Num),
	foreign key (Dep_Date, Num) references Departure(Dep_Date, Num)
);

		     /* Assigned_To Relationship Sets */

create table Assigned_To (
	Emp_No		smallint not null,
	Dep_Date	varchar(6) not null,
	Num		smallint not null,
	primary key (Emp_No, Dep_Date, Num),
	foreign key (Emp_No) references Employee(Emp_No),
	foreign key (Dep_Date, Num) references Departure(Dep_Date, Num)
);

		       /* Can_Fly Relationship Sets */

create table Can_Fly (
	Emp_No		smallint not null,
	Model_No	varchar(15) not null,
	primary key (Emp_No, Model_No),
	foreign key (Emp_No) references Employee(Emp_No),
	foreign key (Model_No) references Plane(Model_No)
);

		       /* Equipment Relationship Set */

create table Equipment (
	Dep_Date	varchar(6) not null,
	Num		smallint not null,
	Serial_No	smallint not null,
	Model_No	varchar(15) not null,
	primary key (Dep_Date, Num, Serial_No, Model_No),
	foreign key (Dep_Date, Num) references Departure(Dep_Date, Num),
	foreign key (Serial_No, Model_No) references 
		Aircraft(Serial_No, Model_No)
);

			      /* Populate DB */

insert into Person
values ('Smith',	'123 Elm St.',		'801-556-2239');
insert into Person
values ('Jones',	'234 Oak St.',		'801-552-2943');
insert into Person
values ('Peters',	'345 Pine St.',		'801-393-2230');
insert into Person
values ('Green',	'435 Alder St.',	'801-933-2320');
insert into Person
values ('Rowe',		'348 Elder St.',	'801-343-2320');
insert into Person
values ('Phillips',	'395 Pine St.',		'801-323-2320');
insert into Person
values ('Gates',	'285 Kapok St.',	'801-493-2203');
insert into Person
values ('Clark',	'223 Easy St.',		'801-193-2320');
insert into Person
values ('Warnock',	'775 Main St.',		'801-303-2222');
insert into Person
values ('Hooper',	'456 Maple St.',	'313-912-2101');
insert into Person
values ('Edwards',	'567 Spruce St.',	'801-228-6729');
insert into Person
values ('Majeris',	'678 Willow St.',	null);
insert into Person
values ('MacBride',	'789 Fir St.',		null);

insert into Employee
values ('Jones',	50000.00,	1001);
insert into Employee
values ('Peters',	45000.00,	1002);
insert into Employee
values ('Rowe',		35000.00,	1003);
insert into Employee
values ('Phillips',	25000.00,	1004);
insert into Employee
values ('Gates',	5000000.00,	1005);
insert into Employee
values ('Clark',	150000.00,	1006);
insert into Employee
values ('Warnock',	500000.00,	1007);

insert into Pilot	values (1001);
insert into Pilot	values (1002);
insert into Pilot	values (1003);

insert into Plane	values ('Boeing',	'B727');
insert into Plane	values ('Boeing',	'B747');
insert into Plane	values ('Boeing',	'B757');
insert into Plane	values ('MD',		'DC9');
insert into Plane	values ('MD',		'DC10');
insert into Plane	values ('Airbus',	'A310');
insert into Plane	values ('Airbus',	'A320');
insert into Plane	values ('Airbus',	'A330');
insert into Plane	values ('Airbus',	'A340');

insert into Aircraft	values (11,		'B727');
insert into Aircraft	values (13,		'B727');
insert into Aircraft	values (10,		'B747');
insert into Aircraft	values (13,		'B747');
insert into Aircraft	values (22,		'B757');
insert into Aircraft	values (93,		'B757');
insert into Aircraft	values (21,		'DC9');
insert into Aircraft	values (22,		'DC9');
insert into Aircraft	values (23,		'DC9');
insert into Aircraft	values (24,		'DC9');
insert into Aircraft	values (21,		'DC10');
insert into Aircraft	values (70,		'A310');
insert into Aircraft	values (80,		'A320');

insert into Flight
values (100,	'SLC',	'BOS',	'08:00',	'17:50');
insert into Flight
values (206,	'DFW',	'STL',	'09:00',	'11:40');
insert into Flight
values (334,	'ORD',	'MIA',	'12:00',	'14:14');
insert into Flight
values (335,	'MIA',	'ORD',	'15:00',	'17:14');
insert into Flight
values (336,	'ORD',	'MIA',	'18:00',	'20:14');
insert into Flight
values (337,	'MIA',	'ORD',	'20:30',	'23:53');
insert into Flight
values (121,	'STL',	'SLC',	'07:00',	'09:13');
insert into Flight
values (122,	'STL',	'YYV',	'08:30',	'10:19');
insert into Flight
values (330,	'JFK',	'YYV',	'16:00',	'18:53');
insert into Flight
values (991,	'BOS',	'ORD',	'17:00',	'18:22');
insert into Flight
values (394,	'DFW',	'MIA',	'19:00',	'21:30');
insert into Flight
values (395,	'MIA',	'DFW',	'21:00',	'23:43');
insert into Flight
values (449,	'CDG',	'DEN',	'10:00',	'19:29');
insert into Flight
values (930,	'YYV',	'DCA',	'13:00',	'16:10');
insert into Flight
values (931,	'DCA',	'YYV',	'17:00',	'18:10');
insert into Flight
values (932,	'DCA',	'YYV',	'18:00',	'19:10');
insert into Flight
values (112,	'DCA',	'DEN',	'14:00',	'18:07');

insert into Departure	values ('Oct 31',	100);
insert into Departure	values ('Oct 31',	112);
insert into Departure	values ('Oct 31',	206);
insert into Departure	values ('Oct 31',	334);
insert into Departure	values ('Oct 31',	335);
insert into Departure	values ('Oct 31',	337);
insert into Departure	values ('Oct 31',	449);
insert into Departure	values ('Nov  1',	100);
insert into Departure	values ('Nov  1',	112);
insert into Departure	values ('Nov  1',	206);
insert into Departure	values ('Nov  1',	334);
insert into Departure	values ('Nov  1',	395);
insert into Departure	values ('Nov  1',	991);

insert into Booked_On	values ('Smith',	'Oct 31',	100);
insert into Booked_On	values ('Green',	'Oct 31',	206);
insert into Booked_On	values ('Hooper',	'Oct 31',	334);
insert into Booked_On	values ('Edwards',	'Oct 31',	449);
insert into Booked_On	values ('MacBride',	'Nov  1',	991);
insert into Booked_On	values ('Gates',	'Nov  1',	991);
insert into Booked_On	values ('Rowe',		'Nov  1',	100);
insert into Booked_On	values ('Clark',	'Nov  1',	100);
insert into Booked_On	values ('Phillips',	'Oct 31',	449);
insert into Booked_On	values ('Warnock',	'Oct 31',	449);
insert into Booked_On	values ('Smith',	'Nov  1',	991);
insert into Booked_On	values ('Peters',	'Nov  1',	100);

insert into Assigned_To	values (1001,		'Oct 31',	100);
insert into Assigned_To	values (1002,		'Oct 31',	100);
insert into Assigned_To	values (1003,		'Oct 31',	100);
insert into Assigned_To	values (1004,		'Oct 31',	100);
insert into Assigned_To	values (1007,		'Oct 31',	206);
insert into Assigned_To	values (1003,		'Oct 31',	337);
insert into Assigned_To	values (1004,		'Oct 31',	337);
insert into Assigned_To	values (1005,		'Oct 31',	337);
insert into Assigned_To	values (1006,		'Oct 31',	337);
insert into Assigned_To	values (1001,		'Nov  1',	100);
insert into Assigned_To	values (1002,		'Nov  1',	100);
insert into Assigned_To	values (1006,		'Nov  1',	991);
insert into Assigned_To	values (1007,		'Nov  1',	991);
insert into Assigned_To	values (1007,		'Nov  1',	112);

insert into Can_Fly	values (1001,	'B727');
insert into Can_Fly	values (1001,	'B747');
insert into Can_Fly	values (1001,	'DC10');
insert into Can_Fly	values (1002,	'DC9');
insert into Can_Fly	values (1002,	'A340');
insert into Can_Fly	values (1002,	'B757');
insert into Can_Fly	values (1002,	'A320');
insert into Can_Fly	values (1003,	'A310');
insert into Can_Fly	values (1003,	'DC9');

insert into Equipment	values ('Oct 31',	100,	11,	'B727');
insert into Equipment	values ('Oct 31',	206,	13,	'B727');
insert into Equipment	values ('Oct 31',	112,	11,	'B727');
insert into Equipment	values ('Oct 31',	337,	24,	'DC9');
insert into Equipment	values ('Nov  1',	991,	22,	'B757');
insert into Equipment	values ('Nov  1',	112,	21,	'DC10');
