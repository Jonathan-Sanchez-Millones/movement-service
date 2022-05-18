package com.bootcamp.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.reactive.entity.Movement;
import com.bootcamp.reactive.service.MovementService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movement")
public class MovementController {

	@Autowired
	private MovementService service;
	
	@PostMapping
    public Mono<Movement> saveMovement(@RequestBody Mono<Movement> movement){
        return service.saveMovement(movement);
    }
	
	@GetMapping("/{id}")
    public Mono<Movement> getMovementById(@PathVariable String id){
        return service.getMovementById(id);
	}
}
