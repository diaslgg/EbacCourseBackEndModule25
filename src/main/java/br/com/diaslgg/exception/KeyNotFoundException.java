package br.com.diaslgg.exception;

public class KeyNotFoundException extends Exception {

    private static final long serialVersionUID = -1389494676398525746L;

    public KeyNotFoundException(String message) {

        this(message, null);
    }

    public KeyNotFoundException(String message, Throwable e) {
        super(message, e);
    }

}
