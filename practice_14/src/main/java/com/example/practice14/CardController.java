package com.example.practice14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/cards")
public class CardController {
    private ArrayList<Card> cards = new ArrayList<>();
    private int id = 0;

    @GetMapping
    public String getCards(Model model){
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
        cards.remove(findById(id));
        return "redirect:/cards";
    }

    @PostMapping
    public String addCard(@ModelAttribute("newCard") Card card){
        card.setId(++id);
        cards.add(card);
        return "redirect:/cards";
    }
}
