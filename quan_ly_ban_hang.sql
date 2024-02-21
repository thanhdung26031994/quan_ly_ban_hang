drop database if exists quan_ly_ban_hang;
create database if not exists quan_ly_ban_hang;

use quan_ly_ban_hang;

create table khach_hang(
	id int primary key auto_increment,
    ten varchar(255),
    sdt char(10),
    email varchar(255),
    dia_chi varchar(255)
);

create table san_pham(
	id int primary key auto_increment,
    ma char(4),
    ten varchar(255),
    gia float check (gia > 0),
    so_luong int
);

create table hoa_don(
	id int primary key auto_increment,
    ngay_ban date,
    tong_tien float,
    id_kh int,
    foreign key(id_kh) references khach_hang(id)
);

create table chi_tiet_hoa_don(
	id int primary key auto_increment,
    id_hd int,
    id_sp int,
    so_luong int,
    foreign key(id_hd) references hoa_don(id),
    foreign key(id_sp) references san_pham(id)
);

insert into khach_hang
values (1, 'Hải Nhật', '0987654321', 'hainhat@gmail.com', 'Huế'),
(2, 'Đăng Pháp', '081234560', 'dangphap@gmail.com', 'Quảng Nam');
insert into hoa_don
values (1, '2024-01-01', 17900, 1),
(2, '2024-02-02', 2200.00, 2);

insert into san_pham
values (1, 'SP01', 'Áo thun', '150.000', 10),
(2, 'SP02', 'Quần Jean', '270.000', 15),
(3, 'SP03', 'Mũ Sơn', '310.000', 5),
(4, 'SP04', 'Giày Niken', '2500.000', 8),
(5, 'SP05', 'Đồng Hồ', '1800.000', 9);

insert into chi_tiet_hoa_don
values (1, 1, 1, 1),
(2, 2, 2, 2);

select hoa_don.*, khach_hang.ten, khach_hang.sdt
from hoa_don
join khach_hang on khach_hang.id = hoa_don.id_kh;



DELIMITER //
create procedure get_all_cthd()
begin
select ct.id as stt, sp.ma as masp, sp.ten as ten, ct.so_luong as soluong,sp.gia as giaban, (ct.so_luong * sp.gia) as tien
from chi_tiet_hoa_don ct
join san_pham sp on sp.id = ct.id_sp
join hoa_don hd on hd.id = ct.id_hd;
end //
DELIMITER ;

call get_all_cthd();



select sp.ma as masp, sp.ten as ten, ct.so_luong as soluong, kh.ten as tenKH
from chi_tiet_hoa_don ct
join san_pham sp on sp.id = ct.id_sp
join hoa_don hd on hd.id = ct.id_hd
join khach_hang kh on kh.id = hd.id_kh;