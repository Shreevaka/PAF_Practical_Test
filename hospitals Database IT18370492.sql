-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 01:17 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospitals`
--

CREATE TABLE `hospitals` (
  `hosID` int(11) NOT NULL,
  `hosName` varchar(30) CHARACTER SET latin1 NOT NULL,
  `hosAddress` varchar(70) CHARACTER SET latin1 NOT NULL,
  `hosPhoneNo` int(10) NOT NULL,
  `hosEmail` varchar(50) CHARACTER SET latin1 NOT NULL,
  `hosNoOfRooms` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospitals`
--

INSERT INTO `hospitals` (`hosID`, `hosName`, `hosAddress`, `hosPhoneNo`, `hosEmail`, `hosNoOfRooms`) VALUES
(34, 'Nawaloka', 'Cplombo 2', 113326589, 'nawaloka@gmail.com', 246),
(35, 'Ruhunu', 'Karapitiya, Galle', 912277456, 'ruhunu@gmail.com', 118),
(36, 'Asiri', 'Colombo 10', 112222222, 'asiri@gmail.com', 330),
(37, 'Hemas', 'Colombo 3', 118822228, 'hemas@gmail.com', 100),
(38, 'Lanka Hospital', 'Colombo 4', 118888888, 'lanka@gmail.com', 156);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospitals`
--
ALTER TABLE `hospitals`
  ADD PRIMARY KEY (`hosID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospitals`
--
ALTER TABLE `hospitals`
  MODIFY `hosID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
