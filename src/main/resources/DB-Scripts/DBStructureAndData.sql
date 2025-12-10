CREATE DATABASE  IF NOT EXISTS `backlogvideojuegos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `backlogvideojuegos`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: backlogvideojuegos
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `companhias`
--

DROP TABLE IF EXISTS `companhias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companhias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(55) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companhias`
--

LOCK TABLES `companhias` WRITE;
/*!40000 ALTER TABLE `companhias` DISABLE KEYS */;
INSERT INTO `companhias` VALUES (8,'Capcom'),(7,'CD Projekt Red'),(5,'Nintendo EAD'),(6,'Rockstar Games');
/*!40000 ALTER TABLE `companhias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataformas`
--

DROP TABLE IF EXISTS `plataformas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plataformas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(55) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataformas`
--

LOCK TABLES `plataformas` WRITE;
/*!40000 ALTER TABLE `plataformas` DISABLE KEYS */;
INSERT INTO `plataformas` VALUES (10,'Móvil (Android/iOS)'),(9,'Nintendo Switch'),(6,'PC'),(7,'PlayStation 5'),(8,'Xbox Series X');
/*!40000 ALTER TABLE `plataformas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(55) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `is_admin` tinyint(1) DEFAULT '0',
  `stylesheet` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'jamp1','$2a$10$rDX36VVGu2sgARt0YkjrE.K3ZnSX7QhVLxk799MW.VAMXWeIkEvp2','jamp1998@mail.com',0,0),(5,'pepito','$2a$10$a/FMMz2k/TmgdyCUV3RzIe7f2oZKWNto6xGGrhWCAPG/6jMO6H8Z6','pepe@mail.com',1,0),(7,'javi','$2a$10$2AiP/g9wQiFYERPtZDTbmOXwRUfnzcxpICyzQoTjS7Eai2GcompG2','javi@mail.com',0,0),(9,'pepe','porepor','nrnn',0,0),(10,'admin_user','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','admin@mail.com',1,0),(11,'jugador1','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','jugador1@mail.com',0,0),(12,'caza_ofertas','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','caza_ofertas@mail.com',0,1),(13,'rolero_pro','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','rolero_pro@mail.com',0,0),(14,'gamer_retro','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','gamer_retro@mail.com',0,1),(15,'usuario6','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','usuario6@mail.com',0,0),(16,'usuario7','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','usuario7@mail.com',0,0),(17,'usuario8','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','usuario8@mail.com',0,0),(18,'usuario9','$2a$10$B.t.jF2H5.jY8E.n.8rOQ.w1D.L/d.jF2H5.jY8E.n.8rOQ','usuario9@mail.com',0,0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_backlog`
--

DROP TABLE IF EXISTS `usuarios_backlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_backlog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_videojuego` int NOT NULL,
  `id_usuario` int NOT NULL,
  `resenha` text,
  `valoracion` tinyint DEFAULT NULL,
  `estado` enum('BACKLOG','PLAYED','PLAYING') NOT NULL DEFAULT 'BACKLOG',
  `duracion` decimal(4,1) DEFAULT NULL,
  `fecha_resenha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_videojuegos_idx` (`id_videojuego`),
  KEY `fk_usuarios_idx` (`id_usuario`),
  CONSTRAINT `fk_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_videojuegos` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_backlog`
--

LOCK TABLES `usuarios_backlog` WRITE;
/*!40000 ALTER TABLE `usuarios_backlog` DISABLE KEYS */;
INSERT INTO `usuarios_backlog` VALUES (10,23,10,'Obra maestra de Nintendo que expande magistralmente la fórmula de Breath of the Wild. La exploración vertical y la habilidad de construcción lo hacen sin precedentes.',10,'PLAYED',180.5,'2023-05-20'),(11,25,10,'Mundo impresionante, aunque el lanzamiento estuvo plagado de bugs. La narrativa y los personajes son de lo mejor del género Sci-Fi.',7,'PLAYED',150.0,'2022-12-01'),(12,27,10,'Clásico atemporal. Es el sandbox definitivo que permite una creatividad ilimitada.',9,'PLAYING',500.0,'2019-01-01'),(13,30,10,'Roguelike con una narrativa excelente, aunque la dificultad me intimida un poco. Lo tengo pendiente para una inmersión completa.',9,'BACKLOG',NULL,'2024-01-10'),(14,31,10,'Plataformas increíblemente satisfactorio, aunque la historia me resultó un poco básica. La jugabilidad es fluida y desafiante.',8,'PLAYED',25.5,'2023-11-15'),(15,24,10,'Pendiente de rejugada. Un mundo abierto que se siente vivo como pocos. Lo tengo en mi lista de \"pendiente\".',9,'BACKLOG',NULL,'2024-06-01'),(16,28,10,'Aventura interesante, pero con poco valor de rejugabilidad. La ambientación y la banda sonora son lo mejor del juego.',7,'PLAYED',12.0,'2024-07-10'),(17,32,10,'Un metroidvania de manual, con un diseño de niveles intrincado y desafiante. No apto para impacientes, pero muy gratificante.',8,'PLAYING',30.0,'2024-08-15'),(18,24,11,'El mejor juego de mundo abierto jamás creado. La atención al detalle es enfermiza. Una experiencia inolvidable.',10,'PLAYED',160.0,'2020-03-05'),(19,26,11,'Horas de diversión con amigos. La curva de dificultad es alta y requiere mucha coordinación y estrategia.',7,'PLAYING',80.0,'2021-06-10'),(20,28,11,'Corto pero memorable. Jugar como un gato en un mundo cyberpunk es una experiencia única y visualmente deslumbrante.',8,'PLAYED',6.0,'2023-08-28'),(21,32,11,'En el backlog para cuando tenga tiempo libre, sé que será un gran desafío y requiere mucha paciencia.',9,'BACKLOG',NULL,'2024-02-01'),(22,33,11,'Comenzando. Parece un gran desafío moral, las reseñas me han convencido a darle una oportunidad por su narrativa.',8,'BACKLOG',NULL,'2024-03-03'),(23,23,11,'Muy divertido, aunque preferí la versión anterior. Un gran juego de exploración y aventura.',6,'PLAYED',20.0,'2024-06-01'),(24,27,11,'Muy divertido y relajante. El juego es muy disfrutable si te gusta la estética urbana y futurista.',8,'PLAYED',15.0,'2024-07-01'),(25,31,11,'Uno de los mejores platformers indie. Su historia sobre la ansiedad es conmovedora y muy bien ejecutada.',9,'PLAYING',5.0,'2024-08-01'),(26,29,12,'Historia oscura y banda sonora brutal. La ambientación mitológica griega es genial, aunque la dificultad de los jefes es frustrante a veces.',8,'PLAYED',12.0,'2023-10-10'),(27,30,12,'Perfecto para jugar en pareja, muy innovador. Un juego que demuestra que la narrativa puede ir de la mano con la diversión pura y cooperativa.',9,'PLAYED',15.0,'2023-01-15'),(28,31,12,'Pendiente de descarga, lo compré en rebajas. Me han dicho que es una joya oculta del género de plataformas y quiero probarlo.',8,'BACKLOG',NULL,'2024-04-01'),(29,32,12,'Atmósfera increíble, pura claustrofobia y un diseño de niveles excepcional. Debería tener más reconocimiento por su arte.',9,'PLAYED',5.0,'2022-09-01'),(30,33,12,'Necesita mucha lectura, pero el guion es oro y las decisiones tienen peso real. Me está costando avanzar, pero es brillante en su ejecución.',10,'PLAYING',45.0,'2024-05-01'),(31,23,12,'Juego comprado a precio completo. Un gran retorno a la esencia de Zelda. Vale cada euro gastado en la exploración.',10,'PLAYED',100.0,'2023-12-01'),(32,25,12,'Excelente ambientación, aunque aún tengo que darle más horas para ver el verdadero potencial del RPG y sus ramas de historia.',7,'PLAYING',20.0,'2024-06-15'),(33,27,12,'Un juego muy relajante. La dinámica del gato callejero es genial. Lo recomiendo para desconectar después de un día duro.',8,'PLAYED',7.0,'2024-07-20'),(34,25,13,'Mejoró muchísimo con los parches. Una experiencia rolera densa y profunda que recompensa la inversión de tiempo. ¡El final es épico y conmovedor!',9,'PLAYED',200.0,'2023-10-20'),(35,33,13,'El RPG más puro que he jugado. No hay combate, solo diálogos y decisiones que cambian el mundo. Obra maestra de la escritura.',10,'PLAYED',60.0,'2023-03-01'),(36,23,13,'Miembro del backlog eterno. Lo jugaré cuando termine con mi lista actual de RPGs japoneses, es una prioridad.',8,'BACKLOG',NULL,'2024-01-01'),(37,27,13,'Construyendo un nuevo mundo en Minecraft. La creatividad que ofrece este juego es ilimitada y la comunidad es fantástica y activa.',9,'PLAYING',120.0,'2023-06-01'),(38,32,13,'A medio camino, la historia es muy emotiva y el arte es brutal, pero los saltos de precisión me frustran a veces.',7,'PLAYING',10.0,'2024-05-10'),(39,24,13,'Una joya del género Western. La narrativa de Arthur Morgan es una de las mejores de la historia del videojuego, muy profunda.',10,'PLAYED',180.0,'2022-05-01'),(40,29,13,'Lo tengo en el backlog. Se ve un roguelike con mucha personalidad y un sistema de combate muy pulido. Tengo muchas ganas de empezar.',9,'BACKLOG',NULL,'2024-06-01'),(41,31,13,'Un desafío de plataformas perfecto. Lo compré para un viaje largo y me enganchó por su dificultad y recompensas.',8,'PLAYED',25.0,'2024-07-01'),(42,29,14,'Veloz y adictivo. Un roguelike con mucho corazón. De los mejores indies que he jugado, no lo puedo soltar y siempre vuelvo.',9,'PLAYED',30.0,'2022-11-01'),(43,31,14,'Un reto de plataformas que merece la pena. La historia es conmovedora y el pixel art es hermoso y nostálgico.',9,'PLAYED',35.0,'2023-07-07'),(44,32,14,'Estilo de arte único. Un metroidvania con una ambientación opresiva y un diseño de sonido magistral, un clásico moderno.',8,'PLAYED',4.0,'2022-01-01'),(45,23,14,'Lo compré en Switch, aún sin abrir. Es una prioridad cuando termine con mi lista de juegos retro, se ve muy prometedor.',8,'BACKLOG',NULL,'2024-01-01'),(46,24,14,'Lo jugué en PS4, pendiente de la versión de PC. Una obra maestra que merece ser rejugada en la mejor calidad posible.',10,'BACKLOG',NULL,'2024-02-01'),(47,26,14,'Increíble experiencia multijugador. Un grind fest que se disfruta mucho si te gusta la cacería y la progresión continua.',10,'PLAYED',120.0,'2024-03-01'),(48,28,14,'Un juego muy bien narrado. La temática vikinga es genial, y la protagonista es muy fuerte y bien desarrollada.',7,'PLAYING',8.0,'2024-04-01'),(49,30,14,'Cooperativo 10/10. Mi pareja y yo lo terminamos en dos fines de semana, muy recomendado para parejas y amigos.',10,'PLAYED',18.0,'2024-05-01'),(50,23,15,'En el backlog, esperando la rebaja. Se ve ambicioso y complejo, me emociona la exploración y la construcción de bases.',8,'BACKLOG',NULL,'2024-03-01'),(51,24,15,'Pendiente de compra. Me lo han recomendado mucho por su inmersión y la historia tan bien lograda.',9,'BACKLOG',NULL,'2024-04-01'),(52,25,15,'Lo tengo en la lista para cuando renueve mi PC. Las críticas son fantásticas tras los parches y el contenido adicional.',7,'BACKLOG',NULL,'2024-05-01'),(53,26,15,'Juego divertido, pero me resultó un poco repetitivo a la larga en sus mecánicas de cacería.',6,'PLAYED',50.0,'2023-10-01'),(54,27,15,'Aventura corta pero muy estética. El gato es adorable y el mundo es visualmente cautivador.',8,'PLAYED',6.5,'2024-01-01'),(55,29,15,'Roguelike muy adictivo. El combate es fluido y la música te atrapa. La progresión es muy satisfactoria.',9,'PLAYING',15.0,'2024-06-01'),(56,30,15,'Juego cooperativo genial para pasar el rato, muy ingenioso y con puzles desafiantes.',10,'PLAYED',15.0,'2024-07-01'),(57,33,15,'RPG denso que requiere mucha concentración. La historia es profunda y con mucho texto, pero vale la pena.',8,'PLAYING',10.0,'2024-08-01'),(58,26,16,'Muy entretenido, la cacería es satisfactoria. Lo tengo en la PS5 y funciona de maravilla, el rendimiento es estable.',6,'PLAYING',10.0,'2024-01-01'),(59,27,16,'Lo tengo en el backlog. Se ve un juego muy original y con una buena ambientación de ciencia ficción.',7,'BACKLOG',NULL,'2024-02-01'),(60,23,16,'Una experiencia increíble. El mejor juego de la década. La libertad es total y el diseño de misiones es soberbio.',9,'PLAYED',150.0,'2024-03-01'),(61,24,16,'Pendiente. He oído que la historia es deprimente, pero vale la pena por el mundo y los personajes.',8,'BACKLOG',NULL,'2024-04-01'),(62,25,16,'Comprado en oferta. Necesito darle un intento serio pronto, me emociona la ambientación cyberpunk.',7,'BACKLOG',NULL,'2024-05-01'),(63,28,16,'Una experiencia intensa, con una gran banda sonora y buen uso de la mitología nórdica. Muy bien ejecutado.',7,'PLAYING',5.0,'2024-06-01'),(64,30,16,'Excelente juego cooperativo. Me encantó la mecánica de los puzles y la forma en que obliga a la comunicación.',9,'PLAYED',10.0,'2024-07-01'),(65,32,16,'Un metroidvania genial, con arte en 2D precioso. Lo jugaré pronto, tiene pinta de ser un clásico instantáneo.',8,'BACKLOG',NULL,'2024-08-01'),(66,23,17,'Zelda: Obra maestra de la exploración. Le dediqué 200 horas sin darme cuenta. Imprescindible para Switch.',10,'PLAYED',200.0,'2023-06-01'),(67,24,17,'RDR2: Una historia madura y personajes complejos. Un logro técnico para su época y un mundo muy detallado.',10,'PLAYED',180.0,'2022-04-01'),(68,25,17,'Cyberpunk: La redención de un gran juego. La historia es atrapante y la atmósfera cyberpunk es inigualable.',9,'PLAYING',80.0,'2024-01-01'),(69,26,17,'MHW: Grind fest entretenido. Siempre hay algo nuevo que cazar y las batallas contra monstruos son épicas.',8,'PLAYED',150.0,'2021-09-01'),(70,29,17,'Hades: Roguelike con el mejor diálogo. La muerte nunca se sintió tan bien, es adictivo y divertido.',9,'PLAYED',40.0,'2023-08-01'),(71,31,17,'Celeste: Un juego de plataformas que te enseña sobre la superación. El diseño de niveles es magistral y muy pulido.',9,'PLAYED',30.0,'2023-10-01'),(72,32,17,'Hollow Knight: Arte y dificultad de alto nivel. Me encanta su mundo oscuro y misterioso. Un gran desafío.',8,'PLAYING',20.0,'2024-02-01'),(73,33,17,'Disco Elysium: RPG puramente narrativo. Brillante en su escritura y las posibilidades de rol son infinitas.',10,'PLAYED',65.0,'2024-05-01'),(74,23,18,'Zelda: Simplemente el mejor juego de Switch. La escala del mundo es abrumadora y la sensación de descubrimiento es constante.',10,'PLAYED',190.0,'2023-07-01'),(75,25,18,'Cyberpunk: Lo compré de salida y me arrepentí, pero ahora es fantástico. La historia te absorbe por completo.',9,'PLAYED',160.0,'2024-04-01'),(76,27,18,'Stray: Una aventura corta pero muy relajante. La atmósfera cyberpunk es genial y el protagonista es encantador.',8,'PLAYED',7.0,'2023-09-01'),(77,28,18,'Hellblade: Un viaje emocional e intenso. La representación de la salud mental es respetuosa y muy poderosa.',9,'PLAYED',15.0,'2023-11-01'),(78,30,18,'It Takes Two: El cooperativo más divertido que he jugado. Pura creatividad en cada nivel y mecánica.',10,'PLAYED',16.0,'2022-10-01'),(79,32,18,'Hollow Knight: Un metroidvania bellísimo. La dificultad es alta, pero el diseño de niveles lo compensa con creces.',9,'PLAYING',25.0,'2024-01-01'),(80,24,18,'RDR2: Pendiente de jugar, sé que es largo y quiero dedicarle el tiempo que merece.',9,'BACKLOG',NULL,'2024-05-01'),(81,26,18,'MHW: Lo jugué en su momento y lo volvería a hacer. Excelente combate y mucha variedad de monstruos.',8,'PLAYED',100.0,'2022-01-01');
/*!40000 ALTER TABLE `usuarios_backlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegos`
--

DROP TABLE IF EXISTS `videojuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuegos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(55) NOT NULL,
  `id_companhia` int DEFAULT NULL,
  `genero` varchar(55) DEFAULT NULL,
  `categoria` enum('INDIE','TRIPLE_A','DOBLE_A') DEFAULT NULL,
  `portada` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `titulo_UNIQUE` (`titulo`),
  KEY `fk_companhias_idx` (`id_companhia`),
  CONSTRAINT `fk_companhias` FOREIGN KEY (`id_companhia`) REFERENCES `companhias` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegos`
--

LOCK TABLES `videojuegos` WRITE;
/*!40000 ALTER TABLE `videojuegos` DISABLE KEYS */;
INSERT INTO `videojuegos` VALUES (23,'The Legend of Zelda: Tears of the Kingdom',5,'Aventura','TRIPLE_A','https://media.rawg.io/media/games/556/55684bfd048706f4266d331d70050b37.jpg'),(24,'Red Dead Redemption 2',6,'Acción / Western','TRIPLE_A','https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg'),(25,'Cyberpunk 2077',7,'RPG / Sci-Fi','TRIPLE_A','https://media.rawg.io/media/games/062/06285b425e61623530c5430f20e5d222.jpg'),(26,'Monster Hunter World',8,'RPG / Caza','TRIPLE_A','https://media.rawg.io/media/games/21c/21cc15d233117c6809ec86870559e105.jpg'),(27,'Stray',8,'Aventura','DOBLE_A','https://media.rawg.io/media/games/cd3/cd3c9c7d3e95cb1608fd6250f1b90b7a.jpg'),(28,'Hellblade: Senua\'s Sacrifice',5,'Aventura / Hack and Slash','DOBLE_A','https://media.rawg.io/media/games/63f/63f0e68688cad279ed38cde931dbfcdb.jpg'),(29,'Hades',6,'Roguelike / Acción','DOBLE_A','https://media.rawg.io/media/games/1f4/1f47a270b8f241e4676b14d39ec620f7.jpg'),(30,'It Takes Two',7,'Plataformas / Cooperativo','DOBLE_A','https://media.rawg.io/media/games/d47/d479582ed0a46496ad34f65c7099d7e5.jpg'),(31,'Celeste',5,'Plataformas','INDIE','https://media.rawg.io/media/games/594/59487800889ebac294c7c2c070d02356.jpg'),(32,'Hollow Knight',6,'Metroidvania','INDIE','https://media.rawg.io/media/games/4cf/4cfc6b7f1850590a4634b08bfab308ab.jpg'),(33,'Disco Elysium',7,'RPG / Misterio','INDIE','https://media.rawg.io/media/games/840/8408ad3811289a6a5830cae60fb0b62a.jpg');
/*!40000 ALTER TABLE `videojuegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegos_plataformas`
--

DROP TABLE IF EXISTS `videojuegos_plataformas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuegos_plataformas` (
  `id_plataforma` int NOT NULL,
  `id_videojuego` int NOT NULL,
  `precio_juego` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id_plataforma`,`id_videojuego`),
  KEY `fk_videojuegos_plataformas_idx` (`id_videojuego`),
  CONSTRAINT `fk_plataformas` FOREIGN KEY (`id_plataforma`) REFERENCES `plataformas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_videojuegos_plataformas` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegos_plataformas`
--

LOCK TABLES `videojuegos_plataformas` WRITE;
/*!40000 ALTER TABLE `videojuegos_plataformas` DISABLE KEYS */;
INSERT INTO `videojuegos_plataformas` VALUES (6,24,59.99),(6,25,59.99),(6,27,29.99),(6,28,19.99),(6,29,19.99),(6,30,39.99),(6,31,19.99),(6,32,14.99),(6,33,39.99),(7,24,49.99),(7,25,39.99),(7,26,29.99),(7,27,19.99),(7,28,14.99),(7,30,39.99),(7,33,29.99),(8,23,49.99),(8,25,39.99),(8,26,19.99),(8,28,9.99),(8,29,19.99),(9,23,69.99),(9,24,39.99),(9,29,24.99),(9,30,39.99),(9,31,19.99),(9,32,14.99),(10,23,10.99),(10,27,2.99),(10,29,4.99);
/*!40000 ALTER TABLE `videojuegos_plataformas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-10 20:58:43
