package com.example.practice14;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final SessionFactory sessionFactory;
    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Card> bankCriteriaQuery;
    private Root<Card> root;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        bankCriteriaQuery = builder.createQuery(Card.class);
        root = bankCriteriaQuery.from(Card.class);
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<>(session.createQuery("select c from Card c",
                Card.class).getResultList());
    }

    public ArrayList<Card> filter(Card filter){
        ArrayList<Predicate> predicates = new ArrayList<>();
        if(filter.getCardNumber()!=0) {
            predicates.add(builder.equal(root.get("cardNumber"), filter.getCardNumber()));
        }
        if(filter.getCode()!=0) {
            predicates.add(builder.equal(root.get("code"), filter.getCode()));
        }
        if(!filter.getBankName().equals("")) {
            predicates.add(builder.equal(root.get("bank").get("name"), filter.getBankName()));
        }
        bankCriteriaQuery.where(predicates.toArray(new Predicate[0]));
        Query<Card> query = session.createQuery(bankCriteriaQuery);
        return new ArrayList<>(query.getResultList());
    }

    public void deleteCard(Card card){
        session.beginTransaction();
        session.delete(card);
        session.getTransaction().commit();
    }

    public void addCard(Card card){
        card.setBank(BankService.getBankByName(card.getBankName()));
        session.beginTransaction();
        session.save(card);
        session.getTransaction().commit();
    }

    public Bank getBankByCard(Long cardId) {
        return session.createQuery("from Card where id = " + cardId, Card.class)
                .getSingleResult().getBank();
    }

}
