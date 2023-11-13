package com.example.IoC;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("antigua")
@Profile("default")
public class InyectableImpl implements Inyectable {
	private Dependencia dep;
	
	public InyectableImpl(Dependencia dep) {
		this.dep = dep;
	}
	
	@Override
	public void run() {
		dep.algo();
		cuantos();
	}
	@Override
	public void add() { dep.add(); }
	@Override
	public void delete() { dep.delete(); }
	@Override
	public void cuantos() { 
		System.out.println("Llevo " + dep.getContador());
	}

}
