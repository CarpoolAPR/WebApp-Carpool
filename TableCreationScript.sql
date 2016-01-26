CREATE DATABASE `carpool`;

CREATE TABLE `carpooler` (
  `carpoolId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `contactNumber` varchar(45) NOT NULL,
  `vehicleNumber` varchar(45) NOT NULL,
  `noOfSeatsAvailable` int(11) NOT NULL,
  `source` varchar(45) NOT NULL,
  `destination` varchar(45) NOT NULL,
  PRIMARY KEY (`carpoolId`)
);