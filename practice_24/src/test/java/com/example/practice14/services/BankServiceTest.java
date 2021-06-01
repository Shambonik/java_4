package com.example.practice14.services;

import com.example.practice14.models.Bank;
import com.example.practice14.models.Card;
import com.example.practice14.repositories.BankRepo;
import com.example.practice14.repositories.CardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {
    @Mock
    private BankRepo bankRepo;

    @Mock
    private EmailService emailService;

    @Captor
    ArgumentCaptor<Bank> captor;

    @Test
    public void getBanks() {
        Bank bank1 = new Bank();
        bank1.setName("sber");
        Bank bank2 = new Bank();
        bank2.setName("tochka");
        Mockito.when(bankRepo.findAll()).thenReturn(List.of(bank1, bank2));
        BankService bankService = new BankService(bankRepo, emailService);
        Assertions.assertEquals(2, bankService.getBanks().size());
        Assertions.assertEquals("sber", bankService.getBanks().get(0).getName());
    }

    @Test
    public void addBank(){
        Bank bank = new Bank();
        bank.setName("сбербанк");
        BankService bankService = new BankService(bankRepo, emailService);
        bankService.addBank(bank);
        Mockito.verify(bankRepo).save(captor.capture());
        Bank captured = captor.getValue();
        Assertions.assertEquals("сбербанк", captured.getName());
    }

    @Test
    public void filter(){
        Bank bank1 = new Bank();
        bank1.setName("sber");
        Bank bank2 = new Bank();
        bank2.setName("tochka");

        Mockito.when(bankRepo
                .findBanksByNameAndAddress("sber", null)
        ).thenReturn(List.of(bank1));

        Mockito.when(bankRepo
                .findBanksByNameAndAddress("tochka", null)
        ).thenReturn(List.of(bank2));

        BankService bankService = new BankService(bankRepo, emailService);

        List<Bank> banks1 = bankService.filter(bank1);
        List<Bank> banks2 = bankService.filter(bank2);

        Assertions.assertEquals(1, banks1.size());
        Assertions.assertEquals("sber", banks1.get(0).getName());
        Assertions.assertEquals(1, banks2.size());
        Assertions.assertEquals("tochka", banks2.get(0).getName());
    }

    @Test
    public void getBankByName() {
        Bank bank = new Bank();
        bank.setName("сбербанк");
        Mockito.when(bankRepo.findBanksByName(Mockito.any()))
                .thenReturn(null);
        Mockito.when(bankRepo.findBanksByName("сбербанк"))
                .thenReturn(new ArrayList(Collections.singleton(bank)));
        BankService bankService = new BankService(bankRepo, emailService);
        Assertions.assertEquals("сбербанк", bankService.getBankByName(bank.getName()).getName());
        Assertions.assertNull(bankService.getBankByName("t"));
    }
}
