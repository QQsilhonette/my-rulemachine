package com.org.example.my.rulemachine.test;

import com.org.example.my.rulemachine.api.*;
import com.org.example.my.rulemachine.core.DefaultRulesEngine;
import com.org.example.my.rulemachine.core.InferenceRulesEngine;
import com.org.example.my.rulemachine.core.RuleBuilder;
import org.junit.Test;

import static com.org.example.my.rulemachine.test.DecreaseTemperatureAction.decreaseTemperature;
import static com.org.example.my.rulemachine.test.HighTemperatureCondition.itIsHot;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/9 3:04 下午
 * @description：规则引擎单测
 */
public class RuleMachineTest {

    @Test
    public void testHelloWorld() {
        Facts facts = new Facts();

        Rules rules = new Rules();
        rules.register(new HelloWorldRule());

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }

    @Test
    public void testAirCond() {
        Facts facts = new Facts();
        facts.put("temperature", 30);

        Rule airConditioningRule = new RuleBuilder()
                .name("air conditioning rule")
                .when(itIsHot())
                .then(decreaseTemperature())
                .build();
        Rules rules = new Rules();
        rules.register(airConditioningRule);

        RulesEngine rulesEngine = new InferenceRulesEngine();
        rulesEngine.fire(rules, facts);
    }

    @Test
    public void testAnnotation() {
        // create rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        // create rules
        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        rules.register(new NonFizzBuzzRule());

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }

}
