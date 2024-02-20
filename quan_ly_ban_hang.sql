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
    fon_gia float,san_phamkhach_hang
    foreign key(id_hd) references hoa_don(id),
    foreign key(id_sp) references san_pham(id)
);

insert into khach_hang
values (1, 'Hải Nhật', '0987654321', 'hainhat@gmail.com', 'Huế');