drop database acl;

create database if not exists ACL;

use ACL;

create table if not exists Application(
ApplicationId int primary key auto_increment,
ApplicationName varchar(20),
lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);


create Table if not exists Users(
	UserId int Primary Key auto_increment,
    UserName varchar(20),
    UserPassword varchar(40) ,
    lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);


create Table if not exists  Admin(
	AdminId int primary Key auto_increment,
    AdminName varchar(30),
    AdminPassword varchar(40),
    lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);


create table if not exists Role(
RoleID int primary Key auto_increment,
RoleName varchar(30),
lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);



create table if not exists RoleUser
(
	RoleUserId int primary Key,
    RoleId int,
    UserId int,
    lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    constraint fkRoleUserToRole FOREIGN KEY(RoleId) REFERENCES Role(RoleId) on delete cascade on update cascade,
    constraint fkRoleUserToUsers FOREIGN KEY(UserId) REFERENCES Users(UserId) on delete cascade on update cascade
);


create table if not exists  Privilege(
PrivilegeId int primary key auto_increment,
Views boolean,
Edits boolean
);


create table if not exists  ApplicationUserPrivilege(
ApplicationUserPrivilegeId int Primary Key auto_increment,
ApplicationId int,
UserId int,
PrivilegeId int,
lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
constraint fkApplicationUserPrivilegeToApplication FOREIGN KEY(ApplicationId) REFERENCES Application(ApplicationId) on delete cascade on update cascade,
constraint fkApplicationUserPrivilegeToPrivilege FOREIGN KEY(PrivilegeId) REFERENCES Privilege(PrivilegeId) on delete cascade on update cascade,
constraint fkApplicationUserPrivilegeToUsers FOREIGN KEY(UserId) REFERENCES Users(UserId) on delete cascade on update cascade
);

create table if not exists ApplicationRolePrivilege(
ApplicationRolePrivilegeId int Primary Key auto_increment,
ApplicationId int,
RoleId int,
PrivilegeId int,
lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
constraint fkApplicationRolePrivilegeToApplication FOREIGN KEY(ApplicationId) REFERENCES Application(ApplicationId) on delete cascade on update cascade,
constraint fkApplicationRolePrivilegeToPrivilege FOREIGN KEY(PrivilegeId) REFERENCES Privilege(PrivilegeId) on delete cascade on update cascade,
constraint fkApplicationRolePrivilegeToRole FOREIGN KEY(RoleId) REFERENCES Role(RoleId) on delete cascade on update cascade
);


create table if not exists ApplicationObject(
ApplicationObjectId int primary key auto_increment,
ApplicationId int,
ObjectPath varchar(50),
lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
constraint fk_obj_aam foreign key (ApplicationId) references Application(ApplicationId)on delete cascade on update cascade
);

 
create table if not exists ApplicationUserObjectPrivilege(
ApplicationUserObjectPrivilegeId int primary key auto_increment,
ApplicationObjectId int ,
UserId int,
PrivilegeId int,
lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
constraint fk_obj_aaam foreign key (ApplicationObjectId) references ApplicationObject(ApplicationObjectId) on delete cascade on update cascade,
constraint fk_obj_paa foreign key (PrivilegeId) references Privilege(PrivilegeId)on delete cascade on update cascade,
constraint fkAppUserObjPriToUsers FOREIGN KEY(UserId) REFERENCES Users(UserId) on delete cascade on update cascade
);

create table if not exists  ApplicationRoleObjectPrivilege(
ApplicationRoleObjectPrivilegeId int primary key auto_increment,
ApplicationObjectId int ,
RoleId int,
PrivilegeId int,
lastModifiedDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
constraint fkAppRoleObjPriToAppObj foreign key (ApplicationObjectId) references ApplicationObject(ApplicationObjectId) on delete cascade on update cascade,
constraint fkAppRoleObjPriToPri foreign key (PrivilegeId) references Privilege(PrivilegeId)on delete cascade on update cascade,
constraint fkAppRoleObjPriToRole foreign key (RoleId) references Role(RoleId)on delete cascade on update cascade
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
	application;
    
    
    
 
 
DELETE FROM 
	application 
WHERE 
	ApplicationName="TestApp";    
-- desc applicationobject;

use acl;


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
    a.UserId=u.userId 
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
    
    

select
	*  
from 
	Admin 
where 
	adminName="Manan" 
    AND AdminPassword="aaa";



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



select 
	* 
from 
	application;


select 
	* 
from 
	ApplicationObject ao 
    JOIN 
    Application a 
    ON 
		ao.ApplicationId=a.ApplicationId  
where 
	a.ApplicationName="Test App";  



delete from applicationuserobjectprivilege where ApplicationUserObjectPrivilegeId>0;
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
	applicationuserobjectprivilege auop JOIN applicationobject ao 
    ON auop.ApplicationObjectId=ao.ApplicationObjectId ;



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
	applicationuserobjectprivilege aoup ;

Select p.PrivilegeId,p.Views,p.Edits from ApplicationUserObjectPrivilege aoup 
Left Join ApplicationObject ao ON  aoup.ApplicationObjectId=ao.ApplicationObjectId 
Left Join Privilege p ON aoup.PrivilegeId=p.PrivilegeId 
where ao.applicationId=1 and ao.applicationobjectId=1 and aoup.UserId=1;





        

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
    


select * from users;


Delete from users where userid=1;


 
select 
	* 
from 
	applicationObject;
    
    
insert into applicationObject 
(
	ApplicationId,
    ObjectPath
)values(
	1,
    "/more.html"
);


select 
	* 
from 
	ApplicationObject 
where 
	ApplicationId=1;


Select 
	* 
from 
	applicationuserprivilege;
	
select 
	u.userId,
    u.userName 
from
	ApplicationUserPrivilege a,
    Users u 
where 
	a.ApplicationId=11 
    AND a.UserId=u.userId;



insert into applicationuserprivilege(
	applicationId,
    UserId,
    PrivilegeId
)values(
	11,
    5,
    1
);


select 
	a.userId,
    p.views,
    p.edits 
from 
	ApplicationUserPrivilege a,
    Privilege p 
where 
	a.ApplicationId=11 
    AND a.PrivilegeId=p.PrivilegeId;


select 
	* 
from 
	users;


delete 
from 
	users 
where 
	userid>0;
