ALTER TABLE `sgr`.`saa_usuario` ADD COLUMN `profile` VARCHAR(50) AFTER `logomarca`;

ALTER TABLE `sgr`.`saa_usuario` MODIFY COLUMN `profile` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 0;
