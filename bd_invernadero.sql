-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd_invernadero
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_invernadero
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_invernadero` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bd_invernadero` ;

-- -----------------------------------------------------
-- Table `bd_invernadero`.`plantas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_invernadero`.`plantas` (
  `id_planta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `tipo` VARCHAR(100) NOT NULL,
  `humedad_optima` DOUBLE NOT NULL,
  PRIMARY KEY (`id_planta`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_invernadero`.`registro_plantas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_invernadero`.`registro_plantas` (
  `idregistro_plantas` INT NOT NULL AUTO_INCREMENT,
  `planta_id_planta` INT NOT NULL,
  `ultima_humedad` DOUBLE NOT NULL,
  `ultima_vez_regada` DATETIME NOT NULL,
  PRIMARY KEY (`idregistro_plantas`),
  INDEX `id_planta_idx` (`planta_id_planta` ASC) VISIBLE,
  CONSTRAINT `id_planta`
    FOREIGN KEY (`planta_id_planta`)
    REFERENCES `bd_invernadero`.`plantas` (`id_planta`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
