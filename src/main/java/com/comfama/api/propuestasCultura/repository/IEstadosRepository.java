package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.models.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadosRepository extends JpaRepository<Estados, Integer> {

}
