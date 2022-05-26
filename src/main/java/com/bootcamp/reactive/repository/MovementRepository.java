package com.bootcamp.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;

import com.bootcamp.reactive.entity.Movement;


public interface MovementRepository extends ReactiveCrudRepository<Movement,String>{

}
