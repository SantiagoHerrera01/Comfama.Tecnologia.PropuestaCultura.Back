package com.comfama.api.propuestasCultura.repository;

import com.comfama.api.propuestasCultura.models.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones,String> {
}
