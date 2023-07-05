module com.examples.main {
	requires java.sql;
	requires com.examples.contracts;
	requires transitive com.examples.domains.services;
	exports com.examples.main;
        
	uses com.examples.contracts.Configuracion;
}