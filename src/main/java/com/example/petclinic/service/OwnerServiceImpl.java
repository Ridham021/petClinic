package com.example.petclinic.service;

import com.example.petclinic.Handler.OwnerException;
import com.example.petclinic.Handler.OwnerExceptionHandler;
import com.example.petclinic.model.Owner;
import com.example.petclinic.repository.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;
    @Override
    @Transactional
    public Owner getOwner(int id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        System.out.println("=============================================================================");
        if(!owner.isEmpty())
        {
            return ownerRepository.findById(id).get();

        }
        else {
            throw new OwnerExceptionHandler("This is not found");

        }

    }

    @Override
    @Transactional
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveOwner(Owner owner) {
           ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public void deleteOwner(int id) {
        Owner o = ownerRepository.findById(id).get();
       ownerRepository.delete(o);
    }
}
