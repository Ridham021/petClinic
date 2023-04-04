package com.example.petclinic.service;

import com.example.petclinic.model.Pet;
import com.example.petclinic.repository.PetsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsServiceImpl implements PetsService{


    @Autowired
    private PetsRepository petsRepository;
    @Override
    @Transactional
    public List<Pet> getPets() {

        return petsRepository.findAll();

    }

    @Override
    @Transactional
    public Pet getPet(int petId) {
        return petsRepository.findById(petId).get();
    }

    @Override
    @Transactional
    public Pet savePet(Pet pet) {

        return petsRepository.save(pet);
    }

    @Override
    @Transactional
    public void deletePet(int petId) {

        petsRepository.delete(petsRepository.getById(petId));

    }
}
