CREATE DATABASE ASMHT_QLSV
GO
USE ASMHT_QLSV
GO

CREATE TABLE USERS(
Username nvarchar(50),
Password nvarchar(50), 
Role bit
CONSTRAINT PK_USERS PRIMARY KEY(Username)
)
GO

CREATE TABLE STUDENTS(
MaSV nvarchar(50),
HoTen nvarchar(50),
Email nvarchar(50),
SDT nvarchar(50),
GioiTinh bit,
DiaChi nvarchar(50),
Hinh nvarchar(50)
CONSTRAINT PK_STUDENTS PRIMARY KEY(MaSV)
)
GO

CREATE TABLE GRADE(
MaSV nvarchar(50),
TiengAnh float,
TinHoc float,
GDTC float
CONSTRAINT PK_GRADE PRIMARY KEY(MaSV)
foreign key(MaSV) references STUDENTS(MaSV)
)
GO

INSERT INTO USERS(Username, Password, Role)
VALUES
--role = 1: giảng viên, role = 0: cán bộ--
('giangvien', '123', 1),
('canbo', '123', 0),
('admin', '123', 1),
('admin2', '123', 0),
('nam', '888', 1),
('minh', '999', 0);


INSERT INTO STUDENTS(MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, Hinh)
VALUES
--1: nam, 0: nữ--
('PH101','Cao Van Nghia', 'nghiacv1810@gmail.com', '0126453798', 1, 'Thanh Hoa', 'nghia.jpg'),
('PH102','Đo Huyen Trang', 'huyendt1298@gmail.com', N'0948239985', 0, 'Ha Noi', 'huyen.jpg'),
('PH103','Trinh Thi Thu', 'thutt1725@gmail.com', '0967854454', 0, 'Ha Tinh', 'thu.jpg'),
('PH104','Cao Thi Van', 'vanct2625@gmail.com', '0998765456', 0, 'Ninh Binh', 'van.jpg'),
('PH105','Vuong Thien Minh', 'minhvt1210@gmail.com', '0124356978', 1, 'Hai Phong', 'minh.jpg'),
('PH106','Nguyen Xuan Khai', 'khainx2912@gmail.com', '0987245323', 1, 'Nghe An', 'khai.jpg'),
('PH107','Nguyen Lan Anh', 'anhnl1265@gmail.com', '0988256326', 0, 'Ha Nam', 'anh.jpg'),
('PH108','Tran Xuan Mai', 'maitx7687@gmail.com', '0765346879', 0, 'Thanh Hoa', 'mai.jpg'),
('PH109','Đoan Manh The', 'thedm1209@gmail.com', '0654312789', 1, 'Nam Đinh', 'the.png'),
('PH110','Đo Thi Ha', 'hadt7629@gmail.com', '0992371783', 0, 'Đong Nai', 'ha.jpg'),
('PH111','Nguyen Van Kien', 'kiennv123@gmai.com', '0123456789', 1, 'Ha Noi', 'kien.jpg');


INSERT INTO GRADE(MaSV, TiengAnh, TinHoc, GDTC)
VALUES
('PH101', 8, 9, 8),
('PH102', 9, 7, 6),
('PH103', 6, 8, 7);

SELECT * FROM USERS
SELECT * FROM STUDENTS
SELECT * FROM GRADE



























