package org.example.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourseNotFoundException extends RuntimeException{

    public ResourseNotFoundException(String message)
    {
        super(message);
    }
}
