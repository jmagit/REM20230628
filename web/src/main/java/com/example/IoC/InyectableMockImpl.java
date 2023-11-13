package com.example.IoC;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("nueva")
@Profile("test")
public class InyectableMockImpl implements Inyectable {
	@Override
	public void run() {
		System.err.println("Soy la simulacion");
	}
	@Override
	public void add() {  }
	@Override
	public void delete() {  }
	@Override
	public void cuantos() { 
		System.out.println("Llevo 0");
	}

}
