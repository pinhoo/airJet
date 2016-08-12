CREATE TABLE `aircraft` (
  `id` BIGINT AUTO_INCREMENT,
  `modelo` VARCHAR(45) NOT NULL,
  `num_assentos` INT NOT NULL,
  PRIMARY KEY (`id`)
  )ENGINE = InnoDB DEFAULT CHARSET=utf8