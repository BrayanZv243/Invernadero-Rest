package com.planta.service.servicio;

import com.plantaservice.model.RegistroPlanta;
import com.plantaservice.repository.IRegistroPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroPlantaServicio implements IRegistroPlantaServicio {

    @Autowired
    private IRegistroPlantaRepository repositorio;

    @Override
    public List<RegistroPlanta> listarTodosLosRegistros() {
        return repositorio.findAll();
    }

    @Override
    public RegistroPlanta guardarRegistroPlanta(RegistroPlanta registroPlanta) {
        return repositorio.save(registroPlanta);
    }

    @Override
    public Optional<RegistroPlanta> obtenerRegistroPlantaPorId(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public RegistroPlanta actualizarRegistroPlanta(RegistroPlanta registroPlanta) {
        return repositorio.save(registroPlanta);
    }

    @Override
    public void eliminarRegistroPlantaPorId(Integer id) {
        repositorio.deleteById(id);
    }

}
