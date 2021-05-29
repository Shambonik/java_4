package com.example.practice14;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<>(session.createQuery("select c from Card c",
                Card.class).getResultList());
    }

    public void deleteCard(Card card){
        session.beginTransaction();
        session.delete(card);
        session.getTransaction().commit();
    }

    public void addCard(Card card){
        session.beginTransaction();
        session.save(card);
        session.getTransaction().commit();
    }
}
