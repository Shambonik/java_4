package com.example.practice14;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CardService {
    private final CardRepo cardRepo;
    private final BankService bankServiceo;

    public List<Card> getCards() {
        log.info("Get all cards");
        return cardRepo.findAll();
    }

    public List<Card> filter(Card filter){
        log.info("Get cards with filter {}, bankName {}", filter, filter.getBankName());
        return cardRepo.findCardsByCardNumberAndCodeAndBankName(
                filter.getCardNumber(), filter.getCode(), filter.getBankName()
        );
    }

    public void deleteCard(long id){
        log.info("Get card with id {}", id);
        cardRepo.deleteById(id);
    }

    public void addCard(Card card){
        card.setBank(bankServiceo.getBankByName(card.getBankName()));
        log.info("Save card {}", card);
        cardRepo.save(card);
    }

    public Bank getBankByCard(Long cardId) {
        log.info("Get bank of card with id {}", cardId);
        return cardRepo.findCardById(cardId).getBank();
    }

}
