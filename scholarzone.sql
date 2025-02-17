-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 17, 2025 at 01:52 PM
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
  `rpc` varchar(255) NOT NULL,
  `bsb` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applicants`
--

INSERT INTO `applicants` (`id`, `username`, `email`, `pfp`, `password`, `firstname`, `lastname`, `gender`, `birthdate`, `phone_number`, `school`, `program`, `rpc`, `bsb`) VALUES
(1, 'johndoe', 'monde12@gmail.com', NULL, '$2y$10$wJtFKX1/aHp8och8iFkk5eUoYdv15nNMF2ioOBizJIPKUVsQBS/Oi', 'monde', 'guil', 'male', '2005-05-28', 2147483647, 'Upang', 'BSIT', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(2, 'johndoe', 'monde12@gmail.com', NULL, '$2y$10$eK3v2iRqc/H7WjzRt/A8d.9yvqzpn3ClXe7FDAVKjAmcfp5RbEAO2', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(3, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$IPV2ZampWthjkGhJMEFWFuypyQC24ArZXjej00bV/pHxBbGEZObCe', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(4, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$msIrebn.RVhJ9nuc0pbV1eDxeE7WAL.t85X1.NldDeC0hYChP9qri', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(5, 'monddee', 'monde12@gmail.com', NULL, '$2y$10$2t4D3h3qHWiIDgYlgIcZuu8dZ8Zk4yUAL04E3MVdgIYmLA6JiGNSu', 'monde', 'guil', 'male', '2005-05-28', 2147483647, '', '', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(6, 'John', 'john@email.com', NULL, '$2y$10$G0A//jfqQiyOz4aelO6/K.vzmWg8ewdImLgd3.APPhRVrWANIdkem', 'John', 'Doee', 'Male', '2005-06-09', 2147483647, 'UPang', 'BSIT', 'Pangasinan', 'Bari'),
(7, 'John', 'john@email.com', NULL, '$2y$10$IZ9hTGsldlIfnBwgoGiJcOkia4BCBuV/rc9t5fSjNn707dN5Xf42m', 'John', 'Doee', 'Male', '2005-06-09', 2147483647, 'UPang', 'BSIT', 'Pangasinan', 'Bari'),
(8, 'john', 'g@gmail.com', NULL, '$2y$10$vcCfVCA3nKRraV7EGNy1ju5j1Iy5vkRqcwtX9Lx92DO1y5dIs3gzi', 'Johhn', 'Jodheo', 'Male', '2025-02-11', 1344364, 'B', 'S', 'T', 'B'),
(9, 'monde', 'monde12@gmail.com', NULL, '$2y$10$cZDMCEM7wpyB3l.eUOL1oeI8Jsx8UBdFJgW.x8IoqSAa02TRtnKgK', 'Richmond ', 'Guiling ', 'Male', '2005-05-28', 1234567891, 'PHINMA- UNIVERSITY OF PANGASINAN ', 'Information Technology ', '1, Pangasinan, daguapn', 'dagupan, arillinso,1'),
(10, 'ji', 'a@a.com', NULL, '$2y$10$0FkTBKyJTjoMnSSVkIaqtOd2fP3qM2RWUgkkzi1sur82HPHfYA6Yy', 'Jojn', 'Doe', 'Male', '2025-02-16', 1243467, 'B', 'S', 'T', 'B'),
(11, 'meow', 'a@a.com', NULL, '$2y$10$KwdMCKoQrLEwo/DEXjJhEOFKDhiCrqssM0C0QR/oX8qxFbOA0hTNe', 'a', 'b', 'male', '2005-06-09', 1, 'm', 'a', 'm', 'm'),
(12, 'meow', 'a@a.com', NULL, '$2y$10$Pjmt.u2jZ0cGsvYTgZ4n0O96VAFZukZ1y8hNAsRQkBFNtgY4q2QJ.', 'a', 'b', 'male', '2005-06-09', 1, 'm', 'a', 'm', 'm'),
(13, 'meow', 'a@a.com', NULL, '$2y$10$YjwHKXhTLFvOqrrwxJNK1ezYqN.irLBG18DFgHJKLpgehprgukx.2', 'a', 'b', 'male', '2005-06-09', 1, 'm', 'a', 'm', 'm'),
(14, 'meow', 'a@a.com', NULL, '$2y$10$6a4uTMoBXaIgSdY3X8aD8uXmRKeqvOcXQFtJzGE96/3imn16xU8f2', 'a', 'b', 'male', '2005-06-09', 1, 'm', 'a', 'm', 'm');

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
(4, 10, '049d9b95f7bd9eb8da8d4bb1137527086f9d284d156a38555e1f8b302efd4fe2');

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
  `rpc` varchar(255) NOT NULL,
  `bsb` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviewers`
--

INSERT INTO `reviewers` (`id`, `username`, `pfp`, `email`, `password`, `firstname`, `lastname`, `birthdate`, `gender`, `phone_number`, `company`, `rpc`, `bsb`) VALUES
(1, 'monddee', NULL, 'monde12@gmail.com', '$2y$10$0CBvj7M4qfeXyIvWbCgazuCucaGjsGJFwR/fBu.Otu9niMCdAoAlK', 'monde', 'guil', '2005-05-28', 'male', 2147483647, 'BDO', 'Region 1,Pangasinan, Dagupan City', 'Pantal, aguilar street, Building 45'),
(2, 'John', NULL, 'john@email.com', '$2y$10$Hei1WKW7D.ZLJ/tUUOyOJeAjOK768hb3U3apkXw30JPeQcOtWe602', 'John', 'Doee', '2005-06-09', 'Male', 2147483647, 'PHINMA', 'Pangasinan', 'Bari'),
(3, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$SvrBROwlJELJz/cZyC3ofemPXlHJ/wlaKUK6hALpziqBJGGvAbe7u', 'John', 'Doe', '2025-02-11', 'other', 2147483647, 'sada', 'dadad', 'adad'),
(4, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$1l90fDpuLuN3N85dMxm0tuDpx86i3PQTMJNsTNRQOA7DFygAq95u.', 'John', 'Doe', '2025-02-11', 'other', 2147483647, 'asda', 'dadada', 'adada'),
(5, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$/lw8d8XJy8bM2qDv4RXbBeLbX1NS8eYiHPgR5xC/eKo8q04mf4syG', 'John', 'Doe', '2025-02-11', 'other', 2147483647, 'asda', 'dadada', 'adada'),
(6, 'Nana', NULL, 'info.up@phinmaed.com', '$2y$10$Z8hguaFawqLRf7U4kQwHPOj0NZqos5A.aL8QQTHTkJCLYu89pKZ4u', 'John', 'Doe', '2025-02-11', 'other', 2147483647, 's', 'sdada', 'adada'),
(7, 'meow', NULL, 'a@a.com', '$2y$10$gbr1Ows7DOKsJLOWJ8xz/u8oucATx0ElomC07j8dY0GZpBhaEkkje', 'a', 'b', '2005-06-09', 'male', 1, 'PHINMA', 'm', 'm'),
(8, 'meow', NULL, 'a@a.com', '$2y$10$fWMTf3FXEL1fbsu/ch7Zk.Ux4IcpNaQ0Wx5rqheUgMI2EWXZs3Qs6', 'a', 'b', '2005-06-09', 'male', 1, 'PHINMA', 'm', 'm'),
(9, 'meow', NULL, 'a@a.com', '$2y$10$qjnf/xTDtBa.Q7YRvTnPxuMz7a78FmYbaHgbsJVUi0gK7nDbkUR/u', 'a', 'b', '2005-06-09', 'male', 1, 'PHINMA', 'm', 'm'),
(10, 'meow', NULL, 'a@a.com', '$2y$10$un8GMVTaXyx7uOCncqSOOeG4NcGWA828blol1hAyC4817Ywyvauva', 'a', 'b', '2005-06-09', 'male', 1, 'PHINMA', 'm', 'm'),
(11, 'meow', NULL, 'a@a.com', '$2y$10$DjAqeH5.LY4q4R2DwFf5j.8xTwoDf4rysF9o.Evp7wwrwDVOs00cO', 'a', 'b', '2005-06-09', 'male', 1, 'PHINMA', 'm', 'm'),
(12, 'meow', NULL, 'a@a.com', '$2y$10$SKPFiAh//vgXDIX516Mf0uJfggoRxkKsckjSE6xLhnM7FtXU3SAHW', 'a', 'b', '2005-06-09', 'male', 1, 'PHINMA', 'm', 'm');

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
(4, 12, '1b0295eb039d845898faae4ba1bd6de9bff1a2026c04f9ec468cd66745fa922b');

-- --------------------------------------------------------

--
-- Table structure for table `scholarship_applications`
--

CREATE TABLE `scholarship_applications` (
  `id` int(11) NOT NULL,
  `reviewer_id` int(11) NOT NULL,
  `application_name` varchar(255) NOT NULL,
  `application_description` varchar(255) NOT NULL,
  `duration` varchar(255) NOT NULL,
  `application_image` varchar(255) DEFAULT '',
  `category` varchar(255) NOT NULL,
  `slots` int(255) NOT NULL,
  `deadline` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `scholarship_applications`
--

INSERT INTO `scholarship_applications` (`id`, `reviewer_id`, `application_name`, `application_description`, `duration`, `application_image`, `category`, `slots`, `deadline`) VALUES
(2, 12, 'hi', 'hi', '4 years', NULL, 'hi', 1, '0000-00-00'),
(3, 12, 'hi', 'hi', '4 years', '', 'hi', 1, '0000-00-00'),
(4, 12, 'hi', 'hi', '4 years', '', 'hi', 1, '0000-00-00'),
(5, 12, 'hi', 'sdasd', '1', '', 'grants', 1, '2025-06-09');

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
(2, 5, '1b0295eb039d845898faae4ba1bd6de9bff1a2026c04f9ec468cd66745fa922b');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applicants`
--
ALTER TABLE `applicants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `applicant_tokens`
--
ALTER TABLE `applicant_tokens`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reviewers`
--
ALTER TABLE `reviewers`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for table `applicants`
--
ALTER TABLE `applicants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `applicant_tokens`
--
ALTER TABLE `applicant_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `reviewers`
--
ALTER TABLE `reviewers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `reviewer_tokens`
--
ALTER TABLE `reviewer_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `scholarship_tokens`
--
ALTER TABLE `scholarship_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  ADD CONSTRAINT `fk_reviewer` FOREIGN KEY (`reviewer_id`) REFERENCES `reviewers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
