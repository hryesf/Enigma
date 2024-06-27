package com.hryesf;

import com.hryesf.domain.PlugBoard;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        PlugBoard plugboard = new PlugBoard("ABCDEFGHIJKLMNOPQRST");
        System.out.println(plugboard.process('A'));
        System.out.println(plugboard.process('B'));
        System.out.println(plugboard.process('X'));
        System.out.println(plugboard.process('.'));
    }
}