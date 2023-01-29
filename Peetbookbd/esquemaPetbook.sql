-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Petbookbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Petbookbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Petbookbd` DEFAULT CHARACTER SET utf8 ;
USE `Petbookbd` ;

-- -----------------------------------------------------
-- Table `Petbookbd`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbookbd`.`usuarios` (
  `idusuarios` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuarios`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Petbookbd`.`publicaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbookbd`.`publicaciones` (
  `id_publicacion` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(140) NOT NULL,
  `foto` TEXT NULL,
  `likes` INT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`id_publicacion`, `usuarios_idusuarios`),
  INDEX `fk_publicaciones_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Petbookbd`.`administradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbookbd`.`administradores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Petbookbd`.`likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbookbd`.`likes` (
  `likes` INT NOT NULL AUTO_INCREMENT,
  `publicaciones_id_publicacion` INT NOT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`likes`, `usuarios_idusuarios`),
  INDEX `fk_likes_publicaciones_idx` (`publicaciones_id_publicacion` ASC) VISIBLE,
  INDEX `fk_likes_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
