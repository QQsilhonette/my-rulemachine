package com.org.example.my.rulemachine.test;

import com.org.example.my.rulemachine.api.Facts;
import com.org.example.my.rulemachine.api.Rule;
import com.org.example.my.rulemachine.api.Rules;
import com.org.example.my.rulemachine.api.RulesEngine;
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

}
