package com.hryesf.utils;

import com.hryesf.exceptions.DuplicateLetterException;
import com.hryesf.exceptions.OddNumberException;
import com.hryesf.exceptions.MaxWireException;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {

    // Prevent instantiation of the utility class
    // can see on https://github.com/hryesf/effective-java-series/tree/master/Item4
    private ValidationUtils() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    public static void validateWires(String wires) throws IllegalAccessException {
        NotNullOrEmpty(wires);
        validateNumberOfLetters(wires);
        validateMaxWireCount(wires);
        validateDuplicateCharacters(wires);
    }

    private static void validateDuplicateCharacters(String wires) {
        if (hasDuplicateCharacter(wires)) {
            throw new DuplicateLetterException();
        }
    }

    private static void validateMaxWireCount(String wires) {
        if (wires.length() / 2 > 10) {
            throw new MaxWireException();
        }
    }

    private static void validateNumberOfLetters(String wires) {
        if (wires.length() % 2 != 0) {
            throw new OddNumberException();
        }
    }

    private static void NotNullOrEmpty(String wires) throws IllegalAccessException {
        if (wires == null || wires.isEmpty()) {
            throw new IllegalAccessException("Invalid wire Input.");
        }
    }

    // this function will find the first duplicate character in input string
    private static boolean hasDuplicateCharacter(String wires) {
        final Set<Character> seen = new HashSet<>();
        for (char character : wires.toCharArray()) {
            if (seen.contains(character)) {
                return true;
            }
            seen.add(character);
        }
        return false;
    }
}
