/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE TABLE `cities` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `failure_ride` (
  `id` int(11) DEFAULT NULL,
  `ride_id` int(11) NOT NULL,
  `failure_id` int(11) NOT NULL,
  KEY `ride_id` (`ride_id`),
  CONSTRAINT `failure_ride_ibfk_1` FOREIGN KEY (`ride_id`) REFERENCES `rides` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `failures` (
  `id` int(11) NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `passenger_ride` (
  `id` int(11) DEFAULT NULL,
  `ride_id` int(11) DEFAULT NULL,
  `passenger_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `passengers` (
  `id` int(11) DEFAULT NULL,
  `passenger` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rides` (
  `id` int(11) NOT NULL,
  `departure_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `departure_city_id` int(11) NOT NULL,
  `destination_city_id` int(11) NOT NULL,
  `train_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `train_id` (`train_id`),
  CONSTRAINT `rides_ibfk_1` FOREIGN KEY (`train_id`) REFERENCES `trains` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `trains` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 DEFAULT 'NULL',
  `max_speed` float DEFAULT NULL,
  `max_capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `cities` (`id`, `name`) VALUES
(1, 'Brussel-Zuid');
INSERT INTO `cities` (`id`, `name`) VALUES
(2, 'Halle');
INSERT INTO `cities` (`id`, `name`) VALUES
(3, 'Elsene');





INSERT INTO `passenger_ride` (`id`, `ride_id`, `passenger_id`) VALUES
(1, 1, 1);
INSERT INTO `passenger_ride` (`id`, `ride_id`, `passenger_id`) VALUES
(2, 2, 1);
INSERT INTO `passenger_ride` (`id`, `ride_id`, `passenger_id`) VALUES
(3, 3, 2);

INSERT INTO `passengers` (`id`, `passenger`) VALUES
(1, 'Axel');
INSERT INTO `passengers` (`id`, `passenger`) VALUES
(2, 'Ilyes');


INSERT INTO `rides` (`id`, `departure_time`, `departure_city_id`, `destination_city_id`, `train_id`) VALUES
(1, '2021-10-28 14:06:50', 1, 2, 1);


INSERT INTO `trains` (`id`, `type`, `max_speed`, `max_capacity`) VALUES
(1, 'Desiro', 50, 300);
INSERT INTO `trains` (`id`, `type`, `max_speed`, `max_capacity`) VALUES
(2, 'Desiro 2', 60, 250);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;