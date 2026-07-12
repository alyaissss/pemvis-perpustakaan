-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Jul 13, 2026 at 12:47 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id_anggota` varchar(10) NOT NULL,
  `nama_anggota` varchar(30) NOT NULL,
  `jk` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `tgl_registrasi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id_anggota`, `nama_anggota`, `jk`, `kelas`, `tgl_registrasi`) VALUES
('ID0001', 'Dinda Kirana', 'Perempuan', '1-A', '2026-04-26'),
('ID0002', 'Michael', 'Laki-Laki', '1-B', '2026-04-26'),
('ID0003', 'Cantik Alya', 'Perempuan', '2-A', '2026-04-30'),
('ID0004', 'Marsya Nur Afni', 'Perempuan', '2-B', '2026-05-01'),
('ID0005', 'Angga Yunanda', 'Laki-Laki', '3-A', '2026-05-09'),
('ID0006', 'Shenina', 'Perempuan', '3-B', '2026-05-15'),
('ID0007', 'Laqisya Naela', 'Perempuan', '4-A', '2026-05-20'),
('ID0008', 'Arkana Lutfhi', 'Laki-Laki', '4-B', '2026-05-27'),
('ID0009', 'Sharina Nurul', 'Perempuan', '5-A', '2027-05-31'),
('ID0010', 'Xavier Alden', 'Laki-Laki', '5-B', '2026-06-02'),
('ID0011', 'Zayyan Alfatih', 'Laki-Laki', '6-A', '2026-06-06'),
('ID0012', 'Gavin Narendra', 'Laki-Laki', '6-B', '2026-06-14'),
('ID0013', 'Miftahul Zanah', 'Perempuan', '1-A', '2026-06-18'),
('ID0014', 'Afifah Achmad', 'Perempuan', '1-B', '2026-06-23'),
('ID0015', 'Raden Wijaya', 'Laki-Laki', '2-A', '2026-06-29'),
('ID0016', 'Aisha Humaira', 'Perempuan', '2-B', '2026-06-08');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` varchar(10) NOT NULL,
  `isbn` varchar(30) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penulis` varchar(30) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `tahun` varchar(5) NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `stok` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `isbn`, `judul`, `penulis`, `penerbit`, `tahun`, `kategori`, `stok`) VALUES
('BK0001', '978-623-462-026-9', 'Seni Budaya Jawa dan Karawitan', 'Arina Restian', 'UMMPress', '2022', 'Kesenian & Olahraga', 16),
('BK0002', '978-623-254-520-5', 'Komik KKPK: My Supermom', 'Hilya Faizzati Mardliyah, Dkk.', 'Dar! Mizan', '2024', 'Karya Umum', 11),
('BK0003', '978-623-307-005-8', 'Ayo, Mengenal Negara ASEAN!', 'Olany Agus Widiyani', 'Badan Bahasa', '2020', 'Ilmu Sosial', 52),
('BK0004', '978-602-467-782-4', 'Ensiklopedia Sains: Memahami Sains', 'Om Books International', 'PT Penerbit Erlangga', '2023', 'Sains & Matematika', 80),
('BK0005', '978-623-254-240-2', 'KKPK REG: Sahabat Pena Istimewa', 'Aisya Najwa Kirana Alenty', 'Dar! Mizan', '2022', 'Karya Umum', 7);

-- --------------------------------------------------------

--
-- Table structure for table `denda`
--

CREATE TABLE `denda` (
  `id_denda` varchar(10) NOT NULL,
  `tgl_pembayaran` date NOT NULL,
  `jumlah_denda` varchar(11) NOT NULL,
  `id_kembali` varchar(10) NOT NULL,
  `id_petugas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `denda`
--

INSERT INTO `denda` (`id_denda`, `tgl_pembayaran`, `jumlah_denda`, `id_kembali`, `id_petugas`) VALUES
('PAY0001', '2026-07-13', '1000', 'MK0006', 'PG0005'),
('PAY0002', '2026-07-13', '5000', 'MK0010', 'PG0005');

-- --------------------------------------------------------

--
-- Table structure for table `isi`
--

CREATE TABLE `isi` (
  `id_nota` varchar(10) NOT NULL,
  `id_buku` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `isi`
--

INSERT INTO `isi` (`id_nota`, `id_buku`) VALUES
('MP0002', 'BK0001'),
('MP0001', 'BK0001'),
('MP0002', 'BK0001'),
('MP0003', 'BK0001'),
('MP0004', 'BK0001'),
('MP0005', 'BK0001'),
('MP0006', 'BK0001'),
('MP0007', 'BK0001'),
('MP0008', 'BK0001'),
('MP0009', 'BK0001'),
('MP0010', 'BK0001'),
('MP0011', 'BK0001'),
('MP0012', 'BK0001'),
('MP0013', 'BK0001'),
('MP0014', 'BK0001'),
('MP0015', 'BK0001'),
('MP0016', 'BK0001'),
('MP0017', 'BK0001'),
('MP0018', 'BK0001'),
('MP0019', 'BK0001'),
('MP0020', 'BK0001'),
('MP0021', 'BK0001'),
('MP0022', 'BK0001'),
('MP0024', 'BK0001'),
('MP0008', 'BK0005'),
('MP0008', 'BK0003'),
('MP0009', 'BK0004'),
('MP0010', 'BK0003'),
('MP0010', 'BK0005');

-- --------------------------------------------------------

--
-- Table structure for table `nota`
--

CREATE TABLE `nota` (
  `id_nota` varchar(10) NOT NULL,
  `tgl_nota` date NOT NULL,
  `id_anggota` varchar(10) NOT NULL,
  `id_petugas` varchar(10) NOT NULL,
  `jatuh_tempo` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nota`
--

INSERT INTO `nota` (`id_nota`, `tgl_nota`, `id_anggota`, `id_petugas`, `jatuh_tempo`) VALUES
('MP0001', '2026-07-07', 'ID0001', 'PG0001', '2026-07-12'),
('MP0002', '2026-07-07', 'ID0002', 'PG0001', '2026-07-12'),
('MP0003', '2026-07-07', 'ID0003', 'PG0001', '2026-07-12'),
('MP0004', '2026-07-07', 'ID0002', 'PG0001', '2026-07-12'),
('MP0005', '2026-07-07', 'ID0002', 'PG0001', '2026-07-12'),
('MP0006', '2026-07-07', 'ID0003', 'PG0001', '2026-07-12'),
('MP0007', '2026-07-07', 'ID0002', 'PG0002', '2026-07-12'),
('MP0008', '2026-07-13', 'ID0016', 'PG0002', '2026-07-20'),
('MP0009', '2026-07-01', 'ID0015', 'PG0002', '2026-07-08'),
('MP0010', '2026-07-13', 'ID0006', 'PG0005', '2026-07-20');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_kembali` varchar(10) NOT NULL,
  `tgl_nota` date NOT NULL,
  `denda` varchar(10) NOT NULL,
  `id_nota` varchar(10) NOT NULL,
  `id_petugas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id_kembali`, `tgl_nota`, `denda`, `id_nota`, `id_petugas`) VALUES
('MK0001', '2026-07-12', '0', 'MP0001', 'PG0002'),
('MK0002', '2026-07-12', '0', 'MP0001', 'PG0003'),
('MK0003', '2026-07-12', '0', 'MP0013', 'PG0001'),
('MK0004', '2026-07-12', '0', 'MP0001', 'PG0001'),
('MK0005', '2026-07-13', '1000', 'MP0004', 'PG0001'),
('MK0006', '2026-07-13', '1000', 'MP0001', 'PG0001'),
('MK0007', '2026-07-13', '0', 'MP0018', 'PG0002'),
('MK0008', '2026-07-13', '', 'MP0008', 'PG0002'),
('MK0009', '2026-07-13', '5000', 'MP0009', 'PG0005'),
('MK0010', '2026-07-13', '5000', 'MP0009', 'PG0001'),
('MK0011', '2026-07-13', '0', 'MP0010', 'PG0001');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` varchar(10) NOT NULL,
  `nama_petugas` varchar(30) NOT NULL,
  `jk` varchar(10) NOT NULL,
  `no_telp` varchar(16) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama_petugas`, `jk`, `no_telp`, `alamat`, `password`) VALUES
('PG0001', 'Rizky Febian', 'Laki-Laki', '082156792248', 'Tangerang', '123'),
('PG0002', 'Mahalini', 'Perempuan', '087763259147', 'Bekasi', 'lini~'),
('PG0003', 'Tulus', 'Laki-Laki', '082366150478', 'Bogor', 'tls075'),
('PG0004', 'Tiara Andini', 'Perempuan', '085800213698', 'Jakarta Barat', 'titi99'),
('PG0005', 'Fiersa Besari', 'Laki-Laki', '082150364430', 'Jakarta Pusat', 'bungfiersa!'),
('PG0006', 'Hanggini', 'Perempuan', '085613704281', 'Depok', '45hanggini_'),
('PG0007', 'Baskara', 'Laki-Laki', '083891476552', 'Jakarta Timur', 'hindia0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `denda`
--
ALTER TABLE `denda`
  ADD PRIMARY KEY (`id_denda`),
  ADD KEY `fk_denda_pengembalian` (`id_kembali`),
  ADD KEY `fk_denda_petugas` (`id_petugas`);

--
-- Indexes for table `isi`
--
ALTER TABLE `isi`
  ADD KEY `fk_isi_buku` (`id_buku`);

--
-- Indexes for table `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id_nota`),
  ADD KEY `fk_nota_anggota` (`id_anggota`),
  ADD KEY `fk_nota_petugas` (`id_petugas`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_kembali`),
  ADD KEY `fk_peminjaman` (`id_nota`),
  ADD KEY `fk_petugass` (`id_petugas`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `denda`
--
ALTER TABLE `denda`
  ADD CONSTRAINT `fk_denda_petugas` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`);

--
-- Constraints for table `isi`
--
ALTER TABLE `isi`
  ADD CONSTRAINT `fk_isi_buku` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`);

--
-- Constraints for table `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `fk_nota_anggota` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`),
  ADD CONSTRAINT `fk_nota_petugas` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `fk_petugass` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
