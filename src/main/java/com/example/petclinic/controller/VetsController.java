package com.example.petclinic.controller;

import com.example.petclinic.model.Vets;
import com.example.petclinic.service.VetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vets")
public class VetsController {

    @Autowired
    private VetsService vetsService;

    @GetMapping("")
    public ResponseEntity<List<Vets>> getAllVets(){
        List<Vets> vets = vetsService.getAllVets();
        return new ResponseEntity<List<Vets>>(vets , HttpStatus.OK);
    }


    @GetMapping("/{vetId}")
    public ResponseEntity<Vets> getVetById(@PathVariable("vetId") int vetId){
        Vets vet = vetsService.getVet(vetId) ;
        return new ResponseEntity<Vets>(vet , HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Vets> addVet(@RequestBody Vets vet){
        vet.setId(0);
        Vets v = vetsService.addVet(vet);
        return new ResponseEntity<Vets>(v,HttpStatus.OK);
    }

    @PutMapping("/{vetId}")
    public ResponseEntity<Vets> updateVet(@PathVariable("vetId") int vetId , @RequestBody Vets vet){
        Vets v = vetsService.getVet(vetId);
        v.setFirstName(vet.getFirstName());
        v.setLastName(vet.getLastName());
        vetsService.addVet(v);
        return new ResponseEntity<Vets>(v,HttpStatus.OK);

    }

    @DeleteMapping("{vetId}")
    public String deleteVet(@PathVariable("vetId") int vetId){
        vetsService.deleteVet(vetId);
        return "deleted";
    }
}
