-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2025 at 05:13 AM
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
(5, 'Solo Leveling', 'Andre Estrera', '01/19/2025', 'Available');

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
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `Fname`, `Lname`, `Contactnum`, `email`, `usertype`, `Reguser`, `RegPass`, `status`) VALUES
(1, 'Carlo', 'Del Soccoro', '0923144353', 'Carlokusgan@gmail.com', 'Borrower', 'carlo12345', 'Carlo@123', 'Pending'),
(2, 'james', 'ansali', '093256588365', 'jamessvennakaigit@yahoo.com', 'Borrower', 'jemsbayot123', 'JemsBayot123', 'Pending'),
(3, 'colena', 'adam', '09231434234', 'colenanoted@yahoo.com', 'Borrower', 'colenscolens', 'ColenaNoted@123', 'Approved'),
(4, 'jeswel', 'aliganga', '0912432435', 'aligangajeswel@yahoo.com', 'Borrower', 'jeswelteves123', 'e5a732d4a3e9f0aab3908c3e849c54851391eec38abefe5f711f44f2e7791bae', 'Approved'),
(5, 'charles', 'malacaste', '09234566534', 'malacastec@yahoo.com', 'Admin', 'charles011605', 'c4acb504a8976cee6851e062550aa540a7ac48c533e27ded758d4e46c38ad0c7', 'Approved'),
(8, 'Marlo', 'Alcaya', '09234354211', 'alcayamarlo@gmail.com', 'Borrower', 'marlofannygods123', 'Marlo@123', 'Pending'),
(9, 'Marlo', 'Alcaya', '09234354211', 'alcayamarlo@gmail.com', 'Borrower', 'marlofannygods123', 'Marlo@123', 'Pending'),
(10, 'test', 'test', '092311322343', 'test@gmail.com', 'Borrower', 'test123', 'Test@123', 'Pending'),
(11, 'First Name', 'Last Name', 'Contact Number', 'Email', 'User Type', 'Username', 'Password', 'Status');

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
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
