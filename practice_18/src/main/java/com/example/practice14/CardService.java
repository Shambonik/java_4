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
    private final CardRepo cardRepo;
    private final BankService bankServiceo;

    public List<Card> getCards() {
        return cardRepo.findAll();
    }

    public List<Card> filter(Card filter){
        return cardRepo.findCardsByCardNumberAndCodeAndBankName(
                filter.getCardNumber(), filter.getCode(), filter.getBankName()
        );
    }

    public void deleteCard(long id){
        cardRepo.deleteById(id);
    }

    public void addCard(Card card){
        card.setBank(bankServiceo.getBankByName(card.getBankName()));
        cardRepo.save(card);
    }

    public Bank getBankByCard(Long cardId) {
        return cardRepo.findCardById(cardId).getBank();
    }

}
