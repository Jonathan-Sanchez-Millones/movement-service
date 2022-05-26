package com.bootcamp.reactive.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootcamp.reactive.entity.Movement;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class MovementServiceTest {

	@Autowired
    MovementService service;

	Movement mov;
	
    @Test
    public void when_saveMovement_ok(){
        
    	mov = new Movement(); 
        mov.setAmount(1111);
        mov.setType("deposito");
        mov.setMovementDate(LocalDateTime.now().toString());
        StepVerifier.create(service.saveMovement(Mono.just(mov)))
            .expectNext(mov)
            .expectComplete()
            .verify();
    }
    
    @Test
    public void when_getMovement_ok(){
        mov = new Movement();
        mov.setId("6287f8e8c2dd9c5c651125e9");
        mov.setAmount(1500);
        mov.setType("deposito");
        mov.setMovementDate("2022-05-20T15:24:08.173593100");

        StepVerifier.create(service.getMovementById("6287f8e8c2dd9c5c651125e9"))
            .expectNext(mov)
            .expectComplete()
            .verify();
    }

}
