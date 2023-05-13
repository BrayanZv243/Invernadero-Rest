/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller.service;

import com.planta.service.servicio.IPlantaServicio;
import com.planta.service.servicio.IRegistroPlantaServicio;
import com.plantaservice.model.Planta;
import com.plantaservice.model.RegistroPlanta;

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
@RequestMapping("/planta/registro_planta")
public class RegistroPlantaController {

    @Autowired
    private IRegistroPlantaServicio registroPlantaServicio;

    @Autowired
    private IPlantaServicio plantaServicio;

    @PostMapping
    public ResponseEntity<RegistroPlanta> agregarRegistroPlanta(@RequestBody RegistroPlanta registroPlanta) {

        Optional<Planta> plantaEncontrada = plantaServicio.obtenerPlantaPorId(registroPlanta.getPlanta().getId_planta());

        if (plantaEncontrada.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        registroPlanta.setPlanta(plantaEncontrada.get());

        return ResponseEntity.ok(registroPlantaServicio.guardarRegistroPlanta(registroPlanta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroPlanta> actualizarRegistroPlanta(@PathVariable Integer id, @RequestBody RegistroPlanta registroPlanta) {
        Optional<Planta> plantaEncontrada = plantaServicio.obtenerPlantaPorId(registroPlanta.getPlanta().getId_planta());

        if (plantaEncontrada.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<RegistroPlanta> registroEncontrado = registroPlantaServicio.obtenerRegistroPlantaPorId(id);

        if (registroEncontrado.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        RegistroPlanta registroActualizado = registroEncontrado.get();

        registroActualizado.setPlanta(plantaEncontrada.get());
        registroActualizado.setUltima_humedad(registroPlanta.getUltima_humedad());
        registroActualizado.setUltima_humedad(registroPlanta.getUltima_humedad());

        return ResponseEntity.ok(registroPlantaServicio.actualizarRegistroPlanta(registroActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroPlanta> eliminarRegistroPlanta(@PathVariable Integer id) {
        Optional<RegistroPlanta> registroPlantaEncontrado = registroPlantaServicio.obtenerRegistroPlantaPorId(id);

        if (registroPlantaEncontrado.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        registroPlantaServicio.eliminarRegistroPlantaPorId(id);

        return ResponseEntity.ok(registroPlantaEncontrado.get());
    }

    @GetMapping
    public ResponseEntity<List<RegistroPlanta>> listarRegistrosPlantas() {
        return ResponseEntity.ok(registroPlantaServicio.listarTodosLosRegistros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroPlanta> obtenerRegistroPlantaPorId(@PathVariable Integer id) {
        Optional<RegistroPlanta> registroPlantaEncontrado = registroPlantaServicio.obtenerRegistroPlantaPorId(id);
        if (registroPlantaEncontrado.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(registroPlantaEncontrado.get());
    }

}
