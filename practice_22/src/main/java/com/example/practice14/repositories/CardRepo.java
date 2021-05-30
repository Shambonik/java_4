package com.example.practice14.repositories;

import com.example.practice14.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {
    Card findCardById(Long id);
    @Query(value = "select card.* from card join bank on bank.id = card.bank_id " +
            "where (0 = :cardNumber or card_number = :cardNumber) and " +
            "(0 = :code or code = :code) and " +
            "('' = :bankName or bank.name = :bankName)", nativeQuery = true)
    List<Card> findCardsByCardNumberAndCodeAndBankName(long cardNumber, int code, String bankName);
}
