module com.example.main {
	requires transitive com.example.domains.services;
	requires transitive com.example.infraestructure;
	
	requires com.example.domains.contracts;
	uses com.example.domains.contracts.Config;
}