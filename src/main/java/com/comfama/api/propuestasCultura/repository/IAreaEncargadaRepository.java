package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.models.AreaEncargada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAreaEncargadaRepository extends JpaRepository<AreaEncargada, Integer> {
}
