package com.example.practice14.services;

import com.example.practice14.models.Bank;
import com.example.practice14.models.Card;
import com.example.practice14.repositories.CardRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {
    private final CardRepo cardRepo;
    private final BankService bankService;

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
        card.setBank(bankService.getBankByName(card.getBankName()));
        log.info("Save card {}", card);
        cardRepo.save(card);
    }

    public Bank getBankByCard(Long cardId) {
        log.info("Get bank of card with id {}", cardId);
        return cardRepo.findCardById(cardId).getBank();
    }

}
