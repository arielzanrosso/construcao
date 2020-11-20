package br.com.construcao.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.construcao.dao.HistoricoDAO;
import br.com.construcao.dao.ProdutoDAO;
import br.com.construcao.domain.Historico;
import br.com.construcao.domain.Produto;

@ManagedBean
@ViewScoped
public class ProdutoPesquisaBean {
	
	private Produto produto;
	private boolean exibir;
	private Historico historico;
	
	
	
	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public boolean isExibir() {
		return exibir;
	}

	public void setExibir(boolean exibir) {
		this.exibir = exibir;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@PostConstruct
	public void novo() {
	
		historico = new Historico();
		produto = new Produto();
		exibir = false;
	}
	
	public void buscar() {
		
		try {
		ProdutoDAO produtodao = new ProdutoDAO();
		Produto resultado = produtodao.buscar(produto.getCodigo());
		
		if(resultado == null) {
			Messages.addGlobalWarn("Produto não encontrado");
			exibir = false;
		}else {
			
			exibir = true;
			produto = resultado;
		}
	}catch (RuntimeException erro) {
		Messages.addFlashGlobalError("Ocorreu um erro");
		erro.printStackTrace();
	}

}
	
	public void salvar() {
		
		try {
			historico.setHorario(new Date());
			historico.setProduto(produto);
			
			HistoricoDAO historicoDAO = new HistoricoDAO();
			historicoDAO.salvar(historico);
			
			Messages.addFlashGlobalInfo("Histórico salvo com sucesso!");
		}catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o histórico");
			erro.printStackTrace();
		}
	}
}
