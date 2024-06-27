package com.hryesf;

import java.util.InputMismatchException;
import java.util.Map;

public class Plugboard {

    private final Map<Character, Character> wires;

    public Plugboard(Map<Character, Character> map) throws IllegalAccessException {
        if (map == null || map.isEmpty() || map.size() % 2 != 0) {
            throw new IllegalAccessException("Invalid wires configuration.");
        }
        this.wires = map;
    }

    public Character process(Character input) {
        boolean containsInput = wires.containsKey(input);
        if (!containsInput) {
            throw new InputMismatchException();
        }

        return wires.get(input);
    }
}
