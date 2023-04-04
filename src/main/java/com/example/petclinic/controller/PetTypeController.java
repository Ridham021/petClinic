package com.example.petclinic.controller;

import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import com.example.petclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("petTypes")
public class PetTypeController {

    @Autowired
    private PetTypeService petTypeService;

    @GetMapping("")
    public List<PetType> getAllPetTypes(){
        return petTypeService.getPetTypes();
    }

    @GetMapping("/{petTypeId}")
    public PetType getPetTypeById(@PathVariable("petTypeId") int petTypeId){
        System.out.println(petTypeService.getPetType(petTypeId).toString());
        PetType p = petTypeService.getPetType(petTypeId);
        return p;
    }

    @PostMapping("")
    public PetType addPetType(@RequestBody PetType petType){
        petType.setId(0);
        return petTypeService.savePetType(petType);
    }

    @DeleteMapping("/{petTypeId}")
    public String deletePetType(@PathVariable("petTypeId")int petTypeId){
        petTypeService.deletePetType(petTypeId);
        return "deleted";
    }

    @PutMapping("/{petTypeId}")
    public PetType updatePetType(@PathVariable("petTypeId") int petTypeId , @RequestBody PetType petType){
      //  PetType pType = petType;
        System.out.println(petType.toString()+"========================================");
        PetType p = petTypeService.getPetType(petTypeId);
        System.out.println(p.toString());
        System.out.println(petType.getName());
        p.setName(petType.getName());

        return p;
    }


}
