package com.comfama.api.propuestasCultura.mapper;

import com.comfama.api.propuestasCultura.domain.solicitante.SolicitanteGuardarDTO;
import com.comfama.api.propuestasCultura.domain.solicitante.SolicitanteObtenerDTO;
import com.comfama.api.propuestasCultura.models.Solicitante;
import org.springframework.stereotype.Component;

@Component
public class SolicitantesMapper {
    public Solicitante toSolicitante(SolicitanteGuardarDTO dto) {
        return Solicitante.builder()
                .nombreProponente(dto.getNombreProponente())
                .nombres(dto.getNombres())
                .apellidos(dto.getApellidos())
                .numeroDocumento(dto.getNumeroDocumento())
                .telefonoFijo(dto.getTelefonoFijo())
                .telefonoCelular(dto.getTelefonoCelular())
                .correo(dto.getCorreo())
                .build();
    }

    public SolicitanteObtenerDTO toSolicitanteDTO(Solicitante entity) {
        return SolicitanteObtenerDTO.builder()
                .idSolicitante(entity.getIdSolicitante())
                .nombreProponente(entity.getNombreProponente())
                .nombres(entity.getNombres())
                .apellidos(entity.getApellidos())
                .tipoDocumento(entity.getTipoDocumento())
                .numeroDocumento(entity.getNumeroDocumento())
                .telefonoFijo(entity.getTelefonoFijo())
                .telefonoCelular(entity.getTelefonoCelular())
                .correo(entity.getCorreo())
                .build();
    }

    public SolicitanteGuardarDTO toSolicitanteGuardar(Solicitante entity, SolicitanteGuardarDTO dto) {
        return SolicitanteGuardarDTO.builder()
                .idSolicitante(entity.getIdSolicitante())
                .nombreProponente(entity.getNombreProponente())
                .idTipoDocumento(dto.getIdTipoDocumento())
                .nombres(entity.getNombres())
                .apellidos(entity.getApellidos())
                .numeroDocumento(entity.getNumeroDocumento())
                .telefonoFijo(entity.getTelefonoFijo())
                .telefonoCelular(entity.getTelefonoCelular())
                .correo(entity.getCorreo())
                .build();
    }

    public void toSolicitanteActualizar(SolicitanteGuardarDTO dto, Solicitante solicitanteExistente) {
        solicitanteExistente.setIdSolicitante(dto.getIdSolicitante());
        solicitanteExistente.setNombreProponente(dto.getNombreProponente());
        solicitanteExistente.setNombres(dto.getNombres());
        solicitanteExistente.setApellidos(dto.getApellidos());
        solicitanteExistente.setNumeroDocumento(dto.getNumeroDocumento());
        solicitanteExistente.setTelefonoFijo(dto.getTelefonoFijo());
        solicitanteExistente.setTelefonoCelular(dto.getTelefonoCelular());
        solicitanteExistente.setCorreo(dto.getCorreo());
    }

}
