package br.com.construcao.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// http://localhost:8080/Construcao/rest/construcao
@Path("construcao")
public class ConstrucaoService {
	@GET
	public String exibir(){
		return "Ariel Zanrosso";
	}
}
