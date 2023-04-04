package com.example.petclinic.service;

import com.example.petclinic.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetsService {
    public List<Pet> getPets();

    public Pet getPet(int petId);

    public Pet savePet(Pet pet);

    public void  deletePet(int prtId);

}
