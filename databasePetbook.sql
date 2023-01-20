-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Petbook
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Petbook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Petbook` DEFAULT CHARACTER SET utf8 ;
USE `Petbook` ;

-- -----------------------------------------------------
-- Table `Petbook`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbook`.`usuarios` (
  `idusuarios` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuarios`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Petbook`.`publicaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbook`.`publicaciones` (
  `id_publicacion` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(140) NOT NULL,
  `foto` TEXT NULL,
  `likes` INT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`id_publicacion`, `usuarios_idusuarios`),
  INDEX `fk_publicaciones_usuarios_idx` (`usuarios_idusuarios` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Petbook`.`blog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbook`.`blog` (
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`usuarios_idusuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Petbook`.`administradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbook`.`administradores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Petbook`.`publicaciones_blog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Petbook`.`publicaciones_blog` (
  `id_blog` INT NOT NULL AUTO_INCREMENT,
  `informacion` VARCHAR(1000) NOT NULL,
  `Fecha_actualizacion` DATE NOT NULL,
  `autores` VARCHAR(100) NOT NULL,
  `blog_usuarios_idusuarios` INT NOT NULL,
  `administradores_id` INT NOT NULL,
  PRIMARY KEY (`id_blog`, `blog_usuarios_idusuarios`, `administradores_id`),
  INDEX `fk_publicaciones_blog_blog1_idx` (`blog_usuarios_idusuarios` ASC) VISIBLE,
  INDEX `fk_publicaciones_blog_administradores1_idx` (`administradores_id` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
