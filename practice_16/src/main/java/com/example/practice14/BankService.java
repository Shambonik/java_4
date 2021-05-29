package com.example.practice14;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BankService {
    private final SessionFactory sessionFactory;
    private Session session;
    private static ArrayList<Bank> banks = new ArrayList<>();

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        banks = new ArrayList<>(session.createQuery("select b from Bank b",
                Bank.class).getResultList());
    }

    public ArrayList<Bank> getBanks() {
        banks = new ArrayList<>(session.createQuery("select b from Bank b",
                Bank.class).getResultList());
        return banks;
    }

    public void deleteBank(Bank bank){
        session.beginTransaction();
        session.delete(bank);
        session.getTransaction().commit();
    }

    public void addBank(Bank bank){
        session.beginTransaction();
        session.save(bank);
        session.getTransaction().commit();
    }

    public static Bank getBankByName(String name){
        for(Bank bank : banks){
            if(bank.getName().equals(name)) return bank;
        }
        return null;
    }
}
