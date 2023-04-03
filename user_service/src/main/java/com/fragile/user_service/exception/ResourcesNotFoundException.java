package com.fragile.user_service.exception;

public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(){
        super("Resource not found !!!");
    }
    public ResourcesNotFoundException(String message){
        super(message);
    }
}
