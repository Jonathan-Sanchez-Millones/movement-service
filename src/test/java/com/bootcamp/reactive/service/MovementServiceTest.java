package com.bootcamp.reactive.service;

import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootcamp.reactive.entity.Movement;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@WebFluxTest(MovementService.class)
public class MovementServiceTest {

	@MockBean
    MovementService service;

    @Test
    public void when_saveMovement_ok(){
        
    	Mono<Movement> movement= Mono.just(new Movement(null, null, null, 0));
    	
    	when(service.saveMovement(movement)).thenReturn(movement);
		
		StepVerifier.create(movement)
		.expectSubscription()
		.expectNext(new Movement(null, null, null, 0))
		.verifyComplete();

    }
    
    @Test
    public void when_getMovement_ok(){
        
    	Mono<Movement> movement= Mono.just(new Movement("123", null, null, 0));

    	when(service.getMovementById("123")).thenReturn(movement);
    	
        StepVerifier.create(movement)
        .expectSubscription()
		.expectNext(new Movement("123", null, null, 0))
		.verifyComplete();
    }

}
