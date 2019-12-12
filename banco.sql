CREATE SCHEMA IF NOT EXISTS DesafioBasis DEFAULT CHARACTER SET utf8 ;
USE DesafioBasis;

CREATE TABLE IF NOT EXISTS `DesafioBasis`.`empresa` (
  `cod` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `endereco` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`cod`),
  UNIQUE INDEX `cpf` (`cnpj` ASC) VISIBLE,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  INDEX `fk_EndEmpresa` (`endereco` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `DesafioBasis`.`endereco` (
  `cod` INT(11) NOT NULL AUTO_INCREMENT,
  `pais` VARCHAR(250) NOT NULL,
  `uf` VARCHAR(250) NOT NULL,
  `cidade` VARCHAR(250) NOT NULL,
  `bairro` VARCHAR(250) NOT NULL,
  `rua` VARCHAR(250) NOT NULL,
  `numero` INT(11) NOT NULL,
  PRIMARY KEY (`cod`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `DesafioBasis`.`funcionario` (
  `cod` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `cod_empresa` INT(11) NOT NULL,
  `cod_endereco` INT(11) NOT NULL,
  PRIMARY KEY (`cod`),
  UNIQUE INDEX `cpf` (`cpf` ASC) VISIBLE,
  INDEX `fk_funcionarioEnd_idx` (`cod_endereco` ASC) VISIBLE,
  INDEX `fk_funcionarioEmp_idx` (`cod_empresa` ASC) VISIBLE,
  CONSTRAINT `fk_funcionarioEmp`
    FOREIGN KEY (`cod_empresa`)
    REFERENCES `DesafioBasis`.`empresa` (`cod`)
  CONSTRAINT `fk_funcionarioEnd`
    FOREIGN KEY (`cod_endereco`)
    REFERENCES `DesafioBasis`.`endereco` (`cod`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;
;
