package com.hryesf.Exceptions;

public class EvenNumberException extends RuntimeException{
    public EvenNumberException(){
        super("The number of Letters can not be even");
    }
}
