package com.bootcamp.reactive.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.reactive.entity.Movement;
import com.bootcamp.reactive.repository.MovementRepository;

import reactor.core.publisher.Mono;

@Service
public class MovementService {

	@Autowired
	private MovementRepository movementRepository;
	

	public Mono<Movement> saveMovement(Mono<Movement> movement) {

		return movement.flatMap(m -> {
			
			return movementRepository.insert(m);
		});

	}
	
	public Mono<Movement> getMovementById(String id){
		
		return movementRepository.findById(id);
	}
}
