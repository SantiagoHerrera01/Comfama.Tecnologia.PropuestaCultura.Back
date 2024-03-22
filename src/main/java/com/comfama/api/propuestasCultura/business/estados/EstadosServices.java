package com.comfama.api.propuestasCultura.business.estados;

import com.comfama.api.propuestasCultura.repository.IEstadosRepository;
import com.comfama.api.propuestasCultura.models.Estados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadosServices {
    @Autowired
    IEstadosRepository iEstadosRepository;

    //Se listan metodos para accionar la logica de negocio
    //Almacenar en la BD un estado
    public Estados agregarEstado(Estados datosEstado) throws Exception{
        try{
            //Aplicar Validaciones necesarias

            //llamar repositorio
            return this.iEstadosRepository.save(datosEstado);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Estados> buscarTodosLosEstados()throws Exception{
        try {
            return this.iEstadosRepository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Estados buscarEstadoPorId(Integer idEstado) throws Exception{
        try {
            if (this.iEstadosRepository.findById(idEstado).isPresent()){
                System.out.println(this.iEstadosRepository.findById(idEstado).get().getEstado());
                return this.iEstadosRepository.findById(idEstado).get();

            }else {
                throw new Exception("Estado no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



}
