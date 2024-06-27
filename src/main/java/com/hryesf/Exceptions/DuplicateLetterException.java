package com.hryesf.Exceptions;

public class DuplicateLetterException extends RuntimeException{
    public DuplicateLetterException(){
        super("Duplicate Letter is not Allowed.");
    }
}
