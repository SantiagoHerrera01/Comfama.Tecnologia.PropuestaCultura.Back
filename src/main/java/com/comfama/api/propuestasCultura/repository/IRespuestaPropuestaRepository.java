package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.models.RespuestaPropuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRespuestaPropuestaRepository extends JpaRepository<RespuestaPropuesta, Integer> {
    @Query(value = "SELECT * FROM  respuestas_propuestas  WHERE id_propuesta = :idPropuesta", nativeQuery = true)
    List<RespuestaPropuesta> obtenerPorIdPropuesta(@Param("idPropuesta") String idPropuesta);
}
