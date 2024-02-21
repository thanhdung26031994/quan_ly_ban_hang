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
    don_gia float,
    foreign key(id_hd) references hoa_don(id),
    foreign key(id_sp) references san_pham(id)
);

insert into khach_hang
values (1, 'Hải Nhật', '0987654321', 'hainhat@gmail.com', 'Huế');
insert into hoa_don
values (1, '2024-01-01', 17900, 1);
select hoa_don.*, khach_hang.ten, khach_hang.sdt
from hoa_don
join khach_hang on khach_hang.id = hoa_don.id_kh;

update hoa_don set ngay_ban = '2023-01-03', tong_tien = '1234', id_kh = '2' where id = 1;