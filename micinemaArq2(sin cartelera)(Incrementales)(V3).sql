-- MySQL Script generated by MySQL Workbench
-- 02/11/15 07:37:26
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema miCinemaArq
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema miCinemaArq
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `miCinemaArq` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `miCinemaArq` ;

-- -----------------------------------------------------
-- Table `miCinemaArq`.`Pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Pelicula` (
  `idPelicula` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPelicula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Formato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Formato` (
  `idFormato` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idFormato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Localidad` (
  `idLocalidad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idLocalidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Tarifa` (
  `idTarifa` INT NOT NULL AUTO_INCREMENT,
  `Formato_idFormato` INT NOT NULL,
  `Valor` DOUBLE NOT NULL,
  `Localidad_idLocalidad` INT NOT NULL,
  `PuntosAcumular` INT NULL,
  `ValorTarjeta` DOUBLE NOT NULL,
  INDEX `fk_Tarifa_Formato1_idx` (`Formato_idFormato` ASC),
  PRIMARY KEY (`idTarifa`),
  INDEX `fk_Tarifa_Localidad1_idx` (`Localidad_idLocalidad` ASC),
  CONSTRAINT `fk_Tarifa_Formato1`
    FOREIGN KEY (`Formato_idFormato`)
    REFERENCES `miCinemaArq`.`Formato` (`idFormato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tarifa_Localidad1`
    FOREIGN KEY (`Localidad_idLocalidad`)
    REFERENCES `miCinemaArq`.`Localidad` (`idLocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Cine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Cine` (
  `idCine` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Telefono` VARCHAR(15) NULL,
  `Ciudad` VARCHAR(45) NULL,
  PRIMARY KEY (`idCine`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Sala` (
  `idSala` INT NOT NULL,
  `Cine_idCine` INT NOT NULL,
  `NumeroAsientos` INT NULL,
  PRIMARY KEY (`idSala`, `Cine_idCine`),
  INDEX `fk_Sala_Cine1_idx` (`Cine_idCine` ASC),
  CONSTRAINT `fk_Sala_Cine1`
    FOREIGN KEY (`Cine_idCine`)
    REFERENCES `miCinemaArq`.`Cine` (`idCine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Funcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Funcion` (
  `Pelicula_idPelicula` INT NOT NULL,
  `Fecha` DATETIME NOT NULL,
  `Estado` VARCHAR(20) NOT NULL COMMENT 'Estado: Activa/Inactiva',
  `Tarifa_idTarifa` INT NOT NULL,
  `Sala_idSala` INT NOT NULL,
  `Sala_Cine_idCine` INT NOT NULL,
  PRIMARY KEY (`Pelicula_idPelicula`, `Fecha`),
  INDEX `fk_Funcion_Pelicula_idx` (`Pelicula_idPelicula` ASC),
  INDEX `fk_Funcion_Tarifa1_idx` (`Tarifa_idTarifa` ASC),
  INDEX `fk_Funcion_Sala1_idx` (`Sala_idSala` ASC, `Sala_Cine_idCine` ASC),
  CONSTRAINT `fk_Funcion_Pelicula`
    FOREIGN KEY (`Pelicula_idPelicula`)
    REFERENCES `miCinemaArq`.`Pelicula` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcion_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `miCinemaArq`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcion_Sala1`
    FOREIGN KEY (`Sala_idSala` , `Sala_Cine_idCine`)
    REFERENCES `miCinemaArq`.`Sala` (`idSala` , `Cine_idCine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Asiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Asiento` (
  `idAsiento` INT NOT NULL,
  `Estado` VARCHAR(20) NULL,
  `Localidad_idLocalidad` INT NOT NULL,
  `Sala_idSala` INT NOT NULL,
  `Sala_Cine_idCine` INT NOT NULL,
  PRIMARY KEY (`idAsiento`, `Localidad_idLocalidad`, `Sala_idSala`, `Sala_Cine_idCine`),
  INDEX `fk_Asiento_Localidad1_idx` (`Localidad_idLocalidad` ASC),
  INDEX `fk_Asiento_Sala1_idx` (`Sala_idSala` ASC, `Sala_Cine_idCine` ASC),
  CONSTRAINT `fk_Asiento_Localidad1`
    FOREIGN KEY (`Localidad_idLocalidad`)
    REFERENCES `miCinemaArq`.`Localidad` (`idLocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asiento_Sala1`
    FOREIGN KEY (`Sala_idSala` , `Sala_Cine_idCine`)
    REFERENCES `miCinemaArq`.`Sala` (`idSala` , `Cine_idCine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Socio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Socio` (
  `idSocio` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NULL,
  `Telefono` VARCHAR(15) NOT NULL,
  `Estado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idSocio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Operador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Operador` (
  `idOperador` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Cine_idCine` INT NOT NULL,
  `NombreUsuario` VARCHAR(45) NOT NULL,
  `Contrasena` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idOperador`),
  INDEX `fk_Operador_Cine1_idx` (`Cine_idCine` ASC),
  UNIQUE INDEX `Cine_idCine_UNIQUE` (`Cine_idCine` ASC),
  UNIQUE INDEX `NombreUsuario_UNIQUE` (`NombreUsuario` ASC),
  CONSTRAINT `fk_Operador_Cine1`
    FOREIGN KEY (`Cine_idCine`)
    REFERENCES `miCinemaArq`.`Cine` (`idCine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `Valor` DOUBLE NOT NULL,
  `Fecha` DATE NOT NULL,
  `Socio_idSocio` INT NULL,
  `Operador_idOperador` INT NOT NULL,
  `Estado` TINYINT(1) NOT NULL COMMENT 'El estado corresponde a Pago o Pendiente (Reserva)',
  `PuntosRedimidos` INT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Venta_Socio1_idx` (`Socio_idSocio` ASC),
  INDEX `fk_Venta_Operador1_idx` (`Operador_idOperador` ASC),
  CONSTRAINT `fk_Venta_Socio1`
    FOREIGN KEY (`Socio_idSocio`)
    REFERENCES `miCinemaArq`.`Socio` (`idSocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Operador1`
    FOREIGN KEY (`Operador_idOperador`)
    REFERENCES `miCinemaArq`.`Operador` (`idOperador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`TipoPago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`TipoPago` (
  `idTipoPago` INT NOT NULL AUTO_INCREMENT,
  `NombreTipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Boleta` (
  `IdBoleta` INT NOT NULL AUTO_INCREMENT,
  `EsReserva` TINYINT(1) NOT NULL,
  `Asiento_idAsiento` INT NOT NULL,
  `Asiento_Localidad_idLocalidad` INT NOT NULL,
  `Asiento_Sala_idSala` INT NOT NULL,
  `Asiento_Sala_Cine_idCine` INT NOT NULL,
  `Factura_idFactura` INT NOT NULL,
  `Funcion_Pelicula_idPelicula` INT NOT NULL,
  `Funcion_Fecha` DATETIME NOT NULL,
  `TipoPago_idTipoPago` INT NOT NULL,
  PRIMARY KEY (`IdBoleta`),
  INDEX `fk_Boleta_Asiento1_idx` (`Asiento_idAsiento` ASC, `Asiento_Localidad_idLocalidad` ASC, `Asiento_Sala_idSala` ASC, `Asiento_Sala_Cine_idCine` ASC),
  INDEX `fk_Boleta_Factura1_idx` (`Factura_idFactura` ASC),
  INDEX `fk_Boleta_Funcion1_idx` (`Funcion_Pelicula_idPelicula` ASC, `Funcion_Fecha` ASC),
  INDEX `fk_Boleta_TipoPago1_idx` (`TipoPago_idTipoPago` ASC),
  CONSTRAINT `fk_Boleta_Asiento1`
    FOREIGN KEY (`Asiento_idAsiento` , `Asiento_Localidad_idLocalidad` , `Asiento_Sala_idSala` , `Asiento_Sala_Cine_idCine`)
    REFERENCES `miCinemaArq`.`Asiento` (`idAsiento` , `Localidad_idLocalidad` , `Sala_idSala` , `Sala_Cine_idCine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Boleta_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `miCinemaArq`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Boleta_Funcion1`
    FOREIGN KEY (`Funcion_Pelicula_idPelicula` , `Funcion_Fecha`)
    REFERENCES `miCinemaArq`.`Funcion` (`Pelicula_idPelicula` , `Fecha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Boleta_TipoPago1`
    FOREIGN KEY (`TipoPago_idTipoPago`)
    REFERENCES `miCinemaArq`.`TipoPago` (`idTipoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Formato_por_Pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Formato_por_Pelicula` (
  `Formato_idFormato` INT NOT NULL,
  `Pelicula_idPelicula` INT NOT NULL,
  INDEX `fk_Formato_has_Pelicula_Pelicula1_idx` (`Pelicula_idPelicula` ASC),
  INDEX `fk_Formato_has_Pelicula_Formato1_idx` (`Formato_idFormato` ASC),
  UNIQUE INDEX `Formato_idFormato_UNIQUE` (`Formato_idFormato` ASC),
  UNIQUE INDEX `Pelicula_idPelicula_UNIQUE` (`Pelicula_idPelicula` ASC),
  PRIMARY KEY (`Formato_idFormato`, `Pelicula_idPelicula`),
  CONSTRAINT `fk_Formato_has_Pelicula_Formato1`
    FOREIGN KEY (`Formato_idFormato`)
    REFERENCES `miCinemaArq`.`Formato` (`idFormato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Formato_has_Pelicula_Pelicula1`
    FOREIGN KEY (`Pelicula_idPelicula`)
    REFERENCES `miCinemaArq`.`Pelicula` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Tarjeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Tarjeta` (
  `IdTarjeta` INT NOT NULL AUTO_INCREMENT,
  `Socio_idSocio` INT NOT NULL,
  `Puntos` INT NULL,
  `FechaCreacion` DATE NOT NULL,
  PRIMARY KEY (`IdTarjeta`),
  INDEX `fk_Tarjeta_Socio1_idx` (`Socio_idSocio` ASC),
  CONSTRAINT `fk_Tarjeta_Socio1`
    FOREIGN KEY (`Socio_idSocio`)
    REFERENCES `miCinemaArq`.`Socio` (`idSocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`TipoOperador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`TipoOperador` (
  `idTipoOperador` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Operador_idOperador` INT NULL,
  PRIMARY KEY (`idTipoOperador`),
  INDEX `fk_TipoOperador_Operador1_idx` (`Operador_idOperador` ASC),
  UNIQUE INDEX `Operador_idOperador_UNIQUE` (`Operador_idOperador` ASC),
  CONSTRAINT `fk_TipoOperador_Operador1`
    FOREIGN KEY (`Operador_idOperador`)
    REFERENCES `miCinemaArq`.`Operador` (`idOperador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`table1` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Actor` (
  `idActor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idActor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`Reserva` (
  `FechaReserva` DATETIME NULL,
  `Socio_idSocio` INT NOT NULL,
  `Factura_idFactura` INT NOT NULL,
  PRIMARY KEY (`Socio_idSocio`, `Factura_idFactura`),
  INDEX `fk_Reserva_Socio1_idx` (`Socio_idSocio` ASC),
  INDEX `fk_Reserva_Factura1_idx` (`Factura_idFactura` ASC),
  CONSTRAINT `fk_Reserva_Socio1`
    FOREIGN KEY (`Socio_idSocio`)
    REFERENCES `miCinemaArq`.`Socio` (`idSocio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `miCinemaArq`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`combo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`combo` (
  `idcombo` INT NOT NULL,
  `puntosAcumular` INT NOT NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`idcombo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `miCinemaArq`.`combo_has_Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `miCinemaArq`.`combo_has_Factura` (
  `combo_idcombo` INT NOT NULL,
  `Factura_idFactura` INT NOT NULL,
  `NumeroCombos` INT NOT NULL,
  PRIMARY KEY (`combo_idcombo`, `Factura_idFactura`),
  INDEX `fk_combo_has_Factura_Factura1_idx` (`Factura_idFactura` ASC),
  INDEX `fk_combo_has_Factura_combo1_idx` (`combo_idcombo` ASC),
  CONSTRAINT `fk_combo_has_Factura_combo1`
    FOREIGN KEY (`combo_idcombo`)
    REFERENCES `miCinemaArq`.`combo` (`idcombo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_combo_has_Factura_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `miCinemaArq`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
