package com.example.IoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class OtroComponente {
	@Autowired
	private Dependencia dep;
	
	public void exec() {
		dep.algo();
		System.out.println("Llevo " + dep.getContador());
	}

}
