package com.bootcamp.reactive.service;

import com.bootcamp.reactive.entity.Movement;

import reactor.core.publisher.Mono;

public interface MovementService {
	
	Mono<Movement> saveMovement(Mono<Movement> m);

	Mono<Movement> getMovementById(String id);
}
