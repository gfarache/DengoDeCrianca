-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dengodecrianca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dengodecrianca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dengodecrianca` DEFAULT CHARACTER SET utf8 ;
USE `dengodecrianca` ;

-- -----------------------------------------------------
-- Table `dengodecrianca`.`resp_financeiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`resp_financeiro` (
  `cpf` VARCHAR(11) NOT NULL,
  `parentesco` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `rg` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(20) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `complemento` VARCHAR(50) NULL,
  `municipio` VARCHAR(50) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `telefone` VARCHAR(30) NOT NULL,
  `email` VARCHAR(100) NULL,
  `mensalidade` DECIMAL(6,2) NOT NULL,
  `coativo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`aluno` (
  `matricula` VARCHAR(10) NOT NULL,
  `resp_financeiro_cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `datanascimento` VARCHAR(8) NOT NULL,
  `cpf` VARCHAR(11) NULL,
  `rg` VARCHAR(20) NULL,
  `sexo` CHAR(1) NOT NULL,
  `turno` CHAR(1) NOT NULL COMMENT '1 - integral\n2 - meio-período/manhã\n3 - meio-período/tarde\n4 - reforço/manhã\n5 - reforço/tarde',
  `nomeMae` VARCHAR(80) NOT NULL,
  `coativo` VARCHAR(1) NOT NULL,
  `nomePai` VARCHAR(80) NULL,
  `foto` BLOB NULL,
  PRIMARY KEY (`matricula`, `resp_financeiro_cpf`),
  INDEX `fk_aluno_resp_financeiro1_idx` (`resp_financeiro_cpf` ASC),
  CONSTRAINT `fk_aluno_resp_financeiro1`
    FOREIGN KEY (`resp_financeiro_cpf`)
    REFERENCES `dengodecrianca`.`resp_financeiro` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`funcionario` (
  `matricula` VARCHAR(10) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `datanascimento` VARCHAR(8) NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `endereco` VARCHAR(20) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `complemento` VARCHAR(50) NULL,
  `municipio` VARCHAR(50) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `telefone` VARCHAR(30) NOT NULL,
  `email` VARCHAR(100) NULL,
  `cargo` VARCHAR(30) NOT NULL,
  `salario` DECIMAL(6,2) NOT NULL,
  `dataadmissao` VARCHAR(8) NOT NULL,
  `datademissao` VARCHAR(8) NULL,
  `foto` BLOB NULL,
  `coativo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`entrada_saida_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`entrada_saida_aluno` (
  `data_hora` VARCHAR(8) NOT NULL,
  `tipo` VARCHAR(1) NOT NULL,
  `aluno_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`aluno_matricula`),
  CONSTRAINT `fk_entrada_saida_aluno_aluno1`
    FOREIGN KEY (`aluno_matricula`)
    REFERENCES `dengodecrianca`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`ponto_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`ponto_funcionario` (
  `data_hora` VARCHAR(8) NOT NULL,
  `tipo` VARCHAR(1) NOT NULL,
  `funcionario_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`funcionario_matricula`),
  CONSTRAINT `fk_ponto_funcionario_funcionario1`
    FOREIGN KEY (`funcionario_matricula`)
    REFERENCES `dengodecrianca`.`funcionario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`pagamento` (
  `descricao` VARCHAR(45) NOT NULL,
  `valor` DECIMAL(6,2) NOT NULL,
  `data_hora` VARCHAR(8) NOT NULL,
  `multa` DECIMAL NULL,
  `resp_financeiro_cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`resp_financeiro_cpf`),
  CONSTRAINT `fk_pagamento_resp_financeiro1`
    FOREIGN KEY (`resp_financeiro_cpf`)
    REFERENCES `dengodecrianca`.`resp_financeiro` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`frequencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`frequencia` (
  `nota` DECIMAL(4,2) NULL,
  `datanotas` VARCHAR(8) NULL,
  `freq_data` VARCHAR(8) NOT NULL,
  `aluno_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`aluno_matricula`),
  CONSTRAINT `fk_frequencia_aluno1`
    FOREIGN KEY (`aluno_matricula`)
    REFERENCES `dengodecrianca`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`receita_despesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`receita_despesa` (
  `idreceitas_despesas` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(1) NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  `valor` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`idreceitas_despesas`))
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `dengodecrianca`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`evento` (
  `ideventos` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(50) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`ideventos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`usuario` (
  `login` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  `perfil` VARCHAR(20) NOT NULL,
  `coativo` VARCHAR(1) NOT NULL,
  `funcionario_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`login`),
  INDEX `fk_usuario_funcionario1_idx` (`funcionario_matricula` ASC),
  CONSTRAINT `fk_usuario_funcionario1`
    FOREIGN KEY (`funcionario_matricula`)
    REFERENCES `dengodecrianca`.`funcionario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`funcionario_hist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`funcionario_hist` (
  `salario` DECIMAL(6,2) NOT NULL,
  `cargo` VARCHAR(80) NOT NULL,
  `data_hora` VARCHAR(8) NOT NULL,
  `advertencia` INT ZEROFILL NOT NULL,
  `funcionario_matricula` VARCHAR(10) NOT NULL,
  INDEX `fk_funcionario_hist_funcionario1_idx` (`funcionario_matricula` ASC),
  CONSTRAINT `fk_funcionario_hist_funcionario1`
    FOREIGN KEY (`funcionario_matricula`)
    REFERENCES `dengodecrianca`.`funcionario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`usuario_hist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`usuario_hist` (
  `transacao` VARCHAR(30) NOT NULL,
  `data_hora` VARCHAR(8) NOT NULL,
  `usuario_login` VARCHAR(20) NOT NULL,
  INDEX `fk_usuario_hist_usuario1_idx` (`usuario_login` ASC),
  CONSTRAINT `fk_usuario_hist_usuario1`
    FOREIGN KEY (`usuario_login`)
    REFERENCES `dengodecrianca`.`usuario` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`emissao_documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`emissao_documento` (
  `tipo` VARCHAR(30) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`serie` (
  `descricao` VARCHAR(10) NOT NULL,
  `turma` VARCHAR(20) NOT NULL,
  `aluno_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`aluno_matricula`),
  CONSTRAINT `fk_serie_aluno1`
    FOREIGN KEY (`aluno_matricula`)
    REFERENCES `dengodecrianca`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`disciplina` (
  `iddisciplina` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `aluno_matricula` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`iddisciplina`, `aluno_matricula`),
  INDEX `fk_disciplina_aluno_idx` (`aluno_matricula` ASC),
  CONSTRAINT `fk_disciplina_aluno`
    FOREIGN KEY (`aluno_matricula`)
    REFERENCES `dengodecrianca`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`registroatividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`registroatividades` (
  `idregistro` INT NOT NULL AUTO_INCREMENT,
  `login_ciente` VARCHAR(20) NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `usuario_login` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idregistro`),
  INDEX `fk_registroatividades_usuario1_idx` (`usuario_login` ASC),
  CONSTRAINT `fk_registroatividades_usuario1`
    FOREIGN KEY (`usuario_login`)
    REFERENCES `dengodecrianca`.`usuario` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`tipologradouro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`tipologradouro` (
  `idtipologradouro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipologradouro`, `nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`uflogradouro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`uflogradouro` (
  `iduflogradouro` INT NOT NULL AUTO_INCREMENT,
  `couf` VARCHAR(2) NOT NULL,
  `nomeuf` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`iduflogradouro`, `couf`, `nomeuf`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
