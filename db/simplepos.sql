-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Bulan Mei 2023 pada 18.27
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simplepos`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `idcustomer` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `idsales` varchar(100) DEFAULT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` varchar(50) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedby` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `mygroup`
--

CREATE TABLE `mygroup` (
  `idgroup` int(11) NOT NULL,
  `group_name` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` varchar(200) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedby` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mygroup`
--

INSERT INTO `mygroup` (`idgroup`, `group_name`, `description`, `created`, `createdby`, `updated`, `updatedby`) VALUES
(1, 'administrator', 'Administrator', '2016-04-26 00:04:00', 'System', '2023-03-20 00:00:00', 'system'),
(2, 'kasir', 'Kasir', '2016-04-26 00:05:00', 'System', '2023-03-20 00:00:00', 'system'),
(3, 'super admin', 'Super Admin', '2018-01-08 18:52:49', 'system', '2018-01-08 18:52:49', 'system');

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `idsupplier` bigint(11) UNSIGNED NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `description` text,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` varchar(50) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedby` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`idsupplier`, `name`, `address`, `phone`, `description`, `created`, `createdby`, `updated`, `updatedby`) VALUES
(1, 'Tri Mitra Handal', 'Jakarta', '08989481222', 'Jakarta', '2017-04-29 16:47:40', 'administrator', '2023-03-17 23:23:39', 'Administrator'),
(3, 'Andi', 'Purbalingga', '08569283811', 'Penyetok Kedua', '2017-05-05 15:03:43', 'administrator', '2023-03-17 23:23:52', 'Administrator'),
(4, 'Tata', 'Cilacap', '087573717233', 'Tata Cilacap', '2023-03-23 14:02:57', 'Administrator', '2023-03-23 14:02:57', 'Administrator');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `status` enum('nonactive','active') NOT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` varchar(200) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedby` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `name`, `email`, `status`, `created`, `createdby`, `updated`, `updatedby`) VALUES
(1, 'administrator', 'e10adc3949ba59abbe56e057f20f883e', 'Administrator', '', 'nonactive', '2016-04-26 00:08:00', 'System', '2023-03-20 00:00:00', 'administrator'),
(2, 'dimas', '31781647244955850622fb2f37c5244f', 'H.F. Dimastrian', '', 'nonactive', '2016-04-26 00:09:00', 'System', '2017-04-29 16:44:17', 'administrator'),
(3, 'kinan', 'f81db5fec0b004d37df80bd0cf7e36a5', 'Kinanti Nuke M.', '', 'nonactive', '2016-04-26 00:09:00', 'System', '2017-04-29 16:45:01', 'administrator')

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_group`
--

CREATE TABLE `user_group` (
  `iduser_group` int(11) NOT NULL,
  `iduser` int(11) DEFAULT NULL,
  `idgroup` int(11) DEFAULT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` varchar(200) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `updatedby` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_group`
--

INSERT INTO `user_group` (`iduser_group`, `iduser`, `idgroup`, `created`, `createdby`, `updated`, `updatedby`) VALUES
(1, 1, 1, '2016-04-26 00:10:00', 'System', NULL, NULL),
(2, 2, 2, '2016-04-26 00:11:00', 'System', NULL, NULL),
(3, 3, 2, '2016-04-26 00:12:00', 'System', NULL, NULL),
(6, 8, 2, '2016-05-03 19:44:39', NULL, NULL, NULL),
(9, 13, 1, '2023-03-19 22:50:45', 'super admin', '2023-03-19 22:50:45', 'super admin'),
(10, 9, 3, '2023-03-20 19:05:34', 'system', '2023-03-20 19:05:34', 'system');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idcustomer`);

--
-- Indeks untuk tabel `mygroup`
--
ALTER TABLE `mygroup`
  ADD PRIMARY KEY (`idgroup`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idsupplier`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- Indeks untuk tabel `user_group`
--
ALTER TABLE `user_group`
  ADD PRIMARY KEY (`iduser_group`),
  ADD KEY `iduser` (`iduser`,`idgroup`),
  ADD KEY `idgroup` (`idgroup`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `idcustomer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11150;

--
-- AUTO_INCREMENT untuk tabel `mygroup`
--
ALTER TABLE `mygroup`
  MODIFY `idgroup` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `supplier`
--
ALTER TABLE `supplier`
  MODIFY `idsupplier` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `user_group`
--
ALTER TABLE `user_group`
  MODIFY `iduser_group` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `user_group`
--
ALTER TABLE `user_group`
  ADD CONSTRAINT `user_group_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_group_ibfk_2` FOREIGN KEY (`idgroup`) REFERENCES `mygroup` (`idgroup`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
