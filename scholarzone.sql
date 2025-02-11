-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2025 at 06:19 AM
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
-- Table structure for table `applicants`
--

CREATE TABLE `applicants` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pfp` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `phone_number` int(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `program` varchar(255) NOT NULL,
  `full_address` varchar(255) NOT NULL,
  `rpc` varchar(255) NOT NULL,
  `bsb` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applicants`
--

INSERT INTO `applicants` (`id`, `username`, `email`, `pfp`, `password`, `firstname`, `lastname`, `gender`, `birthdate`, `phone_number`, `school`, `program`, `full_address`, `rpc`, `bsb`) VALUES
(1, 'johndoe', 'monde12@gmail.com', NULL, '$2y$10$wJtFKX1/aHp8och8iFkk5eUoYdv15nNMF2ioOBizJIPKUVsQBS/Oi', 'monde', 'guil', 'male', '2005-05-28', 2147483647, 'Upang', 'BSIT', '253, Banaoang, Sta barbara, Pangasinan', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(2, 'johndoe', 'monde12@gmail.com', NULL, '$2y$10$eK3v2iRqc/H7WjzRt/A8d.9yvqzpn3ClXe7FDAVKjAmcfp5RbEAO2', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', '253, Banaoang, Sta barbara, Pangasinan', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(3, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$IPV2ZampWthjkGhJMEFWFuypyQC24ArZXjej00bV/pHxBbGEZObCe', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', '253, Banaoang, Sta barbara, Pangasinan', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(4, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$msIrebn.RVhJ9nuc0pbV1eDxeE7WAL.t85X1.NldDeC0hYChP9qri', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', '253, Banaoang, Sta barbara, Pangasinan', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(5, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$2t4D3h3qHWiIDgYlgIcZuu8dZ8Zk4yUAL04E3MVdgIYmLA6JiGNSu', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', '253, Banaoang, Sta barbara, Pangasinan', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45');

-- --------------------------------------------------------

--
-- Table structure for table `reviewers`
--

CREATE TABLE `reviewers` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `pfp` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `company` varchar(255) NOT NULL,
  `full_address` varchar(255) NOT NULL,
  `rpc` varchar(255) NOT NULL,
  `bsb` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviewers`
--

INSERT INTO `reviewers` (`id`, `username`, `pfp`, `email`, `password`, `firstname`, `lastname`, `birthdate`, `gender`, `phone_number`, `company`, `full_address`, `rpc`, `bsb`) VALUES
(1, 'monddee', NULL, 'monde12@gmail.com', '$2y$10$0CBvj7M4qfeXyIvWbCgazuCucaGjsGJFwR/fBu.Otu9niMCdAoAlK', 'monde', 'guil', '2005-05-28', 'male', 2147483647, 'BDO', '253, Banaoang, Sta barbara, Pangasinan', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45');

-- --------------------------------------------------------

--
-- Table structure for table `scholarship_applications`
--

CREATE TABLE `scholarship_applications` (
  `id` int(11) NOT NULL,
  `application_name` varchar(255) NOT NULL,
  `application_description` varchar(255) NOT NULL,
  `duration` varchar(255) NOT NULL,
  `application_image` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `slots` int(255) NOT NULL,
  `deadline` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applicants`
--
ALTER TABLE `applicants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reviewers`
--
ALTER TABLE `reviewers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applicants`
--
ALTER TABLE `applicants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reviewers`
--
ALTER TABLE `reviewers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
