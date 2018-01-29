

drop database ACL;

create database if not exists ACL;

use ACL;




create table Application(
ApplicationId int primary key auto_increment,
ApplicationName varchar(20)

);


create Table Users(
	UserId int Primary Key auto_increment,
    UserName varchar(20),
    Passwrd varchar(40) 
);

create Table Admin(
	AdminId int primary Key auto_increment,
    AdminName varchar(30),
    AdminPassword varchar(20)
);

create table Privilege(
PrivilegeId int primary key auto_increment,
Views boolean,
Edits boolean
);

create table ApplicationUserPrivilege(
ApplicationUserPrivilegeId int Primary Key auto_increment,
ApplicationId int,
UserId int,
PrivilegeId int,
constraint fkApplicationUserPrivilegeToApplication FOREIGN KEY(ApplicationId) REFERENCES Application(ApplicationId) on delete cascade on update cascade,
constraint fkApplicationUserPrivilegeToPrivilege FOREIGN KEY(PrivilegeId) REFERENCES Privilege(PrivilegeId) on delete cascade on update cascade
);


create table ApplicationObject(
ApplicationObjectId int primary key auto_increment,
ApplicationId int,
ObjectPath varchar(50),
constraint fk_obj_aam foreign key (ApplicationId) references Application(ApplicationId)on delete cascade on update cascade
);

 
create table ApplicationUserObjectPrivilege(
ApplicationUserObjectPrivilegeId int primary key auto_increment,
ApplicationObjectId int ,
UserId int,
PrivilegeId int,
constraint fk_obj_aaam foreign key (ApplicationObjectId) references ApplicationObject(ApplicationObjectId) on delete cascade on update cascade,
constraint fk_obj_paa foreign key (PrivilegeId) references Privilege(PrivilegeId)on delete cascade on update cascade

);
