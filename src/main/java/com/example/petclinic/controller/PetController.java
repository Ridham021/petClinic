package com.example.petclinic.controller;

import com.example.petclinic.model.Pet;
import com.example.petclinic.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {


    @Autowired
    private PetsService petsService;

    @GetMapping("")
    public ResponseEntity<List<Pet>> getAllPets(){

        System.out.println(petsService.getPets());
        return new ResponseEntity<List<Pet>>(petsService.getPets(), HttpStatus.OK);
    }

    @GetMapping("/{petId}")
    public Pet getPetById(@PathVariable("petId") int petId){
        System.out.println(petsService.getPet(petId));
        return petsService.getPet(petId);
    }

    @PostMapping("")
    public Pet addPet(@RequestBody Pet pet){

        pet.setId(0);
        System.out.println(pet.toString());

        return petsService.savePet(pet);
    }

    @DeleteMapping("/{petId}")
    public String deletePet(@PathVariable("petId") int petId)
    {
        petsService.deletePet(petId);
        return "deleted";
    }


}
