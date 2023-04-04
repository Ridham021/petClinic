package com.example.petclinic.controller;


import com.example.petclinic.model.Owner;
import com.example.petclinic.repository.OwnerRepository;
import com.example.petclinic.service.OwnerService;
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
    private OwnerService ownerService;

    @GetMapping("")
    public ResponseEntity<List<Owner>> getAllOwners(){
          List<Owner> owners= ownerService.getOwners();
        return new ResponseEntity<List<Owner>>(owners, HttpStatus.OK);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<Owner> getOwner(@PathVariable("ownerId") int ownerId){
        Owner owner = ownerService.getOwner(ownerId);
         if(owner == null){
             return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<Owner>(owner, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner){

        owner.setId(0);
        ownerService.saveOwner(owner);

        return new ResponseEntity<Owner>(owner,HttpStatus.OK);
    }

    @DeleteMapping("/{ownerId}")
    public String deleteOwner(@PathVariable("ownerId") int ownerId){

        ownerService.deleteOwner(ownerId);
        return "deleted";
    }

    @PutMapping("/{ownerId}")
    public Owner updateOwner(@PathVariable("ownerId") int ownerId , @RequestBody Owner owner){

        Owner currentOwner = ownerService.getOwner(ownerId);
        currentOwner.setAddress(owner.getAddress());
        currentOwner.setCity(owner.getCity());
        currentOwner.setTelephone(owner.getTelephone());
        currentOwner.setLastName(owner.getLastName());
        currentOwner.setFirstName(owner.getFirstName());

        return currentOwner;

    }






}
