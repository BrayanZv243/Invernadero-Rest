package com.controller.service;

import com.planta.service.servicio.IPlantaServicio;
import com.plantaservice.model.Planta;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planta")
public class PlantaController {

    @Autowired
    private IPlantaServicio plantaServicio;

    @PostMapping
    public ResponseEntity<Planta> agregarPlanta(@RequestBody Planta planta) {
        return ResponseEntity.of(Optional.ofNullable(plantaServicio.guardarPlanta(planta)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planta> actualizarPlanta(@PathVariable Integer id, @RequestBody Planta planta) {
        Optional<Planta> plantaEncontrada = plantaServicio.obtenerPlantaPorId(id);

        if (plantaEncontrada.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Planta plantaActualizada = plantaEncontrada.get();

        plantaActualizada.setNombre(planta.getNombre());
        plantaActualizada.setTipo(planta.getTipo());
        plantaActualizada.setHumedad_optima(planta.getHumedad_optima());

        return ResponseEntity.ok(plantaServicio.actualizarPlanta(plantaActualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Planta> eliminarPlanta(@PathVariable Integer id) {
        Optional<Planta> plantaEncontrada = plantaServicio.obtenerPlantaPorId(id);

        if (plantaEncontrada.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        plantaServicio.eliminarPlantaPorId(id);

        return ResponseEntity.ok(plantaEncontrada.get());
    }

    @GetMapping
    public ResponseEntity<List<Planta>> listarPlantas() {
        return ResponseEntity.ok(plantaServicio.listarTodasLasPlantas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planta> obtenerPlantaPorId(@PathVariable Integer id) {
        Optional<Planta> plantaEncontrada = plantaServicio.obtenerPlantaPorId(id);
        if (plantaEncontrada.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(plantaEncontrada.get());
    }
}
