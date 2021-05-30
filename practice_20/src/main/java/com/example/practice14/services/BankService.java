package com.example.practice14.services;

import com.example.practice14.models.Bank;
import com.example.practice14.repositories.BankRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {
    private final BankRepo bankRepo;

    public List<Bank> filter(Bank filter){
        log.info("Get banks with filter {}", filter);
        return bankRepo.findBanksByNameAndAddress(filter.getName(), filter.getAddress());
    }

    public List<Bank> getBanks() {
        log.info("Get all banks");
        return bankRepo.findAll();
    }

    public void deleteBank(Long id){
        log.info("Delete bank with id {}", id);
        bankRepo.deleteById(id);
    }

    public void addBank(Bank bank){
        log.info("Save bank {}", bank);
        bankRepo.save(bank);
    }

    public Bank getBankByName(String name){
        List<Bank> banks = bankRepo.findBanksByName(name);
        log.info("Get bank with name {}", name);
        return banks==null ? null : banks.get(0);
    }
}
