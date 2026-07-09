-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema UniversidadUT
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema UniversidadUT
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `UniversidadUT` ;
USE `UniversidadUT` ;

-- -----------------------------------------------------
-- Table `UniversidadUT`.`ALUMNOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UniversidadUT`.`ALUMNOS` (
  `id_alum` INT NOT NULL,
  `nombre` VARCHAR(45) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  `curp` VARCHAR(45) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  `promedio` DOUBLE NOT NULL,
  `grado` INT NOT NULL,
  PRIMARY KEY (`id_alum`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `UniversidadUT`.`MAESTRO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UniversidadUT`.`MAESTRO` (
  `id_maest` INT NOT NULL,
  `nombre` VARCHAR(45) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  `curp` VARCHAR(45) COLLATE 'utf8mb3_spanish_ci' NOT NULL,
  `puesto` VARCHAR(45) CHARACTER SET 'utf8mb3' NOT NULL,
  `sueldo` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_maest`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

