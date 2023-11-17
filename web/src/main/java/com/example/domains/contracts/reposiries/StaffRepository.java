package com.example.domains.contracts.reposiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domains.entities.Staff;
import com.example.domains.entities.dtos.EmpleadoProjetion;

@RepositoryRestResource(path="empleados", itemResourceRel="empleado", 
	collectionResourceRel="empleados", excerptProjection = EmpleadoProjetion.class)
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
