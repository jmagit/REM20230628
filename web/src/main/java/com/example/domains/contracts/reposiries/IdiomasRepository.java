package com.example.domains.contracts.reposiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.domains.entities.Language;

@RepositoryRestResource(path="idiomas", itemResourceRel="idioma", collectionResourceRel="idiomas")
public interface IdiomasRepository extends JpaRepository<Language, Integer> {
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id);
}
