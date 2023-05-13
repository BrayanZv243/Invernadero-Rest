package com.plantaservice.repository;

import com.plantaservice.model.RegistroPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistroPlantaRepository extends JpaRepository<RegistroPlanta, Integer>{
    
}
