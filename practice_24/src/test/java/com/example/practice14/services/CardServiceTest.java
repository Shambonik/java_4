package com.example.practice14.services;

import com.example.practice14.models.Bank;
import com.example.practice14.models.Card;
import com.example.practice14.repositories.CardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {
    @Mock
    private CardRepo cardRepo;

    @Mock
    private BankService bankService;

    @Mock
    private EmailService emailService;

    @Captor
    ArgumentCaptor<Card> captor;

    @Test
    public void getCards() {
        Card card1 = new Card();
        card1.setCardNumber(123456789);
        Card card2 = new Card();
        card2.setCardNumber(223456789);
        Mockito.when(cardRepo.findAll()).thenReturn(List.of(card1, card2));
        CardService cardService = new CardService(cardRepo, bankService, emailService);
        Assertions.assertEquals(2, cardService.getCards().size());
        Assertions.assertEquals(123456789, cardService.getCards().get(0).getCardNumber());
    }

    @Test
    public void addCard(){
        Bank bank = new Bank();
        bank.setName("сбербанк");
        Card card = new Card();
        card.setCardNumber(123456789);
        card.setBankName(bank.getName());
        Mockito.when(bankService.getBankByName(bank.getName())).thenReturn(bank);
        CardService cardService = new CardService(cardRepo, bankService, emailService);
        cardService.addCard(card);
        Mockito.verify(cardRepo).save(captor.capture());
        Card captured = captor.getValue();
        Assertions.assertEquals(123456789, captured.getCardNumber());
        Assertions.assertEquals("сбербанк", captured.getBank().getName());
    }

    @Test
    public void filter(){
        Card card1 = new Card();
        card1.setCardNumber(11111);
        Card card2 = new Card();
        card2.setCardNumber(22222);

        Mockito.when(cardRepo
                .findCardsByCardNumberAndCodeAndBankName(11111, 0, null)
        ).thenReturn(List.of(card1));

        Mockito.when(cardRepo
                .findCardsByCardNumberAndCodeAndBankName(22222, 0, null)
        ).thenReturn(List.of(card2));

        CardService cardService = new CardService(cardRepo,
                bankService, emailService);

        List<Card> cards1 = cardService.filter(card1);
        List<Card> cards2 = cardService.filter(card2);

        Assertions.assertEquals(1, cards1.size());
        Assertions.assertEquals(11111, cards1.get(0).getCardNumber());
        Assertions.assertEquals(1, cards2.size());
        Assertions.assertEquals(22222, cards2.get(0).getCardNumber());
    }

    @Test
    public void getBankByCard() {
        Card card = new Card();
        Bank bank = new Bank();
        bank.setName("сбербанк");
        card.setBank(bank);
        Mockito.when(cardRepo.findCardById(card.getId()))
                .thenReturn(card);
        CardService cardService = new CardService(cardRepo,
                bankService, emailService);
        Assertions.assertEquals("сбербанк", cardService
                .getBankByCard(card.getId()).getName());
    }
}
