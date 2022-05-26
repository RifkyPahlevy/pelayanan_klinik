-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2022 at 06:02 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pelayanan`
--

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `kd_obat` varchar(25) NOT NULL,
  `nm_obat` varchar(50) NOT NULL,
  `h_jual` varchar(50) NOT NULL,
  `h_beli` varchar(50) NOT NULL,
  `jumlah` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`kd_obat`, `nm_obat`, `h_jual`, `h_beli`, `jumlah`) VALUES
('K-0001', 'Decolgen', '5000', '6000', '45');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `no_pasien` varchar(25) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `j_kelamin` varchar(50) NOT NULL,
  `tgl_lahir` varchar(50) NOT NULL,
  `no_tlp` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`no_pasien`, `nama`, `j_kelamin`, `tgl_lahir`, `no_tlp`, `alamat`) VALUES
('P-0001', 'Rifky', 'Laki-Laki', '18/06/2000', '021778882', 'Jl.Veteran'),
('P-0002', 'Pahlevy', 'Laki-Laki', '2022-05-26', '08777', 'dds'),
('P-0003', 'Arab', 'Laki-Laki', '2022-05-26', '0986655', 'Durentiga'),
('P-0004', 'Puan Maharani', 'Perempuan', '2022-05-26', '0988888', 'Bekasi');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_byr` varchar(25) NOT NULL,
  `tgl_byr` varchar(50) NOT NULL,
  `admin` varchar(50) NOT NULL,
  `no_rekam` varchar(25) NOT NULL,
  `kd_ptgs` varchar(25) NOT NULL,
  `no_pasien` varchar(25) NOT NULL,
  `kd_obat` varchar(25) NOT NULL,
  `jumlah` varchar(50) NOT NULL,
  `h_obat` varchar(50) NOT NULL,
  `biaya_lyn` varchar(50) NOT NULL,
  `ttl_bayar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_byr`, `tgl_byr`, `admin`, `no_rekam`, `kd_ptgs`, `no_pasien`, `kd_obat`, `jumlah`, `h_obat`, `biaya_lyn`, `ttl_bayar`) VALUES
('PB0001', '2021-12-26', ' Udin', 'PR0001', 'KP0001', 'P-0001', 'K-001', '1', '1000', '40000', '900000'),
('PB0004', '2022-05-26', '', 'PR0003', 'Rifky', 'Puan Maharani', 'K-0001', '2', '5000', '10000', '15000'),
('PB0005', '2022-05-26', '', 'PR0003', 'Rifky', 'Puan Maharani', 'K-0001', '2', '5000', '10000', '10000');

--
-- Triggers `pembayaran`
--
DELIMITER $$
CREATE TRIGGER `stok` AFTER INSERT ON `pembayaran` FOR EACH ROW BEGIN 
UPDATE obat SET jumlah = jumlah - NEW.jumlah
WHERE kd_obat = NEW.kd_obat;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pemeriksaan`
--

CREATE TABLE `pemeriksaan` (
  `no_rekam` varchar(20) NOT NULL,
  `tgl_prksa` varchar(50) NOT NULL,
  `no_pasien` varchar(25) NOT NULL,
  `nm_pasien` varchar(50) NOT NULL,
  `kd_ptgs` varchar(25) NOT NULL DEFAULT '',
  `nm_ptgs` varchar(50) NOT NULL DEFAULT '',
  `diagnosa` varchar(50) NOT NULL DEFAULT '',
  `obat` varchar(100) NOT NULL DEFAULT '',
  `keterangan` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'belum diperiksa'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemeriksaan`
--

INSERT INTO `pemeriksaan` (`no_rekam`, `tgl_prksa`, `no_pasien`, `nm_pasien`, `kd_ptgs`, `nm_ptgs`, `diagnosa`, `obat`, `keterangan`, `status`) VALUES
('PR0001', '26-05-2022 14:40:43', 'P-0002', 'Pahlevy', '', '', '', '', 'dsds', 'belum diperiksa'),
('PR0002', '26-05-2022 14:41:23', 'P-0003', 'Arab', 'KP0002', 'Akmal', 'flue', ' 1. bodrex	\n 2. tolak', 'Sakit', 'sudah diperiksa'),
('PR0003', '26-05-2022 22:04:01', 'P-0004', 'Puan Maharani', 'KP0001', 'Rifky', 'Alergi', ' 1. Salep\n 2. Sabun Colek\n 3. Bedak Herosin\n 4. Bedak Salisil', 'Alergi kuping membesar ', 'sudah diperiksa');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `kd_ptgs` varchar(25) NOT NULL,
  `nama_ptgs` varchar(50) NOT NULL,
  `j_kelamin` varchar(25) NOT NULL,
  `no_tlp` varchar(50) NOT NULL,
  `profesi` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`kd_ptgs`, `nama_ptgs`, `j_kelamin`, `no_tlp`, `profesi`, `email`, `password`, `alamat`) VALUES
('KP0001', 'Rifky', 'Laki-Laki', 'Dokter', '0899938', 'rifky@gmail.com', '1234', 'Veteran'),
('KP0002', 'Wahid', 'Laki-Laki', 'Admin', '08977666', 'wahid@gmail.com', '1234', 'Durentiga');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `kode` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`kode`, `nama`, `password`, `level`) VALUES
('KP0001', 'Rifky', '1234', 'Dokter'),
('KP0002', 'Wahid', '1234', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`kd_obat`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`no_pasien`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_byr`);

--
-- Indexes for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD PRIMARY KEY (`no_rekam`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`kd_ptgs`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
