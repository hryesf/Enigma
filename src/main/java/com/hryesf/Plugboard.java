package com.hryesf;

import java.util.HashMap;
import java.util.Map;

public class Plugboard {

    private final String wires;
    private final Map<Character, Character> wireMap;

    public Plugboard(String wires) throws IllegalAccessException {
        this.wires = wires;

        if (wires == null || wires.isEmpty() || wires.length() % 2 != 0) {
            throw new IllegalAccessException("Invalid wire configuration.");
        }

        if (wires.length()/2 > 10){
            throw new MaxWireException();
        }

        if (hasDuplicateCharacter(wires)){
            throw new DuplicateLetterException();
        }

        wireMap = new HashMap<>();

        for(int i = 0; i < wires.length(); i += 2) {
            wireMap.put(wires.charAt(i), wires.charAt(i+1));
        }
    }

    // in this function unfortunately we don't support searching based on value and find key value!!
    public Character process(Character input) {
        if (wireMap.containsKey(input)) {
            return wireMap.get(input);
        }
        return input;
    }

    // this function will find the first duplicate character in input string
    public boolean hasDuplicateCharacter(String input) {
        final Set<Character> seen = new HashSet<>();
        for (char character : wires.toCharArray()) {
            if (seen.contains(character)){
                return true;
            }
            seen.add(character);
        }
        return false;
    }
}
