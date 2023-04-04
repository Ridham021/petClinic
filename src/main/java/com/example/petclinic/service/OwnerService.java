package com.example.petclinic.service;

import com.example.petclinic.model.Owner;
import java.util.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface OwnerService  {


   public Owner getOwner(int id);

   public List<Owner> getOwners();

   public void saveOwner(Owner owner);

   public void deleteOwner(int id);




}
