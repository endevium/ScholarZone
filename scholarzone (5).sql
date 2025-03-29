-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2025 at 01:01 PM
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
-- Database: `scholarzone`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`) VALUES
(1, 'admin@gmail.com', 'adminpass'),
(2, 'JohnRasheed13@gmail.com', '$2y$10$TKU543JfKD.e/ElYZzKQyOikXlPulslRDJPpzBACZHfSQVrhcHUJy'),
(3, 'admin@email.com', '$2y$10$1RMPDc2Jwm2S21pknt9YYOlIk0CmXpJLkzFtwN.7kcHhSdxraMZyO');

-- --------------------------------------------------------

--
-- Table structure for table `admin_notifications`
--

CREATE TABLE `admin_notifications` (
  `id` int(11) NOT NULL,
  `title` text NOT NULL,
  `body` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_notifications`
--

INSERT INTO `admin_notifications` (`id`, `title`, `body`, `date`) VALUES
(1, 'New Reviewer Registration', 'New reviewer registration: FileUploader', '2025-03-29 10:43:50'),
(2, 'New Reviewer Registration', 'New reviewer registration: YOUDONTOWNME', '2025-03-29 10:43:50'),
(3, 'New Reviewer Registration', 'New Scholarship Application: Ndjbndoand', '2025-03-29 10:43:50'),
(4, 'New Reviewer Registration', 'New Scholarship Application: asdasdasd', '2025-03-29 10:43:50'),
(5, 'New Scholarship Application', 'New Scholarship Application: LastAPI', '2025-03-29 10:43:50'),
(6, 'New Reviewer Registration', 'New reviewer registration: FileUploader', '2025-03-29 10:43:50'),
(7, 'New Scholarship Application', 'New Scholarship Application: Dilaw', '2025-03-29 10:43:50'),
(8, 'New Reviewer Registration', 'New reviewer registration: asdadad', '2025-03-29 10:43:50'),
(9, 'New Reviewer Registration', 'New reviewer registration: meowm', '2025-03-29 10:43:50'),
(10, 'New Scholarship Application', 'New Scholarship Application: dadada', '2025-03-29 10:43:50'),
(11, 'New Scholarship Application', 'New Scholarship Application: sdasda', '2025-03-29 10:43:50'),
(12, 'New Reviewer Registration', 'New reviewer registration: asdsadas', '2025-03-29 11:29:24'),
(13, 'New Reviewer Registration', 'New reviewer registration: asdsada', '2025-03-29 11:30:46');

-- --------------------------------------------------------

--
-- Table structure for table `admin_tokens`
--

CREATE TABLE `admin_tokens` (
  `id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_tokens`
--

INSERT INTO `admin_tokens` (`id`, `admin_id`, `token`) VALUES
(1, 1, '07469655d1391a2856029fe639922ee31e1d1c3844d1f0c2617f4925a572d6bc'),
(2, 2, '5cb76322fc439cb9303015a9aaabeb0859a8579c78cf20e7b361531443bc1020'),
(3, 1, 'd3fdf9457ceab79de4d1491d3ae853977acb3099643edfc16c412263846e58c6'),
(4, 2, '29bfb939ce3d3a6b20597f4665381e178384fae255a61f165d2b49f7f85e1861'),
(5, 3, 'dda6c37502a1d05dab44020b8dd96c43ff8c058c64dfdf42b996f489b2292b6d'),
(6, 3, 'd3e2bb3321a8fa96ccbc49d570fdd7aaafc25a39be5999c1a78dffa339af6b5b'),
(7, 3, 'c43cb32322166fa7d6e87814750fcdfabbbdaed71215d942f4f1d8618f72aab6'),
(8, 3, '1fabcedaa4e69bba56e4659b9fca358f0e688f6aae840331c4bb735a27a034e2'),
(9, 3, '9c10a595321200a47a47d95f12dc1fc692feb15fed70eaa668528faa31801aa8'),
(10, 3, '701ab8217e2cfbcd382c172b802b8fb406e11bba406fd08568eb5731390e26e9');

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`id`, `applicant_id`, `question_id`, `answer`) VALUES
(1, 10, 1, '12'),
(4, 10, 1, 'hi'),
(5, 15, 1, 'hyr'),
(6, 15, 3, 'sadsadasd'),
(7, 15, 4, 'adsadad'),
(8, 15, 5, 'asdadad'),
(14, 10, 9, 'documents/SWOT ANALYSIS (1).png'),
(16, 10, 7, 'hi'),
(19, 10, 9, 'http://localhost/ScholarZone/documents/67cd5247aadf4_psac-scholarship_960x488 2.png'),
(23, 15, 7, 'aaaa'),
(24, 15, 7, 'ayaw magupload'),
(25, 15, 7, 'ahhaha'),
(26, 15, 7, 'BIRDS OF A FEATHER'),
(27, 15, 7, 'hi'),
(28, 15, 7, 'eleven'),
(29, 15, 7, 'hi'),
(30, 15, 7, 'hi'),
(31, 15, 9, 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d032c9ab4f0_1000014461.jpg'),
(32, 15, 16, 'hiii'),
(33, 15, 15, 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d55c2267d28_20250304_115510.jpg'),
(34, 15, 16, 'hi aoasj'),
(35, 15, 15, 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d55d782638a_20250313_111352.jpg'),
(36, 25, 10, 'hui'),
(37, 25, 14, 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67db567542d62_Screenshot_20250318_192102_GCash.png'),
(61, 33, 10, 'IMAGE'),
(62, 33, 14, 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e498bc2f62f_1000014779.png'),
(63, 33, 11, 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e498bc45350_1000014781.png'),
(64, 33, 13, 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e498bc54350_1000014780.png');

-- --------------------------------------------------------

--
-- Table structure for table `applicants`
--

CREATE TABLE `applicants` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `program` varchar(255) NOT NULL,
  `rpc` varchar(255) NOT NULL,
  `bsb` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applicants`
--

INSERT INTO `applicants` (`id`, `username`, `email`, `profile_picture`, `password`, `firstname`, `lastname`, `gender`, `birthdate`, `phone_number`, `school`, `program`, `rpc`, `bsb`) VALUES
(1, 'johndoe', 'monde12@gmail.com', NULL, '$2y$10$wJtFKX1/aHp8och8iFkk5eUoYdv15nNMF2ioOBizJIPKUVsQBS/Oi', 'monde', 'guil', 'male', '2005-05-28', '2147483647', 'Upang', 'BSIT', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(2, 'johndoe', 'monde12@gmail.com', NULL, '$2y$10$eK3v2iRqc/H7WjzRt/A8d.9yvqzpn3ClXe7FDAVKjAmcfp5RbEAO2', 'monde', 'guil', 'male', '2005-05-28', '2147483647', '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(3, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$IPV2ZampWthjkGhJMEFWFuypyQC24ArZXjej00bV/pHxBbGEZObCe', 'monde', 'guil', 'male', '2005-05-28', '2147483647', '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(4, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$msIrebn.RVhJ9nuc0pbV1eDxeE7WAL.t85X1.NldDeC0hYChP9qri', 'monde', 'guil', 'male', '2005-05-28', '2147483647', '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(5, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$2t4D3h3qHWiIDgYlgIcZuu8dZ8Zk4yUAL04E3MVdgIYmLA6JiGNSu', 'monde', 'guil', 'male', '2005-05-28', '2147483647', '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(6, 'John', 'john@email.com', NULL, '$2y$10$G0A//jfqQiyOz4aelO6/K.vzmWg8ewdImLgd3.APPhRVrWANIdkem', 'John', 'Doee', 'Male', '2005-06-09', '2147483647', 'UPang', 'BSIT', 'Pangasinan', 'Bari'),
(7, 'John', 'john@email.com', NULL, '$2y$10$IZ9hTGsldlIfnBwgoGiJcOkia4BCBuV/rc9t5fSjNn707dN5Xf42m', 'John', 'Doee', 'Male', '2005-06-09', '2147483647', 'UPang', 'BSIT', 'Pangasinan', 'Bari'),
(8, 'john', 'g@gmail.com', NULL, '$2y$10$vcCfVCA3nKRraV7EGNy1ju5j1Iy5vkRqcwtX9Lx92DO1y5dIs3gzi', 'Johhn', 'Jodheo', 'Male', '2025-02-11', '1344364', 'B', 'S', 'T', 'B'),
(9, 'monde', 'monde12@gmail.com', NULL, '$2y$10$cZDMCEM7wpyB3l.eUOL1oeI8Jsx8UBdFJgW.x8IoqSAa02TRtnKgK', 'Richmond ', 'Guiling ', 'Male', '2005-05-28', '1234567891', 'PHINMA- UNIVERSITY OF PANGASINAN ', 'Information Technology ', '1, Pangasinan, daguapn', 'dagupan, arillinso,1'),
(10, 'ji', 'a@a.com', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e2ace2be504_dorm7_image2.png', '$2y$10$Eks5HGPufuvCrJCV1PSI1uZt1FznKIkfz6XwsbZJX8y1GcGx4M/Hy', 'Jojn', 'Doe', 'Male', '2025-02-16', '1243467', 'B', 'S', 'T', 'B'),
(11, 'meow', 'a@a.com', NULL, '$2y$10$KwdMCKoQrLEwo/DEXjJhEOFKDhiCrqssM0C0QR/oX8qxFbOA0hTNe', 'a', 'b', 'male', '2005-06-09', '1', 'm', 'a', 'm', 'm'),
(12, 'meow', 'a@a.com', NULL, '$2y$10$Pjmt.u2jZ0cGsvYTgZ4n0O96VAFZukZ1y8hNAsRQkBFNtgY4q2QJ.', 'a', 'b', 'male', '2005-06-09', '1', 'm', 'a', 'm', 'm'),
(13, 'meow', 'a@a.com', NULL, '$2y$10$YjwHKXhTLFvOqrrwxJNK1ezYqN.irLBG18DFgHJKLpgehprgukx.2', 'a', 'b', 'male', '2005-06-09', '1', 'm', 'a', 'm', 'm'),
(14, 'meow', 'a@a.com', NULL, '$2y$10$6a4uTMoBXaIgSdY3X8aD8uXmRKeqvOcXQFtJzGE96/3imn16xU8f2', 'a', 'b', 'male', '2005-06-09', '1', 'm', 'a', 'm', 'm'),
(15, 'API_Tester', 'b@b.com', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e3c3398c589_profile.jpg', '$2y$10$oZ63W4DvxZV6PTJZSKLhIO71Zv6e6zlNDF3Jh4Pck39AvKEy0CBha', 'Hi', 'Tester', 'Male', '2005-06-09', '2147483647', 'meow', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(17, 'hi', 'z@z.com', NULL, '$2y$10$wceGP0Ze2JisCWlOGfcGR.qoJ38aJFCK7EqGj0R1GsevB1Fbs46rC', 'aisjhs', 'shsjhas', 'Female', '2025-03-20', '123456780', 'hi', 'Information Technology', 'hiii', 'hiii'),
(18, 'hi', 'y@y.com', NULL, '$2y$10$esGXqOMsi/I49y/i9MNC/.Te4I7Kv34TXMYG8jOAk/TSFsWrR5ayG', 'aisjhs', 'shsjhas', 'Female', '2025-03-20', '123456789', 'hiii', 'Criminology', 'sjsjjs', 'bshshshs'),
(19, 'hi', 'y@yy.com', NULL, '$2y$10$1WljMotlFKLWfCKpkmIT7OpzIWlpUQfeINSkyFlefH5lJAi6eA5c.', 'aisjhs', 'shsjhas', 'Female', '2025-03-20', '123456789', 'jshshs', 'Information Technology', 'ahahjs', 'shsjhss'),
(20, 'hwisjsh', 's@s.com', NULL, '$2y$10$WY0weuaFG2RKPbR/FLVdne1.EjKH.DvhRTK6bzhu/G64LvuKusI5O', 'A', 'A', 'Male', '2025-03-20', '123457890', 'sjshhs', 'Medical Technology', 'jsjsjs', 'sbsjsh'),
(21, 'jsjsjs', 's@b.com', NULL, '$2y$10$KiezqvZX9jjK5PSp7tE3DeuZEi89K1uJkcm3kqdlmVkGA6RIGmfW6', 'ishahs', 'sjjsjss', 'Male', '2025-03-20', '1234567890', 'huui', 'Criminology', 'jshshs', 'hshshs'),
(22, 'API_Tester', 'b@b.coms', NULL, '$2y$10$q2FnH0zDumUN2rZPuPlz/OxYmKaOjjaVBtvch174T.QBIwlOSmwRO', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(23, 'API_Tester', 'b@b.comss', NULL, '$2y$10$8BtczT6Brh85qc/CfboXEOVZytH/BrsuuPfWUpb9av8NcBHzu4v9m', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(24, 'API_Tester', 'b@b.comsss', NULL, '$2y$10$qpyuEyHjBIsaB4qhidBm3Odie8UINHOQEdT6bvbmovLronAHXPbta', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(25, 'jssjsh', 'jrasheedpaner@gmail.com', NULL, '$2y$10$gxEOm03YDuA3B387tcLxsO689pZEN7e5RMo5BgniVMrywjGAg3C7m', 'sajahaj', 'hhshsha', 'Male', '2025-03-20', '123456789', 'jssjjs', 'Medical Technology', 'sbsjhs', 'bshshs'),
(26, 'API_Tester', 'b@b.comssss', NULL, '$2y$10$Yj.tJ7ySQ1Du0vpF/6S3YO/pKalDeX5IuIZRiOFmIEuQw7lWsv.BO', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(27, 'API_Tester', 'b@b.comsssss', NULL, '$2y$10$gausdkEHyxbK4MIo8YLUeOt98tDQjVnV9zAiyQ8flEbjFnruiK9bO', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(28, 'API_Tester', 'b@b.comssssss', NULL, '$2y$10$GCoMj0SHS3MYMF2fNQTvwuJ78BJg7bwVfBUueJuA/ihzON5Zb74om', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(29, 'API_Tester', 'b@b.comsssssss', NULL, '$2y$10$6DUm0gvge650GE3CU5CW9u9uGJCaEBDWtUQfv7qq6deiAdtSUKVqq', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(30, 'API_Tester', 'b@b.comssssssss', NULL, '$2y$10$sKT9k/K.p4NGXjCvuxrr0ux6snu3PJeI84VMk6WQxRspaGxyXb3uu', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(31, 'API_Tester', 'b@b.comsssssssss', NULL, '$2y$10$HdewQypcyUAKGiVJaEVzMeSm1.PrfQgtnrBAie5yLeMLlvFpf.EKy', 'API', 'Tester', 'Male', '2005-06-09', '09123456789', 'PHINMA UPang', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal'),
(32, 'profilepic', 'f@f.com', NULL, '$2y$10$mPxMK3gGBHq6TAPVCgsrmuH0YHl0e/OuDYCS.h8rbf58J6frItO56', 'John', 'Paner', 'Male', '2025-03-26', '09957245708', 'ksshsbd', 'Medical Technology', 'sbsbds', 'shshshs'),
(33, 'hiii', 'p@p.com', NULL, '$2y$10$X0QOGg5/G1FGNKmMCynwIO0VX/TyylCFRWtTJ/f5Smq7yd1vnVDe2', 'John', 'Paner', 'Male', '2005-06-09', '09957245708', 'jwjsjshs', 'Nursing', 'shshhs', 'bshshshs');

-- --------------------------------------------------------

--
-- Table structure for table `applicant_notifications`
--

CREATE TABLE `applicant_notifications` (
  `id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `body` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applicant_notifications`
--

INSERT INTO `applicant_notifications` (`id`, `applicant_id`, `title`, `body`, `date`) VALUES
(1, 12, 'Hawak Kamay Application Status', 'We regret to inform you that your application has been rejected.', '2025-03-29 10:45:55'),
(2, 12, 'Hawak Kamay Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(3, 12, 'Hawak Kamay Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(4, 15, 'SM Scholarship Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(5, 15, 'SM Scholarship Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(6, 10, 'Hawak Kamay Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(7, 10, 'Hawak Kamay Application Status', 'We regret to inform you that your application has been rejected.', '2025-03-29 10:45:55'),
(8, 10, 'Hawak Kamay Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(9, 10, 'Hawak Kamay Application Status', 'We regret to inform you that your application has been rejected.', '2025-03-29 10:45:55'),
(10, 10, 'Hawak Kamay Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(11, 10, 'Hawak Kamay Application Status', 'Your application status has been updated.', '2025-03-29 10:45:55'),
(12, 12, 'Hawak Kamay Application Status', 'Your application status has been updated.', '2025-03-29 10:45:55'),
(13, 10, 'Hawak Kamay Application Status', 'Your application status has been updated.', '2025-03-29 10:45:55'),
(14, 10, 'Hawak Kamay Application Status', 'We regret to inform you that your application has been rejected.', '2025-03-29 10:45:55'),
(15, 15, 'Hawak Kamay Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(16, 15, 'Feel Special Application Status', 'Your application was rejected.', '2025-03-29 10:45:55'),
(17, 15, 'Feel Special Application Status', 'Your application was rejected.', '2025-03-29 10:45:55'),
(18, 15, 'Feel Special Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(19, 15, 'LastAPI Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(20, 15, 'LastAPI Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 10:45:55'),
(21, 25, 'FileUpload4 Application Status', 'Congratulations! Your application has been approved.', '2025-03-29 12:00:10');

-- --------------------------------------------------------

--
-- Table structure for table `applicant_otp`
--

CREATE TABLE `applicant_otp` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `otp` int(11) NOT NULL,
  `expiry` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applicant_otp`
--

INSERT INTO `applicant_otp` (`id`, `email`, `otp`, `expiry`) VALUES
(1, 'jrasheedpaner@gmail.com', 437286, '2025-03-26 06:29:26'),
(8, 'j', 510693, '2025-03-26 05:02:47');

-- --------------------------------------------------------

--
-- Table structure for table `applicant_tokens`
--

CREATE TABLE `applicant_tokens` (
  `id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applicant_tokens`
--

INSERT INTO `applicant_tokens` (`id`, `applicant_id`, `token`) VALUES
(1, 12, '0f5dd2a694a55b1e9ca4f2cbb1843f1e5683368a7df32b4009c3709f04199fba'),
(2, 13, '1c2767364502a406f0832d0e5673272106d23d1b27fea569419d3f29b24e307d'),
(3, 10, 'a5b6871954a1e0b222ac7a07683f8ce491b186adf30671f7a435205cc1d22dc6'),
(4, 10, '049d9b95f7bd9eb8da8d4bb1137527086f9d284d156a38555e1f8b302efd4fe2'),
(5, 10, '2ee0e3553a16276d1f973d9a3ddb3a2f84c7d12f870a17962822d76e1fd715a0'),
(6, 10, 'f5ad22191c3866a2a0b136c56c13f7ced77d5d0f03a650646999ea27e91fe998'),
(7, 10, '24efad90a1d613123dbf89e6918508be5e9f121502caba65450cf9f246ae8805'),
(8, 10, '2c76f5d75b5920369b2cfb98fec5ec59af64e67502cf5752fc1773da4fc37f13'),
(9, 10, '0779e7b4d540a2701fc165502f1813bc134069fc1da324ff77b93b01aff4d9b1'),
(10, 10, '41dc4b6fb464748ca202e7b0a9ddb2cd806c95e32ceb88af32800cf20201cfd2'),
(11, 10, '4c1de74704a4f3eb74868c36481e74519e21df78f0885e27df288c822cdc8c68'),
(12, 10, '0d54da298e87f666c682f7de4a45e23323af61c2f2e97a9a9bba97a4a463409f'),
(13, 10, 'fc61a3631fe78b77e6b03bebf029f67c4b8fcf7f6fb8c9e0d60e87801f911b74'),
(14, 10, '812561d5bf71f2d79dd5926695970fb59f95b2d493f2429d6f9bc792cf5d8007'),
(15, 10, '927f80c42cbd9cbcf41620af6a1704be4e177eb93fd10ba055727c4e64973f36'),
(16, 10, 'ebfb40a25f612955c3e0cea4a040935b2e4af8cbf78cac5ff4a9a84f4e517d17'),
(17, 10, 'fa9dfd242f3b8100b291e896099705bf80470a2addf0b5e7c5726c2e68b2463b'),
(18, 10, '7a7ab03cb7bf28860b1ba76656fa55ec85c9760a744c963117fb70f0dac517d6'),
(19, 10, 'e2789adc0a907d442665fac61675917c16fd825e9e621a0954a22a51c5fcfb4a'),
(20, 10, 'd8cdaed497845f29bdcd8acb366c47fd2f1bf4828e8d4c361f35fb852d2262b6'),
(21, 10, 'b11993373ddd66ed37b091649807f6bbb9b8d16c3a84e82596acecaab2c8cca9'),
(22, 10, '8764b24dc3958fb1d337ff89f58e0d27f15420beea445bfe207112814bc60840'),
(23, 10, '2222107301ab9d054d507f83f750b3532cbef558447d9485e0560c368b97a3fd'),
(24, 10, 'e43e9e0e62fdc99ccc178d64fe3bec4beffc1917a0d69b4592c0227cc42ecfa7'),
(25, 10, 'ecbd7da345dc67a8add1583835e403c6dbfed3b089d98e4b70849d92edd80bda'),
(26, 10, '0548a78683eaa4c5e3bb294dc11f90cc1551e326167200f1b3f73c36097cf656'),
(27, 15, '334318a77dcc67404997696f3e7ab2899f8df8ba8646b8d55aa76bc481e84855'),
(28, 15, '935dfb571fd0d388aa6cd4dbcf08fd875863809e294083d532b83ee537362d4d'),
(29, 15, 'fa9d829a11b0e42ae8c3fd739d55606b2677c4ffb6a01a8a1b7d17587a0a3388'),
(30, 15, '304c2f2e39c0c5ad107a66900b9ce911ddc841de1d69d5ed0bb5296d4f0b4b5c'),
(31, 15, '3a64b3923266f9664636958fe0bb29a97679246d3c730981870c04f0d194253f'),
(32, 15, '7ab0d7dba6eae39662cdeccc41b31a7b89eb42dc8e989aae169a5dd423e3b5c2'),
(33, 10, '3c7e2b1fc39fced485fd72f3525c52280b2c5849c6f33e35b75f5f9dbb46b4a0'),
(34, 10, '6a9c14d11175f23bbb909ec2cdbfe147d798ea4607222bcf2f8423186fdbbb48'),
(35, 10, '6ccf1054fe928d84ceb6211c64cc0920971adad8b895afed2e8a49cd9b5b2120'),
(36, 10, 'ea170fb5b136f8f670df54e17c9ae6bc8776751cdf0fd0cdf490cf15d5c7a363'),
(37, 15, '8763bc677533a102f458264ae7cc4feaf3cf4a9e50e7c7ee7a1e01627eccb2a5'),
(38, 15, '135f50714d6d4d5f85b87cd574c73ba292aa73436d4b374dcae57760f33c34f3'),
(39, 15, 'e980634fbe8ca352f7add0abaa6c3dca511d20ef94cb73bc727095cda2c73321'),
(40, 16, '944dce93dc4633b5c1a7563912819f25e51d96e89fb7b31dfcb127777b513c1e'),
(41, 15, '3eb4ac9415d1552c77e75c865bfe8599813c81ceb27770a24c29a94d5732f962'),
(42, 15, 'b725021da27f23e53bd3eee499764b9debfeafb8473c3232c1a3f379789359d3'),
(43, 17, '24e6712ff32f31d54e6f59088cd93715b61dc6cb8ff574c283762901da7a9509'),
(44, 18, 'a607beed37b96e0bbea16d4ef39c2b5b7c5923239b81c3d314670b9cda094091'),
(45, 19, '2aea59d73dc42751b6dd5a197bb9dd93571ad4c2111ef8e4223c1d2e64eae688'),
(46, 20, '4151d103074e0ea8bcf0b809843fe21097e44565d00a3d8ac947cf12ae876bbd'),
(47, 21, 'b8cfbf77bb378deff43db83eab86b15772371228e22ae126840e0fa16e6660da'),
(48, 21, 'a4a5197e9070855dbe68ebf8e1e1068b195615b6fa3fb6b4b97019a90de4b33e'),
(49, 22, 'b4c7a57f0eefde51b9aebf93fe555d9be7c2d33f1bd0ca7e4fa2ec2ac6f720a8'),
(50, 23, 'f9bf097e7c2dedccd73946b388caa2a42a1ada30008ce0abe7943f3366490ecc'),
(51, 0, '73526cb3683358ad4f9e3a6848df0484cb7484e1b7674ae70966937a7128278d'),
(52, 25, '710e96aa95a692ed2c16545ece39dc05dfd264ebc54db16c2acae6b018f5baf1'),
(53, 15, 'e98e288c9486df3ca5773365942b27e2c960abf3a60522fef2f0a613ee82e85f'),
(54, 15, 'fbd44e3c114aa947b092b94affe6fe08c640f653bfc450bd19fea01c5866cdf9'),
(55, 26, '4292b110bb0f3aba43bf79fcc6eacccf00d01d18be182dfc8d1f2bed9238d0eb'),
(56, 27, 'f01817edfd18ec6681b7bbacbd6b2b52324162ba9ecc516aa07ba32390e408b0'),
(57, 28, 'b356d7fc6d8804053a18cfd1e2375d5203fd0fe1e86c5404a37b8f4bb714a9bd'),
(58, 29, '2b5236c52b10bb34c34a337fffed9f5fc0b0bd1dc060066e111ec7c0f604d21c'),
(59, 30, '65e8eeed1f60b8ede6c667d8d590ceb0c2a08160121869bc4587a26c9ccaaa59'),
(60, 31, '0cf3bc57e6363e10f8b3e8839ee3c7ba8423e24c937915e91c3d19198fbfc421'),
(61, 15, 'df1c9eab15cf92e05b3a9f85ee4143bc30f30f9e6f75218ed265781dcc19e6eb'),
(62, 32, 'a7fe98813dd2a5c73d80830dc5fada607b953c637d56f90047cfa84b0b471b40'),
(63, 32, '9757d67aa277ef207749e2ecf72013770c0d4db95ce6ccb15df7fb94a2d0d19d'),
(64, 15, '8bd090ffc79510e85de0b04aadba6015eba4fa736fc78c86b5022f42c04739b9'),
(65, 33, '923235272d2fc2743d0fc56cab4d8253d2920401cdf262edd3cbe347b6e1843d'),
(66, 33, 'c3115e78377c25c3e63ad3928cfed494dc3623f63b58b5764a4ba7d0b12c9e34');

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

CREATE TABLE `applications` (
  `id` int(11) NOT NULL,
  `scholarship_application_id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL,
  `status` enum('Pending','Approved','Rejected') DEFAULT 'Pending',
  `submitted_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`id`, `scholarship_application_id`, `applicant_id`, `status`, `submitted_at`, `updated_at`) VALUES
(1, 2, 10, 'Rejected', '2025-02-24 09:20:47', '2025-03-05 13:26:44'),
(2, 3, 10, 'Approved', '2025-02-24 10:25:48', '2025-03-03 15:28:05'),
(3, 2, 12, 'Pending', '2025-02-25 03:41:53', '2025-03-05 13:16:44'),
(4, 2, 10, 'Pending', '2025-03-03 13:32:59', '2025-03-05 13:16:47'),
(5, 4, 15, 'Approved', '2025-03-04 03:02:09', '2025-03-04 03:03:59'),
(6, 11, 15, 'Pending', '2025-03-05 12:26:46', '2025-03-05 12:26:46'),
(7, 2, 15, 'Approved', '2025-03-05 13:34:57', '2025-03-05 13:35:21'),
(8, 11, 15, 'Pending', '2025-03-09 08:43:53', '2025-03-09 08:43:53'),
(9, 11, 15, 'Pending', '2025-03-11 11:31:19', '2025-03-11 11:31:19'),
(10, 11, 15, 'Pending', '2025-03-11 11:33:11', '2025-03-11 11:33:11'),
(11, 11, 15, 'Pending', '2025-03-11 11:44:20', '2025-03-11 11:44:20'),
(12, 11, 15, 'Pending', '2025-03-11 11:59:06', '2025-03-11 11:59:06'),
(13, 11, 15, 'Pending', '2025-03-11 12:34:03', '2025-03-11 12:34:03'),
(14, 11, 15, 'Pending', '2025-03-11 12:42:08', '2025-03-11 12:42:08'),
(15, 11, 15, 'Approved', '2025-03-11 12:53:00', '2025-03-15 01:59:18'),
(16, 11, 15, 'Rejected', '2025-03-11 12:53:10', '2025-03-15 01:58:22'),
(17, 11, 15, 'Rejected', '2025-03-11 12:55:36', '2025-03-15 01:57:49'),
(18, 24, 15, 'Approved', '2025-03-15 10:53:22', '2025-03-15 10:54:16'),
(19, 24, 15, 'Approved', '2025-03-15 10:59:04', '2025-03-15 10:59:34'),
(20, 20, 25, 'Approved', '2025-03-19 23:42:45', '2025-03-29 12:00:10'),
(21, 22, 15, 'Pending', '2025-03-20 15:16:24', '2025-03-20 15:16:24'),
(22, 21, 15, 'Pending', '2025-03-20 15:18:14', '2025-03-20 15:18:14'),
(23, 12, 15, 'Pending', '2025-03-23 10:40:42', '2025-03-23 10:40:42'),
(24, 13, 15, 'Pending', '2025-03-23 13:34:21', '2025-03-23 13:34:21'),
(27, 20, 15, 'Pending', '2025-03-23 14:08:02', '2025-03-23 14:08:02'),
(28, 23, 15, 'Pending', '2025-03-26 23:58:35', '2025-03-26 23:58:35'),
(31, 20, 33, 'Pending', '2025-03-27 00:15:55', '2025-03-27 00:15:55');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `scholarship_application_id` int(11) NOT NULL,
  `question` text NOT NULL,
  `type` enum('question','upload') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `scholarship_application_id`, `question`, `type`) VALUES
(1, 2, 'hi', 'question'),
(3, 2, 'hi', 'question'),
(4, 2, 'hi', 'question'),
(5, 2, 'wewqewqerwqq', 'question'),
(7, 11, 'meow', 'question'),
(9, 11, 'File question test', 'upload'),
(10, 20, 'a', 'question'),
(11, 20, 'hi', 'upload'),
(13, 20, 'strategy', 'upload'),
(14, 20, 'Enter your question here', 'upload'),
(15, 24, 'Upload your grades here', 'upload'),
(16, 24, 'Additional question here', 'question'),
(17, 11, 'hi', 'upload'),
(18, 11, 'sdad', 'upload');

-- --------------------------------------------------------

--
-- Table structure for table `reviewers`
--

CREATE TABLE `reviewers` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `rpc` varchar(255) NOT NULL,
  `bsb` varchar(255) NOT NULL,
  `company_id` varchar(255) NOT NULL,
  `certificate` varchar(255) NOT NULL,
  `authorization` varchar(255) NOT NULL,
  `is_verified` enum('no','yes','rejected') NOT NULL DEFAULT 'no',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviewers`
--

INSERT INTO `reviewers` (`id`, `username`, `profile_picture`, `email`, `password`, `firstname`, `lastname`, `birthdate`, `gender`, `phone_number`, `company`, `rpc`, `bsb`, `company_id`, `certificate`, `authorization`, `is_verified`, `created_at`) VALUES
(1, 'monddee', NULL, 'monde12@gmail.com', '$2y$10$0CBvj7M4qfeXyIvWbCgazuCucaGjsGJFwR/fBu.Otu9niMCdAoAlK', 'monde', 'guil', '2005-05-28', 'male', '2147483647', 'BDO', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45', '', '', '', 'yes', '2025-03-16 08:02:01'),
(2, 'John', NULL, 'john@email.com', '$2y$10$Hei1WKW7D.ZLJ/tUUOyOJeAjOK768hb3U3apkXw30JPeQcOtWe602', 'John', 'Doee', '2005-06-09', 'Male', '2147483647', 'PHINMA', 'Pangasinan', 'Bari', '', '', '', 'yes', '2025-03-16 08:02:01'),
(3, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$SvrBROwlJELJz/cZyC3ofemPXlHJ/wlaKUK6hALpziqBJGGvAbe7u', 'John', 'Doe', '2025-02-11', 'other', '2147483647', 'sada', 'dadad', 'adad', '', '', '', 'yes', '2025-03-16 08:02:01'),
(4, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$1l90fDpuLuN3N85dMxm0tuDpx86i3PQTMJNsTNRQOA7DFygAq95u.', 'John', 'Doe', '2025-02-11', 'other', '2147483647', 'asda', 'dadada', 'adada', '', '', '', 'yes', '2025-03-16 08:02:01'),
(5, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$/lw8d8XJy8bM2qDv4RXbBeLbX1NS8eYiHPgR5xC/eKo8q04mf4syG', 'John', 'Doe', '2025-02-11', 'other', '2147483647', 'asda', 'dadada', 'adada', '', '', '', 'no', '2025-03-16 08:02:01'),
(6, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$Z8hguaFawqLRf7U4kQwHPOj0NZqos5A.aL8QQTHTkJCLYu89pKZ4u', 'John', 'Doe', '2025-02-11', 'other', '2147483647', 's', 'sdada', 'adada', '', '', '', 'rejected', '2025-03-16 08:02:01'),
(12, 'meow', NULL, 'a@a.com', '$2y$10$SKPFiAh//vgXDIX516Mf0uJfggoRxkKsckjSE6xLhnM7FtXU3SAHW', 'a', 'b', '2005-06-09', 'male', '1', 'PHINMA', 'm', 'm', '', '', '', 'rejected', '2025-03-16 08:02:01'),
(13, 'API_Tester', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e7cb805932e_png_(3).png', 'b@b.com', '$2y$10$VPuRhOfMloqNOExuhKZe1uMd26tFw/Rq6rLgk7kuG992SJjJDnXnW', 'API', 'Tester', '2005-06-09', 'Male', '2147483647', 'hM', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal', '', '', '', 'yes', '2025-03-16 08:02:01'),
(14, 'FileUploader', NULL, 'c@c.com', '$2y$10$gTDDMKhvvk6ibiJiqo6Wc.hzlMV6apCjBrBIdkJlc7F89JA5UkUve', 'API', 'Tester', '2005-06-09', 'Male', '2147483647', 'PHINMA UPang', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal', 'http://localhost/ScholarZone/documents/67cd837586d71_scholarship_image.png', 'http://localhost/ScholarZone/documents/67cd8375882d2_myw3schoolsimage.jpg', 'http://localhost/ScholarZone/documents/67cd837588511_Blank_diagram.png', 'no', '2025-03-16 08:02:01'),
(15, 'FileUploader', NULL, 'd@d.com', '$2y$10$hvEt.zveSJatch8xl13mNuNVRi/VjCQLI2v1toav3UCCxuBq/Hn9y', 'API', 'Tester', '2005-06-09', 'Male', '2147483647', 'PHINMA UPang', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal', 'http://localhost/ScholarZone/documents/67d2664fadef9_480768850_3407388686064404_2466501740209375189_n.jpg', 'http://localhost/ScholarZone/documents/67d2664fae357_Untitled_design_(8).png', 'http://localhost/ScholarZone/documents/67d2664fae569_Untitled_design_(7).png', 'no', '2025-03-16 08:02:01'),
(16, 'YOUDONTOWNME', NULL, 'info@phinmaed.com', '$2y$10$4eO9toj3r/slLHDuQG7k2OkF/SNbohwUR8s/fsiQdDyzhGLQb.WqK', 'John Rasheed', 'Paner', '2025-03-05', 'male', '2147483647', 'asdsa', 'sadsada', 'adassd', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d43f93c4e61_dorm6_image2.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d43f93c5193_htpImage.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d43f93c541d_dorm8_image2.png', 'no', '2025-03-16 08:02:01'),
(17, 'FileUploader', NULL, 'd@e.com', '$2y$10$qIUD3C7Etiy2YzrqpNvokONxHTsU0l8ARF3oK.16IVziUE/.V4lV.', 'API', 'Tester', '2005-06-09', 'Male', '2147483647', 'PHINMA UPang', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal', 'http://localhost/ScholarZone/documents/67d56d009a184_dorm6_image3.png', 'http://localhost/ScholarZone/documents/67d56d009a58d_dorm8_image2.png', 'http://localhost/ScholarZone/documents/67d56d009a893_dorm7_image3.png', 'yes', '2025-03-16 08:02:01'),
(18, 'asdadad', NULL, 'asdad@gmail.com', '$2y$10$xqOcAps/9/hY4pFSU6paEezOyQPxa0e9KvO4485cSl2FlFRIuBWua', 'John Rasheed', 'Paner', '2025-03-10', 'female', '+639957245708', 'sadsad', 'adasdsa', 'asdsadsas', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d67907634cb_dorm8_image2.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d679076375a_dorm10_image1.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d6790763952_Screenshot_2023-12-25_130914.png', 'yes', '2025-03-16 08:02:01'),
(19, 'meowm', NULL, 'xd@gmail.com', '$2y$10$YlzwuBjAjnl4qeE/cR6SM..ZerQxpHO9wGemd.YXxpXmY7A4IhE86', 'Jonas', 'Enriquez', '2005-06-09', 'male', '+639957245708', 'sdasd', 'asdsad', 'asdasda', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d685e9d686d_dorm7_image1.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d685e9d6b2c_dorm11_image2.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d685e9d6d21_dorm12_image2.png', 'yes', '2025-03-16 08:03:53'),
(20, 'asdsadas', NULL, 'adasda@ada.com', '$2y$10$Bo5Sn8Ztl2a5gfWDCmjfsOjuPycdFtwzKjD8CaCQHYwcBFAoIIOeu', 'John Rasheed', 'Paner', '2025-03-18', 'male', '+639957245708', '123123', '123123', '13131', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e7d9940a884_review_icon.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e7d9940ab23_create_icon.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e7d9940acfd_review_icon.png', 'no', '2025-03-29 11:29:24'),
(21, 'asdsada', NULL, 'dadasd@a.com', '$2y$10$Fmrg4H6MwJQysrJjh2cT1OQwM.DOZcp4kjXxxwp7fzLOHIZeZH71e', 'John Rasheed', 'Paner', '2025-03-01', 'male', '+639957245708', 'asdsad', 'adadas', 'asdasd', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e7d9e628254_create_icon.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e7d9e6284f4_review_icon.png', 'http://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e7d9e62868f_create_icon.png', 'no', '2025-03-29 11:30:46');

-- --------------------------------------------------------

--
-- Table structure for table `reviewer_notifications`
--

CREATE TABLE `reviewer_notifications` (
  `id` int(11) NOT NULL,
  `reviewer_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `body` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviewer_notifications`
--

INSERT INTO `reviewer_notifications` (`id`, `reviewer_id`, `title`, `body`, `date`) VALUES
(1, 2, 'Scholarship Verification', 'Your scholarship has been verified.', '2025-03-29 10:37:01'),
(2, 13, 'Scholarship Verification', 'Your scholarship has been verified.', '2025-03-29 10:37:01'),
(8, 17, 'Verification', 'Your account has been verified.', '2025-03-29 10:37:01'),
(9, 19, 'Verification', 'Your account has been verified.', '2025-03-29 10:37:01'),
(10, 18, 'Verification', 'Your account has been verified.', '2025-03-29 10:37:01'),
(11, 17, 'Scholarship Verification', 'Your scholarship has been verified.', '2025-03-29 10:37:01'),
(12, 6, 'Rejected', 'Your account has been rejected.', '2025-03-29 10:37:01'),
(13, 12, 'Rejected', 'Your account has been rejected.', '2025-03-29 10:37:01'),
(14, 13, 'Scholarship Rejected', 'Your scholarship has been verified.', '2025-03-29 10:37:01');

-- --------------------------------------------------------

--
-- Table structure for table `reviewer_otp`
--

CREATE TABLE `reviewer_otp` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `otp` int(11) NOT NULL,
  `expiry` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviewer_otp`
--

INSERT INTO `reviewer_otp` (`id`, `email`, `otp`, `expiry`) VALUES
(1, 'b@b.com', 486515, '2025-03-29 13:01:27'),
(2, 'a@a.com', 295823, '2025-03-29 12:46:37');

-- --------------------------------------------------------

--
-- Table structure for table `reviewer_tokens`
--

CREATE TABLE `reviewer_tokens` (
  `id` int(11) NOT NULL,
  `reviewer_id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviewer_tokens`
--

INSERT INTO `reviewer_tokens` (`id`, `reviewer_id`, `token`) VALUES
(1, 9, '0'),
(2, 10, '1658'),
(3, 11, '842614c44064244f4007092de633adbab93155e88bf702445738c43707bc0e90'),
(4, 12, '1b0295eb039d845898faae4ba1bd6de9bff1a2026c04f9ec468cd66745fa922b'),
(5, 13, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3'),
(6, 13, '67f71f42dfc7cb48a3d1d93efa44ab1a7ab4e9206fb7bd7d90c03b1ccd29532f'),
(7, 13, '2f39e475d455f812ee766e2d4058ec47987014b27649beda4bcab9a03ab06d83'),
(8, 13, '049213c987c0d7d0e6d0f6f70a6bd494369f18d838b47b42f4660df292f6bde7'),
(9, 13, 'cabccbc001bf767f817e8dfb0c0c8d65749a4db56084c0977a93282feed77d29'),
(10, 13, 'c86b994ca83a127d3ea7462a57827a1e424b1771e9e9709e68047d757f8d043f'),
(11, 13, 'dd2a51402d7a672dbd1427737460de3acde244b0f97478feba1a4ac4683a5257'),
(12, 13, '954bb629e0b382beb234a367264d04ef2d41a2276b6c22f947f9ca2e768902d3'),
(13, 13, '50f28b2e34012fd9c3db5b58278094245327aab850888bb71ce3bc4749c0238d'),
(14, 13, 'cb0d61124eb4a1ed88b685cc050a8ac446c595ab070962fcece7c7372b876296'),
(15, 13, '2bf04047bc6c5145fca0f96a1e0fd41d0856964df129c6b30f4c614bca63aebb'),
(16, 13, '504896e0a6a301b72f62101ef3495d49c3410ae05864b338f8e041debe7d3185'),
(17, 13, 'daeb9cd643e0d654cd8bf986435d746a87f085577cbf14b9699820fd6383d822'),
(18, 13, '3d56c6cd8f67eae27845e243a254041902729f980d0d42e910ff30a635fcd9af'),
(19, 13, '92db7bdb50518f719b1cb52aeea10e325325990a4361c977fc2bb03adb0268d7'),
(20, 13, '062709058f64ad6891a593bf2fb541f45ab8a294310286514210ac07e33d8c95'),
(21, 13, '44e5670c3896d8a340ba12da00938f020f32b10b3536a3e2c795b093654df75d'),
(22, 13, '94d87f2306ed431215296a68ee76d09dd7b28ec1812873275cb4d9e1bb7ba923'),
(23, 7, 'c01315e126e7e955dc205eef73e1d616a467afce48bd1e9e9a1b9b7c51fefec4'),
(24, 12, 'b738154a62361586479b934e9486bd9dfa5626998d3d19446b3b29af14ff2e5c'),
(25, 14, 'd9a76b4fd2bc227118d76c5dddd5ed2cbd8a6fe829915cd22fac739cb27a4333'),
(26, 1, '6588844747ac532b2b0918a141bd6b47e912f0e2d554202bd60dd70f87abade1'),
(27, 2, '348a231eb1437faaac1539a7ff7c6a81fc72f130caa694b95ad5d21418afe383'),
(28, 13, 'ab1b7854c9233c902fc034cb38ff9c33f96593d61566e7c44d54457892f58239'),
(29, 0, 'e42ae6bcc30e7fcc70b9203625ac100686f97c7a0860a54938798c6e1b36e1eb'),
(30, 0, 'e8585361e2268d55184396c04643c0a0d8c33f16b69e3dd6ae9afe2a65618e15'),
(31, 0, '8c7855adb0f5404398ff42ba6cc2a3451487b87ff37ad5760ed72aa99f762ea5'),
(32, 0, '87a98d3ba7b383f16d1d42be5a90cf6fbcba9ce1605716736fe2adb403ee9ec0'),
(33, 0, '5897974ab58c5fca7e8b4b9fe0f1f471cb677580f86b0f04f3d644f25e81af52'),
(34, 6, '10bc9dd18ee7b7a388ab8167d9b967674514fefebc8482dfa36344530dd2455c'),
(35, 17, '5db330b256acadb25bbe00f09ad974c389f3fbf2aee68af47f771bfb4d4c1d53'),
(36, 17, '7004ad1c9255eaf53a60e7800aee251cc0ad16ae8e29a86fc62744287a34989e'),
(37, 15, '0b73d3fdc5655193e25de2f9c1c81af194856ca6eff0dbdce2c3be2383286433'),
(38, 13, '2b457f839d3bc338172c6d0e18933a15c9a4850f4a30120723cf9ba3e5d3e134'),
(39, 8, 'dfacd8123546f57c26b47600cd1316ae69ebd7c976e3218d14085ed0faf1d32d'),
(40, 9, '293d6442c63aa901ad9d02dcaed077a23f454f9c2ee24e3824504a260b7635e3'),
(41, 13, 'fe144d0f1f6419f237e987741e19db08b18fe5ccfaf5bbc939eb21eed78261df'),
(42, 13, '7039e5ea7f878df0d519b19a2e65818556262f322b29ce7c48f828d7f320e146'),
(43, 13, '0426168de72337ada547c8d8c76a31f5610439f278b6ca557a86f61be04db89b'),
(44, 13, 'bcb36cc68cb578106a4c139dc349ad0290450f67292173e759f95340fb945370'),
(45, 13, '3f30a3912c4f081f042a16c19ce9449b7edecacc63822a2c6f2c9552f0047d6b'),
(46, 13, '2d3908c0b1b920d6540c2c8a6f0e9aad09fa847630b763bc38634b26f88f2971'),
(47, 13, '633d16c9f66d0879d110294e0a82acf7b112e39c2c62d52df88c387cf4d45c36'),
(48, 12, '6828f7bd578c6052b3e4bf4fc3a658db3a15dc29a00a3d0dd86edf1085b8b859'),
(49, 13, '731d7aa244f6159f206aaa551ebbffe3f44e01a3fc4e2b2ee348f9988b35e799'),
(50, 12, '2a9d85537faa3b33677972332e867bede4635d446f3bec0dc80b8fb21a7b46d7'),
(51, 13, '23bf00c1290e980f661b8cca5ca202bbeede9a8f51e3dfdfe12f053cd930824b'),
(52, 12, '14a294fceb6ad77c344270b1064ca1817ccd7ed73bdf2b971fcc2a5919307e10'),
(53, 13, 'a2b1640bb895731dc6bca5fb5a3598510fb91f3342e4b44194f82452425cc0e8'),
(54, 13, '931dea5a1edde4952ef0a7910c150eacc64d0adeacefa572e1aba9303a860d43'),
(55, 13, '4a2148ec0faca7b817fddc107db162cc7d2af811bee47ebcc1bdf95d26adce9a'),
(56, 12, '5dd4ce285a2ab636f2a8f8ad42582d0b233b0edfd49953338f558253d7f266d5'),
(57, 13, '0f78614abc96618fbcab4f1d9fd80acaa618a2d142a076f60bf8f73c1d455b1d'),
(58, 13, 'f02c7418eee1b7c6e7ab03e0fa4b1f7a7470a61a428d748e3925610abd5f47db'),
(59, 13, '9adaae5fbfd617edeaa031cf231d85edcc31e8b51679a8ad587d3db40a74c117');

-- --------------------------------------------------------

--
-- Table structure for table `scholarship_applications`
--

CREATE TABLE `scholarship_applications` (
  `id` int(11) NOT NULL,
  `reviewer_id` int(11) NOT NULL,
  `application_name` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `application_description` text NOT NULL,
  `duration` varchar(255) NOT NULL,
  `application_image` varchar(255) DEFAULT '',
  `category` varchar(255) NOT NULL,
  `slots` int(255) NOT NULL,
  `taken_slots` int(11) NOT NULL,
  `deadline` date NOT NULL,
  `is_verified` enum('no','yes','rejected') NOT NULL DEFAULT 'no',
  `verified_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `scholarship_applications`
--

INSERT INTO `scholarship_applications` (`id`, `reviewer_id`, `application_name`, `company`, `application_description`, `duration`, `application_image`, `category`, `slots`, `taken_slots`, `deadline`, `is_verified`, `verified_at`) VALUES
(2, 12, 'Hawak Kamay', 'PHINMA', 'hi', '4 years', NULL, 'Undergraduate', 1, 0, '2025-03-29', 'yes', '0000-00-00 00:00:00'),
(3, 12, 'Guanzon Grants', 'Guanzon', 'hi', '6 years', '', 'Grants', 1, 0, '0000-00-00', 'yes', '0000-00-00 00:00:00'),
(4, 12, 'SM Scholarship', 'SM', 'hi', '4 years', '', 'Undergraduate', 1, 0, '0000-00-00', 'yes', '0000-00-00 00:00:00'),
(6, 12, 'Sudden Shower', 'ECLIPSE', 'meowmeowmeowmeowmo memwoemwomeowmomoewmowme', '999 years', '', 'Undergraduate', 1999, 0, '2005-05-28', 'yes', '0000-00-00 00:00:00'),
(11, 13, 'Feel Special', 'TWICE', 'NAYEON!!!!!!!!', '4 years', '', 'Undergraduate', 1000, 0, '2025-03-29', 'yes', '2025-03-03 11:44:30'),
(12, 13, 'sda', 'sdsad', '123123123', '12313', '', 'Grants', 26, 0, '2025-02-20', 'yes', '0000-00-00 00:00:00'),
(13, 13, 'Test123', 'TEST', 'NEIWNJKNAKLNLKNFLK', '3 years', '', 'Grants', 43, 0, '2025-02-20', 'yes', '0000-00-00 00:00:00'),
(14, 13, 'Cat & Dog', 'wqeqwe', 'sndknalkdfa', '5 years', '', 'Grants', 999, 0, '2025-02-20', 'rejected', '0000-00-00 00:00:00'),
(15, 12, 'Hard Times', 'PHINMA', 'Paramore', '5 years', '', 'undergrad', 22, 0, '2025-04-03', 'yes', '2025-03-05 13:23:04'),
(16, 12, 'sarap mo angelo', 'PHINMA', 'aaaaaaaa', '6 years', '', 'Education', 9999, 0, '2025-03-30', 'yes', '2025-03-05 13:25:54'),
(18, 13, 'FileUpload2', 'Circus2', 'This is a test for file uploads!2', '100 years', 'http://localhost/ScholarZone/documents/67ceecdb188af_circle-scatter-haikei.png', 'STEM', 22, 0, '2025-06-09', 'yes', '2025-03-10 13:44:59'),
(19, 13, 'FileUpload3', 'Circus3', 'This is a test for file uploads!2', '100 years', 'http://localhost/ScholarZone/documents/67cefa1038375_circle-scatter-haikei.png', 'STEM', 22, 0, '2025-06-09', 'no', '2025-03-10 14:41:20'),
(20, 13, 'FileUpload4', 'Circus4', 'This is a test for file uploads!2', '100 years', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67cefb0db2a15_circle-scatter-haikei.png', 'Undergraduate', 22, 1, '2025-06-09', 'yes', '2025-03-10 14:45:33'),
(21, 2, '21321', 'asdsa', '12113', 'dadsad', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d4425dc41d0_dorm6_image1.png', 'Education', 1, 0, '2025-03-30', 'yes', '2025-03-14 14:51:09'),
(22, 2, 'Ndjbndoand', 'asdsa', 'wqemwqkerwq', '123', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d4bd92cc257_dorm7_image1.png', 'Business', 99, 0, '2025-03-31', 'yes', '2025-03-14 23:36:50'),
(23, 13, 'asdasdasd', 'asdsa', 'djaskodjwkon', '999 years', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d4dd7e1109f_dorm10_image3.png', 'Undergraduate', 1, 0, '2025-03-31', 'yes', '2025-03-15 01:53:02'),
(24, 13, 'LastAPI', 'Circus2', 'testing', '111', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d55b0709a2b_Screenshot_2024-01-03_112722.png', 'Undergraduate', 1, 1, '2025-03-23', 'yes', '2025-03-15 10:48:39'),
(25, 17, 'Dilaw', 'asdsa', 'dahil ikaw ang katiyakan ko', '55 years', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d62e58e8643_dorm8_image1.png', 'Law', 1, 0, '2025-03-16', 'yes', '2025-03-16 01:50:16'),
(26, 13, 'dadada', 'sdasd', 'sadasdsad', 'sadad', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67d7a451158ad_dorm12_image2.png', 'Undergraduate', 111, 0, '2025-03-17', 'no', '2025-03-17 04:25:53'),
(27, 13, 'sdasda', 'hM', 'adadada', 'adada', 'https://active-fox-exactly.ngrok-free.app/ScholarZone/documents/67e55187bc16d_dorm7_image3.png', 'Education', 1, 0, '2025-04-03', 'no', '2025-03-27 13:24:23');

-- --------------------------------------------------------

--
-- Table structure for table `scholarship_tokens`
--

CREATE TABLE `scholarship_tokens` (
  `id` int(11) NOT NULL,
  `scholarship_application_id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `scholarship_tokens`
--

INSERT INTO `scholarship_tokens` (`id`, `scholarship_application_id`, `token`) VALUES
(1, 4, '1b0295eb039d845898faae4ba1bd6de9bff1a2026c04f9ec468cd66745fa922b'),
(2, 5, '1b0295eb039d845898faae4ba1bd6de9bff1a2026c04f9ec468cd66745fa922b'),
(3, 6, '1b0295eb039d845898faae4ba1bd6de9bff1a2026c04f9ec468cd66745fa922b'),
(4, 7, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3'),
(5, 8, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3'),
(6, 9, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3'),
(7, 10, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3'),
(8, 11, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3'),
(9, 12, '94d87f2306ed431215296a68ee76d09dd7b28ec1812873275cb4d9e1bb7ba923'),
(10, 13, '94d87f2306ed431215296a68ee76d09dd7b28ec1812873275cb4d9e1bb7ba923'),
(11, 14, '94d87f2306ed431215296a68ee76d09dd7b28ec1812873275cb4d9e1bb7ba923'),
(12, 15, 'b738154a62361586479b934e9486bd9dfa5626998d3d19446b3b29af14ff2e5c'),
(13, 16, 'b738154a62361586479b934e9486bd9dfa5626998d3d19446b3b29af14ff2e5c'),
(14, 17, '92db7bdb50518f719b1cb52aeea10e325325990a4361c977fc2bb03adb0268d7'),
(15, 18, '92db7bdb50518f719b1cb52aeea10e325325990a4361c977fc2bb03adb0268d7'),
(16, 19, '92db7bdb50518f719b1cb52aeea10e325325990a4361c977fc2bb03adb0268d7'),
(17, 20, '92db7bdb50518f719b1cb52aeea10e325325990a4361c977fc2bb03adb0268d7'),
(18, 21, '348a231eb1437faaac1539a7ff7c6a81fc72f130caa694b95ad5d21418afe383'),
(19, 22, '348a231eb1437faaac1539a7ff7c6a81fc72f130caa694b95ad5d21418afe383'),
(20, 23, 'ab1b7854c9233c902fc034cb38ff9c33f96593d61566e7c44d54457892f58239'),
(21, 24, 'ab1b7854c9233c902fc034cb38ff9c33f96593d61566e7c44d54457892f58239'),
(22, 25, '5db330b256acadb25bbe00f09ad974c389f3fbf2aee68af47f771bfb4d4c1d53'),
(23, 26, 'fe144d0f1f6419f237e987741e19db08b18fe5ccfaf5bbc939eb21eed78261df'),
(24, 27, '7039e5ea7f878df0d519b19a2e65818556262f322b29ce7c48f828d7f320e146');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin_notifications`
--
ALTER TABLE `admin_notifications`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin_tokens`
--
ALTER TABLE `admin_tokens`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_applicant` (`applicant_id`),
  ADD KEY `fk_questions` (`question_id`);

--
-- Indexes for table `applicants`
--
ALTER TABLE `applicants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `applicant_notifications`
--
ALTER TABLE `applicant_notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `applicant_notifications_ibfk_1` (`applicant_id`);

--
-- Indexes for table `applicant_otp`
--
ALTER TABLE `applicant_otp`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `applicant_tokens`
--
ALTER TABLE `applicant_tokens`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `scholarship_application_id` (`scholarship_application_id`),
  ADD KEY `applicant_id` (`applicant_id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `scholarship_application_id` (`scholarship_application_id`);

--
-- Indexes for table `reviewers`
--
ALTER TABLE `reviewers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reviewer_notifications`
--
ALTER TABLE `reviewer_notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reviewer_id` (`reviewer_id`);

--
-- Indexes for table `reviewer_otp`
--
ALTER TABLE `reviewer_otp`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `reviewer_tokens`
--
ALTER TABLE `reviewer_tokens`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_reviewer` (`reviewer_id`);

--
-- Indexes for table `scholarship_tokens`
--
ALTER TABLE `scholarship_tokens`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `admin_notifications`
--
ALTER TABLE `admin_notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `admin_tokens`
--
ALTER TABLE `admin_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `applicants`
--
ALTER TABLE `applicants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `applicant_notifications`
--
ALTER TABLE `applicant_notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `applicant_otp`
--
ALTER TABLE `applicant_otp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `applicant_tokens`
--
ALTER TABLE `applicant_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `applications`
--
ALTER TABLE `applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `reviewers`
--
ALTER TABLE `reviewers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `reviewer_notifications`
--
ALTER TABLE `reviewer_notifications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `reviewer_otp`
--
ALTER TABLE `reviewer_otp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `reviewer_tokens`
--
ALTER TABLE `reviewer_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `scholarship_tokens`
--
ALTER TABLE `scholarship_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `fk_applicant` FOREIGN KEY (`applicant_id`) REFERENCES `applicants` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_questions` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `applicant_notifications`
--
ALTER TABLE `applicant_notifications`
  ADD CONSTRAINT `applicant_notifications_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `applicants` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `applications`
--
ALTER TABLE `applications`
  ADD CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`scholarship_application_id`) REFERENCES `scholarship_applications` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `applications_ibfk_2` FOREIGN KEY (`applicant_id`) REFERENCES `applicants` (`id`);

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`scholarship_application_id`) REFERENCES `scholarship_applications` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reviewer_notifications`
--
ALTER TABLE `reviewer_notifications`
  ADD CONSTRAINT `reviewer_notifications_ibfk_1` FOREIGN KEY (`reviewer_id`) REFERENCES `reviewers` (`id`);

--
-- Constraints for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  ADD CONSTRAINT `fk_reviewer` FOREIGN KEY (`reviewer_id`) REFERENCES `reviewers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
