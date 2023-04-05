package com.example.petclinic.service;

import com.example.petclinic.model.Vets;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VetsService {

    public Vets getVet(int vetId);

    public List<Vets> getAllVets();

    public Vets addVet(Vets vet);

    public void deleteVet(int vetId);
}
