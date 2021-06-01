package com.example.practice14.repositories;

import com.example.practice14.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankRepo extends JpaRepository<Bank, Long> {
    List<Bank> findBanksByName(String name);
    @Query(value = "select bank.* from bank " +
            "where ('' = :name or name = :name) and " +
            "('' = :address or address = :address)", nativeQuery = true)
    List<Bank> findBanksByNameAndAddress(String name, String address);
}
