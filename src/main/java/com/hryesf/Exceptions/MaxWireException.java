package com.hryesf.Exceptions;

public class MaxWireException extends RuntimeException{
    public MaxWireException(){
        super("Max number of wire is 10.");
    }
}
