CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` BIGINT AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_roles_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_roles_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `unipejet`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB