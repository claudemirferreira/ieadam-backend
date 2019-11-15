package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Rotina;

public class RotinaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;

	private String acao;

	private String imagem;

	public RotinaDTO() {
	}

	public RotinaDTO(int id, String nome, String acao, String imagem) {
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		
		if(acao.equals("relatorioSaldoCongregacao.init")) {
			this.setAcao("saldo-congregacao");
		}
		else if(acao.equals("relatorioProventoPastoral.init")) {
			setAcao("provento-pastoral");
		}
		else if(acao.equals("relatorioDebitoFinanceiro.init")) {
			this.setAcao("debito-financeiro");
		}
		else if(acao.equals("relatorioCentroCusto.init")){
			this.setAcao("centro-custo");
		}
		else if(acao.equals("relatorioNadaConsta.init")){
			this.setAcao("nada-consta");
		}
		else if(acao.equals("relatorioSaldoDepartamento.init")){
			this.setAcao("saldo-departamento");
		}
		else if(acao.equals("relatorioBalanceteAnalitico.init")){
			this.setAcao("balancete-analitico");
		}
		else if(acao.equals("relatorioBalanceteSintetico.init")){
			this.setAcao("balancete-sintetico");
		}
		else if(acao.equals("relatorioDebitoPastoral.init")){
			this.setAcao("debito-pastoral");
		}
		else if(acao.equals("relatorioEstatistico.init")){
			this.setAcao("estatistico");
		}
		else if(acao.equals("relatorioDebitoSecretaria.init")){
			this.setAcao("debito-secretaria");
		}
		else if(acao.equals("membroControlador.init")){
			this.setAcao("membro");
		}
		else if(acao.equals("rotinaControlador.init")){
			this.setAcao("rotina");
		}
		else if(acao.equals("perfilControlador.init")){
			this.setAcao("perfil");
		}
		else if(acao.equals("usuarioControlador.init")){
			this.setAcao("usuario");
		}
		else if(acao.equals("logAppControlador.init")){
			this.setAcao("log");
		}
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public static RotinaDTO toDTO(Rotina entity) {
		return new RotinaDTO(entity.getId(), entity.getNome(), entity.getAcao(), entity.getImagem());
	}

	public static List<RotinaDTO> toDTO(List<Rotina> list) {
		List<RotinaDTO> dtos = new ArrayList<RotinaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}