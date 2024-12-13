package fr.unica.miage.essati.dice.controller;

import fr.unica.miage.essati.dice.entity.DiceRollLog;
import fr.unica.miage.essati.dice.repository.DiceRollLogRepository;
import fr.unica.miage.essati.dice.service.Dice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DiceController {

    @Autowired
    private Dice dice;
    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    @GetMapping("/rollDice")
    public int rollDice() {

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            results.add(dice.roll());
        }

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(1);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results.get(0);
    }

    @GetMapping("/rollDices/{X}")
    public List<Integer> rollDices(@PathVariable int X) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            results.add(dice.roll());
        }

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(X);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);
        return results;
    }
}