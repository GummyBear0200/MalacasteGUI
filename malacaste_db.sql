-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2025 at 06:21 PM
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
(1, 'English', 'James Sven Ansali', '08/29/1996', 'unavailable'),
(2, 'Math', 'John Carlo Ababan', '08/30/2005', 'unavailable'),
(3, 'OOP3', 'Mike Bustamante', '12/17/2018', 'unavailable'),
(14, 'Pumping IV', 'Carlo Ababan', '04/22/2025', 'unavailable'),
(15, 'Solo Leveling', 'Andre Estrera', '04/22/2025', 'unavailable'),
(16, 'Language', 'James Seven', '01/23/2009', 'Available'),
(17, 'Book of Enchantment', 'Guinevere', '09/22/2021', 'Available'),
(18, 'Vishanti Book', 'Doctor Strange', '07/12/2020', 'Available'),
(19, 'The Avengers', 'Marvel', '12/20/2024', 'Available'),
(20, 'Iron Man', 'Marvel', '11/25/2011', 'Available'),
(21, 'Thanos Story', 'Marvel', '09/23/2019', 'Available'),
(22, 'Infinity War', 'Marvel', '10/19/2023', 'unavailable'),
(23, 'The Hobbit', 'Tolkien J.R', '08/20/2005', 'Available'),
(24, 'Troll or Derby', 'Red Tash', '04/21/2009', 'Available'),
(25, 'The Chronicles of Aurelia', 'Evelyn Nightshade', '03/12/2001', 'Available'),
(26, 'The Whispering Citadel', 'Thorne Blackwood', '08/25/1999', 'Available'),
(27, 'Legends of the Crystal Vale', 'Seraphina Wren', '11/03/2003', 'Available'),
(28, 'The Moonlight Archives', 'Dorian Vale', '01/27/2000', 'Available'),
(29, 'The Eternal Spire', 'Lyra Stormborn', '06/14/2002', 'Available'),
(30, 'Shadowlight Prophecy', 'Kieran Duskfall', '04/19/2004', 'Available'),
(31, 'The Last Ember', 'Selene Raventhorn', '07/09/1998', 'Available'),
(32, 'Crown of the Starborn', 'Elara Wintermere', '02/28/2005', 'Available'),
(33, 'The Warden of the Winds', 'Galen Thornhart', '12/10/2000', 'Available'),
(34, 'Twilight of the Forgotten Realms', 'Isolde Farsight', '10/01/1997', 'Available'),
(35, 'The Skybreaker’s Oath', 'Corwin Ironshade', '05/16/2001', 'Available'),
(36, 'The Queen’s Labyrinth', 'Mira Stormveil', '09/30/1996', 'Available'),
(37, 'The Oracle of Dreadmoor', 'Luther Embergrave', '03/08/2006', 'Available'),
(38, 'The Phoenix Crown', 'Adelyn Soulfire', '07/11/2002', 'Available'),
(39, 'Mistborn Legacy', 'Vin Elthranor', '01/01/1995', 'Available'),
(40, 'Vault of the Ancients', 'Malrik Dreadveil', '06/22/2003', 'Available'),
(41, 'The Mirror of Aranor', 'Talia Windwhisper', '02/14/2004', 'Available'),
(42, 'The Bloodline Pact', 'Cedric Nightveil', '08/05/1999', 'Available'),
(43, 'Path of the Stormcaller', 'Fiora Stormglen', '04/24/1998', 'Available'),
(44, 'The Song of the Hollow Throne', 'Jareth Duskmourn', '12/29/2001', 'Available'),
(45, 'Whispers from the Ember Isles', 'Lyric Flamesong', '10/17/2005', 'Available'),
(46, 'Ashes of the Dragon Empire', 'Rylen Drakespear', '07/06/2000', 'Available'),
(47, 'The Rift Beyond Stars', 'Aelric Moonglade', '11/21/1997', 'Available'),
(48, 'The Sigil of Eldermoor', 'Kaelen Deepglen', '09/13/1996', 'Available'),
(49, 'The Boundless Depths', 'Naida Waveseer', '05/08/2002', 'Available'),
(50, 'The Timekeeper’s Heir', 'Riven Nightbreeze', '01/20/1994', 'Available'),
(51, 'Veil of the Voidborn', 'Myra Ethereal', '03/03/1998', 'Available'),
(52, 'Throne of the Astral Wyrm', 'Alaric Thorneblade', '06/30/2004', 'Available'),
(53, 'The Seer’s Last Vision', 'Iris Moonstone', '12/05/1995', 'Available'),
(54, 'Oathbound to the Flame', 'Elias Starforge', '10/23/2003', 'Available'),
(55, 'Spider-Verse: Into the Multiverse', 'Stan Webber', '03/15/2008', 'Available'),
(56, 'The Rise of Iron Bat', 'Bruce McKnight', '05/10/2007', 'Available'),
(57, 'X-Force: Shadow Legacy', 'Logan Creed', '07/23/2005', 'Available'),
(58, 'Captain Solar and the Quantum Wars', 'Carol Vortex', '01/08/2011', 'Available'),
(59, 'Gotham Knights: Under the Mask', 'Damian Grayson', '11/03/2009', 'Available'),
(60, 'Nova Core: Lightfall', 'Richard Centauri', '09/27/2006', 'Available'),
(61, 'Green Specter: Toxic Origins', 'Hal Greenwood', '04/18/2004', 'Available'),
(62, 'The Uncanny Flashblade', 'Barry Turner', '06/21/2010', 'Available'),
(63, 'Black Viper: Streets of Venom', 'Selina Venomari', '12/14/2003', 'Available'),
(64, 'Iron Fist Reforged', 'Danny Randson', '02/09/2005', 'Available'),
(65, 'Omega Prime: Galaxy Enforcer', 'Zara Andromeda', '07/17/2002', 'Available'),
(66, 'Shadowhawk: Wings of Night', 'Eric Talon', '10/29/2008', 'Available'),
(67, 'Crimson Claw: Bloodlines', 'Victor Sangre', '03/01/2006', 'Available'),
(68, 'The Atom Shifter', 'Ray Palmerstone', '01/12/2007', 'Available'),
(69, 'Blue Tempest: Storm Protocol', 'Jaime Reyeson', '08/30/2001', 'Available'),
(70, 'Mystic Marvels: The Arcane War', 'Stephen Occult', '09/06/2000', 'Available'),
(71, 'Darksteel: Rise of the Alloy Avenger', 'Tony Blacksmith', '06/19/2012', 'Available'),
(72, 'Lady Phantom: The Lost Mission', 'Diana Mists', '11/27/2009', 'Available'),
(73, 'Galaxy Patrol: Titans of Time', 'Peter Starborne', '04/04/2003', 'Available'),
(74, 'Scarlet Speed: Flashpoint Return', 'Wally Zoom', '05/11/2004', 'Available'),
(75, 'The Vortex Crusaders', 'Quinn Cyclone', '10/10/2005', 'Available'),
(76, 'Night Sentinel: Vigil of Shadows', 'Rico Lunar', '02/14/2002', 'Available'),
(77, 'Phoenix Nova: Inferno Core', 'Jean Flare', '07/25/2006', 'Available'),
(78, 'Technobeast: Cyber Genesis', 'Miles Circuit', '03/30/2007', 'Available'),
(79, 'Atomic Angel: Light of Redemption', 'Angela Fusion', '12/22/2008', 'Available'),
(80, 'The Gargoyle Protocol', 'Rocky Slate', '06/28/2001', 'Available'),
(81, 'Silver Panther: Claws of Justice', 'Tariq Silvera', '08/18/2010', 'Available'),
(82, 'The Webspinner Reborn', 'Ben Arachnid', '01/03/2005', 'Available'),
(83, 'Chrono Soldier: Rift Patrol', 'Nate Tempus', '09/15/2009', 'Available'),
(84, 'Quantum Queen: Reign of Time', 'Lena Phase', '11/08/2006', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `borrowedbooks`
--

CREATE TABLE `borrowedbooks` (
  `bbr_id` int(11) NOT NULL,
  `br_id` int(11) NOT NULL,
  `b_fk` int(11) NOT NULL,
  `borrowdays` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowedbooks`
--

INSERT INTO `borrowedbooks` (`bbr_id`, `br_id`, `b_fk`, `borrowdays`, `created_at`, `updated_at`) VALUES
(1, 4, 1, 15, '2025-05-14 04:09:29', '2025-05-14 04:09:29'),
(2, 4, 15, 2, '2025-05-14 04:12:08', '2025-05-14 04:12:08'),
(5, 6, 2, 45, '2025-05-14 06:06:56', '2025-05-14 06:06:56'),
(10, 6, 14, 25, '2025-05-14 08:21:28', '2025-05-14 08:21:28'),
(12, 4, 15, 25, '2025-05-14 10:28:25', '2025-05-14 10:28:25'),
(13, 1, 3, 30, '2025-05-14 10:45:56', '2025-05-14 10:45:56'),
(14, 2, 1, 2, '2025-05-14 10:47:29', '2025-05-14 10:47:29'),
(15, 7, 22, 25, '2025-05-14 11:58:14', '2025-05-14 11:58:14');

-- --------------------------------------------------------

--
-- Table structure for table `borrowers`
--

CREATE TABLE `borrowers` (
  `br_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `br_status` varchar(20) NOT NULL DEFAULT 'not borrowed'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `borrowers`
--

INSERT INTO `borrowers` (`br_id`, `u_id`, `br_status`) VALUES
(1, 29, 'has borrowed'),
(2, 26, 'has borrowed'),
(3, 30, 'not borrowed'),
(4, 23, 'has borrowed'),
(5, 42, 'not borrowed'),
(6, 22, 'has borrowed'),
(7, 43, 'has borrowed');

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
(59, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-15 02:11:13'),
(60, 21, 'User logged in: charles011605', '2025-04-18 19:54:49'),
(61, 21, 'Admin logged in: charles011605', '2025-04-18 19:58:50'),
(62, 26, 'Password Reset Cancelled: colenscolens', '2025-04-18 20:05:04'),
(63, 40, 'User logged in: baynas123', '2025-04-18 20:10:12'),
(64, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-18 20:10:53'),
(65, 40, 'User logged out: baynas123', '2025-04-18 20:11:10'),
(66, 40, 'User logged in: baynas123', '2025-04-18 20:11:20'),
(67, 26, 'User logged in: colenscolens', '2025-04-18 20:13:53'),
(68, 26, 'User logged out: colenscolens', '2025-04-18 20:14:37'),
(69, 41, 'User registered with username: jimz123', '2025-04-18 20:15:34'),
(70, 21, 'Admin logged in: charles011605', '2025-04-18 20:15:51'),
(71, 21, 'Admin logged out: charles011605', '2025-04-18 20:16:02'),
(72, 41, 'User logged in: jimz123', '2025-04-18 20:16:09'),
(73, 41, 'User updated their info: jimz123 (User ID: 41)', '2025-04-18 20:21:35'),
(74, 41, 'User logged out: jimz123', '2025-04-18 20:21:54'),
(75, 41, 'User logged in: jimz123', '2025-04-18 20:22:00'),
(76, 40, 'User logged in: baynas123', '2025-04-18 20:26:33'),
(77, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-18 20:26:38'),
(78, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-18 20:26:55'),
(79, 40, 'User logged in: baynas123', '2025-04-18 20:30:14'),
(80, 40, 'User logged out: baynas123', '2025-04-18 20:30:19'),
(81, 26, 'User logged in: colenscolens', '2025-04-18 20:30:45'),
(82, 26, 'User updated their info: colenscolens (User ID: 26)', '2025-04-18 20:30:51'),
(83, 26, 'User updated their info: colenscolens (User ID: 26)', '2025-04-18 20:32:17'),
(84, 40, 'User logged in: baynas123', '2025-04-18 20:35:39'),
(85, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-18 20:36:03'),
(86, 40, 'User logged in: baynas123', '2025-04-18 20:40:16'),
(87, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-18 20:40:24'),
(88, 40, 'User updated their info: baynas123 (User ID: 40)', '2025-04-18 20:40:48'),
(89, 40, 'User logged in: baynas123', '2025-04-18 20:42:57'),
(90, 40, 'User logged in: baynas123', '2025-04-18 20:43:35'),
(91, 40, 'User changed their password, Username: baynas123', '2025-04-18 20:44:14'),
(92, 21, 'Admin logged in: charles011605', '2025-04-18 21:02:19'),
(93, 21, 'Admin logged in: charles011605', '2025-04-22 22:35:26'),
(94, 21, 'Admin logged in: charles011605', '2025-04-22 22:37:48'),
(95, 21, 'Admin logged in: charles011605', '2025-04-22 22:41:03'),
(96, 21, 'Admin logged in: charles011605', '2025-04-23 10:05:00'),
(97, 21, 'Admin logged in: charles011605', '2025-04-23 10:07:35'),
(98, 21, 'Admin logged in: charles011605', '2025-04-23 10:08:33'),
(99, 21, 'Admin logged in: charles011605', '2025-04-23 10:10:10'),
(100, 21, 'Admin logged in: charles011605', '2025-04-23 10:11:35'),
(101, 21, 'Admin logged in: charles011605', '2025-04-23 10:12:26'),
(102, 21, 'Admin logged in: charles011605', '2025-04-23 10:15:27'),
(103, 21, 'Admin logged in: charles011605', '2025-04-23 10:16:11'),
(104, 21, 'Admin logged in: charles011605', '2025-04-23 10:26:35'),
(105, 21, 'Admin logged in: charles011605', '2025-04-23 10:32:02'),
(106, 21, 'Updated book: Pumping IV', '2025-04-23 10:32:09'),
(107, 21, 'Updated book: Pumping IV', '2025-04-23 10:32:20'),
(108, 21, 'Admin logged in: charles011605', '2025-04-23 10:37:37'),
(109, 21, 'Admin logged in: charles011605', '2025-04-23 10:39:58'),
(110, 21, 'Admin Added book: Solo Leveling', '2025-04-23 10:40:37'),
(111, 29, 'User RESET their password, Username: shan1234', '2025-04-23 11:33:45'),
(112, 29, 'User logged in: shan1234', '2025-04-23 11:34:09'),
(113, 29, 'User logged out: shan1234', '2025-04-23 11:34:53'),
(114, 29, 'Password Reset Cancelled: shan1234', '2025-04-23 11:53:16'),
(115, 21, 'Admin logged in: charles011605', '2025-04-23 12:15:00'),
(116, 21, 'Admin logged in: charles011605', '2025-04-24 00:42:45'),
(117, 29, 'User logged in: shan1234', '2025-04-24 01:38:03'),
(118, 29, 'User logged out: shan1234', '2025-04-24 01:38:12'),
(119, 29, 'User logged in: shan1234', '2025-04-24 01:39:05'),
(120, 29, 'User logged in: shan1234', '2025-04-24 01:40:00'),
(121, 29, 'User logged out: shan1234', '2025-04-24 01:40:22'),
(122, 21, 'Admin logged in: charles011605', '2025-04-24 01:40:28'),
(123, 21, 'Admin logged in: charles011605', '2025-04-24 01:41:00'),
(124, 21, 'Admin logged in: charles011605', '2025-04-24 01:41:59'),
(125, 21, 'Admin logged in: charles011605', '2025-04-24 01:43:47'),
(126, 21, 'Admin logged in: charles011605', '2025-04-24 01:47:48'),
(127, 21, 'Admin logged in: charles011605', '2025-04-24 01:48:38'),
(128, 21, 'Admin logged in: charles011605', '2025-04-24 01:49:32'),
(129, 21, 'Admin logged in: charles011605', '2025-04-24 01:50:15'),
(130, 21, 'Admin logged in: charles011605', '2025-04-24 01:53:51'),
(131, 21, 'Admin logged out: charles011605', '2025-04-24 01:54:08'),
(132, 29, 'User logged in: shan1234', '2025-04-24 01:54:14'),
(133, 21, 'Admin logged in: charles011605', '2025-04-24 01:58:59'),
(134, 21, 'Admin logged in: charles011605', '2025-04-24 02:00:13'),
(135, 21, 'Admin logged in: charles011605', '2025-04-24 02:02:21'),
(136, 21, 'Admin logged in: charles011605', '2025-04-24 02:03:53'),
(137, 21, 'Admin logged in: charles011605', '2025-04-24 02:05:38'),
(138, 21, 'Admin logged in: charles011605', '2025-04-24 02:06:21'),
(139, 21, 'Admin logged in: charles011605', '2025-04-24 02:07:04'),
(140, 21, 'Admin logged in: charles011605', '2025-04-27 18:59:18'),
(141, 21, 'Admin logged in: charles011605', '2025-05-01 12:04:13'),
(142, 21, 'Admin logged out: charles011605', '2025-05-01 12:04:41'),
(143, 29, 'User logged in: shan1234', '2025-05-01 12:05:01'),
(144, 29, 'User logged out: shan1234', '2025-05-01 12:06:08'),
(145, 26, 'Password Reset Cancelled: colenscolens', '2025-05-01 12:07:32'),
(146, 29, 'User logged in: shan1234', '2025-05-01 12:25:17'),
(147, 29, 'User logged out: shan1234', '2025-05-01 12:27:16'),
(148, 21, 'Admin logged in: charles011605', '2025-05-01 12:27:24'),
(149, 21, 'Admin logged in: charles011605', '2025-05-04 21:14:33'),
(150, 21, 'Admin logged in: charles011605', '2025-05-07 22:26:59'),
(151, 21, 'Admin logged in: charles011605', '2025-05-07 22:36:57'),
(152, 21, 'Admin logged out: charles011605', '2025-05-07 22:37:08'),
(153, 29, 'User logged in: shan1234', '2025-05-07 22:37:17'),
(154, 29, 'User logged in: shan1234', '2025-05-07 22:38:50'),
(155, 29, 'User logged in: shan1234', '2025-05-07 22:40:29'),
(156, 29, 'User logged out: shan1234', '2025-05-07 22:42:24'),
(157, 42, 'User registered with username: mike123', '2025-05-07 23:25:30'),
(158, 21, 'Admin logged in: charles011605', '2025-05-07 23:25:44'),
(159, 21, 'Admin logged out: charles011605', '2025-05-07 23:25:54'),
(160, 42, 'Admin logged in: mike123', '2025-05-07 23:26:39'),
(161, 42, 'Admin logged in: mike123', '2025-05-07 23:27:12'),
(162, 42, 'Admin logged in: mike123', '2025-05-07 23:28:32'),
(163, 42, 'Admin logged in: mike123', '2025-05-07 23:30:31'),
(164, 42, 'User logged out: mike123', '2025-05-07 23:31:42'),
(165, 42, 'Admin logged in: mike123', '2025-05-07 23:32:59'),
(166, 42, 'User logged out: mike123', '2025-05-07 23:33:08'),
(167, 26, 'Password Reset Cancelled: colenscolens', '2025-05-10 15:23:47'),
(168, 29, 'User logged in: shan1234', '2025-05-11 22:03:51'),
(169, 29, 'User logged in: shan1234', '2025-05-11 22:07:08'),
(170, 29, 'User logged in: shan1234', '2025-05-11 22:07:18'),
(171, 29, 'User logged in: shan1234', '2025-05-11 22:24:50'),
(172, 29, 'User logged in: shan1234', '2025-05-11 22:26:16'),
(173, 29, 'User logged out: shan1234', '2025-05-11 22:27:35'),
(174, 29, 'User logged in: shan1234', '2025-05-11 23:01:55'),
(175, 29, 'User logged in: shan1234', '2025-05-11 23:32:46'),
(176, 29, 'User logged in: shan1234', '2025-05-11 23:34:57'),
(177, 29, 'User logged in: shan1234', '2025-05-11 23:35:33'),
(178, 29, 'User logged in: shan1234', '2025-05-11 23:37:50'),
(179, 29, 'User logged in: shan1234', '2025-05-11 23:46:19'),
(180, 29, 'User logged in: shan1234', '2025-05-11 23:52:03'),
(181, 29, 'User logged in: shan1234', '2025-05-11 23:52:53'),
(182, 29, 'User logged in: shan1234', '2025-05-11 23:53:30'),
(183, 21, 'Admin logged in: charles011605', '2025-05-11 23:59:20'),
(184, 21, 'Admin logged in: charles011605', '2025-05-12 00:00:29'),
(185, 21, 'Admin logged in: charles011605', '2025-05-12 00:02:52'),
(186, 29, 'User logged in: shan1234', '2025-05-12 00:03:17'),
(187, 29, 'User logged out: shan1234', '2025-05-12 00:03:30'),
(188, 21, 'Admin logged in: charles011605', '2025-05-12 00:03:40'),
(189, 21, 'Admin logged in: charles011605', '2025-05-12 00:05:34'),
(190, 21, 'Admin logged in: charles011605', '2025-05-12 00:07:38'),
(191, 21, 'Admin logged in: charles011605', '2025-05-12 00:08:26'),
(192, 21, 'Admin logged in: charles011605', '2025-05-12 00:09:36'),
(193, 21, 'Admin logged in: charles011605', '2025-05-12 00:12:12'),
(194, 21, 'Admin logged in: charles011605', '2025-05-12 00:12:59'),
(195, 21, 'Admin logged in: charles011605', '2025-05-12 00:14:46'),
(196, 21, 'Admin logged in: charles011605', '2025-05-12 00:16:20'),
(197, 21, 'Admin logged in: charles011605', '2025-05-12 00:18:24'),
(198, 21, 'Admin logged in: charles011605', '2025-05-12 00:21:56'),
(199, 26, 'Password Reset Cancelled: colenscolens', '2025-05-12 01:04:07'),
(200, 26, 'Password Reset Cancelled: colenscolens', '2025-05-12 01:18:48'),
(201, 26, 'Password Reset Cancelled: colenscolens', '2025-05-12 01:37:49'),
(202, 29, 'User logged in: shan1234', '2025-05-14 09:47:39'),
(203, 26, 'User logged in: colenscolens', '2025-05-14 10:46:13'),
(204, 26, 'User logged out: colenscolens', '2025-05-14 10:47:02'),
(205, 23, 'User logged in: reinpumped123', '2025-05-14 10:58:34'),
(206, 23, 'User logged in: reinpumped123', '2025-05-14 11:28:43'),
(207, 23, 'User logged in: reinpumped123', '2025-05-14 11:29:34'),
(208, 23, 'User logged in: reinpumped123', '2025-05-14 11:33:19'),
(209, 23, 'User logged in: reinpumped123', '2025-05-14 11:39:44'),
(210, 23, 'User logged out: reinpumped123', '2025-05-14 11:40:09'),
(211, 21, 'Admin logged in: charles011605', '2025-05-14 11:40:15'),
(212, 23, 'User logged in: reinpumped123', '2025-05-14 11:42:45'),
(213, 23, 'User logged out: reinpumped123', '2025-05-14 11:43:54'),
(214, 21, 'Admin logged in: charles011605', '2025-05-14 11:44:08'),
(215, 21, 'Admin logged in: charles011605', '2025-05-14 11:48:24'),
(216, 21, 'Admin logged in: charles011605', '2025-05-14 11:51:40'),
(217, 21, 'Admin logged in: charles011605', '2025-05-14 11:54:29'),
(218, 21, 'Admin logged in: charles011605', '2025-05-14 11:55:03'),
(219, 21, 'Admin logged in: charles011605', '2025-05-14 11:56:17'),
(220, 21, 'Admin logged in: charles011605', '2025-05-14 11:56:49'),
(221, 21, 'Admin logged in: charles011605', '2025-05-14 11:57:44'),
(222, 21, 'Admin logged in: charles011605', '2025-05-14 11:59:55'),
(223, 23, 'User logged in: reinpumped123', '2025-05-14 12:09:09'),
(224, 23, 'User logged in: reinpumped123', '2025-05-14 12:11:57'),
(225, 23, 'User logged in: reinpumped123', '2025-05-14 12:13:34'),
(226, 23, 'User logged out: reinpumped123', '2025-05-14 12:20:13'),
(227, 21, 'Admin logged in: charles011605', '2025-05-14 13:27:56'),
(228, 21, 'Admin logged in: charles011605', '2025-05-14 13:29:41'),
(229, 21, 'Admin logged in: charles011605', '2025-05-14 13:35:10'),
(230, 21, 'Admin logged in: charles011605', '2025-05-14 13:39:02'),
(231, 21, 'Admin logged in: charles011605', '2025-05-14 13:39:49'),
(232, 23, 'User logged in: reinpumped123', '2025-05-14 13:52:53'),
(233, 23, 'User logged out: reinpumped123', '2025-05-14 13:52:59'),
(234, 21, 'Admin logged in: charles011605', '2025-05-14 14:03:22'),
(235, 21, 'Admin logged out: charles011605', '2025-05-14 14:04:20'),
(236, 23, 'User logged in: reinpumped123', '2025-05-14 14:04:28'),
(237, 23, 'User logged out: reinpumped123', '2025-05-14 14:04:35'),
(238, 22, 'User RESET their password, Username: james12345', '2025-05-14 14:05:41'),
(239, 22, 'Admin logged in: james12345', '2025-05-14 14:05:48'),
(240, 22, 'Admin logged out: james12345', '2025-05-14 14:05:59'),
(241, 22, 'User logged in: james12345', '2025-05-14 14:06:07'),
(242, 23, 'User logged in: reinpumped123', '2025-05-14 14:09:43'),
(243, 23, 'User logged out: reinpumped123', '2025-05-14 14:10:29'),
(244, 21, 'Admin logged in: charles011605', '2025-05-14 14:10:37'),
(245, 23, 'User logged in: reinpumped123', '2025-05-14 14:17:44'),
(246, 23, 'User logged in: reinpumped123', '2025-05-14 15:11:50'),
(247, 23, 'User logged in: reinpumped123', '2025-05-14 15:14:36'),
(248, 23, 'User logged in: reinpumped123', '2025-05-14 15:15:48'),
(249, 23, 'User logged in: reinpumped123', '2025-05-14 15:20:14'),
(250, 23, 'User logged in: reinpumped123', '2025-05-14 15:21:54'),
(251, 23, 'User logged in: reinpumped123', '2025-05-14 15:23:17'),
(252, 23, 'User logged in: reinpumped123', '2025-05-14 15:32:29'),
(253, 23, 'User logged in: reinpumped123', '2025-05-14 15:36:23'),
(254, 23, 'User logged in: reinpumped123', '2025-05-14 15:41:00'),
(255, 23, 'User logged in: reinpumped123', '2025-05-14 15:47:27'),
(256, 23, 'User logged in: reinpumped123', '2025-05-14 15:59:40'),
(257, 23, 'User logged out: reinpumped123', '2025-05-14 16:00:57'),
(258, 26, 'User logged in: colenscolens', '2025-05-14 16:01:05'),
(259, 23, 'User logged in: reinpumped123', '2025-05-14 16:04:46'),
(260, 23, 'User logged out: reinpumped123', '2025-05-14 16:05:02'),
(261, 26, 'User logged in: colenscolens', '2025-05-14 16:05:19'),
(262, 21, 'Admin logged in: charles011605', '2025-05-14 16:17:16'),
(263, 21, 'Admin logged in: charles011605', '2025-05-14 16:19:06'),
(264, 21, 'Admin logged in: charles011605', '2025-05-14 16:20:56'),
(265, 21, 'Admin logged out: charles011605', '2025-05-14 16:21:04'),
(266, 22, 'User logged in: james12345', '2025-05-14 16:21:19'),
(267, 22, 'User logged out: james12345', '2025-05-14 16:21:36'),
(268, 21, 'Admin logged in: charles011605', '2025-05-14 16:21:47'),
(269, 22, 'User logged in: james12345', '2025-05-14 16:30:43'),
(270, 22, 'User logged out: james12345', '2025-05-14 16:31:24'),
(271, 21, 'Admin logged in: charles011605', '2025-05-14 16:31:34'),
(272, 21, 'Admin logged in: charles011605', '2025-05-14 16:34:33'),
(273, 21, 'Admin logged out: charles011605', '2025-05-14 16:34:45'),
(274, 22, 'User logged in: james12345', '2025-05-14 16:34:51'),
(275, 22, 'User logged out: james12345', '2025-05-14 16:35:00'),
(276, 21, 'Admin logged in: charles011605', '2025-05-14 16:35:12'),
(277, 23, 'User logged in: reinpumped123', '2025-05-14 18:27:42'),
(278, 23, 'User logged out: reinpumped123', '2025-05-14 18:28:47'),
(279, 21, 'Admin logged in: charles011605', '2025-05-14 18:28:55'),
(280, 23, 'User logged in: reinpumped123', '2025-05-14 18:32:07'),
(281, 29, 'User logged in: shan1234', '2025-05-14 18:40:10'),
(282, 26, 'User logged in: colenscolens', '2025-05-14 18:47:19'),
(283, 26, 'User logged out: colenscolens', '2025-05-14 18:48:41'),
(284, 43, 'User registered with username: marlo123', '2025-05-14 18:51:21'),
(285, 21, 'Admin logged in: charles011605', '2025-05-14 18:51:34'),
(286, 21, 'Admin logged out: charles011605', '2025-05-14 18:51:45'),
(287, 43, 'User logged in: marlo123', '2025-05-14 18:51:51'),
(288, 21, 'Admin logged in: charles011605', '2025-05-14 19:24:47'),
(289, 21, 'Admin Added book: Language', '2025-05-14 19:25:53'),
(290, 21, 'Admin Added book: Book of Enchantment', '2025-05-14 19:26:19'),
(291, 21, 'Admin Added book: Vishanti Book', '2025-05-14 19:26:42'),
(292, 21, 'Admin Added book: The Avengers', '2025-05-14 19:27:19'),
(293, 21, 'Admin Added book: Iron Man', '2025-05-14 19:27:39'),
(294, 21, 'Admin Added book: Thanos Story', '2025-05-14 19:28:19'),
(295, 21, 'Admin Added book: Infinity War', '2025-05-14 19:28:53'),
(296, 21, 'Admin Added book: The Hobbit', '2025-05-14 19:29:55'),
(297, 21, 'Admin Added book: Troll or Derby', '2025-05-14 19:30:24'),
(298, 26, 'User logged in: colenscolens', '2025-05-14 19:39:51'),
(299, 43, 'User logged in: marlo123', '2025-05-14 19:54:12'),
(300, 43, 'User updated their info: marlo123 (User ID: 43)', '2025-05-14 19:55:50'),
(301, 43, 'Borrower \'marlo123\' borrowed the book ID: 22', '2025-05-14 19:58:14'),
(302, 29, 'User logged in: shan1234', '2025-05-14 21:57:32'),
(303, 29, 'User changed their password, Username: shan1234', '2025-05-14 21:59:19'),
(304, 21, 'Admin logged in: charles011605', '2025-05-14 22:35:59'),
(305, 21, 'Admin logged out: charles011605', '2025-05-14 22:39:20'),
(306, 43, 'User logged in: marlo123', '2025-05-14 22:39:33'),
(307, 43, 'User logged in: marlo123', '2025-05-14 22:47:03'),
(308, 43, 'User logged in: marlo123', '2025-05-14 22:47:52');

-- --------------------------------------------------------

--
-- Table structure for table `penalties`
--

CREATE TABLE `penalties` (
  `penalty_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `days_overdue` int(11) DEFAULT NULL,
  `penalty_amount` decimal(10,2) DEFAULT NULL,
  `is_paid` tinyint(1) DEFAULT 0,
  `issued_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(1, 26, '2025-04-06 07:21:08', 'pending', '992341'),
(2, 26, '2025-04-06 08:03:00', 'approved', '123456'),
(3, 26, '2025-04-23 04:13:45', 'pending', '124654');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `trans_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`trans_id`, `user_id`, `book_id`, `borrow_date`, `return_date`) VALUES
(1, 22, 3, '2025-05-14 16:31:15', '2025-05-14 16:34:56'),
(2, 23, 15, '2025-05-14 18:28:25', NULL),
(3, 29, 3, '2025-05-14 18:45:56', NULL),
(4, 26, 1, '2025-05-14 18:47:29', NULL),
(5, 43, 22, '2025-05-14 19:58:14', NULL);

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
(22, 'James Sven', 'Ansali Jr', '092134354546', 'ansaligwapo@gmail.com', 'Borrower', 'james12345', '338c8bf01f4552dff1d4b2eed84c7a38c3a5f001604804fba47e3d28fc6ad4f5', 'Who is my solo friend?', 'Andre', 'Active', '', '000000'),
(23, 'Rein', 'Coronado', '091234324545', 'rein@gmail.com', 'Borrower', 'reinpumped123', '3ed98713c918bc067c8c18915f27af01ff66cd6db95a49ad9f52582c010304bc', 'Who is the most pumped?', 'Carlo', 'Active', 'C:\\Users\\II\\Downloads\\REIN.jpg', '123456'),
(26, 'Christian', 'Colina', '09202237644', 'andreestrera20@gmail.com', 'Borrower', 'colenscolens', 'c6d41388426fafd6d20fba8b0c2cde84ee8070b908a5f6032bc82fe3cb4eb906', 'What is my favorite line?', 'Okay Colina Noted!', 'Active', 'src/profileImages/3406ace7-c369-490e-8605-95dfed680a50.jpg', '011605'),
(29, 'Shanellayza L', 'Torres', '09202237644', 'shann@gmail.com', 'User', 'shan1234', 'cb609517a5bf0e81a66a7cf45b6a38afc80ceb50f9bdaf3a9e6af6c191754c3e', 'What is my fav food?', 'Charles', 'Active', 'src/profileImages/ACKKKShann.jpg', '123456'),
(30, 'Maby', 'Otahay', '09233235456', 'maby@gmail.com', 'Borrower', 'mabycrushngbayan123', '1ceadcf6cfcfddccb00bcb4f78bc238d3615eeaca4adae85e118ca4760b2073f', NULL, NULL, 'Active', 'src/profileImages/MABY.png', NULL),
(40, 'Mego Gwapo', 'baynas', '09234354545', 'baynas@gmail.com', 'Borrower', 'baynas123', '2bbbef0f660fcdf7964da674ae21fd545c0db304ccaf18f7c4e01c70abe804a2', 'Is baynas gwapo?', 'Of course, yes', 'Active', 'src/profileImages/A_detailed_illustration_of_an_Admin_Dashboard_for_a_Library_Management_System_GUI_The_dashboard_features_a_clean_and_modern_design_with_a_sidebar_on_the_left_containing_navigation_options_like_Dashboard_Books_Members_.png', '111111'),
(41, 'Jimz', 'Ansali', '092343435', 'jimz@gmail.com', 'Borrower', 'jimz123', '0b255eaebd53193359560878526c9a06d31d8a4128659571244ee27726f05260', 'Am I friendly to you?', 'Yes', 'Active', 'src/profileImages/111.jpg', '111111'),
(42, 'Mike', 'Bustamante', '092323232323', 'mike@st.cecila.edu.ph', 'Librarian', 'mike123', '5155ea8ca667bc8bbfc722df032b4d9721c6666c93e0a20e6c7181165d232ef6', 'Are you  pumped?', 'Yes', 'Active', NULL, NULL),
(43, 'Marlo', 'Alcaya', '09232434345', 'marlo@gmail.com', 'Borrower', 'marlo123', 'd193ba31d7634024e15cf9353e650a5db11485262c8e01785337bb3d50e32789', 'Are you the fanny gods?', 'yes', 'Active', 'src/profileImages/MicrosoftVisualStudioSetupComplete.png', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `borrowedbooks`
--
ALTER TABLE `borrowedbooks`
  ADD PRIMARY KEY (`bbr_id`),
  ADD KEY `br_id` (`br_id`),
  ADD KEY `b_fk` (`b_fk`);

--
-- Indexes for table `borrowers`
--
ALTER TABLE `borrowers`
  ADD PRIMARY KEY (`br_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `penalties`
--
ALTER TABLE `penalties`
  ADD PRIMARY KEY (`penalty_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `pin_requests`
--
ALTER TABLE `pin_requests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`trans_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `book_id` (`book_id`);

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
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `borrowedbooks`
--
ALTER TABLE `borrowedbooks`
  MODIFY `bbr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `borrowers`
--
ALTER TABLE `borrowers`
  MODIFY `br_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=309;

--
-- AUTO_INCREMENT for table `penalties`
--
ALTER TABLE `penalties`
  MODIFY `penalty_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pin_requests`
--
ALTER TABLE `pin_requests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `trans_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrowedbooks`
--
ALTER TABLE `borrowedbooks`
  ADD CONSTRAINT `borrowedbooks_ibfk_1` FOREIGN KEY (`br_id`) REFERENCES `borrowers` (`br_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `borrowedbooks_ibfk_2` FOREIGN KEY (`b_fk`) REFERENCES `books` (`b_id`) ON DELETE CASCADE;

--
-- Constraints for table `borrowers`
--
ALTER TABLE `borrowers`
  ADD CONSTRAINT `borrowers_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`);

--
-- Constraints for table `penalties`
--
ALTER TABLE `penalties`
  ADD CONSTRAINT `penalties_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`),
  ADD CONSTRAINT `penalties_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`b_id`);

--
-- Constraints for table `pin_requests`
--
ALTER TABLE `pin_requests`
  ADD CONSTRAINT `pin_requests_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE;

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`b_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
