CREATE TABLE `Category` (
  `CatId` int(11) AUTO_INCREMENT NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Description` text,
  `Parent_Id` int(11) NOT NULL,
  `APP_USER_ID` int(11) NOT NULL,
  `CreatedDTM` datetime DEFAULT CURRENT_TIMESTAMP,
  `ModifiedDTM` datetime DEFAULT NULL,
  PRIMARY KEY (`CatId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `AppUser` (
  `UserId` int(11) AUTO_INCREMENT NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Email` varchar(64) NOT NULL,
  `UserSalt` varchar(45) NOT NULL,
  `CreatedDTM` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ModifiedDTM` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Password` varchar(64) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Site` (
  `SiteId` int(11) AUTO_INCREMENT NOT NULL,
  `AppUserId` int(11) NOT NULL,
  `CatId` int(11) NOT NULL,
  `Name` varchar(64) NOT NULL,
  `Login` varchar(45) DEFAULT NULL,
  `SitePwd` varchar(64) DEFAULT NULL,
  `SiteURL` varchar(256) DEFAULT NULL,
  `Notes` mediumtext,
  `CeatedDTM` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ModifiedDTM` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`SiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

