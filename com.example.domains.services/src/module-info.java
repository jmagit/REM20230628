module com.example.domains.services {
	requires transitive com.example.domains.entities;
	requires com.example.domains.contracts;
	
	exports com.example.domains.services;
	
	provides com.example.domains.contracts.Config with com.example.domains.services.config.ConfigImpl;
}