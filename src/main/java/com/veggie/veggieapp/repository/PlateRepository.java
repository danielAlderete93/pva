package com.veggie.veggieapp.repository;

import com.veggie.veggieapp.model.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepository extends JpaRepository<Plate,Integer> {
}
