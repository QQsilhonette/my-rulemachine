package com.org.example.my.rulemachine.test;

import com.org.example.my.rulemachine.api.Action;
import com.org.example.my.rulemachine.api.Facts;

public class DecreaseTemperatureAction implements Action {

    static DecreaseTemperatureAction decreaseTemperature() {
        return new DecreaseTemperatureAction();
    }

    @Override
    public void execute(Facts facts) {
        System.out.println("It is hot! cooling air..");
        Integer temperature = facts.get("temperature");
        facts.put("temperature", temperature - 1);
    }
}