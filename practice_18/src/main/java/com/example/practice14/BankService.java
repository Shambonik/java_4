package com.example.practice14;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepo bankRepo;

    public List<Bank> filter(Bank filter){
        return bankRepo.findBanksByNameAndAddress(filter.getName(), filter.getAddress());
    }

    public List<Bank> getBanks() {
        return bankRepo.findAll();
    }

    public void deleteBank(Long id){
        bankRepo.deleteById(id);
    }

    public void addBank(Bank bank){
        bankRepo.save(bank);
    }

    public Bank getBankByName(String name){
        List<Bank> banks = bankRepo.findBanksByName(name);
        return banks==null ? null : banks.get(0);
    }
}
