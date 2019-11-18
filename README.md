# FACA BACKUP DO BANDO DE DADOS
1 execute o script de importacao do banco de dados

# configure o usuario e senha no arquivo application.properties

# mvn install

# java -jar nome_arquivo.jar

# PENDÊNCIA 
1 - RelatorioEstatistico 
	chama a procedure do sqlserver 
	EXECUTE SIIAD.dbo.STP_EXPORTA_REL_EST_TER
		@P_MESANOINI = $P{data_inicio},
		@P_MESANOFIM = $P{data_fim},
		@P_ID_AREA = $P{area};
		
	Verificar com o dryen
	
	
