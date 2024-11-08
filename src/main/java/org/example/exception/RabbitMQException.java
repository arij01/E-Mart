package org.example.exception;

public class RabbitMQException extends Exception{
    public RabbitMQException(String message){
        super("RabbitMQ Exception" + message);
    }
}
