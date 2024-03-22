package com.comfama.api.propuestasCultura.business.notificaciones;

import com.comfama.api.propuestasCultura.models.Notificaciones;
import com.comfama.api.propuestasCultura.repository.INotificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionesBusiness {
    @Autowired
    INotificacionesRepository iNotificacionesRepository;



    public List<Notificaciones> obtenerTodosNotificaciones()throws Exception{
        try {
            return this.iNotificacionesRepository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Notificaciones buscarNotificacionPorId(String idNotificacion) throws Exception{
        try {
            if (this.iNotificacionesRepository.findById(idNotificacion).isPresent()){
                System.out.println(this.iNotificacionesRepository.findById(idNotificacion).get().getIdNotificacion());
                return this.iNotificacionesRepository.findById(idNotificacion).get();

            }else {
                throw new Exception("Notificacion no encontrada");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Notificaciones agregarNotificacion(Notificaciones datosNotificaciones) throws Exception{
        try{
            //Aplicar Validaciones necesarias

            //llamar repositorio
            return this.iNotificacionesRepository.save(datosNotificaciones);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
