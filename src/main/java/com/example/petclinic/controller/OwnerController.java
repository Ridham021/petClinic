package com.example.petclinic.controller;


import com.example.petclinic.Handler.ResponseBodyObj;
import com.example.petclinic.Handler.ResponseError;
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
        System.out.println("Haa me yaaha hu");
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

    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable("id") int ownerId ,  @RequestBody Owner owner){

        Owner currentOwner = ownerService.getOwner(ownerId);
        System.out.println(owner);
        owner.setId(0);
        ownerService.saveOwner(owner);
        currentOwner.setAddress(owner.getAddress());
        currentOwner.setCity(owner.getCity());
        currentOwner.setTelephone(owner.getTelephone());
        currentOwner.setLastName(owner.getLastName());
        currentOwner.setFirstName(owner.getFirstName());

        return ownerService.getOwner(currentOwner.getId());

    }
    @ExceptionHandler(value = jakarta.persistence.NoResultException.class)
    public ResponseEntity<ResponseBodyObj> handleNullPointer(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = java.sql.SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleIntegrity(){
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST, "Please match the constraunts");
        return new ResponseEntity<ResponseError>(error,HttpStatus.BAD_REQUEST);
    }







}
