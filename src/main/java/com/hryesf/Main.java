package com.hryesf;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Plugboard plugboard = new Plugboard("ABCDEFGHIJKLMNOPQRST");
        System.out.println(plugboard.process('A'));
        System.out.println(plugboard.process('B'));
        System.out.println(plugboard.process('X'));
        System.out.println(plugboard.process('.'));
    }
}