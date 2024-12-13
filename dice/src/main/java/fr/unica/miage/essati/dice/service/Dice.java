package fr.unica.miage.essati.dice.service;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
