package com.hryesf;

import java.util.HashMap;
import java.util.Map;

public class Plugboard {

    private final String wires;
    private final Map<Character, Character> WIREMAP;

    public Plugboard(String wires) throws IllegalAccessException {
        this.wires = wires;

        if (wires == null || wires.isEmpty() || wires.length() % 2 != 0) {
            throw new IllegalAccessException("Invalid wire configuration.");
        }

        if (wires.length()/2 > 10){
            throw new MaxWireException();
        }

        WIREMAP = new HashMap<>();

        for(int i = 0; i < wires.length(); i += 2) {
            WIREMAP.put(wires.charAt(i), wires.charAt(i+1));
        }
    }

    public Character process(Character input) {
        boolean containsInput = wires.containsKey(input);
        if (!containsInput) {
            throw new InputMismatchException();
        }

        return wires.get(input);
    }
}
