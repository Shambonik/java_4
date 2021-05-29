package com.example.practice14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/cards")
public class CardController {
    private ArrayList<Card> cards = new ArrayList<>();
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public String getCards(Model model){
        cards = cardService.getCards();
        model.addAttribute("cards", cards);
        model.addAttribute("newCard", new Card());
        return "cards";
    }

    private Card findById(int id) {
        for(Card card: cards){
            if(card.getId() == id) return card;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable("id") int id){
        cardService.deleteCard(findById(id));
        return "redirect:/cards";
    }

    @PostMapping
    public String addCard(@ModelAttribute("newCard") Card card){
        cardService.addCard(card);
        return "redirect:/cards";
    }

    @GetMapping(value = "/{cardId}/bank")
    public @ResponseBody Bank getCardBank(@PathVariable("cardId") Long cardId){
        return cardService.getBankByCard(cardId);
    }

}
