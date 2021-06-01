package com.example.practice14.controllers;

import com.example.practice14.models.Bank;
import com.example.practice14.models.Card;
import com.example.practice14.services.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cards")
public class CardController {
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public String getCards(Model model){
        model.addAttribute("cards", cardService.getCards());
        model.addAttribute("newCard", new Card());
        model.addAttribute("filterCard", new Card());
        return "cards";
    }

//    private Card findById(int id) {
//        for(Card card: cards){
//            if(card.getId() == id) return card;
//        }
//        return null;
//    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable("id") int id){
        cardService.deleteCard(id);
        return "redirect:/cards";
    }

    @PostMapping
    public String addCard(@ModelAttribute("newCard") Card card){
        cardService.addCard(card);
        return "redirect:/cards";
    }

    @PostMapping("/filter")
    public @ResponseBody String filterBanks(@ModelAttribute("filterCard") Card card){
        StringBuilder result = new StringBuilder();
        for(Card cardEntry: cardService.filter(card)){
            result.append(cardEntry.toString()).append("<br>");
        }
        return result.toString();
    }

    @GetMapping(value = "/{cardId}/bank")
    public @ResponseBody
    Bank getCardBank(@PathVariable("cardId") Long cardId){
        return cardService.getBankByCard(cardId);
    }

}
