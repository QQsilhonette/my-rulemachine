package com.org.example.my.rulemachine.api;

@FunctionalInterface
public interface Condition {

    boolean evaluate(Facts facts);

    /**
     * 无论什么入参一律输出false
     */
    Condition FALSE = facts -> false;

    /**
     * 无论什么入参一律输出true
     */
    Condition TRUE = facts -> true;
}
