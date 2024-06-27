package com.hryesf;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.hryesf.Exceptions.DuplicateLetterException;
import com.hryesf.Exceptions.EvenNumberException;
import com.hryesf.Exceptions.MaxWireException;

import java.util.HashSet;
import java.util.Set;

public class Plugboard {

    private final String wires;
    private final BiMap<Character, Character> wireMap;

    public Plugboard(String wires) throws IllegalAccessException {
        this.wires = wires;

        if (wires == null || wires.isEmpty()) {
            throw new IllegalAccessException("Invalid wire configuration.");
        }

        if (wires.length() % 2 != 0){
            throw new EvenNumberException();
        }

        if (wires.length()/2 > 10){
            throw new MaxWireException();
        }

        if (hasDuplicateCharacter(wires)){
            throw new DuplicateLetterException();
        }

        wireMap = HashBiMap.create();

        for(int i = 0; i < wires.length(); i += 2) {
            wireMap.put(wires.charAt(i), wires.charAt(i+1));
        }
    }

    public Character process(Character input) {
        if (wireMap.containsKey(input)) {
            return wireMap.get(input);

        } else if (wireMap.containsValue(input)) {
            return wireMap.inverse().get(input);

        }else {
            return input;
        }
    }

    // this function will find the first duplicate character in input string
    private boolean hasDuplicateCharacter(String input) {
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
