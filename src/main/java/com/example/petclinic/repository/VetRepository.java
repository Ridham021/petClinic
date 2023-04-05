package com.example.petclinic.repository;

import com.example.petclinic.model.Vets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vets,Integer> {
}
