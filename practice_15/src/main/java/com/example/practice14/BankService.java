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

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public ArrayList<Bank> getBanks() {
        return new ArrayList<>(session.createQuery("select b from Bank b",
                Bank.class).getResultList());
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
}
