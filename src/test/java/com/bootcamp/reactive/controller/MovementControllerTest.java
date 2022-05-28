package com.bootcamp.reactive.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bootcamp.reactive.entity.Movement;
import com.bootcamp.reactive.service.MovementService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@WebFluxTest(MovementController.class)
public class MovementControllerTest {

	@MockBean
    MovementService service;
	
	@Autowired
	WebTestClient webClient;
	
    @Test
    public void when_saveMovement_ok(){
        
    	Mono<Movement> movement= Mono.just(new Movement(null, null, null, 0));
    	
    	when(service.saveMovement(movement)).thenReturn(movement);
    	
    	webClient.post().uri("/movement")
		.body(Mono.just(movement), Movement.class)
		.exchange()
		.expectStatus().isOk();
		
		StepVerifier.create(movement)
		.expectSubscription()
		.expectNext(new Movement(null, null, null, 0))
		.verifyComplete();

    }
    
    @Test
    public void when_getMovement_ok(){
        
    	Mono<Movement> movement= Mono.just(new Movement("123", null, null, 0));

    	when(service.getMovementById("123")).thenReturn(movement);
    			
		Flux<Movement> responseBody = webClient.get().uri("/movement/123")
		.exchange()
		.expectStatus().isOk()
		.returnResult(Movement.class)
		.getResponseBody();
    	
        StepVerifier.create(responseBody)
        .expectSubscription()
		.expectNext(new Movement("123", null, null, 0))
		.verifyComplete();
    }
}
