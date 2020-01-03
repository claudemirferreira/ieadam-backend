ALTER TABLE `sgr`.`saa_usuario` ADD COLUMN `profile` VARCHAR(50) AFTER `logomarca`;

ALTER TABLE `sgr`.`saa_usuario` MODIFY COLUMN `profile` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 0;


create view view_perfil_rotina as SELECT a.id_rotina, a.nome,
  ( SELECT DISTINCT b.id_perfil FROM saa_perfil_rotina b
    WHERE (a.id_rotina = b.id_rotina)) id_perfil
FROM saa_rotina a;