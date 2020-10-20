-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
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
  `complemento` VARCHAR(50) NULL DEFAULT NULL,
  `municipio` VARCHAR(50) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `telefone` VARCHAR(30) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `mensalidade` DECIMAL(6,2) NOT NULL,
  `coativo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`serie` (
  `idserie` VARCHAR(2) NOT NULL,
  `descricao` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idserie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`turma` (
  `id_turma` VARCHAR(4) NOT NULL,
  `serie_idserie` VARCHAR(4) NOT NULL,
  `descricao` VARCHAR(20) NOT NULL,
  `capacidademaxima` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id_turma`, `serie_idserie`),
  INDEX `fk_turma_serie1_idx` (`serie_idserie` ASC),
  CONSTRAINT `fk_turma_serie1`
    FOREIGN KEY (`serie_idserie`)
    REFERENCES `dengodecrianca`.`serie` (`idserie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`filiacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`filiacao` (
  `idfiliacao` VARCHAR(10) NOT NULL,
  `nome_mae` VARCHAR(100) NOT NULL,
  `nome_pai` VARCHAR(100) NULL,
  PRIMARY KEY (`idfiliacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`mensalidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`mensalidades` (
  `tipo` VARCHAR(20) NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  `valor` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`tipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`contato` (
  `idcontato` VARCHAR(10) NOT NULL,
  `contato1` VARCHAR(11) NOT NULL,
  `contato2` VARCHAR(11) NULL,
  `contato3` VARCHAR(11) NULL,
  PRIMARY KEY (`idcontato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`aluno` (
  `matricula` VARCHAR(10) NOT NULL,
  `resp_financeiro_cpf` VARCHAR(11) NOT NULL,
  `turma_serie_idserie` VARCHAR(2) NOT NULL,
  `turma_id_turma` VARCHAR(4) NOT NULL,
  `filiacao_idfiliacao` VARCHAR(10) NOT NULL,
  `mensalidades_tipo` VARCHAR(20) NOT NULL,
  `contato_idcontato` VARCHAR(10) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `datanascimento` VARCHAR(8) NOT NULL,
  `cpf` VARCHAR(11) NULL DEFAULT NULL,
  `rg` VARCHAR(20) NULL DEFAULT NULL,
  `sexo` CHAR(1) NOT NULL,
  `turno` CHAR(1) NOT NULL COMMENT '1 - integral\n2 - meio-período/manhã\n3 - meio-período/tarde\n4 - reforço/manhã\n5 - reforço/tarde',
  `coativo` VARCHAR(1) NOT NULL,
  `foto` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`, `resp_financeiro_cpf`, `turma_serie_idserie`, `turma_id_turma`, `filiacao_idfiliacao`, `mensalidades_tipo`, `contato_idcontato`),
  INDEX `fk_aluno_resp_financeiro1_idx` (`resp_financeiro_cpf` ASC),
  INDEX `fk_aluno_turma1_idx` (`turma_serie_idserie` ASC, `turma_id_turma` ASC),
  INDEX `fk_aluno_filiacao1_idx` (`filiacao_idfiliacao` ASC),
  INDEX `fk_aluno_mensalidades1_idx` (`mensalidades_tipo` ASC),
  INDEX `fk_aluno_contato1_idx` (`contato_idcontato` ASC),
  CONSTRAINT `fk_aluno_resp_financeiro1`
    FOREIGN KEY (`resp_financeiro_cpf`)
    REFERENCES `dengodecrianca`.`resp_financeiro` (`cpf`),
  CONSTRAINT `fk_aluno_turma1`
    FOREIGN KEY (`turma_serie_idserie` , `turma_id_turma`)
    REFERENCES `dengodecrianca`.`turma` (`serie_idserie` , `id_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_filiacao1`
    FOREIGN KEY (`filiacao_idfiliacao`)
    REFERENCES `dengodecrianca`.`filiacao` (`idfiliacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_mensalidades1`
    FOREIGN KEY (`mensalidades_tipo`)
    REFERENCES `dengodecrianca`.`mensalidades` (`tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_contato1`
    FOREIGN KEY (`contato_idcontato`)
    REFERENCES `dengodecrianca`.`contato` (`idcontato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`disciplina` (
  `iddisciplina` VARCHAR(2) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iddisciplina`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`desempenho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`desempenho` (
  `aluno_matricula` VARCHAR(10) NOT NULL,
  `disciplina_iddisciplina` VARCHAR(2) NOT NULL,
  `nota` DECIMAL(4,2) NULL,
  PRIMARY KEY (`aluno_matricula`, `disciplina_iddisciplina`),
  INDEX `fk_disciplina_aluno_idx` (`aluno_matricula` ASC),
  INDEX `fk_desempenho_disciplina1_idx` (`disciplina_iddisciplina` ASC),
  CONSTRAINT `fk_disciplina_aluno`
    FOREIGN KEY (`aluno_matricula`)
    REFERENCES `dengodecrianca`.`aluno` (`matricula`),
  CONSTRAINT `fk_desempenho_disciplina1`
    FOREIGN KEY (`disciplina_iddisciplina`)
    REFERENCES `dengodecrianca`.`disciplina` (`iddisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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
  `complemento` VARCHAR(50) NULL DEFAULT NULL,
  `municipio` VARCHAR(50) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `telefone` VARCHAR(30) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `cargo` VARCHAR(30) NOT NULL,
  `salario` DECIMAL(6,2) NOT NULL,
  `dataadmissao` VARCHAR(8) NOT NULL,
  `datademissao` VARCHAR(8) NULL DEFAULT NULL,
  `foto` BLOB NULL DEFAULT NULL,
  `coativo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`usuario` (
  `funcionario_matricula` VARCHAR(10) NOT NULL,
  `login` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `perfil` VARCHAR(15) NOT NULL,
  `coativo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`login`),
  INDEX `fk_usuario_funcionario1_idx` (`funcionario_matricula` ASC),
  CONSTRAINT `fk_usuario_funcionario1`
    FOREIGN KEY (`funcionario_matricula`)
    REFERENCES `dengodecrianca`.`funcionario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`documento` (
  `iddocumento` VARCHAR(2) NOT NULL,
  `descricao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`iddocumento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`emissao_documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`emissao_documento` (
  `documento_iddocumento` VARCHAR(2) NOT NULL,
  `usuario_login` VARCHAR(20) NOT NULL,
  `tipo` VARCHAR(30) NOT NULL,
  `dataemissao` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`tipo`),
  INDEX `fk_emissao_documento_usuario1_idx` (`usuario_login` ASC),
  INDEX `fk_emissao_documento_documento1_idx` (`documento_iddocumento` ASC),
  CONSTRAINT `fk_emissao_documento_usuario1`
    FOREIGN KEY (`usuario_login`)
    REFERENCES `dengodecrianca`.`usuario` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emissao_documento_documento1`
    FOREIGN KEY (`documento_iddocumento`)
    REFERENCES `dengodecrianca`.`documento` (`iddocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`entrada_saida_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`entrada_saida_aluno` (
  `aluno_matricula` VARCHAR(10) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(4) NOT NULL,
  `tipo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`aluno_matricula`),
  CONSTRAINT `fk_entrada_saida_aluno_aluno1`
    FOREIGN KEY (`aluno_matricula`)
    REFERENCES `dengodecrianca`.`aluno` (`matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`funcionario_hist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`funcionario_hist` (
  `funcionario_matricula` VARCHAR(10) NOT NULL,
  `salario` DECIMAL(6,2) NOT NULL,
  `cargo` VARCHAR(80) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(4) NOT NULL,
  `advertencia` INT(11) NOT NULL,
  INDEX `fk_funcionario_hist_funcionario1_idx` (`funcionario_matricula` ASC),
  CONSTRAINT `fk_funcionario_hist_funcionario1`
    FOREIGN KEY (`funcionario_matricula`)
    REFERENCES `dengodecrianca`.`funcionario` (`matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`pagamento` (
  `resp_financeiro_cpf` VARCHAR(11) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `valor` DECIMAL(6,2) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(4) NOT NULL,
  `multa` DECIMAL(10,0) NULL DEFAULT NULL,
  PRIMARY KEY (`resp_financeiro_cpf`),
  CONSTRAINT `fk_pagamento_resp_financeiro1`
    FOREIGN KEY (`resp_financeiro_cpf`)
    REFERENCES `dengodecrianca`.`resp_financeiro` (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`ponto_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`ponto_funcionario` (
  `funcionario_matricula` VARCHAR(10) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(4) NOT NULL,
  `tipo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`funcionario_matricula`),
  CONSTRAINT `fk_ponto_funcionario_funcionario1`
    FOREIGN KEY (`funcionario_matricula`)
    REFERENCES `dengodecrianca`.`funcionario` (`matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`registro_atividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`registro_atividades` (
  `usuario_login` VARCHAR(20) NOT NULL,
  `idregistro` INT(11) NOT NULL AUTO_INCREMENT,
  `login_ciente` VARCHAR(20) NULL DEFAULT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`idregistro`),
  INDEX `fk_registroatividades_usuario1_idx` (`usuario_login` ASC),
  CONSTRAINT `fk_registroatividades_usuario1`
    FOREIGN KEY (`usuario_login`)
    REFERENCES `dengodecrianca`.`usuario` (`login`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dengodecrianca`.`usuario_hist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dengodecrianca`.`usuario_hist` (
  `usuario_login` VARCHAR(20) NOT NULL,
  `transacao` VARCHAR(30) NOT NULL,
  `data` VARCHAR(8) NOT NULL,
  `hora` VARCHAR(4) NOT NULL,
  INDEX `fk_usuario_hist_usuario1_idx` (`usuario_login` ASC),
  CONSTRAINT `fk_usuario_hist_usuario1`
    FOREIGN KEY (`usuario_login`)
    REFERENCES `dengodecrianca`.`usuario` (`login`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

  
---------------------------------------------------------------------------------------------------------
  
INSERT INTO `dengodecrianca`.`funcionario` (
  `matricula`, `cpf`, `rg`, `nome`, `datanascimento`, `sexo`, `endereco`,
  `numero`, `bairro`, `complemento`, `municipio`, `uf`, `cep`, `telefone`,
  `email`, `cargo`, `salario`, `dataadmissao`, `coativo`) 
VALUES ('2020TI0001', '77453816220', '1476993-0 SSP/AM', 'Gustavo Farache Oliveira',
  '19850222', 'M', 'Avenida Genebra', '7', 'Planalto', 'Quadra 12', 'Manaus', 'AM',
  '69045380', '(92)98233-0453', 'gfarache@gmail.com', 'Analista de TI', '0.00', '20200801', 'A');
  
INSERT INTO `dengodecrianca`.`usuario` 
(`login`, `senha`, `perfil`, `coativo`, `funcionario_matricula`) 
VALUES ('admin', '2', 'ADMIN', 'A', '2020TI0001');
