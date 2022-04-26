package com.bank.find.bank.repo;

import com.bank.find.bank.model.Bank;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BankRepository {

    private Set<Bank> bankDetails = new HashSet<>();

    public boolean addBank(Bank bank) {
        return bankDetails.add(bank);
    }

    public boolean addBank(List<Bank> bank) {
        return bankDetails.addAll(bank);
    }

    public Set<Bank>  findAll(){
        return this.bankDetails;
    }

}
