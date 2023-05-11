package com.planta.service.servicio;

import com.plantaservice.model.Planta;
import java.util.List;

public interface IPlantaServicio {
    List<Planta> listarTodasLasPlantas();

    Planta guardarPlanta(Planta planta);

    Planta obtenerPlantaPorId(Integer id);

    Planta actualizarPlanta(Planta planta);

    void eliminarPlantaPorId(Integer id);
    
}
