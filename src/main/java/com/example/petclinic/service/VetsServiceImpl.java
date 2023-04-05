package com.example.petclinic.service;

import com.example.petclinic.model.Vets;
import com.example.petclinic.repository.VetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VetsServiceImpl implements VetsService{


    @Autowired
    private VetRepository vetRepository ;
    @Override
    @Transactional
    public Vets getVet(int vetId) {
        return vetRepository.getById(vetId);
    }

    @Override
    @Transactional
    public List<Vets> getAllVets() {
        return vetRepository.findAll();
    }

    @Override
    @Transactional
    public Vets addVet(Vets vet) {
        return vetRepository.save(vet);

    }

    @Override
    @Transactional
    public void deleteVet(int vetId) {
         vetRepository.delete(vetRepository.getById(vetId));
    }
}
