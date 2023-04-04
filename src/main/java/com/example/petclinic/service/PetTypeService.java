package com.example.petclinic.service;

import com.example.petclinic.model.PetType;

import java.util.List;

public interface PetTypeService {

    public List<PetType> getPetTypes();

    public PetType getPetType(int petTypeId);

    public PetType savePetType(PetType petType);

    public void deletePetType(int petTypeId);
}
