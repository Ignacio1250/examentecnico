package com.ignacio1250.examenpractico.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignacio1250.examenpractico.entities.Gender;

@Repository
public interface IGenderDAO extends CrudRepository<Gender,Integer>{

}
