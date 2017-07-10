begin transaction;

create table employee (
     id integer primary key,
     firstname varchar(60) not null,
     name varchar(60) not null,
     login varchar(20) not null unique,
     password varchar(11) not null,
     unique (name, firstname)
);

create table project (
     id integer primary key,
     name varchar(50) not null unique,
     description varchar(100),
     startdate date not null,
     enddate date,
     manager integer not null references employee(id)
);

create table prestation (
     id integer primary key,
     day date not null,
     employee integer not null references employee(id),
     project integer not null references project(id) ,
     duration integer not null,
     comment varchar(200)
);

create table keys (
	tablename varchar(50),
	idvalue	integer
);

insert into employee(id, firstname, name, login, password) values(1, 'bruce', 'wayne', 'batman', 'I am Batman');
insert into employee(id, firstname, name, login, password) values(2, 'diana', 'prince', 'wonder', 'woman');

insert into project(id, name, description, startdate, enddate, manager)
	values(1, 'Justice League', 'Superheros League', '2017-06-21', null, 1);

insert into prestation(id, day, employee, project, duration, comment)
	values(1, '2017-06-22', 1, 1, 2, 'Send email');
insert into prestation(id, day, employee, project, duration, comment)
	values(2, '2017-06-23', 2, 1, 1, 'Read email');
insert into prestation(id, day, employee, project, duration, comment)
	values(3, '2017-06-23', 2, 1, 1, 'Send response');
	
insert into keys(tablename, idvalue) values('prestation', 3);

commit;

