-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2022 at 07:12 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `booksite`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `page_number` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `release_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `isbn`, `author`, `genre`, `image`, `page_number`, `price`, `publisher`, `release_date`, `title`) VALUES
(1, '9786155252990', 'Borsa Brown', 'Romantikus', 'https://s02.static.libri.hu/cover/ac/1/2658948_5.jpg', 469, 3500, 'Álomgyár Kiadó', '2015-10-28 01:00:00', 'Az Arab (Arab 1.) - Szenvedély és erotika a Kelet kapujában'),
(2, '9786155760877', 'Raphaelle Giordano', 'Romantikus', 'https://s06.static.libri.hu/cover/56/b/4463140_5.jpg', 221, 2500, 'Művelt Nép Könyvkiadó', '2018-01-01 01:00:00', 'A második életed akkor kezdődik amikor megérted, hogy csak egy van'),
(3, '9789632663852', 'Jojo Moyes', 'Romantikus', 'https://s05.static.libri.hu/cover/9a/2/3137009_5.jpg', 483, 3800, 'Cartaphilus Kiadói Kft.', '2020-01-01 01:00:00', 'Mielőtt megismertelek'),
(4, '9789639765306', 'Murakami Haruki', 'Romantikus', 'https://s03.static.libri.hu/cover/8f/6/738073_5.jpg', 419, 4000, 'Geopen Könyvkiadó Kft.', '2021-01-01 01:00:00', 'Norvég erdő'),
(5, '9789639861381', 'Oliver Bowden', 'Akció és kaland', 'https://s04.static.libri.hu/cover/72/b/836133_5.jpg', 435, 4700, 'Fumax Kft.', '2021-01-01 01:00:00', 'Assassin’s Creed – Titkos keresztes háború'),
(6, '9789636357986', 'Leslie L. Lawrence', 'Akció és kaland', 'https://s06.static.libri.hu/cover/6d/9/8020428_5.jpg', 512, 4000, 'I.P.C Könyvek Kft.', '2021-01-01 01:00:00', 'A jakfarkas zászló'),
(7, '9789635443802', 'Laila Shukri', 'Akció és kaland', 'https://s06.static.libri.hu/cover/b9/2/7323779_5.jpg', 429, 3790, 'Kossuth Kiadó Zrt.', '2021-01-01 01:00:00', 'Az arab bordély foglyai'),
(8, '9789634474760', 'Emily Gunnis', 'Akció és kaland', 'https://s06.static.libri.hu/cover/c4/d/5744060_5.jpg', 336, 3700, 'Alexandra Könyvesház Kft.', '2019-01-01 01:00:00', 'A lány levélből'),
(9, '9789634795414', 'George Orwell', 'Szatíra', NULL, 119, 1450, 'HELIKON KIADÓ KFT.', '2021-01-01 01:00:00', 'Állatfarm'),
(10, '9789634798101', 'Bödőcs Tibor', 'Szatíra', NULL, 208, 3300, 'HELIKON KIADÓ KFT.', '2022-01-01 01:00:00', 'Addig se iszik'),
(11, '2399987972546', 'Timur Vermes', 'Szatíra', NULL, 341, 3790, 'Libri Könyvkiadó', '2013-01-01 01:00:00', 'Nézd, ki van itt'),
(12, '9786155164705', 'Karinthy Frigyes', 'Szatíra', NULL, 352, 4740, 'SZÁZADVÉG KIADÓ', '2020-01-01 01:00:00', 'Gulliver történetei'),
(13, '2399993030827', 'Franz Kafka', 'Szépirodalmi', NULL, 302, 1500, 'Európa Könyvkiadó', '1982-01-01 01:00:00', 'Az átváltozás'),
(14, '9789636896973', 'Thomas Mann', 'Szépirodalmi', NULL, 252, 1000, 'GABO KÖNYVKIADÓ ÉS KERESK.KFT.', '2013-01-01 01:00:00', 'Halál Velencében - Mario és a varázsló - Talentum'),
(15, '9789630794534', 'Ken Kesey', 'Szépirodalmi', NULL, 374, 780, 'EURÓPA KÖNYVKIADÓ KFT.', '2020-01-01 01:00:00', 'Száll a kakukk fészkére'),
(16, '9786066468701', 'Madách Imre', 'Szépirodalmi', NULL, 247, 850, 'Kreatív Kiadó', '2022-01-01 01:00:00', 'Az ember tragédiája'),
(17, '9789632442952', 'Janne Teller', 'Filozófia', 'https://s02.static.libri.hu/cover/90/9/830872_5.jpg', 181, 2800, 'SCOLAR KIADÓ KFT.', '2021-01-01 01:00:00', 'Semmi'),
(18, '9789634798156', 'Oscar Wilde', 'Filozófia', 'https://s06.static.libri.hu/cover/f6/4/6640364_5.jpg', 299, 1700, 'HELIKON KIADÓ KFT.', '2021-01-01 01:00:00', 'Dorian Gray arcképe'),
(19, '9632070771', 'Marx Karl', 'Filozófia', 'https://cdn.antikvarium.hu/foto/eredeti/5519051.jpg', 284, 1200, 'Magyar Helikon', '1978-01-01 01:00:00', 'A filozófia nyomorúsága'),
(20, '2399987079177', 'Agrippa von Nettesheim', 'Filozófia', 'https://s04.static.libri.hu/cover/sl/7c/b/7cb39ef709a23086bac0e48846d4b24a_big.jpg', 199, 2300, 'Hermit Könyvkiadó Bt.', '1999-01-01 01:00:00', 'Okkult filozófia'),
(21, '9789635043934', 'Stephen King', 'Horror', 'https://s02.static.libri.hu/cover/11/5/7307518_5.jpg', 283, 3300, 'EURÓPA KÖNYVKIADÓ KFT.', '2021-01-01 01:00:00', 'Carrie'),
(22, '9789635661848', 'Joe Hill', 'Horror', 'https://s02.static.libri.hu/cover/27/7/8226292_5.jpg', 400, 4000, 'GABO KÖNYVKIADÓ ÉS KERESK.KFT.', '2022-01-01 01:00:00', 'Fekete telefon'),
(23, '9789635701759', 'Megan Goldin', 'Horror', 'https://s06.static.libri.hu/cover/3c/b/7574035_5.jpg', 399, 2100, 'ÁLOMGYÁR KIADÓ', '2021-01-01 01:00:00', 'Szállj ki, ha tudsz!'),
(24, '9786156013507', 'Heidi Perks', 'Horror', 'https://s01.static.libri.hu/cover/6d/c/5397487_5.jpg', 416, 2000, 'ÁLOMGYÁR KIADÓ', '2021-01-01 01:00:00', 'Mint a szemed fényére'),
(25, '9789635660933', 'Dan Brown', 'Krimi', 'https://s04.static.libri.hu/cover/34/b/744306_5.jpg', 733, 4200, 'GABO KÖNYVKIADÓ ÉS KERESK.KFT.', '2009-01-01 01:00:00', 'Az elveszett jelkép'),
(26, '9789634067702', 'Ken Follett', 'Krimi', 'https://s04.static.libri.hu/cover/df/a/822254_5.jpg', 968, 5670, 'GABO KÖNYVKIADÓ ÉS KERESK.KFT.', '2010-01-01 01:00:00', 'A Titánok bukása'),
(27, '2399989193932', 'Stieg Larsson', 'Krimi', 'https://s04.static.libri.hu/cover/sl/33/a/33a0ca61e27f03cbfc95729889b6037e_big.jpg', 576, 1990, 'Animus Kiadó', '0000-00-00 00:00:00', 'A tetovált lány'),
(28, '9789635661121', 'Dan Brown', 'Krimi', 'https://s04.static.libri.hu/cover/e0/5/4325023_5.jpg', 576, 4200, 'GABO KÖNYVKIADÓ ÉS KERESK.KFT.', '2018-01-01 01:00:00', 'Eredet'),
(29, '9789634158493', 'Szabó Magda', 'Lányregény', 'https://s03.static.libri.hu/cover/fb/7/3260410_5.jpg', 349, 2650, 'MÓRA FERENC IFJÚSÁGI KÖNYVKIADÓ ZRT', '2022-01-01 01:00:00', 'Abigél'),
(30, '0359000822052', 'Lisi Harrison', 'Lányregény', 'https://s04.static.libri.hu/cover/sl/e3/4/e3443cedb694532451c76c17c04665c4_big.jpg', 302, 790, 'Ulpius-ház', '2008-01-01 01:00:00', 'Klikk'),
(31, '9789639563001', 'Jacqueline Wilson', 'Lányregény', 'https://s01.static.libri.hu/cover/37/c/676905_4.jpg', 112, 1400, 'Animus Kiadó', '2003-01-01 01:00:00', 'Aludj nálunk!'),
(32, '0939000025785', 'William Somerset Maugham', 'Lányregény', 'https://s04.static.libri.hu/cover/sl/97/5/9755596491bcd2430495c1fec5c3c368_big.jpg', 314, 490, 'Fabula Könyvkiadó Kft.', '1994-01-01 01:00:00', 'Szerelmek végórái'),
(33, '9789635040094', 'Stephen King', 'Rejtély és thriller', 'https://s02.static.libri.hu/cover/8a/e/5133250_5.jpg', 592, 3800, 'Európa Kiadó', '2019-03-18 00:00:00', 'Kedvencek temetője'),
(34, '9789635041060', 'Stephen King', 'Rejtély és thriller', 'https://s03.static.libri.hu/cover/9b/c/5583207_5.jpg', 1200, 7600, 'Európa Kiadó', '2019-08-29 00:00:00', 'Az 1-2'),
(35, '9789634059455', 'Stephen King', 'Rejtély és thriller', 'https://s04.static.libri.hu/cover/54/3/5049885_5.jpg', 624, 3800, 'Európa Kiadó', '2018-11-16 00:00:00', 'Borzalmak városa'),
(36, '9630768984', 'Stephen King', 'Rejtély és thriller', 'https://static1.lira.hu/upload/M_28/rek1/841/2992841.jpg', 440, 3790, 'Európa Kiadó', '2001-01-01 00:00:00', 'A ragyogás'),
(37, '9789635841226', 'Cynthia és Brian Paterson', 'Gyermek', 'https://static1.lira.hu/upload/M_28/rek1/512/2880512.jpg', 256, 7100, 'Manó Könyvek', '2022-02-22 00:00:00', 'Foxwood összes meséje'),
(38, '9789635095155', 'Takács Viktória', 'Gyermek', 'https://static1.lira.hu/upload/M_28/rek1/327/2879327.jpg', 24, 2000, 'Scolar Kiadó', '2022-02-01 00:00:00', 'Farsangi mese'),
(39, '9789635990856', 'Polgár Judit', 'Gyermek', 'https://s06.static.libri.hu/cover/cb/1/4086261_5.jpg', 64, 3800, 'KOLIBRI GYEREKKÖNYVKIADÓ KFT', '2020-01-01 00:00:00', 'Kalandozás a sakk táblán'),
(40, '9789635841189', 'Lucy Strange', 'Gyermek', 'https://static1.lira.hu/upload/M_28/rek1/22/2878022.jpg', 336, 2800, 'Manó Könyvek', '2022-02-15 00:00:00', 'A nővérek átka'),
(41, '9789635840960', 'Serena Valentino', 'Ifjúsági', 'https://static1.lira.hu/upload/M_28/rek1/18/2878018.jpg', 264, 3300, 'Manó Könyvek', '2022-02-25 00:00:00', 'Minden gonoszok úrnője - A sötét tündér története'),
(42, '9789633998465', 'Rick Riordan', 'Ifjúsági', 'https://static1.lira.hu/upload/M_28/rek1/838/1267838.jpg', 373, 3000, 'KÖNYVMOLYKÉPZŐ KIADÓ KFT', '2016-11-03 00:00:00', 'Percy Jackson és az olimposziak 1. – A villámtolvaj'),
(43, '9789635616770', 'Leigh Bardugo', 'Ifjúsági', 'https://static1.lira.hu/upload/M_28/rek1/481/2576481.jpg', 376, 3600, 'KÖNYVMOLYKÉPZŐ KIADÓ KFT', '2021-05-14 00:00:00', 'Árnyék és csont'),
(44, '9789638988881', 'Berg Judit', 'Ifjúsági', 'https://static1.lira.hu/upload/M_28/rek1/508/1690508.jpg', 272, 4000, 'ECOVIT KIADÓ KFT', '2019-05-31 00:00:00', 'Az őrzők'),
(45, '9789635660346', 'Andrzej Sapkowski', 'Fantázia', 'https://static1.lira.hu/upload/M_28/rek1/718/2448718.jpg', 632, 3790, 'Gabo Könyvkiadó és Kereskedo Kft', '2021-01-08 00:00:00', 'Vaják - Az utolsó kívánság'),
(46, '2399978772728', 'J.R.R. Tolkien', 'Fantázia', 'https://s04.static.libri.hu/cover/sl/51/c/51c13f36b84bbe786f62285562535172_big.jpg', 1607, 12300, 'Árkádia Könyvkiadó', '1990-01-01 00:00:00', 'A gyűrűk Ura I-II-III.'),
(47, '9789634059615', 'Stephen King és Owen King', 'Fantázia', 'https://static1.lira.hu/upload/M_28/rek1/257/1600257.jpg', 706, 5200, 'EURÓPA KÖNYVKIADÓ KFT.', '2019-01-08 00:00:00', 'Csipkerózsikák'),
(48, '9789634478409', 'George R.R. Martin', 'Fantázia', 'https://static1.lira.hu/upload/M_28/rek1/710/2371710.jpg', 816, 5000, 'Alexandra Kiadó', '2020-11-20 00:00:00', 'Trónok harca');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
