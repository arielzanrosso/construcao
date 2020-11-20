package br.com.construcao.bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


@ManagedBean
@RequestScoped
public class ImageBean {
	
	
	@ManagedProperty("#{param.cami}")
	private String cami;
	private StreamedContent foto;
	
	
	public String getCami() {
		return cami;
	}
	
	public void setCami(String cami) {
		this.cami = cami;
	}
	
	public StreamedContent getFoto() throws IOException {
		
		if(cami == null || cami.isEmpty()) {
			Path path = Paths.get("C:/Sistema Vendas 2/uploads/imagem.jpg");
			InputStream stream = Files.newInputStream(path);
			foto = new DefaultStreamedContent(stream);
			return foto;
		}else {
			Path path = Paths.get(cami);
			InputStream stream = Files.newInputStream(path);
			foto = new DefaultStreamedContent(stream);
			
		}
		return foto;
	}
	
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

}
