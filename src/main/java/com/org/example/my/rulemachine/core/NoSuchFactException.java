package com.org.example.my.rulemachine.core;

class NoSuchFactException extends RuntimeException {

    private final String missingFact;

    public NoSuchFactException(String message, String missingFact) {
        super(message);
        this.missingFact = missingFact;
    }

    public String getMissingFact() {
        return missingFact;
    }
}
