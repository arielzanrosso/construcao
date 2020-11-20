package br.com.construcao.test;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.com.construcao.dao.FornecedorDAO;
import br.com.construcao.dao.ProdutoDAO;
import br.com.construcao.domain.Fornecedor;
import br.com.construcao.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.buscar(new Long("1"));
		
		Produto produto = new Produto();
		produto.setDescricao("Cimento CP-II");
		produto.setFornecedor(fornecedor);
		produto.setPreco(new BigDecimal("19.90"));
		produto.setQuantidade(new Short("150"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso");
	}
}
