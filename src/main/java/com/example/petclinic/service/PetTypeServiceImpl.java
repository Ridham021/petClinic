package com.example.petclinic.service;

import com.example.petclinic.model.PetType;
import com.example.petclinic.repository.PetTypeRepository;
import com.example.petclinic.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeServiceImpl implements PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;
    @Override
    public List<PetType> getPetTypes() {
        return petTypeRepository.findAll();
    }

    @Override
    public PetType getPetType(int petTypeId) {
        return petTypeRepository.getById(petTypeId);
    }

    @Override
    public PetType savePetType(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void deletePetType(int petTypeId) {

        PetType pType = petTypeRepository.getById(petTypeId);
        petTypeRepository.delete(pType);

    }
}
