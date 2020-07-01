====================MODUL_1====================

#Langkah_Pertama

create tablespace septiadipraktikum07028
datafile 'B:\SEMESTER 4\BD\Soal Praktikum\septiadi_praktikum07028.dbf'
size 30m;

create user septiadipraktikum_07028
identified by 040900
default tablespace septiadipraktikum07028
quota 30m on septiadipraktikum07028;

grant all privileges to septiadipraktikum_07028;

conn septiadipraktikum_07028/040900;

#Langkah_Kedua

create table admin_07028
(
id_admin INTEGER not null,
nama_admin VARCHAR2(32),
jenis_admin VARCHAR2(16),
alamat VARCHAR2(100),
telp VARCHAR2(16),
username VARCHAR2(16),
password VARCHAR2(16),
aktivasi VARCHAR2(11),
constraint PK_admin primary key (id_admin)
);

create table kamar_07028
(
id_kamar INTEGER not null,
id_harga INTEGER,
nama_kamar VARCHAR2(20),
no_kamar NUMBER(3),
jenis_kamar VARCHAR2(30),
stok NUMBER(2),
status VARCHAR2(20),
constraint PK_kamar primary key (id_Kamar)
);

create table harga_07028
(
id_harga INTEGER not null,
nama_barang VARCHAR2(64),
daftar_harga INTEGER,
kategori VARCHAR2(20),
constraint PK_harga primary key (id_harga)
);

create table pembayaran_07028
(
id_pembayaran INTEGER not null,
id_laporan INTEGER,
id_booking INTEGER,
jenis_pembayaran VARCHAR2(30),
biaya_lain INTEGER,
total INTEGER,
keterangan VARCHAR2(100),
constraint PK_pembayaran primary key (id_pembayaran)
);

create table laporan_07028
(
id_laporan INTEGER not null,
id_pembayaran INTEGER,
tanggal DATE,
constraint PK_laporan primary key (id_laporan)
);

create table booking_07028
(
id_booking INTEGER not null,
id_kamar INTEGER,
id_admin INTEGER,
nama_pengunjung VARCHAR2(32),
alamat_pengunjung VARCHAR2(100),
telp_pengunjung VARCHAR2(16),
tanggal_masuk DATE,
tanggal_keluar DATE,
status VARCHAR2(32),
keterangan VARCHAR(100),
constraint PK_booking primary key (id_booking)  
);

#Langkah_Ketiga

alter table kamar_07028
add constraint FK_id_harga FOREIGN KEY (id_harga)
references harga_07028(id_harga);

alter table booking_07028
add constraint FK_id_kamar FOREIGN KEY (id_kamar)
references kamar_07028(Id_kamar)
add constraint FK_id_admin FOREIGN KEY (id_admin)
references admin_07028(Id_admin);

alter table pembayaran_07028
add constraint FK_id_booking FOREIGN KEY (id_booking)
references booking_07028(id_booking);

alter table laporan_07028
add constraint FK_id_pembayaran FOREIGN KEY (id_pembayaran)
references pembayaran_07028(id_pembayaran);

#Langkah_Keempat
create sequence id_admin
minvalue 1
maxvalue 999
start with 6
increment by 1
cache 20;

create sequence id_harga
minvalue 1
maxvalue 999
start with 6
increment by 1
cache 20;

create sequence id_kamar
minvalue 1
maxvalue 999
start with 6
increment by 1
cache 20;

create sequence id_booking
minvalue 1
maxvalue 999
start with 6
increment by 1
cache 20;

create sequence id_pembayaran
minvalue 1
maxvalue 999
start with 6
increment by 1
cache 20;

create sequence id_laporan
minvalue 1
maxvalue 999
start with 6
increment by 1
cache 20;

#Langkah_Kelima

alter table laporan_07028 rename column tanggal_keluar to 07028_tanggal_keluar;

#Langkah_Keenam

alter table kamar_07028
add constraint kamar_unique
unique (nama_kamar);

#Langkah_Ketujuh

alter table admin_07028 modify(aktivasi INTEGER);



====================MODUL_2====================

#Langkah_1

conn septiadipraktikum_07028/040900

=================TABEL ADMIN=================
#1_A (tabel admin)
insert into admin_07028 values (1, 'Septiadi Rachmat Santoso', 'Staff', 'Babatan Indah', '082140933554', 'adiofficials', '040900', 1);
insert into admin_07028 values (2, 'Daffa Rahmatul', 'Staff', 'Peneleh', '082140966882', 'daffa', 'daffa123', 0);

#1_B (tabel admin)
insert all
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (3, 'Bima Kurnia', 'Staff', 'SDA', '085230833443', 'bima', 'bima123', 0)
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (4, 'Ikhlasul Amal', 'Staff', 'Menganti', '082190255324', 'ikhlas', 'ikhlas123', 0)
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (5, 'Nicholas Sumardi', 'Staff', 'SDA', '082140466554', 'nichol', 'nichol123', 0)
select 1 from dual;

#1_C (tabel admin)
INSERT INTO admin_07028 values (id_admin.nextval, 'Zaedar Rahman', 'Staff', 'SDA', '082150866774', 'zaedar', 'zaedar123', 0);



=================TABEL HARGA=================
#1_A (tabel harga)
insert into harga_07028 values (1, 'VVIP Rooms Class I', '2500000', 'Kamar');
insert into harga_07028 values (2, 'VVIP Rooms Class II', '2000000', 'Kamar');

#1_B (tabel harga)
insert all
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (3, 'VIP Rooms Class I', '1500000', 'Kamar')
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (4, 'VIP Rooms Class II', '750000', 'Kamar')
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (5, 'Standart Rooms Class I', '500000', 'Kamar')
select 1 from dual;

#1_C (tabel harga)
INSERT INTO harga_07028 VALUES (id_harga.nextval, 'Standart Rooms Class II', '350000', 'Kamar');



=================TABEL KAMAR=================
#1_A (tabel kamar)
INSERT INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (1, 1, 'Superior Room', '601', 'VVIP Rooms Class I', 0, 'Tersedia');
INSERT INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (2, 2, 'Super Deluxe Room', '501', 'VVIP Rooms Class II', 0, 'Tersedia');

#1_B (tabel kamar)
insert all
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (3, 3, 'Deluxe Room', '401', 'VIP Rooms Class I', 0, 'Tersedia')
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (4, 4, 'Signature Room', '301', 'VIP Rooms Class II', 0, 'Tersedia')
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (5, 5, 'Natural Room', '201', 'Standart Rooms Class I', 0, 'Tersedia')
select 1 from dual;

#1_C (tabel kamar)
INSERT INTO kamar_07028 VALUES (id_kamar.nextval, 2, 'Couple Room', '101', 'Standart Rooms Class II', 0, 'Tersedia');



=================TABEL BOOKING=================
#1_A (tabel booking)

INSERT INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (1, 1, 1, 'Gery', 'surabaya', '081333992599', to_date ('28-04-2020','dd/mm/yyyy'), to_date ('30-04-2020','dd/mm/yyyy'), 'Belum Transaksi', '');
INSERT INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (2, 3, 2, 'Ahmad', 'sidoarjo', '085305869126', to_date ('30-04-2020','dd/mm/yyyy'), to_date ('02-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '');

#1_B (tabel booking)
INSERT ALL
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (3, 3, 1, 'budi ', 'ampel', '123456', to_date ('02-05-2020','dd/mm/yyyy'), to_date ('04-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (4, 4, 1, 'septi', 'palembang', '123456', to_date ('02-05-2020','dd/mm/yyyy'), to_date ('03-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (5, 5, 1, 'edo', 'bandung', '12543', to_date ('02-05-2020','dd/mm/yyyy'), to_date ('05-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
select 1 from dual;

#1_C (tabel booking)
INSERT INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (id_booking.nextval, 6, 1, 'Ahmadi', 'sidoarjo', '085305869126', to_date ('04-05-2020','dd/mm/yyyy'), to_date ('06-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '-');




=================TABEL PEMBAYARAN=================
#1_A (tabel pembayaran)
insert into pembayaran_07028 values (1, 1, 3, 'Tunai', '', '5000000', '');
insert into pembayaran_07028 values (2, 2, 3, 'Tunai', '', '4000000', '');

#1_B (tabel pembayaran)
insert all
into pembayaran_07028 (id_pembayaran, id_laporan, id_booking, jenis_pembayaran, biaya_lain, total, keterangan) values (3, 3, 3, 'Debit', '', '3000000', '')
into pembayaran_07028 (id_pembayaran, id_laporan, id_booking, jenis_pembayaran, biaya_lain, total, keterangan) values (4, 4, 4, 'Tunai', '', '1500000', '')
into pembayaran_07028 (id_pembayaran, id_laporan, id_booking, jenis_pembayaran, biaya_lain, total, keterangan) values (5, 5, 5, 'Debit', '', '1000000', '')
select 1 from dual;

#1_C (tabel pembayaran)
insert into pembayaran_07028 values (id_pembayaran.nextval, 6, 6, 'Tunai', '', '700000', '');




=================TABEL LAPORAN=================
#1_A (tabel laporan)
insert into laporan_07028 values (1, 1, to_date('30/04/2020','dd/mm/yyyy'));
insert into laporan_07028 values (2, 2, to_date('02/05/2020','dd/mm/yyyy'));

#1_B (tabel laporan)
insert all
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (3, 3, to_date('04/05/2020','dd/mm/yyyy'))
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (4, 4, to_date('03/05/2020','dd/mm/yyyy'))
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (5, 5, to_date('05/05/2020','dd/mm/yyyy'))
select 1 from dual;

#1_C (tabel laporan)
insert into laporan_07028 values (Id_laporan.nextval, 6, to_date('06/05/2020','dd/mm/yyyy'));




#Langkah_2

#2_A (tabel harga) :
SELECT * FROM kamar_07028; (Untuk cek data yang ada pada tabel)
UPDATE kamar_07028 SET Status = 'Tidak Tersedia', stok = 0 where (id_kamar = 1);
SELECT * FROM kamar_07028; (Untuk cek data yang ada pada tabel)

#2_B (tabel harga) :
SELECT * FROM harga_07028; (Untuk cek data yang ada pada tabel)
UPDATE harga_07028 SET Daftar_harga = 2000000 WHERE id_harga = 1;
UPDATE harga_07028 SET Daftar_harga = 1000000 WHERE id_harga = 2;
UPDATE harga_07028 SET Daftar_harga = 900000 WHERE id_harga = 3;
UPDATE harga_07028 SET Daftar_harga = 800000 WHERE id_harga = 4;
UPDATE harga_07028 SET Daftar_harga = 700000 WHERE id_harga = 5;
SELECT * FROM harga_07028; (Untuk cek data yang ada pada tabel)

#2_C (tabel booking)
SELECT * FROM booking_07028; (Untuk cek data yang ada pada tabel)
UPDATE booking_07028 SET Nama_pengunjung = 'Gery' WHERE Nama_pengunjung LIKE 'G%y';
UPDATE booking_07028 SET Nama_pengunjung = 'Ahmad' WHERE Nama_pengunjung LIKE 'A%';
UPDATE booking_07028 SET Nama_pengunjung = 'Budi' WHERE Nama_pengunjung LIKE 'bu%';
UPDATE booking_07028 SET Nama_pengunjung = 'Septi' WHERE Nama_pengunjung LIKE '%sep%';
UPDATE booking_07028 SET Nama_pengunjung = 'edo' WHERE Nama_pengunjung LIKE 'e%';
SELECT * FROM booking_07028; (Untuk cek data yang ada pada tabel)

#2_D (tabel booking)
SELECT * FROM booking_07028; (Untuk cek data yang ada pada tabel)
UPDATE booking_07028 SET status = 'Sudah Transaksi', keterangan = 'Note Pengunjung' WHERE (id_kamar = 1 or id_booking = 1) AND id_admin = 1;
UPDATE booking_07028 SET status = 'Sudah Transaksi', keterangan = 'Request For A Change Of Check Out' WHERE (id_kamar = 2 or id_booking = 2) AND id_admin = 2;
UPDATE booking_07028 SET status = 'Sudah Transaksi', keterangan = 'Note 1' WHERE (id_kamar = 3 or id_booking = 3) AND id_admin = 1;
UPDATE booking_07028 SET status = 'Sudah Transaksi', keterangan = 'Note 2' WHERE (id_kamar = 4 or id_booking = 4) AND id_admin = 1;
UPDATE booking_07028 SET status = 'Sudah Transaksi', keterangan = 'Note 3' WHERE (id_kamar = 5 or id_booking = 5) AND id_admin = 1;
SELECT * FROM booking_07028; (Untuk cek data yang ada pada tabel)


#Langkah_3
SELECT * FROM booking_07028; (Untuk cek data yang ada pada tabel)
DELETE FROM booking_07028 WHERE status = 'Sudah Transaksi' AND keterangan BETWEEN 'Note 1' AND 'Note 2';
DELETE FROM booking_07028 WHERE status = 'Sudah Transaksi' OR keterangan = 'Note Pengunjung';
DELETE FROM booking_07028 WHERE status = 'Sudah Transaksi' AND tanggal_keluar LIKE '%04%';
SELECT * FROM booking_07028; (Untuk cek data yang ada pada tabel)

#Langkah_4

#4_A
SAVEPOINT savepoint_1;
update booking_07028 set status = 'Sudah Transaksi' where (id_booking = 1);

#4_B
COMMIT;

#4_C
ROLLBACK TO savepoint_1; (Ini error karena setelah commit, semua savepoint yang kita buat sebelumya terhapus)

ROLLBACK; (Ini bisa dijalankan tetapi tidak berfungsi karena ada commit sebelumnya)

(Jadi kita hanya bisa melakukan rollback to savepoint / rollback jika dilakukan sebelum commit dijalankan. Jika commit dahulu yang dilakukan, maka rollback tidak dapat dilakukan.)

#Langkah_5

#5_A
SELECT * FROM kamar_07028
ORDER BY id_kamar DESC;

#5_B
select nama_kamar
from kamar_07028
GROUP BY nama_kamar;


====================MODUL_3====================

#NO_1

=================TABEL ADMIN=================
insert all
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (7, 'Alexander', 'Staff', 'SDA', '085240833443', 'alexander', 'alexander123', 0)
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (8, 'Rega', 'Staff', 'Menganti', '082150255324', 'rega', 'rega123', 0)
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (9, 'Regi', 'Staff', 'SDA', '082140786554', 'regi', 'regi123', 0)
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (10, 'Budi', 'Staff', 'SDA', '082140466224', 'budi', 'budi123', 0)
INTO admin_07028 (id_admin, nama_admin, jenis_admin, alamat, telp, username, password, aktivasi) values (11, 'Arif', 'Staff', 'SDA', '085240466554', 'arif', 'arif123', 0)
select 1 from dual;

=================TABEL HARGA=================
insert all
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (8, 'VIP Rooms Class I', '1500000', 'Kamar')
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (9, 'VIP Rooms Class II', '750000', 'Kamar')
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (10, 'Standart Rooms Class I', '500000', 'Kamar')
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (11, 'Standart Rooms Class I', '500000', 'Kamar')
INTO harga_07028 (id_harga, nama_barang, daftar_harga , kategori) VALUES (12, 'Standart Rooms Class I', '500000', 'Kamar')
select 1 from dual;

=================TABEL KAMAR=================
insert all
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (8, 3, 'Deluxe Room I', '801', 'VIP Rooms Class I', 0, 'Tersedia')
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (9, 4, 'Signature Room I', '701', 'VIP Rooms Class II', 0, 'Tersedia')
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (10, 5, 'Natural Room I', '202', 'Standart Rooms Class I', 0, 'Tersedia')
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (11, 5, 'Natural Room II', '203', 'Standart Rooms Class I', 0, 'Tersedia')
INTO kamar_07028 (id_kamar, id_harga, nama_kamar, no_kamar, jenis_kamar, stok, status) VALUES (12, 5, 'Natural Room III', '204', 'Standart Rooms Class I', 0, 'Tersedia')
select 1 from dual;

=================TABEL BOOKING=================
INSERT ALL
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (2, 2, 1, 'budi ', 'ampel', '123456', to_date ('02-05-2020','dd/mm/yyyy'), to_date ('04-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (3, 3, 1, 'septi', 'palembang', '123456', to_date ('04-05-2020','dd/mm/yyyy'), to_date ('06-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (4, 4, 1, 'edo', 'bandung', '12543', to_date ('06-05-2020','dd/mm/yyyy'), to_date ('08-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (5, 5, 1, 'bogel', 'sidoarjo', '1254521', to_date ('08-05-2020','dd/mm/yyyy'), to_date ('10-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
INTO booking_07028 (id_booking, id_kamar, id_admin, nama_pengunjung, alamat_pengunjung, telp_pengunjung, tanggal_masuk, tanggal_keluar, status, keterangan) VALUES (7, 7, 1, 'hesti', 'bandung', '12544354', to_date ('10-05-2020','dd/mm/yyyy'), to_date ('12-05-2020','dd/mm/yyyy'), 'Belum Transaksi', '')
select 1 from dual;

=================TABEL PEMBAYARAN=================
insert all
into pembayaran_07028 (id_pembayaran, jenis_pembayaran, biaya_lain, total, keterangan, id_laporan) values (7, 'Debit', '', '3000000', '', 7)
into pembayaran_07028 (id_pembayaran, jenis_pembayaran, biaya_lain, total, keterangan, id_laporan) values (8, 'Tunai', '', '1500000', '', 8)
into pembayaran_07028 (id_pembayaran, jenis_pembayaran, biaya_lain, total, keterangan, id_laporan) values (9, 'Debit', '', '1000000', '', 9)
into pembayaran_07028 (id_pembayaran, jenis_pembayaran, biaya_lain, total, keterangan, id_laporan) values (10, 'Debit', '', '1000000', '', 10)
into pembayaran_07028 (id_pembayaran, jenis_pembayaran, biaya_lain, total, keterangan, id_laporan) values (11, 'Debit', '', '1000000', '', 11)
select 1 from dual;

=================TABEL LAPORAN=================
insert all
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (7, 7, to_date('04/05/2020','dd/mm/yyyy'))
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (8, 8, to_date('03/05/2020','dd/mm/yyyy'))
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (9, 9, to_date('05/05/2020','dd/mm/yyyy'))
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (10, 10, to_date('06/05/2020','dd/mm/yyyy'))
into laporan_07028 (id_laporan, id_pembayaran, tanggal) values (11, 11, to_date('08/05/2020','dd/mm/yyyy'))
select 1 from dual;

#NO_2

SELECT id_harga, MAX(daftar_harga) AS TERBANYAK, MIN(daftar_harga) AS TERENDAH FROM harga_07028 GROUP BY id_harga;

SELECT id_pembayaran, count(id_pembayaran) AS banyak_transaksi from pembayaran_07028 where id_pembayaran = 10 AND id_laporan = 10 GROUP BY id_pembayaran;

SELECT id_harga, SUM(daftar_harga) AS total_daftar_harga 
FROM harga_07028 where nama_barang LIKE 'VIP Rooms Class I' 
GROUP BY id_harga;

SELECT avg(daftar_harga) as rata2 from harga_07028 where id_harga = 3;

#NO_3

SELECT nama_barang AS kamar_harga_terendah_tertinggi FROM harga_07028 WHERE id_harga = (SELECT id_harga FROM harga_07028 WHERE daftar_harga = (SELECT MAX(daftar_harga) FROM harga_07028)) OR id_harga = (SELECT id_harga FROM harga_07028 WHERE daftar_harga = (SELECT MIN(daftar_harga) FROM harga_07028));

SELECT nama_admin AS nama_admin,
(SELECT COUNT(*) FROM booking_07028 WHERE booking_07028.id_admin = admin_07028.id_admin AND admin_07028.alamat IS NOT NULL) AS jumlah_transaksi_ditangani
FROM admin_07028;

SELECT nama_admin AS nama_admin, (SELECT SUM(daftar_harga)
FROM harga_07028 WHERE harga_07028.id_harga = admin_07028.id_admin) AS hasil_transaksi_ditangani
FROM admin_07028 WHERE id_admin = 1;

SELECT nama_admin AS nama_admin, (SELECT AVG(daftar_harga)
FROM harga_07028 WHERE harga_07028.id_harga = admin_07028.id_admin) AS rata2_transaksi_ditangani
FROM admin_07028 WHERE id_admin = 2;

SELECT nama_admin
FROM admin_07028
WHERE id_admin < (SELECT AVG(id_admin) FROM admin_07028)
GROUP BY nama_admin;

SELECT id_harga, (SELECT MAX(daftar_harga)
FROM harga_07028) AS daftar_harga
FROM harga_07028 WHERE id_harga = (SELECT id_harga
FROM harga_07028 WHERE daftar_harga = (SELECT MAX(daftar_harga)
FROM harga_07028));

SELECT nama_barang AS kamar_harga_terendah_tertinggi 
FROM harga_07028 WHERE id_harga = (SELECT id_harga 
FROM harga_07028 WHERE daftar_harga = (SELECT MAX(daftar_harga) 
FROM harga_07028)) OR id_harga = (SELECT id_harga 
FROM harga_07028 WHERE daftar_harga = (SELECT MIN(daftar_harga) 
FROM harga_07028));

====================MODUL_3====================

#NO_2
select a.nama_cabang, b.nama_pegawai
from cabang_06977 a join
pegawai_06977 b
on a.id_cabang = b.id_cabang
where rownum <=20;

SELECT a.nama, b.tanggal_beli, c.tanggal_jual, (SELECT COUNT(*) FROM pegawai_07028) AS jumlah_seluruh_pegawai
FROM pegawai_07028 a
JOIN transaksi_beli_07028 b ON a.id_pegawai = b.id_pegawai
LEFT JOIN transaksi_jual_07028 c ON b.id_pegawai = c.id_pegawai;

====================MODUL_4====================

#NO_2
SELECT a.nama AS kamar_yang_dibooking, b.daftar_harga, b.tanggal_masuk
FROM booking_07028 a JOIN pembayaran_07028 b
ON a.id_hewan = b.id_hewan
WHERE rownum <= 2;

SELECT a.nama AS nama_pegawai_yang_menangani, b.tanggal_beli, c.tanggal_jual
FROM pegawai_07053 a
LEFT JOIN transaksi_beli_07053 b ON a.id_pegawai = b.id_pegawai
LEFT JOIN transaksi_jual_07053 c ON b.id_beli = c.id_beli
WHERE a.id_pegawai BETWEEN (SELECT MIN(id_pegawai) 
FROM pegawai_07053) AND (SELECT MAX(id_pegawai)
FROM pegawai_07053);

SELECT a.nama AS nama_hewan_yang_dibeli,
COUNT(b.id_pegawai) AS jumlah_transaksi, c.nama AS pegawai_yang_membeli
FROM hewan_07053 a
RIGHT JOIN transaksi_beli_07053 b
ON a.id_hewan = b.id_hewan
RIGHT JOIN pegawai_07053 c
ON b.id_pegawai = c.id_pegawai
WHERE NOT c.nama LIKE '%l%' AND NOT c.nama LIKE '%r%'
GROUP BY a.nama, c.nama;

#NO_3
CREATE VIEW list_hewan
AS SELECT id_hewan, nama, umur, status
FROM hewan_07053;

INSERT INTO list_hewan (id_hewan, nama, umur, status)
VALUES (101, 'Lebah', 1, 'belum terjual');

SELECT * FROM list_hewan;

#NO_4
CREATE VIEW list_transaksi_beli
AS SELECT a.nama AS nama_hewan_yang_dibeli, b.harga_beli, b.tanggal_beli
FROM hewan_07053 a JOIN transaksi_beli_07053 b
ON a.id_hewan = b.id_hewan
WHERE rownum <= 10;

CREATE VIEW list_tanggal_transaksi
AS SELECT a.nama AS nama_pegawai_yang_menangani, b.tanggal_beli, c.tanggal_jual
FROM pegawai_07053 a
LEFT JOIN transaksi_beli_07053 b ON a.id_pegawai = b.id_pegawai
LEFT JOIN transaksi_jual_07053 c ON b.id_beli = c.id_beli
WHERE a.id_pegawai BETWEEN (SELECT MIN(id_pegawai) 
FROM pegawai_07053) AND (SELECT MAX(id_pegawai)
FROM pegawai_07053);

CREATE VIEW list_pegawai_yang_membeli
AS SELECT a.nama AS nama_hewan_yang_dibeli,
COUNT(b.id_pegawai) AS jumlah_transaksi, c.nama AS pegawai_yang_membeli
FROM hewan_07053 a
RIGHT JOIN transaksi_beli_07053 b
ON a.id_hewan = b.id_hewan
RIGHT JOIN pegawai_07053 c
ON b.id_pegawai = c.id_pegawai
WHERE NOT c.nama LIKE '%l%' AND NOT c.nama LIKE '%r%'
GROUP BY a.nama, c.nama;

#NO_5
INSERT INTO list_transaksi_beli (harga_beli, tanggal_beli)
VALUES (5000000, TO_DATE('05/05/2050', 'dd/mm/yyyy'));

SELECT * FROM user_updatable_columns WHERE table_name LIKE 'LIST%';
