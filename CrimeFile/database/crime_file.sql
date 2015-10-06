USE master
GO

IF EXISTS (
	SELECT name FROM sys.databases
	WHERE name = 'crime_file'
) DROP DATABASE crime_file
GO

CREATE DATABASE crime_file
GO

USE crime_file
GO

CREATE TABLE case_profile(
	id_profile INT IDENTITY(1,1) PRIMARY KEY,
	day_admission NVARCHAR(10) NOT NULL,
	crime_scene NVARCHAR(256)NOT NULL,
	exhibit NVARCHAR(128)NOT NULL,
	accusation NVARCHAR(64)NOT NULL,
	conclude NVARCHAR(64)NOT NULL,
	status NVARCHAR(32)NOT NULL
)
GO

CREATE TABLE complaint(
	id_complaint INT IDENTITY(1,1) PRIMARY KEY,
	victim_name NVARCHAR(32)NOT NULL,
	id_card NVARCHAR(32)NOT NULL,
	sex BIT NOT NULL,
	birth NVARCHAR(10) NOT NULL,
	address NVARCHAR(256)NOT NULL,
	nationality NVARCHAR(256)NOT NULL,
	testimony NVARCHAR(2048) NOT NULL,
	id_profile INT NOT NULL
)
GO

CREATE TABLE crime_list(
	id_profile INT NOT NULL,
	id_crime INT NOT NULL
)
GO

ALTER TABLE crime_list
ADD CONSTRAINT pk_ID PRIMARY KEY (id_profile, id_crime)
GO

ALTER TABLE complaint
ADD CONSTRAINT fk_idProfile FOREIGN KEY (id_profile) REFERENCES case_profile (id_profile)
GO

CREATE TABLE crime_infomation(
	id_crime INT IDENTITY(1,1) PRIMARY KEY,
	crime_name NVARCHAR(32) NOT NULL,
	id_card NVARCHAR(32) NOT NULL,
	sex BIT NOT NULL,
	birth NVARCHAR(10) NOT NULL,
	hometown NVARCHAR(32) NOT NULL,
	address NVARCHAR(32) NOT NULL,
	jobs NVARCHAR(32) NOT NULL,
	nationality NVARCHAR(32) NOT NULL,
	crime_type NVARCHAR(32) NOT NULL,
	avatar NVARCHAR(256) NOT NULL
)
GO

ALTER TABLE crime_list
ADD CONSTRAINT fk_idProfileCL FOREIGN KEY (id_profile) REFERENCES case_profile (id_profile)
GO

ALTER TABLE crime_list
ADD CONSTRAINT fk_idCrimeCL FOREIGN KEY (id_crime) REFERENCES crime_infomation (id_crime)
GO

CREATE TABLE wanted (
	id_crime INT PRIMARY KEY,
	notify_date NVARCHAR(10) NOT NULL,
	content NVARCHAR(256) NOT NULL,
	status NVARCHAR(32) NOT NULL
)
GO

ALTER TABLE wanted
ADD CONSTRAINT fk_idCrimeW FOREIGN KEY (id_crime) REFERENCES crime_infomation (id_crime)
GO

CREATE TABLE corpse(
	id_corpse INT IDENTITY(1,1) PRIMARY KEY,
	corpse_name NVARCHAR(32) NOT NULL,
	id_card NVARCHAR(32) NOT NULL,
	sex BIT NOT NULL,
	birth NVARCHAR(10) NOT NULL,
	address NVARCHAR(32) NOT NULL,
	nationality NVARCHAR(32) NOT NULL,
	autopsy_date NVARCHAR(10) NOT NULL,
	reasons_dead NVARCHAR(256) NOT NULL,
	username NVARCHAR(16) NOT NULL,
	id_profile INT NOT NULL
)
GO

ALTER TABLE corpse
ADD CONSTRAINT fk_idProfileC FOREIGN KEY (id_profile) REFERENCES case_profile (id_profile)
GO

CREATE TABLE prisoners (
	id_crime INT PRIMARY KEY,
	detention_date NVARCHAR(10) NOT NULL,
	prison_address NVARCHAR(64) NOT NULL,
	jail_time NVARCHAR(32) NOT NULL
)
GO

ALTER TABLE prisoners
ADD CONSTRAINT fk_idCrimeP FOREIGN KEY (id_crime) REFERENCES crime_infomation (id_crime)
GO

CREATE TABLE list_inquisitor (
	id_profile INT NOT NULL,
	username NVARCHAR(16) NOT NULL	
)
GO

ALTER TABLE list_inquisitor
ADD CONSTRAINT pk_IDL PRIMARY KEY (id_profile, username)
GO

ALTER TABLE list_inquisitor
ADD CONSTRAINT fk_idProfileL FOREIGN KEY (id_profile) REFERENCES case_profile (id_profile)
GO

CREATE TABLE account (
	username NVARCHAR(16) PRIMARY KEY,
	password NVARCHAR(32) NOT NULL,
	email NVARCHAR(64) NOT NULL,
	level INT NOT NULL,
	full_name NVARCHAR(32) NOT NULL,
	sex BIT NOT NULL,
	birth NVARCHAR(10) NOT NULL,
	address NVARCHAR(128) NOT NULL,
	phone_number NVARCHAR(16) NOT NULL,
	workplace NVARCHAR(64) NOT NULL,
	avartar NVARCHAR(256) NOT NULL
)
GO

ALTER TABLE corpse
ADD CONSTRAINT fk_usernameC FOREIGN KEY (username) REFERENCES account (username)
GO

ALTER TABLE list_inquisitor
ADD CONSTRAINT fk_usernameL FOREIGN KEY (username) REFERENCES account (username)
GO