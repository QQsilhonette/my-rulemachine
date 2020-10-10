package com.org.example.my.rulemachine.api;

import java.util.Collections;
import java.util.Map;

public interface RulesEngine {

    RulesEngineParameters getParameters();

    void fire(Rules rules, Facts facts);

    default Map<Rule, Boolean> check(Rules rules, Facts facts) {
        return Collections.emptyMap();
    }
}
