package com.scf.bankomat.repository;

import com.scf.bankomat.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Integer> {
    public Long countById(Integer id);

    @Query("SELECT p FROM Client p WHERE p.lastname LIKE %?1%")
    public List<Client> findAll(String keyword);



}

