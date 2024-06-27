package com.hryesf.exceptions;

public class DuplicateLetterException extends RuntimeException{
    public DuplicateLetterException(){
        super("Duplicate Letter is not Allowed.");
    }
}
