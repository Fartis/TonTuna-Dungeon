-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: tontunadungeon
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arma`
--

DROP TABLE IF EXISTS `arma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arma` (
  `nombre` varchar(20) NOT NULL,
  `atributo` enum('fuerza','destreza','intelecto') NOT NULL,
  `bonificador` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  `nivel` int(11) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arma`
--

LOCK TABLES `arma` WRITE;
/*!40000 ALTER TABLE `arma` DISABLE KEYS */;
INSERT INTO `arma` VALUES ('Baston','intelecto',6,'Atiza en la cabeza mientras estudias.',8),('Boomerang','destreza',3,'Golpea y vuelve.',5),('Cazo','intelecto',4,'Cuando no sacas del puchero, matas enemigos.',6),('Chancla','destreza',2,'Una chancla para arrojarla contra los enemigos.',4),('Chivata','intelecto',2,'Bastón que usan los viejos para espantar gamberros.',3),('Corchopan','fuerza',1,'Cilindro de material esponjoso que no vale para nada.',2),('Cuchara','intelecto',2,'Una cuchara para apuntas hechizos o para comer sopa.',4),('Cuchillo jamonero','fuerza',4,'Para cortar jamón y enemigos.',6),('Cuchillo para untar','fuerza',3,'Un cuchillo que no pincha pero corta, aunque no mucho',5),('Daga','destreza',5,'Meter cuchillo, sacar tripas.',7),('Espada larga','fuerza',6,'Corta bien cualquier cosa mientras la mantengas afilada',8),('Espadita cortita','fuerza',5,'Arma clásica para pinchar y cortar.',7),('Estaca','fuerza',2,'Hecha con madera de membrillo que, aunque dobla, hinca.',3),('Estoque ES','destreza',6,'No es arrojadizo pero te puedes mover y pinchar rapido.',9),('Frisbi','destreza',1,'Disco de plástico que vuela pero tampoco mucho...',2),('Garrote','intelecto',5,'Golpea en el lomo y lanza hechizos.',7),('Guante','fuerza',1,'Un guante que protege tu mano cuando guanteas enemigos.',1),('Hacha','fuerza',6,'Parte cosas, los enemigos son cosas también.',9),('Honda','destreza',5,'Arma para arrojar plomos con motor V y 150cv.',7),('Juego de cuchillos','destreza',4,'Colección de distintos tamaños para usar en la cocina, perfectos para lanzar.',6),('Machete','fuerza',5,'Así le llamaban',7),('MT 10','destreza',8,'Esta máquina técnica permite aprender el movimiento Poder Oculto.',10),('Paleta de cocina','intelecto',3,'Puedes voltear la comida o lanzar hechizos.',5),('Palillo chino','intelecto',1,'Un palillo de la comida china que usas cómo varita mágica',1),('Pedrolos','destreza',4,'Contundentes y azumban.',6),('Pelotaca de fuego','intelecto',8,'Hechizo aprendid del libro del narrador de D&D.',10),('Piedra con filo','destreza',2,'No están equilibradas, pero clavan.',3),('Puñao de piedras','destreza',1,'Sirven para mantener el enemigo a distancia.',1),('Puño de kaio','fuerza',8,'Es la tecnica del Dios Kaio, te pone colorao.',10),('Rascaculos','intelecto',3,'Vara de cortalongtud que se usa para rascar dónde no te llegas.',5),('Rotulador','intelecto',1,'Puedes anotar cosas con él, pero también usarlo cómo varita.',2),('Shuriken','destreza',6,'Estrella ninja para entendernos.',8),('Tarama de olivo','fuerza',2,'Rama sobrante de la poda, escuece en el lomo',4),('Tenedor','fuerza',3,'Tenedor para carnes, pincha bien en cualquier otra cosa.',5),('Tenedos','destreza',3,'Cubierto para pinchar con 2 puntas, es de tipo 2, es tene2',5),('Tijeras','fuerza',4,'Éstas pinchan y cortan.',6),('Vara de membrillo','intelecto',4,'Dobla e hinca en las costillas magicamente.',6),('Vara de olivo','intelecto',5,'Una vara que varea.',7),('Varita de encina','intelecto',6,'Muy resistente y centenaria para lanzar magia.',9);
/*!40000 ALTER TABLE `arma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `armadura`
--

DROP TABLE IF EXISTS `armadura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `armadura` (
  `nombre` varchar(20) NOT NULL,
  `bonificador` int(10) unsigned NOT NULL,
  `indice` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  `nivel` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armadura`
--

LOCK TABLES `armadura` WRITE;
/*!40000 ALTER TABLE `armadura` DISABLE KEYS */;
INSERT INTO `armadura` VALUES ('Armadura Acolchada',1,5,'Armadura de tela acolchada, fácil de romper pero algo quita',1),('Armadura completa',5,20,'Coraza que cubre todo el cuerpo fabricada con hierro',5),('Armadura de cartón',1,3,'Con ella se mueve uno acartonao pero menos da una piedra',1),('Armadura RoscaChapa',4,10,'Hecha de placas de chapa que truenan al ser golpeada pero te protegerá',4),('Cota de escamas',5,15,'Fabricada en escamas metálicas que protegen a la vez que brillan',5),('Cota de malla',4,12,'Igual que un jersey tricotado pero de anillas de hierro',4),('Cuero',2,6,'Armadura de cuero, cómo una segunda piel',2),('Cuero endurecido',2,8,'Armadura de cuero endurecido que resiste más',2),('Cuero Tachonado',3,9,'Armadura de cuero con tachuelas que aguantan algunos golpes',3),('Túnica mágica',3,7,'Túnica con un hechizo que resiste los golpes, aunque la tendrás que reparar igualmente',3);
/*!40000 ALTER TABLE `armadura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desbloqueado`
--

DROP TABLE IF EXISTS `desbloqueado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `desbloqueado` (
  `raza` varchar(20) NOT NULL,
  `logro` varchar(20) NOT NULL,
  `desbloqueado` tinyint(1) NOT NULL DEFAULT '0',
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `raza` (`raza`),
  UNIQUE KEY `logro` (`logro`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desbloqueado`
--

LOCK TABLES `desbloqueado` WRITE;
/*!40000 ALTER TABLE `desbloqueado` DISABLE KEYS */;
/*!40000 ALTER TABLE `desbloqueado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eliminado`
--

DROP TABLE IF EXISTS `eliminado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eliminado` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreMON` varchar(20) NOT NULL,
  `cantidad` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`nombrePJ`,`nombreMON`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eliminado`
--

LOCK TABLES `eliminado` WRITE;
/*!40000 ALTER TABLE `eliminado` DISABLE KEYS */;
/*!40000 ALTER TABLE `eliminado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventarioar`
--

DROP TABLE IF EXISTS `inventarioar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventarioar` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `razaPJ` varchar(20) NOT NULL,
  `nombrePJ` varchar(20) NOT NULL,
  `arma` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`,`razaPJ`,`nombrePJ`),
  UNIQUE KEY `ID` (`ID`),
  KEY `razaPJ` (`razaPJ`),
  KEY `nombrePJ` (`nombrePJ`),
  CONSTRAINT `inventarioar_ibfk_1` FOREIGN KEY (`razaPJ`) REFERENCES `pjcreado` (`raza`),
  CONSTRAINT `inventarioar_ibfk_2` FOREIGN KEY (`nombrePJ`) REFERENCES `pjcreado` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventarioar`
--

LOCK TABLES `inventarioar` WRITE;
/*!40000 ALTER TABLE `inventarioar` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventarioar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventarioardu`
--

DROP TABLE IF EXISTS `inventarioardu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventarioardu` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `razaPJ` varchar(20) NOT NULL,
  `nombrePJ` varchar(20) NOT NULL,
  `armadura` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`,`razaPJ`,`nombrePJ`),
  UNIQUE KEY `ID` (`ID`),
  KEY `razaPJ` (`razaPJ`),
  KEY `nombrePJ` (`nombrePJ`),
  CONSTRAINT `inventarioardu_ibfk_1` FOREIGN KEY (`razaPJ`) REFERENCES `pjcreado` (`raza`),
  CONSTRAINT `inventarioardu_ibfk_2` FOREIGN KEY (`nombrePJ`) REFERENCES `pjcreado` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventarioardu`
--

LOCK TABLES `inventarioardu` WRITE;
/*!40000 ALTER TABLE `inventarioardu` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventarioardu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventarioob`
--

DROP TABLE IF EXISTS `inventarioob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventarioob` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `razaPJ` varchar(20) NOT NULL,
  `nombrePJ` varchar(20) NOT NULL,
  `objeto` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`,`razaPJ`,`nombrePJ`),
  UNIQUE KEY `ID` (`ID`),
  KEY `razaPJ` (`razaPJ`),
  KEY `nombrePJ` (`nombrePJ`),
  CONSTRAINT `inventarioob_ibfk_1` FOREIGN KEY (`razaPJ`) REFERENCES `pjcreado` (`raza`) on delete cascade,
  CONSTRAINT `inventarioob_ibfk_2` FOREIGN KEY (`nombrePJ`) REFERENCES `pjcreado` (`nombre`) on delete cascade
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventarioob`
--

LOCK TABLES `inventarioob` WRITE;
/*!40000 ALTER TABLE `inventarioob` DISABLE KEYS */;
INSERT INTO `inventarioob` VALUES (6,'Humano','Manuel','Hámster entrenado'),(7,'Humano','Manuel','Coctail Molotov'),(8,'Humano','Manuel','Poción curación'),(11,'Humano','asdfeffefe','Hámster entrenado'),(12,'Humano','Jose','Cuesco embotellado'),(13,'Humano','Piruletamantico','Poción curación');
/*!40000 ALTER TABLE `inventarioob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logro`
--

DROP TABLE IF EXISTS `logro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logro` (
  `nombre` varchar(50) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logro`
--

LOCK TABLES `logro` WRITE;
/*!40000 ALTER TABLE `logro` DISABLE KEYS */;
/*!40000 ALTER TABLE `logro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monstruo`
--

DROP TABLE IF EXISTS `monstruo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monstruo` (
  `nombre` varchar(20) NOT NULL,
  `nivel` int(10) unsigned NOT NULL,
  `fuerza` int(10) unsigned NOT NULL,
  `destreza` int(10) unsigned NOT NULL,
  `intelecto` int(10) unsigned NOT NULL,
  `constitucion` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monstruo`
--

LOCK TABLES `monstruo` WRITE;
/*!40000 ALTER TABLE `monstruo` DISABLE KEYS */;
INSERT INTO `monstruo` VALUES ('Amazonas',4,3,1,1,5,'No se depilan, eso en Grecia no se lleva. Matan por kiki.'),('Anti-Captcha',9,2,2,2,10,'\'Completely Automated Public Turing Test\', es un test controlado por una máquina, en logar de por un humano como en la prueba de Turing. Y ESTA ARMADO'),('Araña',1,2,1,2,1,'¡CUIDADO ARAÑA! siempre con esas patitas peluditas y esos ojos brillantes. Dan \'esgrima\' literalmente, tiene un estoque.'),('Arpia',2,3,1,1,2,'Esta tia es muy chunga, es prima de la Jeny y la Vane.'),('Babosa Gigante',2,3,1,2,1,'Es pegajosa, huele mal, anda lento, no es fuerte, es un enemigo facil de vencer.'),('Biciclope',5,3,3,3,2,'Es una persona normal, tiene dos ojos.'),('Brocoli',5,4,2,2,3,'Super Saiyan Legendario, rico en proteinas vegetales.'),('Cani',8,4,4,1,6,'Vive en el parque de los patos, en vez de tirarte piedras se la fuma.'),('Crocopulpo',3,1,3,1,3,'Es un crocodilo con tentaculos, es una estrella del Hentai, tiene muchas extremidades.'),('Cruzcampo',5,3,3,3,2,'Meado de burra, tiene que estar muy fria y a punto de hielo, da mucho dolor de cabeza y una resaca mortal.'),('Dado Maldito',7,1,1,1,11,'Este dado siempre hara que tengas tiradas malas y te comas una pifia, nunca juegues con el al MERP.'),('Dragon salchichonio',10,1,2,7,7,'No perseguirá a personajes de Nivel 5 o inferior. Mal rollo: te tuesta, te almuerza y te mata. Estas muerto.'),('Du Hamster',4,1,1,1,7,'Este hamster es fanatico de Ramstein, siempre canta Du Hast.'),('El A\'rock\'allipsis',10,7,2,1,7,'I\'m the lord of the wastelands, a modern day man of steel, I gather darkness to please me and I command you to kneel. Kiss - God of thunder'),('El Bastardo',8,3,2,6,3,'Es hijo de un señorito español, actualmente trabaja en Genova y ocupa un cargo no electo en el gobierno.'),('El señor obstuso',9,4,4,4,4,'El señor obstuso y del leru partido, que quiere la otra mitad para invitar a la peña de gratis y no pagar.'),('Elemental de cuesco',7,3,3,4,2,'Es un elemental gaseoso que lo produjo un mago despues de comer mucha comida mexicana.'),('Elemental de Pelos',6,2,3,4,3,'Magopelos lo creo, el pudo darle vida, practicamente por que es uno de los desarrolladores.'),('Enemigo pixelado',10,4,4,4,5,'Es una criatura de la antigüedad, antes de la alta definición. Su poder no se puede calcular o tardarias mucho, ya que fue diseñado en 8bits.'),('Enredadera',1,1,2,1,2,'Es una planta que ha crecido sin control, tapara puertas y de vez en cuando sera un incordio.'),('Esfinge',3,1,1,1,5,'Gato sin pelo, da mucho repelus.'),('Fampiro',9,6,2,2,6,'Secuaz de Alejo I, el dictador que prohibio todas las expreciones de ocio y gobierna la mayor parte de Europa con una mezcla de dictadura y buenrollismo.'),('Gallo Colosal',9,3,3,3,7,'Un autentico gallo de 57kg, huyo de la casa de un americano un dia de acción de gracias y prometio vengarse del mundo.'),('Golem de masa de pan',3,2,2,2,2,'Su cabeza es un pan de cantos recien hecho. Esta muy rico.'),('Hipopogrifo',4,4,2,2,2,'Es un hipopotamo muy gordo con dos pequeñas alitas en la espalda, creo que utiliza celo para pegarselas.'),('Horse Luis',10,1,1,1,14,'Horse Luis es un fenomeno viral en twitter, nacio el 20 de Septiembre del 2014 y ha sido invitado a este juego. Su madre se lo ha permitido.'),('JavaException',3,1,1,4,2,'public class IllegalArgumentException extends RuntimeException. Thrown to indicate that a method has been passed an illegal or inappropriate argument. Since: JDK1.0'),('Javier Ramos',7,4,4,4,2,'Tiene su PC en la mazmorra y como nunca sale de ella estara jugando a algun juego, siempre tiene tabaco.'),('Jubilados',6,4,4,3,1,'El inserso cada vez se lo lleva a sitios mas extraños, estan de turismo por la mazmorra y te dejaran seco a base de pellizcos en los mofletes.'),('Lobo terrible',2,2,2,2,1,'Aulla muy mal, el pelo lo tiene descuidado y necesita gafas, su estilo es terrible.'),('MagoPelos',3,6,7,10,5,'Uno de los creadores del juego'),('Mari-Conan',6,4,2,2,4,'Conan salio del armario y hay que apoyarle, paso de ser un simbolo de la virilidad para ser un icono de la lucha de los derechos homosexuales.'),('Medusa',8,1,1,1,12,'Es una criatura mitologica, dicen que mirarle a los ojos te petrifica, suerte que tiene buen cuerpo y no te fijas en esas cosas.'),('Muerto Viviente',2,1,1,1,4,'Le encantan los huesitos y los tigretones.'),('Murciegalos',1,2,1,1,2,'Son murciegalos, no murcielagos. Son descendientes de murcianos y franceses.'),('Ninja con pandereta',9,5,5,3,3,'Podria haberte emboscado, pero oistes una pandereta y estabas en guardia, aun así sabe artes marciales.'),('Orco',2,2,1,1,3,'Es un orco generico, no le busques mas sentido.'),('Osolechuga',1,3,1,1,1,'Es una verdadera mutación simbiotica de una lechuga y un oso, fue un poquemon descartado por ser muy cutre, aun así es peligr\'oso\'.'),('Payasos',1,1,2,2,1,'Creeras que son divertidos, pero estudiaron un libro de chistes de Lepe, cuando cuentan chistes lo que te provoca es dolor agudo, como su humor.'),('Pichaku',5,1,4,4,2,'Es un pomekon de tipo electrico, tiene una bateria de 800mah, te deja tirado en cualquier momento, sobre todo cuando se acaba el botellon.'),('Rafalillo',10,1,6,7,3,'Siempre esta atento a todo movimiento, su humor tambien. Es un mago muy poderoso que se convirtio en elemental de llamas infernales, su enorme rabo en llamas es poderoso.'),('Reloj Despertador',6,1,1,1,9,'BEEP! BEEP! BEEP! BEEP! BEEP! BEEP! BEEP! BEEP! BEEP! BEEP!'),('Salamanquesa',7,2,2,2,8,'Es la reina de las fiestas de un pequeño pueblo de Salamanca.'),('Surfista catolico',7,3,3,3,5,'Surfear una ola es tan gratificante para él como ir a misa el domingo.'),('Suspenso por un 4,5',8,4,4,4,3,'Esta desagradable situación es derivada de una tarde en la que tenias que haber estudiado, pero preferistes ver una pelicula.'),('Testigo de Jehova',8,3,3,3,6,'¿Hola, ha oido hablar de nuestro señor Yave?. Siempre tiene panfletos adoctrinantes.'),('Tortuga Ninja',3,4,1,1,2,'Son los primos gitanos de las verdaderas Tortugas Ninja, utiliza salchichones como nunchakus.'),('Troll',6,3,3,3,3,'Experto en foros, sabe utilizar el paint para hacerse sus memes y acosa a las tias que se encuentra en el lol.'),('Velociraptor',4,3,3,2,2,'Este dinosaurio es adicto a la velocidad, tiene un flamante BMW 320d.'),('Vendedor de seguros',5,2,1,4,4,'No dejara de darte la brasa hasta que te venda un seguro de muerte con cremacion incluida.'),('Zergling',4,2,2,2,4,'Solo cuesta cristales y salen dos por larva, para hacer un rush van muy bien.');
/*!40000 ALTER TABLE `monstruo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto`
--

DROP TABLE IF EXISTS `objeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objeto` (
  `nombre` varchar(20) NOT NULL,
  `bonificador` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  `tipo` enum('curacion','apoyo','dano') NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto`
--

LOCK TABLES `objeto` WRITE;
/*!40000 ALTER TABLE `objeto` DISABLE KEYS */;
INSERT INTO `objeto` VALUES ('Coctail Molotov',8,'Prendes y lanzas, el enemigo arde. No tiene más complicación. Abajo el opresor','dano'),('Cuesco embotellado',2,'Si lanzas el frasco se romperá liberando su nauseabundo contenido','dano'),('Hámster entrenado',4,'Hámster entrenado que lanzas contra el enemigo, le muerde y huye','dano'),('Poción al tope',3,'Aumenta todas tus características durante el resto del combate','apoyo'),('Poción alta',10,'Te cura al tope the power','curacion'),('Poción curación',5,'Si la tomas cierra la mayoría de tus heridas','curacion'),('Poción Destreza',5,'Aumenta tu destreza durante el resto del combate','apoyo'),('Poción Fuerza',5,'Aumenta tu fuerza durante el resto del combate','apoyo'),('Poción Intelecto',5,'Aumenta tu intelecto durante el resto del combate','apoyo'),('Poción leve',3,'Cura poco, pero cura','curacion'),('Poción mayor',8,'Cura mucha tela','curacion'),('Vara verde',18,'Vara de fresno aún flexible que pica tela, golpea al enemigo ignorando su armadura porque simbra y suelta el latigazo','dano');
/*!40000 ALTER TABLE `objeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personaje` (
  `raza` varchar(20) NOT NULL,
  `fuerza` int(10) unsigned NOT NULL,
  `destreza` int(10) unsigned NOT NULL,
  `intelecto` int(10) unsigned NOT NULL,
  `constitucion` int(10) unsigned NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`raza`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES ('Elfo',1,2,3,1,'Los elfos son seres místicos, sensibles a las fuerzas de la naturaleza aunque su constitución no es tan fuerte como su voluntad, sus peregrinaciones hacen que sus conocimientos de las fuerzas de la naturaleza y mágicas tengan un fuerte vínculo con su alma haciendo que sean poderosos magos.'),('Enano',3,1,1,3,'Forjados en las minas más profundas de la tierra, de gran resistencia física y una fuerza capaz de doblegar el metal más duro, instruidos en el arte de la forja saben manejar gran cantidad de armas pero su poder mágico es inexistente, en su linaje ha habido grandes guerreros y poderosos héroes.'),('Humano',2,2,2,2,'Los humanos son personajes versátiles y resistentes físicamente, se dedican a todo pero necesitan de un entrenamiento exhaustivo para convertirse en verdaderos maestros de su profesión. Son sensibles al poder mágico y utilizan todo tipo de armas.'),('Mediano',1,4,1,2,'Agiles y rápidos, como los ladrones medianos no hay comparación, su estatura y su agilidad lo hacen grandes maestros del hurto y son hábiles con armas a distancia, debido a su pequeño tamaño no son fuertes pero son un peligro si no estás atento a tus espaldas aunque sus habilidades mágicas no son gran cosa.');
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pjcreado`
--

DROP TABLE IF EXISTS `pjcreado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pjcreado` (
  `nombre` varchar(20) NOT NULL,
  `raza` varchar(20) NOT NULL,
  `nivel` int(10) unsigned NOT NULL,
  `fcreacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fuerza` int(10) unsigned NOT NULL,
  `destreza` int(10) unsigned NOT NULL,
  `intelecto` int(10) unsigned NOT NULL,
  `constitucion` int(10) unsigned NOT NULL,
  `nombreAR` varchar(20) DEFAULT NULL,
  `nombreARDU` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nombre`,`raza`),
  KEY `pjcreado_ibfk_1` (`raza`),
  CONSTRAINT `pjcreado_ibfk_1` FOREIGN KEY (`raza`) REFERENCES `personaje` (`raza`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pjcreado`
--

LOCK TABLES `pjcreado` WRITE;
/*!40000 ALTER TABLE `pjcreado` DISABLE KEYS */;
INSERT INTO `pjcreado` VALUES ('asdfeffefe','Humano',0,'2017-05-09 10:38:32',2,2,2,8,'Guante','Armadura de cartón'),('ASF','Humano',0,'2017-05-09 10:34:27',2,2,2,8,'Puñao de piedras','Armadura Acolchada'),('hhhth','Humano',0,'2017-05-09 10:34:53',2,2,2,8,'Guante','Armadura de cartón'),('Jose','Humano',0,'2017-05-09 12:41:00',2,2,2,8,'Guante','Armadura Acolchada'),('Manuel','Humano',0,'2017-05-09 11:03:39',3,4,2,5,'Guante','Armadura Acolchada'),('Piruletamantico','Humano',0,'2017-05-10 08:05:14',2,8,2,2,'Puñao de piedras','Armadura de cartón'),('Tonto','Humano',0,'2017-05-10 08:36:44',2,2,2,8,'Palillo chino','Armadura de cartón');
/*!40000 ALTER TABLE `pjcreado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiene`
--

DROP TABLE IF EXISTS `tiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiene` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreOB` varchar(20) NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nombrePJ`,`nombreOB`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiene`
--

LOCK TABLES `tiene` WRITE;
/*!40000 ALTER TABLE `tiene` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utiliza`
--

DROP TABLE IF EXISTS `utiliza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utiliza` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreARMA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombrePJ`,`nombreARMA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utiliza`
--

LOCK TABLES `utiliza` WRITE;
/*!40000 ALTER TABLE `utiliza` DISABLE KEYS */;
/*!40000 ALTER TABLE `utiliza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilizamon`
--

DROP TABLE IF EXISTS `utilizamon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilizamon` (
  `nombreMON` varchar(20) NOT NULL,
  `nombreARMA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombreMON`,`nombreARMA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizamon`
--

LOCK TABLES `utilizamon` WRITE;
/*!40000 ALTER TABLE `utilizamon` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilizamon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viste`
--

DROP TABLE IF EXISTS `viste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viste` (
  `nombrePJ` varchar(20) NOT NULL,
  `nombreARMADURA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombrePJ`,`nombreARMADURA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viste`
--

LOCK TABLES `viste` WRITE;
/*!40000 ALTER TABLE `viste` DISABLE KEYS */;
/*!40000 ALTER TABLE `viste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vistemon`
--

DROP TABLE IF EXISTS `vistemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vistemon` (
  `nombreMON` varchar(20) NOT NULL,
  `nombreARMADURA` varchar(20) NOT NULL,
  PRIMARY KEY (`nombreMON`,`nombreARMADURA`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vistemon`
--

LOCK TABLES `vistemon` WRITE;
/*!40000 ALTER TABLE `vistemon` DISABLE KEYS */;
/*!40000 ALTER TABLE `vistemon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-10 12:04:18
