package com.example.practice14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/banks")
public class BankController {
    private ArrayList<Bank> banks = new ArrayList<>();
    private int id = 0;

    @GetMapping("")
    public String getBanks(Model model){
        model.addAttribute("banks", banks);
        model.addAttribute("newBank", new Bank());
        return "banks";
    }

    private Bank findById(int id) {
        for(Bank bank: banks){
            if(bank.getId() == id) return bank;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteBank(@PathVariable("id") int id){
        banks.remove(findById(id));
        return "redirect:/banks";
    }

    @PostMapping
    public String addBank(@ModelAttribute("newBank") Bank bank){
        bank.setId(++id);
        banks.add(bank);
        return "redirect:/banks";
    }
}
