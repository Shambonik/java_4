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

@Service
@RequiredArgsConstructor
public class BankService {
    private final SessionFactory sessionFactory;
    private static ArrayList<Bank> banks = new ArrayList<>();
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Bank> bankCriteriaQuery;
    private Root<Bank> root;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        bankCriteriaQuery = builder.createQuery(Bank.class);
        root = bankCriteriaQuery.from(Bank.class);
        banks = new ArrayList<>(session.createQuery("select b from Bank b",
                Bank.class).getResultList());
    }

    public ArrayList<Bank> filter(Bank filter){
        ArrayList<Predicate> predicates = new ArrayList<>();
        if(!filter.getName().equals("")) {
            predicates.add(builder.equal(root.get("name"), filter.getName()));
        }
        if(!filter.getAddress().equals("")) {
            predicates.add(builder.equal(root.get("address"), filter.getAddress()));
        }
        bankCriteriaQuery.where(predicates.toArray(new Predicate[0]));
        Query<Bank> query = session.createQuery(bankCriteriaQuery);
        return new ArrayList<>(query.getResultList());
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
