package com.example.petclinic.controller;


import com.example.petclinic.model.Owner;
import com.example.petclinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("")
    public ResponseEntity<List<Owner>> getAllOwners(){
          List<Owner> owners= ownerRepository.findAll();
        return new ResponseEntity<List<Owner>>(owners, HttpStatus.OK);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<Owner> getOwner(@PathVariable("ownerId") int ownerId){
        Owner owner = ownerRepository.findById(ownerId).get();
         if(owner == null){
             return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<Owner>(owner, HttpStatus.OK);
    }




}
