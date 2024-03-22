package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.models.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {
}
