package com.org.example.my.rulemachine.api;

@FunctionalInterface
public interface Action {

    void execute(Facts facts) throws Exception;
}
