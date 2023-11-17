package com.example.IoC;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigBeans {
	@Bean
	Tonteria unaTonteria() {
		return new Tonteria() {			
			@Override
			public void dime() {
				System.out.println("Soy una tonteria");
			}
		};
	}
	@Bean
	Tonteria unaTonteriaGrande() {
		return new Tonteria() {			
			@Override
			public void dime() {
				System.out.println("Soy una tonteria grande");
			}
		};
	}
//	@Bean
//	Tonteria unaTonteriaDep(Dependencia dep) {
//		return new Tonteria() {			
//			@Override
//			public void dime() {
//				System.out.println("Soy una tonteria dependiente " + dep.getContador());
//			}
//		};
//	}
	
	@Value("${app.version:1}")
	private int _version;
	
	@Bean 
	int version() { return _version; }
	@Bean
	String autor() { return "Yo mismo"; }
	
	@Bean
	@Profile("default")
	OtroComponente otroComponente1() {
		return new OtroComponente() {
			@Override
			public void exec() {
				System.out.println("Soy otro componente de prueba");
			}
		};
	}
	@Bean
	@Profile("test")
	OtroComponente otroComponente() {
		return new OtroComponente() {
			@Override
			public void exec() {
				System.out.println("Soy otro componente de prueba");
			}
		};
	}
}
