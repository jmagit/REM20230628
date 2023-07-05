module com.example.infraestructure {
	requires com.example.util;
	requires com.example.domains.contracts;
	requires java.sql;
	
	exports com.example.infraestructure.repositories;
	
	provides com.example.domains.contracts.Config with com.example.infraestructure.config.ConfigImpl;
}