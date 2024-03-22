package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.interfaces.sp.IObtenerDatosSolicitantePropuestaPorIdPropuesta;
import com.comfama.api.propuestasCultura.interfaces.sp.IObtenerTodasLasPropuestas;
import com.comfama.api.propuestasCultura.models.Propuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPropuestaRepository extends JpaRepository<Propuesta,String> {
    @Procedure(procedureName = "sp_obtener_todos_las_propuestas")
    List<IObtenerTodasLasPropuestas>spObtenerTodasLasPropuesta();

    @Procedure(procedureName = "sp_datos_solicitante_propuesta_por_idpropuesta")
    List<IObtenerDatosSolicitantePropuestaPorIdPropuesta> spDatosSolicitantePropuestaPorIdpropuesta(@Param("ID_PROPUESTA_PARAM") String idPropuesta);
}
