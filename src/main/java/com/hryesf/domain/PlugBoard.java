package com.hryesf.domain;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.hryesf.utils.ValidationUtils;

public class PlugBoard {

    private final String wires;
    private final BiMap<Character, Character> wireMap;

    public PlugBoard(String wires) throws IllegalAccessException {
        this.wires = wires;

        ValidationUtils.validateWires(wires);

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
}
