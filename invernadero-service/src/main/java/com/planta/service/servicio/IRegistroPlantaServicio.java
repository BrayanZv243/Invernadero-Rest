package com.planta.service.servicio;

import com.plantaservice.model.RegistroPlanta;
import java.util.List;
import java.util.Optional;

public interface IRegistroPlantaServicio {

    List<RegistroPlanta> listarTodosLosRegistros();

    RegistroPlanta guardarRegistroPlanta(RegistroPlanta registroPlanta);

    Optional<RegistroPlanta> obtenerRegistroPlantaPorId(Integer id);

    RegistroPlanta actualizarRegistroPlanta(RegistroPlanta registroPlanta);

    void eliminarRegistroPlantaPorId(Integer id);
}
