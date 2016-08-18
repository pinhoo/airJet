  CREATE TABLE `user` (
  `id_user` BIGINT AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `documento` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `cartao_milhas` INT NOT NULL,
  `flights_id` VARCHAR(45),
  `username` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)
  )ENGINE = InnoDB DEFAULT CHARSET=utf8
  
  