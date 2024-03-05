package com.split.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    public ResourceNotFoundException(int resourceName) {
        super(String.format("Resource not found with : %s", resourceName));
        this.resourceName = String.valueOf(resourceName);
    }
    public ResourceNotFoundException(String resourceName) {
        super(String.format("Resource not found with : %s", resourceName));
        this.resourceName = String.valueOf(resourceName);
    }
}
