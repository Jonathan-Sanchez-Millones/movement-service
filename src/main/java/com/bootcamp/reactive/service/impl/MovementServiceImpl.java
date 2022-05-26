package com.bootcamp.reactive.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.reactive.entity.Movement;
import com.bootcamp.reactive.repository.MovementRepository;
import com.bootcamp.reactive.service.MovementService;

import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements MovementService{

	@Autowired
	private MovementRepository movementRepository;
	
	@Override
	public Mono<Movement> saveMovement(Mono<Movement> movement) {

		return movement.flatMap(m -> {
			
			return movementRepository.save(m);
		});

	}
	
	@Override
	public Mono<Movement> getMovementById(String id){
		
		return movementRepository.findById(id);
	}
}
