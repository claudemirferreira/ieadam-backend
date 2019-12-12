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
		
2 - proc_rel_fin_proventos_pastoral -> provento-pastoral ok
3 - proc_rel_fin_saldo_congregacao -> saldo-congregacao ok
4 - proc_rel_sec_debito_pastoral debito pastoral ok
5 - proc_rel_sec_debito_secretaria -> debito-secretaria ok 
 - proc_rel_fin_debito_financeiro -> ok

6 - proc_rel_sec_estatistico -> 
		
	Verificar com o dryen
	
	
