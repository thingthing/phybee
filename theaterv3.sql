-- MySQL Script generated by MySQL Workbench
-- Sat May  9 21:47:18 2015
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema theater
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `theater` ;

-- -----------------------------------------------------
-- Schema theater
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `theater` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `theater` ;

-- -----------------------------------------------------
-- Table `theater`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`producer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`producer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`movie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_producer` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `synopsis` VARCHAR(250) NULL DEFAULT 'Synopsis not available.',
  `time` TIME(0) NOT NULL,
  `poster` VARCHAR(45) NOT NULL,
  `release` DATE NOT NULL,
  `end_release` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_producer_idx` (`id_producer` ASC),
  CONSTRAINT `id_producer`
    FOREIGN KEY (`id_producer`)
    REFERENCES `theater`.`producer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `seat` INT NOT NULL,
  `priority_seat` INT NOT NULL,
  `3d` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_movie` INT NOT NULL,
  `id_room` INT NOT NULL,
  `date` DATE NOT NULL,
  `start` TIME(0) NOT NULL,
  `end` TIME(0) NOT NULL,
  `seat_remain` INT NOT NULL,
  `priority_seat_remain` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_room_idx` (`id_room` ASC),
  INDEX `id_movie_idx` (`id_movie` ASC),
  CONSTRAINT `id_room`
    FOREIGN KEY (`id_room`)
    REFERENCES `theater`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_movie`
    FOREIGN KEY (`id_movie`)
    REFERENCES `theater`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_schedule` INT NOT NULL,
  `adult` INT NULL,
  `child` INT NULL,
  `disabled` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_idx` (`id_user` ASC),
  INDEX `id_schedule_idx` (`id_schedule` ASC),
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `theater`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_schedule`
    FOREIGN KEY (`id_schedule`)
    REFERENCES `theater`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`genre` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`movieGenre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`movieGenre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_moviex` INT NOT NULL,
  `id_genres` INT NOT NULL,
  INDEX `id_movie_idx` (`id_moviex` ASC),
  INDEX `id_genre_idx` (`id_genres` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `id_moviex`
    FOREIGN KEY (`id_moviex`)
    REFERENCES `theater`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_genres`
    FOREIGN KEY (`id_genres`)
    REFERENCES `theater`.`genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Sample Data
-- -----------------------------------------------------
INSERT INTO `theater`.`account` (`id`, `firstname`, `lastname`, `email`, `password`) VALUES ('1', 'Esteban', 'Roux', 'esteban.roux@aol.fr', 'phybee');
INSERT INTO `theater`.`account` (`id`, `firstname`, `lastname`, `email`, `password`) VALUES ('2', 'Stepa', 'Nenkho', 'stepanenkho@gmail.com', 'nhk');
INSERT INTO `theater`.`account` (`id`, `firstname`, `lastname`, `email`, `password`) VALUES ('3', 'Charles', 'Francois', 'dark.sasuke@caramail.com', 'luv');

INSERT INTO `theater`.`room` (`id`, `name`, `seat`, `priority_seat`, `3d`) VALUES ('1', 'FF', '200', '25', '0');
INSERT INTO `theater`.`room` (`id`, `name`, `seat`, `priority_seat`, `3d`) VALUES ('2', 'Artotszka', '5', '0', '0');
INSERT INTO `theater`.`room` (`id`, `name`, `seat`, `priority_seat`, `3d`) VALUES ('3', 'Mirai', '230', '20', '1');
INSERT INTO `theater`.`room` (`id`, `name`, `seat`, `priority_seat`, `3d`) VALUES ('4', 'Phybee Master', '300', '10', '1');

INSERT INTO `theater`.`genre` (`id`, `name`) VALUES ('1', 'Animation'), ('2', 'Action'), ('3', 'Adventure');
INSERT INTO `theater`.`genre` (`id`, `name`) VALUES ('4', 'Action'), ('5', 'Sci-Fi'), ('6', 'Horror'), ('7', 'Thriller'), ('8', 'Crime');
INSERT INTO `theater`.`producer` (`id`, `name`) VALUES ('1', 'Chris Williams');
INSERT INTO `theater`.`producer` (`id`, `name`) VALUES ('2', 'Joss Whedon');
INSERT INTO `theater`.`producer` (`id`, `name`) VALUES ('3', 'Leigh Whannell'), ('4', 'Colin Trevorrow'), ('5', 'James Wan');
INSERT INTO `theater`.`movie` (`id`, `id_producer`, `title`, `synopsis`, `time`, `poster`, `release`, `end_release`) VALUES ('1', '1', 'Big Hero 6', 'The special bond that develops between plus-sized inflatable robot Baymax, and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.', '01:42:00', 'hero6.jpg', '2015-02-11', '2016-02-11');
INSERT INTO `theater`.`movie` (`id`, `id_producer`, `title`, `synopsis`, `time`, `poster`, `release`, `end_release`) VALUES ('2', '2', 'Avengers: Age of Ultron', 'When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it\'s up to Earth\'s Mightiest Heroes to stop the villainous Ultron from enacting his terrible plans.', '02:21:00', 'avg.jpg', '2015-04-22', '2016-04-22');
INSERT INTO `theater`.`movie` (`id`, `id_producer`, `title`, `synopsis`, `time`, `poster`, `release`, `end_release`) VALUES ('3', '3', 'Insidious: Chapter 3', 'A prequel set before the haunting of the Lambert family that reveals how gifted psychic Elise Rainier reluctantly agrees to use her ability to contact the dead in order to help a teenage girl who has been targeted by a dangerous supernatural entity.', '01:37:00', 'insidious.jpg', '2015-07-08', '2015-09-08');
INSERT INTO `theater`.`movie` (`id`, `id_producer`, `title`, `synopsis`, `time`, `poster`, `release`, `end_release`) VALUES ('4', '4', 'Jurassic World', 'Twenty-two years after the events of Jurassic Park (1993), Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond. After 10 years of operation and visitor rates declining, in order to fulfill a corporate mandate, a new attraction is created to re-spark visitors interest, which backfires horribly.', '02:10:00', 'jurassic.jpg', '2015-06-10', '2015-08-10');
INSERT INTO `theater`.`movie` (`id`, `id_producer`, `title`, `synopsis`, `time`, `poster`, `release`, `end_release`) VALUES ('5', '5', 'Furious 7', 'Deckard Shaw seeks revenge against Dominic Toretto and his family for his comatose brother.', '02:17:00', 'furious7.jpg', '2015-04-01', '2015-06-30');
INSERT INTO `theater`.`movieGenre` (`id_moviex`, `id_genres`) VALUES ('1', '1'), ('1', '2'), ('1','3');
INSERT INTO `theater`.`movieGenre` (`id_moviex`, `id_genres`) VALUES ('2', '4'), ('2', '3'), ('2', '5');
INSERT INTO `theater`.`movieGenre` (`id_moviex`, `id_genres`) VALUES ('3', '6');
INSERT INTO `theater`.`movieGenre` (`id_moviex`, `id_genres`) VALUES ('4', '2'), ('4', '3'), ('4', '5');
INSERT INTO `theater`.`movieGenre` (`id_moviex`, `id_genres`) VALUES ('5', '2'), ('5', '7'), ('5', '8');

INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('1', '1', '4', '2015-06-01', '14:30:00', '16:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('2', '1', '4', '2015-06-01', '17:00:00', '19:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('3', '1', '4', '2015-06-01', '19:30:00', '21:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('4', '1', '4', '2015-06-01', '22:00:00', '00:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('5', '2', '4', '2015-06-02', '14:30:00', '16:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('6', '2', '4', '2015-06-02', '17:00:00', '19:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('7', '2', '4', '2015-06-02', '19:30:00', '21:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('8', '2', '4', '2015-06-02', '22:00:00', '00:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('9', '3', '3', '2015-07-08', '14:30:00', '16:30:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('10', '3', '3', '2015-07-08', '17:00:00', '19:00:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('11', '3', '3', '2015-07-08', '19:30:00', '21:30:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('12', '3', '3', '2015-07-08', '22:00:00', '00:00:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('13', '4', '3', '2015-06-10', '14:30:00', '16:30:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('14', '4', '3', '2015-06-10', '17:00:00', '19:00:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('15', '4', '3', '2015-06-10', '19:30:00', '21:30:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('16', '4', '3', '2015-06-10', '22:00:00', '00:00:00', '230', '20');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('17', '5', '4', '2015-05-28', '14:30:00', '16:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('18', '5', '4', '2015-05-28', '17:00:00', '19:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('19', '5', '4', '2015-05-28', '19:30:00', '21:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('20', '5', '4', '2015-05-28', '22:00:00', '00:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('21', '5', '4', '2015-05-29', '14:30:00', '16:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('22', '5', '4', '2015-05-29', '17:00:00', '19:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('23', '5', '4', '2015-05-29', '19:30:00', '21:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('24', '5', '4', '2015-05-29', '22:00:00', '00:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('25', '5', '4', '2015-05-30', '14:30:00', '16:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('26', '5', '4', '2015-05-30', '17:00:00', '19:00:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('27', '5', '4', '2015-05-30', '19:30:00', '21:30:00', '300', '10');
INSERT INTO `theater`.`schedule` (`id`, `id_movie`, `id_room`, `date`, `start`, `end`, `seat_remain`, `priority_seat_remain`) VALUES ('28', '5', '4', '2015-05-30', '22:00:00', '00:00:00', '300', '10');
INSERT INTO `theater`.`ticket` (`id`, `type`, `price`) VALUES ('1', 'Adult', '7.80'), ('2', 'Child', '4.99'), ('3', 'Disabled', '5.50');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
