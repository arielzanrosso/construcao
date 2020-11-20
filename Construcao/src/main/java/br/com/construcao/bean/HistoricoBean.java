package br.com.construcao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;


import br.com.construcao.dao.HistoricoDAO;

import br.com.construcao.domain.Historico;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HistoricoBean implements Serializable {
	private Historico historico;
	private List<Historico> historicos;

	

	
	
	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public void novo() {
		historico = new Historico();
	}

	public void salvar() {
		try {
			HistoricoDAO historicoDAO  = new HistoricoDAO();
			historicoDAO.merge(historico);

			novo();
			historicos = historicoDAO.listar();
			Messages.addGlobalInfo("Historico salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o historico");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			HistoricoDAO historicoDAO = new HistoricoDAO();
			historicos  = historicoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os historicos");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			historico = (Historico) evento.getComponent().getAttributes().get("fornecedorSelecionado");

			HistoricoDAO historicoDAO = new HistoricoDAO();
			historicoDAO.excluir(historico);

			historicos = historicoDAO.listar();

			Messages.addGlobalInfo("historico removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o historico");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		historico = (Historico) evento.getComponent().getAttributes().get("fornecedorSelecionado");
	}

}
