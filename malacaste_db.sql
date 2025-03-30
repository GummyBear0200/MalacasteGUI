-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2025 at 07:15 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `malacaste_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `b_id` int(11) NOT NULL,
  `b_title` varchar(50) NOT NULL,
  `b_author` varchar(100) NOT NULL,
  `b_pubdate` varchar(50) NOT NULL,
  `b_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`b_id`, `b_title`, `b_author`, `b_pubdate`, `b_status`) VALUES
(1, 'English', 'James Sven Ansali', '08/29/1996', 'Available'),
(2, 'Math', 'John Carlo Ababan', '08/30/2005', 'Available'),
(3, 'OOP3', 'Mike Bustamante', '12/17/2018', 'Available'),
(4, 'Literature', 'Adamn Colina', '09/25/2008', 'Available'),
(5, '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `borrowers`
--

CREATE TABLE `borrowers` (
  `br_id` int(11) NOT NULL,
  `br_name` varchar(100) NOT NULL,
  `br_address` varchar(60) NOT NULL,
  `br_cn` varchar(50) NOT NULL,
  `br_status` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Contactnum` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `usertype` varchar(100) NOT NULL,
  `Reguser` varchar(50) NOT NULL,
  `RegPass` varchar(100) NOT NULL,
  `SecurityQuestion` varchar(255) NOT NULL,
  `answer` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL,
  `PIN` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `Fname`, `Lname`, `Contactnum`, `email`, `usertype`, `Reguser`, `RegPass`, `SecurityQuestion`, `answer`, `status`, `PIN`) VALUES
(21, 'Charles Vincent', 'Malacaste', '093256588365', 'charles@gmail.com', 'Admin', 'charles011605', 'c4acb504a8976cee6851e062550aa540a7ac48c533e27ded758d4e46c38ad0c7', 'Who is the most pumped?', 'Carlo', 'Active', '123456'),
(22, 'James Sven', 'Ansali Jr', '092134354546', 'ansaligwapo@gmail.com', 'Admin', 'james12345', 'f65ee020a5f1c380515e8c77f39a1d122cdb2530bd90172e14eb62c5db98e78b', 'Who is my solo friend?', 'Andre', 'Active', '000000'),
(23, 'Rein', 'Coronado', '091234324545', 'rein@gmail.com', 'Borrower', 'reinpumped123', '3ed98713c918bc067c8c18915f27af01ff66cd6db95a49ad9f52582c010304bc', 'Who is the most pumped?', 'Carlo', 'Active', '111111'),
(26, 'Christian', 'Colina', '09202237644', 'colina@gmail.com', 'Borrower', 'colenscolens', 'd346a3261d2d12574f04ac8ee17069caae03073990515a9023282ed751e9e3fa', 'What is my favorite line?', 'Okay Colina Noted!', 'Active', '011605');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `borrowers`
--
ALTER TABLE `borrowers`
  ADD PRIMARY KEY (`br_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
