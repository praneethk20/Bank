package com.bank.find.bank.service;

import com.bank.find.bank.exception.InvalidInputException;
import com.bank.find.bank.model.Bank;
import com.bank.find.bank.repo.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public boolean addAll(List<Bank> bankList) {
        return bankRepository.addBank(bankList);
    }

    public Set<Bank> findAll() {
        return bankRepository.findAll();
    }

    public Set<Bank> findByBank(String searchType, String searchValue) throws InvalidInputException {
        if ("name,type,city,state,zipcode".contains(searchType.toLowerCase()) == false) {
            throw new InvalidInputException(searchType + "is Invalid . Aceepted values");
        }
        return bankRepository.findAll().stream()
                .peek(System.out::println)
                .filter(rec -> {
                    if ("city".equals(searchType))
                        return rec.getCity().equals(searchValue);
                    if ("name".equals(searchType))
                        return rec.getName().equals(searchValue);
                    if ("type".equals(searchType))
                        return rec.getType().equals(searchValue);
                    if ("state".equals(searchType))
                        return rec.getState().equals(searchValue);
                    if ("zipcode".equals(searchType))
                        return rec.getZipCode() == Integer.parseInt(searchValue);
                    return true;
                })
                .collect(Collectors.toSet());
    }

    public Set<Bank> findByStateAndCity(String state, String city) {
        return this.findAll().stream()
                .filter(rec -> rec.getState().equals(state) && rec.getCity().equals(city))
                .collect(Collectors.toSet());
    }
}
