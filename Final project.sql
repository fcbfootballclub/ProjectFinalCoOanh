use master;

DROP DATABASE IF EXISTS ProjectFinal;
go
create database ProjectFinal;
go
use ProjectFinal;
go
create table ProductType(
id int primary key identity(1,1),
name varchar(20)
);
go


create table Category(
id int primary key identity(1,1),
categoryName varchar(30),
categoryDes varchar(100),
);
go



create table Product (
id bigint primary key identity(1, 1),
title varchar(200),
description text,
idProductType int foreign key references ProductType(id),
price float,
created_at date,
modified_at date
);
go

create table Product_Category(
id bigint primary key identity(1,1),
id_category int foreign key references Category(id),
id_product bigint foreign key references Product(id),
);
go

create table Customer(
id bigint primary key identity(1,1),
firstName varchar(30),
lastName varchar(30),
email varchar(40) unique not null,
address varchar(50),
phone varchar(20),
created_at date,
modified_at date
);
go

create table Role(
id int primary key,
roleTitle varchar(20),
isActive BIT
);
go

create table User_Role(
id int primary key identity(1,1),
username varchar(30) unique,
password varchar(30),
id_customer bigint foreign key references Customer(id),
id_role int foreign key references Role(id)
);
go

create table Shipping(
id int primary key,
shipping_fee float
);
go

create table tblOrder(
id bigint primary key identity(1,1),
id_customer bigint foreign key references Customer(id),
id_shippingValue int foreign key references Shipping(id),
shipping_address varchar(100),
shipping_city varchar(30),
shipping_country varchar(30),
shipping_phone varchar(20),
note varchar(100),
created_at date,
updated_At date,
);
go

create table OrderDetail(
idDetail bigint primary key identity(1,1),
id_order bigint foreign key references tblOrder(id),
id_product bigint foreign key references Product(id),
quantity int,
subtotal float
);
go

create table Cart(
id bigint primary key identity(1,1),
id_customer bigint foreign key references Customer(id),
created_at date,
updated_at date
);
go

create table CartDetail(
id bigint primary key identity(1,1),
id_cart bigint foreign key references Cart(id),
id_product bigint foreign key references Product(id),
quantity int,
subtotal float
);
go