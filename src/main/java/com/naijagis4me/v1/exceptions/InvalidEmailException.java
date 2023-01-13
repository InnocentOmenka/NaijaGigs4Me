package com.naijagis4me.v1.exceptions;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(String message) {
        super(message);
    }

}
