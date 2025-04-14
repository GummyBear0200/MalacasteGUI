-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2025 at 08:14 PM
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
  `log_date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `log_action`, `log_date`) VALUES
(2, 21, 'Admin added user: testest123', '2025-04-09 00:00:00'),
(3, 21, 'Admin updated user: testest123', '2025-04-09 00:00:00'),
(4, 21, 'Admin deleted user: testtwat', '2025-04-09 00:00:00'),
(5, 21, 'Admin deleted user: Andre', '2025-04-09 00:00:00'),
(6, 21, 'Admin added user: hahay123', '2025-04-09 00:00:00'),
(7, 21, 'Admin updated user: hahay123', '2025-04-09 00:00:00'),
(8, 21, 'Admin deleted user: hahay', '2025-04-09 00:00:00'),
(9, 21, 'Admin deleted user: test', '2025-04-09 00:00:00'),
(10, 21, 'Admin added user: baynas123', '2025-04-09 00:00:00'),
(11, 40, 'Admin updated user: baynas123', '2025-04-09 00:00:00'),
(12, 40, 'Admin updated user: baynas123', '2025-04-09 00:00:00'),
(13, 40, 'Admin updated user: baynas123', '2025-04-09 00:00:00'),
(14, 40, 'Admin updated user: baynas123', '2025-04-09 00:00:00'),
(15, 40, 'User updated his info: baynas123', '2025-04-09 00:00:00'),
(21, 30, 'User changed their password, User ID: 30', '2025-04-10 00:17:30'),
(23, 26, 'User changed their password, Username: colenscolens', '2025-04-10 00:26:44'),
(24, 21, 'Admin updated user: baynas123', '2025-04-10 00:40:56'),
(25, 40, 'User updated his info: baynas123', '2025-04-10 00:41:25'),
(26, 40, 'User updated his info: baynas123', '2025-04-10 00:43:46'),
(27, 40, 'User updated his info: baynas123', '2025-04-10 00:43:50'),
(28, 21, 'Admin updated user: baynas123', '2025-04-10 01:02:05'),
(29, 21, 'Admin updated user: baynas123', '2025-04-10 01:02:18'),
(30, 21, 'User updated his info: mabycrushngbayan123', '2025-04-10 01:23:46'),
(31, 21, 'Admin updated user info: baynas123', '2025-04-10 01:28:57'),
(32, 21, 'Admin updated user info: baynas123', '2025-04-10 01:29:10'),
(33, 21, 'Admin updated user info: baynas123', '2025-04-10 01:33:24'),
(34, 21, 'Admin updated user info: baynas123', '2025-04-10 01:33:58'),
(35, 40, 'User updated their info: baynas123', '2025-04-14 23:41:55'),
(36, 21, 'Admin updated user info: baynas123', '2025-04-15 00:12:12'),
(37, 21, 'Admin updated user info: baynas123', '2025-04-15 00:14:26'),
(38, 21, 'Admin updated user info: baynas123', '2025-04-15 00:15:15'),
(39, 21, 'Admin updated user info: baynas123', '2025-04-15 00:21:51'),
(40, 40, 'User updated their info: baynas123', '2025-04-15 00:30:31'),
(41, 40, 'User updated their info: baynas123', '2025-04-15 00:36:24'),
(42, 40, 'User updated their info: baynas123', '2025-04-15 00:39:17'),
(43, 40, 'User updated their info: baynas123', '2025-04-15 00:40:48'),
(44, 40, 'User updated their info: baynas123', '2025-04-15 00:42:53'),
(45, 40, 'User updated their info: baynas123', '2025-04-15 00:48:28'),
(46, 40, 'User updated their info: baynas123', '2025-04-15 00:48:51'),
(47, 40, 'User updated their info: baynas123', '2025-04-15 00:50:50'),
(48, 40, 'User updated their info: baynas123', '2025-04-15 00:51:05'),
(49, 21, 'Admin updated user info: baynas123', '2025-04-15 00:52:21'),
(50, 21, 'Admin updated user info: baynas123', '2025-04-15 00:55:14'),
(51, 21, 'Admin updated user info: baynas123', '2025-04-15 00:55:27'),
(52, 21, 'Admin updated user info: baynas123', '2025-04-15 00:57:53'),
(53, 21, 'Admin updated user info: baynas123 (User ID: 40)', '2025-04-15 01:08:38'),
(54, 26, 'User updated their info: colenscolens (User ID: 26)', '2025-04-15 01:14:11'),
(55, 26, 'User updated their info: colenscolens (User ID: 26)', '2025-04-15 01:15:58'),
(56, 26, 'User changed their password, Username: colenscolens', '2025-04-15 01:17:16'),
(57, 26, 'User changed their password, Username: colenscolens', '2025-04-15 01:30:01'),
(58, 23, 'User RESET their password, Username: reinpumped123', '2025-04-15 01:41:25'),
(59, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-15 02:11:13');

-- --------------------------------------------------------

--
-- Table structure for table `pin_requests`
--

CREATE TABLE `pin_requests` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `requested_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` enum('pending','approved') DEFAULT 'pending',
  `temp_pin` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pin_requests`
--

INSERT INTO `pin_requests` (`id`, `user_id`, `requested_at`, `status`, `temp_pin`) VALUES
(1, 26, '2025-04-06 07:21:08', 'pending', NULL),
(2, 26, '2025-04-06 08:03:00', 'approved', '123456');

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
  `SecurityQuestion` varchar(255) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `PIN` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `Fname`, `Lname`, `Contactnum`, `email`, `usertype`, `Reguser`, `RegPass`, `SecurityQuestion`, `answer`, `status`, `image`, `PIN`) VALUES
(21, 'Charles Vincent', 'Malacaste', '093256588365', 'charles@gmail.com', 'Admin', 'charles011605', 'c4acb504a8976cee6851e062550aa540a7ac48c533e27ded758d4e46c38ad0c7', 'Who is the most pumped?', 'Carlo', 'Active', '', '123456'),
(22, 'James Sven', 'Ansali Jr', '092134354546', 'ansaligwapo@gmail.com', 'Admin', 'james12345', 'f65ee020a5f1c380515e8c77f39a1d122cdb2530bd90172e14eb62c5db98e78b', 'Who is my solo friend?', 'Andre', 'Active', '', '000000'),
(23, 'Rein', 'Coronado', '091234324545', 'rein@gmail.com', 'Borrower', 'reinpumped123', '3ed98713c918bc067c8c18915f27af01ff66cd6db95a49ad9f52582c010304bc', 'Who is the most pumped?', 'Carlo', 'Active', 'C:\\Users\\II\\Downloads\\REIN.jpg', '123456'),
(26, 'Christian', 'Colina', '09202237644', 'colina@gmail.com', 'Borrower', 'colenscolens', 'c6d41388426fafd6d20fba8b0c2cde84ee8070b908a5f6032bc82fe3cb4eb906', 'What is my favorite line?', 'Okay Colina Noted!', 'Active', 'src/profileImages/COLINA.jpg', '011605'),
(29, 'Shanellayza L', 'Torres', '093434554656', 'shann@gmail.com', 'User', 'shan1234', '0157b8ac707ffbbfb865435a6d1780171ec96cd3f8ff45a5d37ad18ed4ee4935', 'What is my fav food?', 'Charles', 'Active', 'src/profileImages/ACKKKShann.jpg', '123456'),
(30, 'Maby', 'Otahay', '09233235456', 'maby@gmail.com', 'Borrower', 'mabycrushngbayan123', '1ceadcf6cfcfddccb00bcb4f78bc238d3615eeaca4adae85e118ca4760b2073f', NULL, NULL, 'Active', 'src/profileImages/MABY.png', NULL),
(40, 'Mego Gwapo', 'baynas', '09234354545', 'baynas@gmail.com', 'Borrower', 'baynas123', 'd196268bbf8059582f6b51c726be9d5a14d7fb45a06d18d19db88118722e2d46', 'Is baynas gwapo?', 'Of course, yes', 'Active', NULL, '111111');

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
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `pin_requests`
--
ALTER TABLE `pin_requests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

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
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `pin_requests`
--
ALTER TABLE `pin_requests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`);

--
-- Constraints for table `pin_requests`
--
ALTER TABLE `pin_requests`
  ADD CONSTRAINT `pin_requests_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
