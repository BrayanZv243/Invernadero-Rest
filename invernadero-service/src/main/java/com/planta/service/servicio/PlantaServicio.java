package com.planta.service.servicio;

import com.plantaservice.model.Planta;
import com.plantaservice.repository.IPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlantaServicio implements IPlantaServicio {
    
    @Autowired
    private IPlantaRepository repositorio;
    
    @Override
    public List<Planta> listarTodasLasPlantas() {
        return repositorio.findAll();
    }

    @Override
    public Planta guardarPlanta(Planta planta) {
        return repositorio.save(planta);
    }

    @Override
    public Optional<Planta> obtenerPlantaPorId(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public Planta actualizarPlanta(Planta planta) {
        return repositorio.save(planta);
    }

    @Override
    public void eliminarPlantaPorId(Integer id) {
        repositorio.deleteById(id);
    }
    
    
}
