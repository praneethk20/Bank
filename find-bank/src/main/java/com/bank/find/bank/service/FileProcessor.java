package com.bank.find.bank.service;

import com.bank.find.bank.model.Bank;
import org.springframework.stereotype.Service;

@Service
public class FileProcessor {

    public Bank parseLine(String record) {
        String[] tokens = record.split(",");

        return Bank.builder()
                        .Id(Integer.parseInt(tokens[0]))
                .name(tokens[1])
                .type(tokens[2])
                .city(tokens[3])
                .state(tokens[4])
                .zipCode(Integer.parseInt(tokens[5]))
                .build();
    }
}
