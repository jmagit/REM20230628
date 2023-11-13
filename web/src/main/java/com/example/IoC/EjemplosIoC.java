package com.example.IoC;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;

@Controller
public class EjemplosIoC {
	@Autowired
	private Rango rango;

	private int version;
	private String autor;

	@ConstructorProperties({"version", "autor"})
	public EjemplosIoC(int version, String autor) {
		super();
		this.version = version;
		this.autor = autor;
//		System.err.println((rango == null ? "sin rango" : rango.toString()));
	}

	@PostConstruct
	private void init() {
		System.err.println("Rectificando version");
		this.version = Math.min(rango.getMax(), Math.max(rango.getMin(), version));
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "EjemplosIoC [version=" + version + ", autor=" + autor  + ", rango=" + 
			(rango == null ? "sin rango" : rango.toString()) + "]";
	}
	
	
}
