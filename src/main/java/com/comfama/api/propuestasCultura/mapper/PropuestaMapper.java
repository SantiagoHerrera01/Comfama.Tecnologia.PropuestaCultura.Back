package com.comfama.api.propuestasCultura.mapper;

import com.comfama.api.propuestasCultura.domain.propuesta.PropuestaGuardarDTO;
import com.comfama.api.propuestasCultura.domain.propuesta.PropuestaObtenerDTO;
import com.comfama.api.propuestasCultura.domain.propuesta.ContraprestacionesDTO;
import com.comfama.api.propuestasCultura.models.Propuesta;
import com.comfama.api.propuestasCultura.repository.IAreaEncargadaRepository;
import org.springframework.stereotype.Component;

@Component
public class PropuestaMapper {
    IAreaEncargadaRepository areaEncargadaRepository;

    public PropuestaObtenerDTO toPropuestaDTO(Propuesta entity){
        return PropuestaObtenerDTO.builder()
                .idPropuesta(entity.getIdPropuesta())
                .departamento(entity.getDepartamento())
                .municipio(entity.getMunicipio())
                .nombrePropuesta(entity.getNombrePropuesta())
                .fechaInicioEvento(entity.getFechaInicioEvento())
                .fechaFinEvento(entity.getFechaFinEvento())
                .presentacionGeneral(entity.getPresentacionGeneral())
                .fechaPresentacionPropuesta(entity.getFechaPresentacionPropuesta())
                .descripcionActividades(entity.getDescripcionActividades())
                .tipoPoblacion(entity.getTipoPoblacion())
                .numeroPersonas(entity.getNumeroPersonas())
                .entidadesAliadas(entity.getEntidadesAliadas())
                .trayectoria(entity.getTrayectoria())
                .contraprestaciones(entity.getContraprestaciones())
                .valorTotal(entity.getValorTotal())
                .aporteComfamaMonetario(entity.getAporteComfamaMonetario())
                .aporteComfamaEspecie(entity.getAporteComfamaEspecie())
                .porcentajeAporteComfama(entity.getPorcentajeAporteComfama())
                .solicitante(entity.getSolicitante())
                .estado(entity.getEstado())
                .areaEncargada(entity.getAreaEncargada())
                .build();
    }

    public PropuestaGuardarDTO toPropuestaGuardarDTO(Propuesta entity, PropuestaGuardarDTO dto){
        return PropuestaGuardarDTO.builder()
                .idPropuesta(entity.getIdPropuesta())
                .departamento(entity.getDepartamento())
                .municipio(entity.getMunicipio())
                .nombrePropuesta(entity.getNombrePropuesta())
                .fechaInicioEvento(entity.getFechaInicioEvento())
                .fechaFinEvento(entity.getFechaFinEvento())
                .presentacionGeneral(entity.getPresentacionGeneral())
                .fechaPresentacionPropuesta(entity.getFechaPresentacionPropuesta())
                .descripcionActividades(entity.getDescripcionActividades())
                .tipoPoblacion(entity.getTipoPoblacion())
                .numeroPersonas(entity.getNumeroPersonas())
                .entidadesAliadas(entity.getEntidadesAliadas())
                .trayectoria(entity.getTrayectoria())
                .idSolicitante(entity.getSolicitante().getIdSolicitante())
                .idEstado(entity.getEstado().getIdEstado())
                .idAreaEncargada(entity.getAreaEncargada().getIdAreaEncargada())
                .estadoEntidadesAliadas(dto.getEstadoEntidadesAliadas())
                .build();
    }


    public Propuesta toPropuesta (PropuestaGuardarDTO dto){
        return Propuesta
                .builder()
                .idPropuesta(dto.getIdPropuesta())
                .departamento(dto.getDepartamento())
                .municipio(dto.getMunicipio())
                .nombrePropuesta(dto.getNombrePropuesta())
                .fechaInicioEvento(dto.getFechaInicioEvento())
                .fechaFinEvento(dto.getFechaFinEvento())
                .presentacionGeneral(dto.getPresentacionGeneral())
                .fechaPresentacionPropuesta(dto.getFechaPresentacionPropuesta())
                .descripcionActividades(dto.getDescripcionActividades())
                .tipoPoblacion(dto.getTipoPoblacion())
                .numeroPersonas(dto.getNumeroPersonas())
                .entidadesAliadas(dto.getEntidadesAliadas())
                .trayectoria(dto.getTrayectoria())
                .build();
    }

    public void toActualizarPropuesta(PropuestaGuardarDTO dto, Propuesta propuestaExistente) {
        propuestaExistente.setDepartamento(dto.getDepartamento());
        propuestaExistente.setMunicipio(dto.getMunicipio());
        propuestaExistente.setNombrePropuesta(dto.getNombrePropuesta());
        propuestaExistente.setFechaInicioEvento(dto.getFechaInicioEvento());
        propuestaExistente.setFechaFinEvento(dto.getFechaFinEvento());
        propuestaExistente.setPresentacionGeneral(dto.getPresentacionGeneral());
        propuestaExistente.setFechaPresentacionPropuesta(dto.getFechaPresentacionPropuesta());
        propuestaExistente.setDescripcionActividades(dto.getDescripcionActividades());
        propuestaExistente.setTipoPoblacion(dto.getTipoPoblacion());
        propuestaExistente.setNumeroPersonas(dto.getNumeroPersonas());
        propuestaExistente.setEntidadesAliadas(dto.getEntidadesAliadas());
        propuestaExistente.setTrayectoria(dto.getTrayectoria());
    }

    public void actualizarPropuestaDesdeContraprestacionesDTO(Propuesta propuesta, ContraprestacionesDTO dto) {
        propuesta.setContraprestaciones(dto.getContraprestaciones());
        propuesta.setAporteComfamaEspecie(dto.getAporteComfamaEspecie());
        propuesta.setAporteComfamaMonetario(dto.getAporteComfamaMonetario());
        propuesta.setPorcentajeAporteComfama(dto.getPorcentajeAporteComfama());
        propuesta.setValorTotal(dto.getValorTotal());
    }


}
