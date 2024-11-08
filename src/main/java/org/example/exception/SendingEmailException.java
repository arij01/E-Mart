package org.example.exception;

public class SendingEmailException extends Exception{
    public SendingEmailException(String message){
        super("Email Exception-" + message);
    }
}
