package edu.java.utils.driver;


public class InvalidPropertiesException extends IllegalArgumentException {
    private final String message;

    public InvalidPropertiesException(String message) {
        this.message = message;
    }

    public InvalidPropertiesException() {
        this.message = "Properties file is empty.";
    }

    public String getMessage() {
        return message;
    }


}