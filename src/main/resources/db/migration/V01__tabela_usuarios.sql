-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `unipejet` DEFAULT CHARACTER SET utf8 ;
USE `unipejet` ;


CREATE TABLE IF NOT EXISTS `unipejet`.`user` (
  `nome` VARCHAR(50) NOT NULL,
  `documento` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `cartao_milhas` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL DEFAULT 1,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `unipejet`.`aircraft` (
  `id_aircraft` BIGINT	AUTO_INCREMENT,
  `modelo` VARCHAR(45) NOT NULL,
  `num_assentos` INT NOT NULL,
  PRIMARY KEY (`id_aircraft`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `unipejet`.`flights` (
  `id_flight` BIGINT AUTO_INCREMENT,
  `origem` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  `hora_partida` DATETIME NOT NULL,
  `duracao` TIME NOT NULL,
  `distancia` DECIMAL NOT NULL,
  `preco_passagem` DECIMAL(10,2) NOT NULL,
  `volta` MEDIUMTEXT NOT NULL,
  `aircraft_id` BIGINT NOT NULL,
  `assentos_ocupados` INT NULL,
  PRIMARY KEY (`id_flight`),
  INDEX `fk_flights_aircraft1_idx` (`aircraft_id` ASC),
  CONSTRAINT `fk_flights_aircraft1`
    FOREIGN KEY (`aircraft_id`)
    REFERENCES `unipejet`.`aircraft` (`id_aircraft`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `unipejet`.`roles` (
  `id_role` BIGINT AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `user_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`),
  INDEX `fk_roles_user1_idx` (`user_username` ASC),
  CONSTRAINT `fk_roles_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `unipejet`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `unipejet`.`pedido` (
  `id_order` INT AUTO_INCREMENT,
  `num_passagens` INT NOT NULL,
  `valor_total` DECIMAL(10,2) NULL,
  `ordercol` VARCHAR(45) NULL,
  `flights_id_flight` BIGINT NOT NULL,
  `total_milhas` INT NULL,
  `user_username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_order`),
  INDEX `fk_order_flights1_idx` (`flights_id_flight` ASC),
  INDEX `fk_pedido_user1_idx` (`user_username` ASC),
  CONSTRAINT `fk_order_flights1`
    FOREIGN KEY (`flights_id_flight`)
    REFERENCES `unipejet`.`flights` (`id_flight`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `unipejet`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


