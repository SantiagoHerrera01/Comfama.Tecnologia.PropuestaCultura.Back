package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.models.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitanteRepository extends JpaRepository<Solicitante,Integer> {

}
