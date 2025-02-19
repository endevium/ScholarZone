-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2025 at 02:25 PM
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
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(14, 'meow', 'a@a.com', NULL, '$2y$10$6a4uTMoBXaIgSdY3X8aD8uXmRKeqvOcXQFtJzGE96/3imn16xU8f2', 'a', 'b', 'male', '2005-06-09', 1, 'm', 'a', 'm', 'm'),
(15, 'API_Tester', 'b@b.com', NULL, '$2y$10$gjLqWuR.k7.AOFAMR3nfbenbe7XCJ3S5uMtV2Oz0D5/cMNeepChTG', 'API', 'Tester', 'Male', '2005-06-09', 2147483647, 'meow', 'BSIT', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal');

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
(37, 15, '8763bc677533a102f458264ae7cc4feaf3cf4a9e50e7c7ee7a1e01627eccb2a5');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `scholarship_application_id` int(11) NOT NULL,
  `question` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `scholarship_application_id`, `question`) VALUES
(1, 2, 'hi'),
(3, 2, 'hi'),
(4, 2, 'hi'),
(5, 2, 'wewqewqerwqq');

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
(12, 'meow', NULL, 'a@a.com', '$2y$10$SKPFiAh//vgXDIX516Mf0uJfggoRxkKsckjSE6xLhnM7FtXU3SAHW', 'a', 'b', '2005-06-09', 'male', 1, 'PHINMA', 'm', 'm'),
(13, 'API_Tester', NULL, 'b@b.com', '$2y$10$ZCt3R6yMm49TAzBe7.IpuuCZFbPXB23Wgdt56GFB8AsKPVrnKIcVy', 'API', 'Tester', '2005-06-09', 'Male', 2147483647, 'hM', 'Region I, Pangasinan, Dagupan', 'Pantal, Pantal, Pantal');

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
(5, 13, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3');

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
  `deadline` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `scholarship_applications`
--

INSERT INTO `scholarship_applications` (`id`, `reviewer_id`, `application_name`, `company`, `application_description`, `duration`, `application_image`, `category`, `slots`, `deadline`) VALUES
(2, 12, 'Hawak Kamay', 'PHINMA', 'hi', '4 years', NULL, 'Undergraduate', 1, '0000-00-00'),
(3, 12, 'Guanzon Grants', 'Guanzon', 'hi', 'N/A', '', 'Grants', 1, '0000-00-00'),
(4, 12, 'SM Scholarship', 'SM', 'hi', '4 years', '', 'Undergraduate', 1, '0000-00-00'),
(6, 12, 'Sudden Shower', 'ECLIPSE', 'meowmeowmeowmeowmo memwoemwomeowmomoewmowme', '999 years', '', 'Undergraduate', 1999, '2005-05-28'),
(11, 13, 'Feel Special', 'TWICE', 'NAYEON!!!!!!!!', '4 years', '', 'Undergraduate', 1000, '2025-03-01');

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
(8, 11, 'd636ac927230068b11652a58ceb74c8f1e2120a699a0132171bc4da705f57ba3');

--
-- Indexes for dumped tables
--

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
-- Indexes for table `applicant_tokens`
--
ALTER TABLE `applicant_tokens`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `applicants`
--
ALTER TABLE `applicants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `applicant_tokens`
--
ALTER TABLE `applicant_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `reviewers`
--
ALTER TABLE `reviewers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `reviewer_tokens`
--
ALTER TABLE `reviewer_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `scholarship_tokens`
--
ALTER TABLE `scholarship_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`scholarship_application_id`) REFERENCES `scholarship_applications` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `scholarship_applications`
--
ALTER TABLE `scholarship_applications`
  ADD CONSTRAINT `fk_reviewer` FOREIGN KEY (`reviewer_id`) REFERENCES `reviewers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
