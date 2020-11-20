package br.com.construcao.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/Construcao/rest
@ApplicationPath("rest")
public class ConstrucaoResourceConfig extends ResourceConfig {
	public ConstrucaoResourceConfig(){
		packages("br.com.construcao.service");
	}
}
