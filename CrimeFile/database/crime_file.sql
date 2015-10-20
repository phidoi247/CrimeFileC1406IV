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

CREATE TABLE account (
	username NVARCHAR(16) PRIMARY KEY,
	password NVARCHAR(32) NOT NULL,
	email NVARCHAR(64) NOT NULL,
	permission INT NOT NULL,
	full_name NVARCHAR(32) NOT NULL,
	gender BIT NOT NULL,
	birth NVARCHAR(10) NOT NULL,
	address NVARCHAR(128) NOT NULL,
	phone_number NVARCHAR(16) NOT NULL,
	workplace NVARCHAR(64) NOT NULL,
	avartar NVARCHAR(256) NOT NULL
)
GO

CREATE TABLE crime_infomation(
	id_crime INT IDENTITY(1,1) PRIMARY KEY,
	crime_name NVARCHAR(32) NOT NULL,
	id_card NVARCHAR(32) NOT NULL,
	gender BIT NOT NULL,
	birth NVARCHAR(10) NOT NULL,
	hometown NVARCHAR(32) NOT NULL,
	address NVARCHAR(32) NOT NULL,
	jobs NVARCHAR(32) NOT NULL,
	nationality NVARCHAR(32) NOT NULL,
	crime_type NVARCHAR(32) NOT NULL,
	avatar NVARCHAR(256) NOT NULL
)
GO

CREATE TABLE victim(
	id_victim INT IDENTITY(1,1) PRIMARY KEY,
	victim_name NVARCHAR(32) NOT NULL,
	id_card NVARCHAR(32) NOT NULL,
	gender BIT NOT NULL,
	birth NVARCHAR(10) NOT NULL,
	address NVARCHAR(32) NOT NULL,
	nationality NVARCHAR(32) NOT NULL,
	isDead BIT NOT NULL,
	autopsy_date NVARCHAR(10)  NULL,
	reasons_dead NVARCHAR(256)  NULL,
	id_profile INT NOT NULL
)
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

CREATE TABLE list_inquisitor (
	id_profile INT NOT NULL,
	username NVARCHAR(16) NOT NULL	
)
GO

CREATE TABLE wanted (
	id_crime INT PRIMARY KEY,
	notify_date NVARCHAR(10) NOT NULL,
	status NVARCHAR(32) NOT NULL
)
GO

CREATE TABLE complaint(
	id_profile INT NOT NULL,
	id_crime INT NOT NULL,
	id_victim INT NOT NULL,
	testimony NVARCHAR(2048) NOT NULL	
)
GO

CREATE TABLE crime_list(
	id_profile INT NOT NULL,
	id_crime INT NOT NULL
)
GO

CREATE TABLE prisoners (
	id_crime INT PRIMARY KEY,
	detention_date NVARCHAR(10) NOT NULL,
	prison_address NVARCHAR(64) NOT NULL,
	jail_time NVARCHAR(32) NOT NULL
)
GO

ALTER TABLE crime_list
ADD CONSTRAINT pk_clID PRIMARY KEY (id_profile, id_crime)
GO

ALTER TABLE complaint
ADD CONSTRAINT fk_idProfile FOREIGN KEY(id_profile) REFERENCES case_profile(id_profile)
GO

ALTER TABLE complaint
ADD CONSTRAINT fk_idCrime FOREIGN KEY(id_crime) REFERENCES crime_infomation (id_crime)
GO

ALTER TABLE complaint
ADD CONSTRAINT fk_idVictim FOREIGN KEY(id_victim) REFERENCES victim (id_victim)
GO

ALTER TABLE complaint
ADD CONSTRAINT pk_Complaint PRIMARY KEY (id_profile, id_crime, id_victim)
GO

ALTER TABLE crime_list
ADD CONSTRAINT fk_idProfileCL FOREIGN KEY (id_profile) REFERENCES case_profile (id_profile)
GO

ALTER TABLE crime_list
ADD CONSTRAINT fk_idCrimeCL FOREIGN KEY (id_crime) REFERENCES crime_infomation (id_crime)
GO

ALTER TABLE wanted
ADD CONSTRAINT fk_idCrimeW FOREIGN KEY (id_crime) REFERENCES crime_infomation (id_crime)
GO

ALTER TABLE victim
ADD CONSTRAINT fk_idProfileC FOREIGN KEY (id_profile) REFERENCES case_profile (id_profile)
GO

ALTER TABLE prisoners
ADD CONSTRAINT fk_idCrimeP FOREIGN KEY (id_crime) REFERENCES crime_infomation (id_crime)
GO

ALTER TABLE list_inquisitor
ADD CONSTRAINT pk_IDL PRIMARY KEY (id_profile, username)
GO

ALTER TABLE list_inquisitor
ADD CONSTRAINT fk_idProfileL FOREIGN KEY (id_profile) REFERENCES case_profile (id_profile)
GO

ALTER TABLE list_inquisitor
ADD CONSTRAINT fk_usernameL FOREIGN KEY (username) REFERENCES account (username)
GO
INSERT INTO account(username,password ,email,permission ,full_name,gender ,birth,address ,phone_number ,workplace ,avartar )
VALUES ('admin','12345','abc@email.com',1,N'Bùi Như Lạc',0,'10/10/2015',N'Đội Cấn','0123456789',N'Công an quận Long Biên','abc'),
('admin1','123456','bcd@email.com',1,N'Mai Thanh Toán',0,'11/11/2011',N'Vạn Bảo','0987654321',N'Công an Vạn Bảo','abc'),
('admin2','1234567','jav@email.com',1,N'Vũ Thanh Huyền',1,'29/02/1996',N'Trần Duy Hưng','1234567890',N'Công an Trần Duy Hưng','abc'),
('admin3','22222','xxx@email.com',1,N'Nguyễn Văn A',1,'22/12/1996',N'Trần Nhân Tông','1111',N'Công an Trần Nhân Tông','abc');
Go
INSERT INTO crime_infomation(crime_name ,id_card ,gender ,birth ,hometown,address ,jobs ,nationality ,crime_type ,avatar)
VALUES (N'Vũ Thị Thanh Huyền',1,0,'11/11/2011',N'Khoái Châu',N'Đội Cấn',N'Bán mắm tôm','VN',N'Mưu sát','abc'),
(N'Trương Bá Nam',1,1,'12/12/2012',N'Long Biên',N'Đội Cấn','Coder','VN',N'Hiếp Dâm','abc'),
(N'Đỗ Việt Huy',1,1,'13/13/2013',N'Hải Phòng',N'Đội Cấn','Coder','VN',N'Ngộ sát','abc'),
(N'Dương Ngọc Sơn',1,1,'11/1/2013',N'Hà Nam',N'Đội Cấn','Coder','VN',N'Quá đẹp zai','abc'),
(N'Lê Thị Bưởi',1,0,'00/00/2000',N'Lũng Cú',N'Đội Cấn','Coder','VN',N'Ngộ sát','abc');
Go
INSERT INTO case_profile(day_admission ,crime_scene ,exhibit ,accusation ,conclude ,status )
VALUES ('10/10/2010',N'Đội Cấn',N'Bút Bi',N'Giết người',N'Chung Thân','abc'),
('11/11/2011',N'Vạn Bảo',N'Xe máy',N'Tai nạn giao thông',N'Tạm giữ giấy tờ xe','abc'),
('12/12/2012',N'Kim Mã','oto',N'Cản trở giao thông',N'Phạt hành chính','abc');
Go
INSERT INTO victim(victim_name ,id_card ,gender ,birth ,address ,nationality ,isDead,autopsy_date ,reasons_dead ,id_profile)
VALUES (N'Cô bán bún',1,0,'22/12/2112',N'Hà Nội',N'Việt Nam',1,'22/10/2012',N'Bị mưu sát',2),
(N'Anh bán than',2,1,'22/12/2112',N'Hà Nội',N'Việt Nam',0,NULL,NULL,2),
(N'Vũ Thanh Huyền',2,0,'29/2/2112',N'Hà Nội',N'Việt Nam',0,'20/10/2015',N'Bị ăn đòn vì quá láo',2);
Go
INSERT INTO  wanted (id_crime,notify_date,status)
VALUES (1,'11/11/2011','abc'),
(2,'10/10/2000','bcd'),
(3,'05/05/2005','efg');
Go
INSERT INTO  list_inquisitor (id_profile ,username)
VALUES (1,'admin'),
(2,'admin1'),
(3,'admin2');
Go
INSERT INTO complaint (id_profile,id_crime ,id_victim ,testimony)
VALUES (1,1,1,'aaaaaa'),
(2,2,2,'xxxxx');
Go
INSERT INTO crime_list(id_profile ,id_crime )
VALUES (1,1),
(2,2),
(3,3);
GO
INSERT INTO prisoners (id_crime,detention_date ,prison_address ,jail_time)
VALUES (1,'20/10/2010',N'Hoả Lò','365 day'),
(2,'21/11/2011',N'Lũng Cú','365 day'),
(3,'22/12/2012',N'Côn Lôn','365 day');
Go
