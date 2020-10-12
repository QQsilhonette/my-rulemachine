package com.org.example.my.rulemachine.test;

import com.org.example.my.rulemachine.api.Condition;
import com.org.example.my.rulemachine.api.Facts;

public class HighTemperatureCondition implements Condition {

    static HighTemperatureCondition itIsHot() {
        return new HighTemperatureCondition();
    }

    @Override
    public boolean evaluate(Facts facts) {
        Integer temperature = facts.get("temperature");
        return temperature > 25;
    }

}