-- MySQL Script generated by MySQL Workbench
-- Thu Apr 30 20:03:21 2015
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
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theater`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theater`.`movie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_producer` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `synopsis` VARCHAR(250) NOT NULL DEFAULT 'Synopsis not available.',
  `genre` VARCHAR(45) NOT NULL,
  `time` TIME(0) NOT NULL,
  `poster` VARCHAR(45) NOT NULL,
  `release` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_producer_idx` (`id_producer` ASC),
  CONSTRAINT `id_producer`
    FOREIGN KEY (`id_producer`)
    REFERENCES `theater`.`producer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
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
  `nb_seat` INT NOT NULL,
  `nb_priority_seat` INT NOT NULL,
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
