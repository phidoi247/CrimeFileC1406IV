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
VALUES ('admin','123456','abc@email.com',1,N'Bùi Như Lạc',0,'10/10/2015',N'Đội Cấn','0123456789',N'Công an quận Long Biên','aaaaaa'),
('admin1','123456','bcd@email.com',1,N'Mai Thanh Toán',0,'11/11/2011',N'Vạn Bảo','0987654321',N'Công an Vạn Bảo','bbbbbb'),
('user1','123','jav@email.com',2,N'Vũ Thanh Huyền',1,'29/02/1996',N'Trần Duy Hưng','1234567890',N'Công an Trần Duy Hưng','cccccccc'),
('user2','123','xxx@email.com',2,N'Nguyễn Văn A',1,'22/12/1996',N'Cầu Giấy','111111111',N'Công an Cầu Giấy','dddđ'),
('user3','123','aaa@email.com',2,N'Nguyễn Văn B',1,'01/02/1996',N'Xuân Thủy','2222222',N'Công an Xuân Thủy','eeeeeeee'),
('user4','123','bbb@email.com',2,N'Nguyễn Thị Nở ',0,'02/03/1996',N'Hai Bà Trưng','333333',N'Công an Hai Bà Trưng','ffffffff'),
('user5','123','ccc@email.com',2,N'Phan Chí Phèo',1,'03/04/1996',N'Tô Hiệu','4444444',N'Công an Tô Hiệu','ggggggg'),
('user6','123','ddd@email.com',2,N'Nguyễn Bá Quân',1,'04/05/1996',N'Phạm Văn Đồng','555555',N'Công an Phạm Văn Đồng','hhhhhhhhhhh'),
('user7','123','eee@email.com',2,N'Tạ Tuấn Anh',1,'05/06/1996',N'Phan Kế Bính','6666666',N'Công an Phan Kế Bính','iiiiiiiiiii'),
('user8','123','ggg@email.com',2,N'Đoàn Hoàng Long',1,'07/08/1996',N'Nguyễn Chí Thanh','777777',N'Công an Nguyễn Chí Thanh','kkkkkkkkk');
Go
INSERT INTO crime_infomation(crime_name ,id_card ,gender ,birth ,hometown,address ,jobs ,nationality ,crime_type ,avatar)
VALUES (N'Vũ Thị Thanh Huyền',1,0,'11/11/2011',N'Khoái Châu',N'Đội Cấn',N'Bán mắm tôm','VN',N'Mưu sát','aaa'),
(N'Trương Bá Nam',1,1,'12/12/2012',N'Long Biên',N'Vạn Bảo',N'Bán Than','VN',N'Hiếp Dâm','bbbb'),
(N'Đỗ Việt Huy',1,1,'13/01/2013',N'Hải Phòng',N'Vạn Phúc',N'Bán Gỗ','VN',N'Ngộ sát','ccccc'),
(N'Dương Ngọc Sơn',1,1,'11/1/2013',N'Hà Nam',N'Cầu Diễn',N'Coder','VN',N'Quá đẹp zai','vvvvvv'),
(N'NGuyễn Bá Quân',1,1,'01/02/2000',N'Bắc Ninh',N'Nhổn',N'Bán Muối','VN',N'Cản trở giao thông','nnnnnnnn'),
(N'Tạ Tuấn Anh',1,1,'02/03/2000',N'Ninh Bình',N'Láng Hạ',N'Bán Gạo','VN',N'Chống người thi hành công vụ','mmmmmmmmm'),
(N'Đoàn Hòang Long',1,1,'03/04/2000',N'Tuyên Quang',N'Thái Hà',N'Bán Bánh','VN',N'Cướp ngân hàng','zzzzzz'),
(N'Phan Văn Phản',1,1,'05/06/2000',N'Tây Nguyên',N'NGuyễn Thái Học',N'Bán Cơm','VN',N'Cướp ngân hàng','xxxxx'),
(N'Lô Như Lốc',1,0,'07/08/2000',N'Nha Trang',N'Tô Hiệu',N'Bán Rau','VN',N'Gây tai nạn giao thông','eeeeeee'),
(N'Bùi Như Lạc',1,0,'09/10/2000',N'Phúc Quốc',N'Hai Bà Trưng',N'Bán Rượu','VN',N'Chiếm đoạt tài sản','ttttt');

Go
INSERT INTO case_profile(day_admission ,crime_scene ,exhibit ,accusation ,conclude ,status )
VALUES ('10/10/2010',N'Đội Cấn',N'Bút Bi',N'Giết người',N'Chung Thân','abc'),
('11/11/2011',N'Vạn Bảo',N'Xe máy',N'Tai nạn giao thông',N'Tạm giữ giấy tờ xe','abc'),
('02/02/2012',N'Kim Mã','oto',N'Cản trở giao thông',N'Phạt hành chính','abc'),
('03/04/2013',N'Thụy KHuê',N'Súng ngắn',N'Cướp ngân hàng',N'10 năm tù giam','abc'),
('05/06/2014',N'Tây Hồ',N'Dao bấm',N'Cố ý gây thương tích',N'2 năm tù giam','abc'),
('07/08/2015',N'Cầu Giấy',N'Lựu đạn',N'Cướp ngân hàng',N'10 năm tù giam','abc'),
('09/10/2016',N'Tây Sơn','AK-47',N'Giết người',N'Tử hình','abc'),
('10/11/2017',N'Giải Phóng','Bình hơi cay',N'Chống người thi hành công vụ',N'3 năm tù treo','abc'),
('13/02/2018',N'Nguyễn Trí Thanh','oto',N'Gây tai nạn giao thông',N'Phạt hành chính','abc'),
('22/10/2019',N'Khuất Duy Tiến','oto',N'Gây tai nạn giao thông',N'Phạt hành chính','abc');
Go
INSERT INTO victim(victim_name,id_card ,gender ,birth ,address ,nationality ,isDead,autopsy_date ,reasons_dead ,id_profile)
VALUES (N'Cô bán bún',1,0,'01/02/2112',N'Hà Nội',N'Việt Nam',1,'22/10/2012',N'Bị mưu sát',2),
(N'Anh bán than',2,1,'03/04/2112',N'Tây Nguyên',N'Việt Nam',0,NULL,NULL,2),
(N'Vũ Thanh Huyền',2,0,'05/06/2112',N'Kon Tum',N'Việt Nam',0,'20/10/2015',N'Bị ăn đòn vì quá láo',2),
(N'Anh bán cơm',1,1,'07/08/2112',N'Đắk Lắk',N'Việt Nam',0,NULL,NULL,2),
(N'Chị bán rau',1,0,'09/10/2112',N'Gia Lai',N'Việt Nam',1,'22/10/2012',N'Bị hãm hại',2),
(N'Thợ sửa ống nước',1,1,'11/12/2112',N'Nha Trang',N'Việt Nam',0,NULL,NULL,2),
(N'Cô đếm tiền',1,0,'22/01/2112',N'Vũng Tàu',N'Việt Nam',0,NULL,NULL,2),
(N'Anh bán muối',1,1,'23/02/2112',N'Phú Quốc',N'Việt Nam',0,NULL,NULL,2),
(N'Cô bán rượu',1,0,'24/03/2112',N'Cần Thơ',N'Việt Nam',0,NULL,NULL,2),
(N'Cô bán thân',1,0,'25/05/2112',N'Cao Bằng',N'Việt Nam',0,NULL,NULL,2);
Go
INSERT INTO  wanted (id_crime,notify_date,status)
VALUES (1,'11/11/2011','aaaa'),
(2,'10/10/2000','bbbb'),
(3,'02/02/2002','efg'),
(4,'05/05/2005','cccc'),
(5,'06/06/2006','dddd'),
(6,'07/07/2007','eeee'),
(7,'08/08/2008','ffff'),
(8,'09/09/2009','gggg'),
(9,'12/12/2012','hhhh'),
(10,'01/01/2001','kkkk');

Go
INSERT INTO  list_inquisitor (id_profile ,username)
VALUES (1,'admin'),
(2,'admin1'),
(3,'user1'),
(4,'user2'),
(5,'user3'),
(6,'user4'),
(7,'user5'),
(8,'user6'),
(9,'user7'),
(10,'user8');
Go
INSERT INTO complaint (id_profile,id_crime ,id_victim ,testimony)
VALUES (1,1,1,'aaaaaa'),
(2,2,2,'bbbbb'),
(3,3,3,'cccccc'),
(4,4,4,'ddddd'),
(5,5,5,'eeeeee'),
(6,6,6,'ffffff'),
(7,7,7,'ggggggggg'),
(8,8,8,'jjjjjjjjjj'),
(9,9,9,'hhhhhhhhhh'),
(10,10,10,'kkkkkkkkk');
Go
INSERT INTO crime_list(id_profile ,id_crime )
VALUES (1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);

GO
INSERT INTO prisoners (id_crime,detention_date ,prison_address ,jail_time)
VALUES (1,'20/10/2010',N'Hoả Lò','365 day'),
(2,'01/11/2011',N'Lũng Cú',N'10 năm'),
(3,'02/02/2012',N'Côn Đảo',N'9 năm'),
(4,'03/03/2012',N'Tây Nguyên',N'8 năm'),
(5,'04/04/2012',N'Lạng Sơn',N'7 năm'),
(6,'05/05/2012',N'Cao Bằng',N'6 năm'),
(7,'06/06/2012',N'Móng Cái',N'5 năm'),
(8,'07/07/2012',N'Bắc Cạn',N'4 năm'),
(9,'08/08/2012',N'Bắc Giang',N'3 năm'),
(10,'09/09/2012',N'Phú Quốc',N'2 năm');
Go
