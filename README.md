# FACA BACKUP DO BANDO DE DADOS
## 1 execute o script de importacao do banco de dados src/main/resources/backup.sql
## 1.1 ALTER TABLE `saa_usuario` ADD COLUMN `profile` VARCHAR(50) AFTER `logomarca`;
## 1.2 UPDATE `saa_usuario` SET senha = '$2a$10$0bnrmA15bLbZb.LhOEGrVuFt5mAlz1FOU0hSClnBsPvRCLex1TvMi' where login = '1977'


## configure o usuario e senha no arquivo application.properties
## crie o usuario no banco de dados
## database= sgr_test
## username = root
## password = root12!@

# mvn install

# java -jar ieadam-service-app-0.0.1-SNAPSHOT.jar

# PENDÊNCIA 
## 1 - CRUD ROTINA;
## 2 - CRUD PERFIL;
## 3 - CRUD USUARIO;
## 4 - ASSOCIAR PERFIL ROTINA
## 5 - ASSOCIAR USUARIO PERFIL;
## 6 - RELATORIO MEMBROS;
## 7 - LAYOUT;

-----
# relatorio de membro
## 	- remover o botao imprimir da listagem
## 	- incluir todos os campos no detalhe
# Geral 
## 	- incluir o botao voltar em todas as telas.
## 	- Layout dos campos de todas as telas.
## 		- tamanho dos campos.
## 		- Cores do sistema
## 		- icones
## 		- logo
	
## ---RELATORIO COM ERRO
# RelatorioEstatistico -> PROCEDURE SIIAD.dbo.STP_EXPORTA_REL_EST_TER não existe


--RELATORIO OK
## RelatorioDebitoSecretaria
## RelatorioDebitoPastoral
## RelatorioFichaMembro
## RelatorioSaldoCongregacao

