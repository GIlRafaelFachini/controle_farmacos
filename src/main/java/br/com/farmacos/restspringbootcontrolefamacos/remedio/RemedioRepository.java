package br.com.farmacos.restspringbootcontrolefamacos.remedio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

	List<Remedio> findAllByAtivoTrue();

	@Query
	Remedio findByNome(@Param("name") String name);

}

