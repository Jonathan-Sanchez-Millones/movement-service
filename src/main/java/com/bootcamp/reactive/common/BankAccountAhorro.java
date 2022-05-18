package com.bootcamp.reactive.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountAhorro {

    private String id;
    private double saldo;
    private long pan;
    private int cvv;
    private List<String> movements;
}
