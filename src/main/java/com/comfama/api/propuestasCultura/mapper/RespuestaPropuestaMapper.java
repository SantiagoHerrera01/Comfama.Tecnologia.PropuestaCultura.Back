package com.comfama.api.propuestasCultura.mapper;

import com.comfama.api.propuestasCultura.domain.respuestaPropuesta.RespuestaPropuestaGuardarDTO;
import com.comfama.api.propuestasCultura.domain.respuestaPropuesta.RespuestaPropuestaObtenerDTO;
import com.comfama.api.propuestasCultura.helpers.NegocioRespuestaPropuesta;
import com.comfama.api.propuestasCultura.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RespuestaPropuestaMapper {

    public RespuestaPropuestaObtenerDTO toRespuestaPropuestaObtenerDTO(RespuestaPropuesta entity) {
        return RespuestaPropuestaObtenerDTO.builder()
                .idRespuestaPropuesta(entity.getIdRespuestaPropuesta())
                .idPropuesta(entity.getPropuesta().getIdPropuesta())
                .fechaRecepcion(entity.getFechaRecepcion())
                .consultaListasPublicas(entity.getConsultaListasPublicas())
                .nombreArea(entity.getAreaEncargada().getNombreArea())
                .negocio(entity.getNegocio().name())
                .observaciones(entity.getObservaciones())
                .montoAprobadoPorCultura(entity.getMontoAprobadoPorCultura())
                .encargadoRespuesta(entity.getEncargadoRespuesta())
                .estado(entity.getEstado().getEstado())
                .fechaCreacion(entity.getFechaCreacion())
                .nombreUsuario(entity.getUsuarios().getNombreUsuario())
                .build();
    }

    public RespuestaPropuesta toRespuestaPropuesta(RespuestaPropuestaGuardarDTO dto) {
        var propuesta = Propuesta.builder().idPropuesta(dto.getIdPropuesta()).build();
        var area = AreaEncargada.builder().idAreaEncargada(dto.getIdAreaEncargada()).build();
        var negocio = NegocioRespuestaPropuesta.valueOf(dto.getNegocio());
        var estado = Estados.builder().idEstado(dto.getIdEstado()).build();
        var usuario = Usuarios.builder().idUsuario(dto.getIdUsuario()).build();
        return RespuestaPropuesta.builder()
                .propuesta(propuesta)
                .fechaRecepcion(dto.getFechaRecepcion())
                .consultaListasPublicas(dto.getConsultaListasPublicas())
                .areaEncargada(area)
                .negocio(negocio)
                .observaciones(dto.getObservaciones())
                .montoAprobadoPorCultura(dto.getMontoAprobadoPorCultura())
                .encargadoRespuesta(dto.getEncargadoRespuesta())
                .estado(estado)
                .fechaCreacion(dto.getFechaCreacion())
                .usuarios(usuario)
                .build();
    }

    public List<RespuestaPropuestaObtenerDTO> toRespuestaPropuestaObtenerListDTO(List<RespuestaPropuesta> entityList) {
        var DTOList = new ArrayList<RespuestaPropuestaObtenerDTO>();
        if (entityList != null) {
            entityList.forEach(entity -> DTOList.add(toRespuestaPropuestaObtenerDTO(entity)));
        }
        return DTOList;
    }
}

