package com.plantaservice.repository;

import com.plantaservice.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlantaRepository extends JpaRepository<Planta, Integer>{
    
}
