package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.models.FormatosAdjuntosSolicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormatosAdjuntosSolicitanteRepository extends JpaRepository<FormatosAdjuntosSolicitante, Integer> {
    @Query(value = "SELECT * FROM  formatos_adjuntos_solicitante  WHERE id_propuesta = :idPropuesta", nativeQuery = true)
    FormatosAdjuntosSolicitante obtenerPorIdPropuesta(@Param("idPropuesta") String idPropuesta);
}
