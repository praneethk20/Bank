package com.bank.find.bank;

import com.bank.find.bank.model.Bank;
import com.bank.find.bank.service.BankService;
import com.bank.find.bank.service.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class FindBankApplication implements CommandLineRunner {

    @Autowired
    private FileProcessor fileProcessor;

    @Autowired
    private BankService bankService;

    public static void main(String[] args) {
        SpringApplication.run(FindBankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Bank> bankList = new ArrayList<>();
        try (FileReader fileReader = new FileReader("src/main/resources/bank-details.csv");
             BufferedReader reader = new BufferedReader(fileReader)) {
            reader.lines().skip(1).forEach(rec -> {
                bankList.add(fileProcessor.parseLine(rec));
            });
        }
        bankService.addAll(bankList);
       // bankService.findAll().stream().forEach(System.out::println);

    }
}
