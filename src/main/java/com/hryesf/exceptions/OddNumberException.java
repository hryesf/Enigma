package com.hryesf.exceptions;

public class OddNumberException extends RuntimeException{
    public OddNumberException(){
        super("The number of Letters can not be odd");
    }
}
