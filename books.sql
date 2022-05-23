-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Máj 23. 18:25
-- Kiszolgáló verziója: 10.4.21-MariaDB
-- PHP verzió: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `booksite`
--

--
-- A tábla adatainak kiíratása `book`
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
(32, '0939000025785', 'William Somerset Maugham', 'Lányregény', 'https://s04.static.libri.hu/cover/sl/97/5/9755596491bcd2430495c1fec5c3c368_big.jpg', 314, 490, 'Fabula Könyvkiadó Kft.', '1994-01-01 01:00:00', 'Szerelmek végórái');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
