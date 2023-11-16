package com.example.domains.contracts.reposiries;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domains.core.contracts.repositories.RepositoryWithProjections;
import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.ActorShort;

@RepositoryRestResource(exported = false)
public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor>,
	RepositoryWithProjections {
	List<Actor> findTop5ByFirstNameStartingWithOrderByLastName(String prefijo);
	List<Actor> findTop5ByFirstNameStartingWith(String prefijo, Sort orderBy);
	
	List<Actor> findByActorIdGreaterThan(int id);
	
	@Query(value = "from Actor a where a.actorId > ?1")
	List<Actor> findNovedadesJPQL(int id);
	@Query(value = "select * from actor a where a.actor_id > :id", nativeQuery = true)
	List<Actor> findNovedadesSQL(int id);
	@Query(name="Actor.findAll")
	List<Actor> findByQueryName();

	List<ActorDTO> readByActorIdGreaterThan(int id);
	List<ActorShort> queryByActorIdGreaterThan(int id);
	<T> List<T> getByActorIdGreaterThan(int id, Class<T> proyeccion);

}
