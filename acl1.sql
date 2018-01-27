drop database acl;

create database if not exists ACL;

use ACL;

create table Application(
ApplicationId int primary key auto_increment,
ApplicationName varchar(20)
);


create Table Users(
	UserId int Primary Key auto_increment,
    UserName varchar(20),
    UserPassword varchar(40) 
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


Create table Role(
RoleUserId int primary key,
RoleId int,
UserId int,
PrivilegeId int
);

show databases;

desc application;

insert into 
	application(ApplicationName) 
Values(
	"MananApp"
);

select 
	* 
from 
	Application;

Insert into 
	users(
			username,
            userPassword
		) 
values(
	"Manna",
    "poi"
);

insert into 
	privilege(
		views,
        edits
        ) 
values(
	true,
    true
);
select 
	* 
from 
	users;
    
select
	* 
from 
	privilege;

insert into 
	applicationuserprivilege(
		applicationId,
        userId,
        privilegeId
        ) 
values(
	1,
    1,
    1
);

select 
	* 
from 
	applicationuserprivilege;
-- desc applicationobject;
-- use acl;
select 
	a.applicationid,
	u.UserId,
    u.Username,
    p.views,
    p.edits 
from 
	ApplicationUserPrivilege a,
	Users u,
    Privilege p 
where 
	a.applicationId=1 
    and a.UserId=u.userId 
    AND a.PrivilegeId=p.PrivilegeId;


insert into 
	admin(
		adminName,
        adminPassword
        ) 
values(
	"Manan",
	"aaa"
);

select 
	* 
from 
	admin;
select *  from Admin where adminName="Manan" AND AdminPassword="aaa";


select
	* 
from 
	users;
    
Insert Into ApplicationObject(
	ApplicationId,
	ObjectPath
) 
Values(
	1,
    "/home.html"
);

select 
	* 
from 
	applicationobject;
    

Insert Into applicationuserobjectprivilege(
	applicationObjectId,
    UserId,
    PrivilegeId
) 
values(
	1,
    1,
    1
);

select 
	* 
from 
	applicationuserobjectprivilege;

delete 
	aoup,
    p 
from 
	applicationuserobjectprivilege aoup 
    Left Join 
    ApplicationObject ao 
    ON  
		aoup.ApplicationObjectId=ao.ApplicationObjectId 
	Left Join 
		Privilege p 
	ON aoup.PrivilegeId=p.PrivilegeId 
where 
	ao.applicationId=1 
    and 
		ao.applicationobjectId=1;
        
        
select 
	*
from 
	applicationuserobjectprivilege aoup 
    Left Join 
    ApplicationObject ao 
    ON  
		aoup.ApplicationObjectId=ao.ApplicationObjectId 
	Left Join 
		Privilege p 
	ON aoup.PrivilegeId=p.PrivilegeId 
where 
	ao.applicationId=1 
    and 
		ao.ApplicationobjectId=1;        
        
        
Update 
	ApplicationUserObjectPrivilege aoup 
	Left Join 
		ApplicationObject ao 
	ON  
		aoup.ApplicationObjectId=ao.ApplicationObjectId 
	Left Join 
		Privilege p 
	ON aoup.PrivilegeId=p.PrivilegeId 
SET 
	p.views=false,
    p.edits=false 
where
	ao.applicationId=1 
	and ao.applicationobjectId=1 
	and aoup.UserId=1;
    
    
    
select * from applicationObject;
insert into applicationObject (ApplicationId,ObjectPath) values(1,"/more.html");