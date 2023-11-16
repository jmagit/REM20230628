package com.example.domains.contracts.reposiries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.domains.entities.Film;

@RepositoryRestResource(path="peliculas", itemResourceRel="pelicula", collectionResourceRel="peliculas")
public interface FilmRepository extends JpaRepository<Film, Integer> {
	@RestResource(path = "clasificacion")
	List<Film> findByRating(String tipo);
}
