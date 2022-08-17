-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema g-sports
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema g-sports
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `g-sports` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema g-sports
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema g-sports
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `g-sports` DEFAULT CHARACTER SET utf8 ;
USE `g-sports` ;

-- -----------------------------------------------------
-- Table `g-sports`.`Proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `g-sports`.`Proveedores` (
  `idProveedores` CHAR(10) NOT NULL,
  `NombreCompañia` VARCHAR(45) NULL,
  `NombreContacto` VARCHAR(45) NULL,
  `Ciudad` VARCHAR(45) NULL,
  `CodPostal` VARCHAR(45) NULL,
  `Teléfono` VARCHAR(45) NULL,
  PRIMARY KEY (`idProveedores`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `g-sports`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `g-sports`.`Categorias` (
  `idCategorias` CHAR(10) NOT NULL,
  `NombreCategoria` VARCHAR(45) NULL,
  `DescripciónCategoría` VARCHAR(300) NULL,
  PRIMARY KEY (`idCategorias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `g-sports`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `g-sports`.`Productos` (
  `idProducto` CHAR(10) NOT NULL,
  `idProveedores` CHAR(10) NOT NULL,
  `idCategorias` CHAR(10) NOT NULL,
  `NombreProducto` VARCHAR(300) NULL,
  `PrecioUnidad` DOUBLE NULL,
  `UnidadesExistentes` VARCHAR(45) NULL,
  `Descripción` VARCHAR(300) NULL,
  `Marca` VARCHAR(50) NULL,
  PRIMARY KEY (`idProducto`, `idProveedores`, `idCategorias`),
  INDEX `fk_Productos_1_idx` (`idProveedores` ASC) VISIBLE,
  INDEX `fk_Productos_2_idx` (`idCategorias` ASC) VISIBLE,
  CONSTRAINT `fk_Productos_1`
    FOREIGN KEY (`idProveedores`)
    REFERENCES `g-sports`.`Proveedores` (`idProveedores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_2`
    FOREIGN KEY (`idCategorias`)
    REFERENCES `g-sports`.`Categorias` (`idCategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `g-sports`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `g-sports`.`Clientes` (
  `idCliente` CHAR(10) NOT NULL,
  `NombreContacto` VARCHAR(45) NULL,
  `Ciudad` VARCHAR(45) NULL,
  `CodPostal` VARCHAR(45) NULL,
  `Teléfono` VARCHAR(45) NULL,
  `Alcaldía` VARCHAR(45) NULL,
  `Correo` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `g-sports`.`Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `g-sports`.`Pedidos` (
  `idPedidos` INT NOT NULL,
  `idCliente` CHAR(10) NOT NULL,
  `FechaPedido` VARCHAR(45) NULL,
  `FechaEnvio` VARCHAR(45) NULL,
  `FechaEntrega` VARCHAR(45) NULL,
  PRIMARY KEY (`idPedidos`, `idCliente`),
  INDEX `fk_Pedidos_1_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Pedidos_1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `g-sports`.`Clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `g-sports`.`DetallesPedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `g-sports`.`DetallesPedidos` (
  `idPedidos` INT NOT NULL,
  `idProducto` CHAR(10) NOT NULL,
  `Cantidad` VARCHAR(45) NULL,
  `Descuento` VARCHAR(45) NULL,
  PRIMARY KEY (`idPedidos`, `idProducto`),
  INDEX `fk_DetallesPedidos_2_idx` (`idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_DetallesPedidos_1`
    FOREIGN KEY (`idPedidos`)
    REFERENCES `g-sports`.`Pedidos` (`idPedidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetallesPedidos_2`
    FOREIGN KEY (`idProducto`)
    REFERENCES `g-sports`.`Productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `g-sports` ;

-- -----------------------------------------------------


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
