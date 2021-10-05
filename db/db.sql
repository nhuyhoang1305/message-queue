-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2021 at 11:26 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `message_queue`
--

-- --------------------------------------------------------

--
-- Table structure for table `config`
--

CREATE TABLE `config` (
  `max_size` int(11) NOT NULL DEFAULT 50,
  `time_push` int(11) NOT NULL DEFAULT 1,
  `time_pull` int(11) NOT NULL DEFAULT 3,
  `number_of_producers` int(11) NOT NULL DEFAULT 1,
  `number_of_consumers` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `config`
--

INSERT INTO `config` (`max_size`, `time_push`, `time_pull`, `number_of_producers`, `number_of_consumers`) VALUES
(50, 1, 3, 5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `message` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL,
  `from` varchar(255) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message`, `from`) VALUES
('rkyzzneynj', 'Consumer-0'),
('cmrayabawk', 'Consumer-0'),
('kilewarjre', 'Consumer-0'),
('ffsgimezug', 'Consumer-0'),
('sntexnjekb', 'Consumer-0'),
('oalvhklzps', 'Consumer-0'),
('pjanhmnhtf', 'Consumer-0'),
('vpppxwbshc', 'Consumer-0'),
('iqxesyplxb', 'Consumer-0'),
('agvktiaznl', 'Consumer-0'),
('wwziwblpgi', 'Consumer-0'),
('wlsscpsamz', 'Consumer-1'),
('qpsptsbimm', 'Consumer-0'),
('doowmkpuvv', 'Consumer-1'),
('qnrweyznlt', 'Consumer-1'),
('eyrrsksgvb', 'Consumer-0');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
