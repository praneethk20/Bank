package com.bank.find.bank.api;

import com.bank.find.bank.model.Bank;
import com.bank.find.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bank-finder")
public class BankSearchController {
    @Autowired
    BankService bankService;

    @GetMapping("/{type}/{value}")
    public ResponseEntity<Set<Bank>> findByCriteria(@PathVariable String type, @PathVariable String value) {
        try {
            return new ResponseEntity<>(bankService.findByBank(type, value), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/by-state-city/{state}/{city}")
    public ResponseEntity<Set<Bank>> findByStateAndCity(@PathVariable String state, @PathVariable String city) {
        return new ResponseEntity<>(bankService.findByStateAndCity(state, city), HttpStatus.OK);
    }
}
