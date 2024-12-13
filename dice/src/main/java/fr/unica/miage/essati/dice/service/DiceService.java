package fr.unica.miage.essati.dice.service;

import fr.unica.miage.essati.dice.entity.DiceRollLog;
import fr.unica.miage.essati.dice.repository.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    @Autowired
    private Dice dice;

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    public List<Integer> rollDices(int diceCount) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < diceCount; i++) {
            results.add(dice.roll());
        }

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results;
    }
}