package com.example.practice14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("/banks")
public class BankController {
    private ArrayList<Bank> banks = new ArrayList<>();
    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    @GetMapping("")
    public String getBanks(Model model){
        banks = bankService.getBanks();
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
        bankService.deleteBank(findById(id));
        return "redirect:/banks";
    }

    @PostMapping
    public String addBank(@ModelAttribute("newBank") Bank bank){
        bankService.addBank(bank);
        return "redirect:/banks";
    }
}
