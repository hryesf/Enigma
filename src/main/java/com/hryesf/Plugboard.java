package com.hryesf;

import java.util.InputMismatchException;
import java.util.Map;

public class Plugboard {

    private final String wires;
    private final Map<Character, Character> WIREMAP;

    public Plugboard(String wires) throws IllegalAccessException {
        this.wires = wires;

        if (wires == null || wires.isEmpty() || wires.length() % 2 != 0) {
            throw new IllegalAccessException("Invalid wire configuration.");
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
