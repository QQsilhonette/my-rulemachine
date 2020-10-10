package com.org.example.my.rulemachine.test;

import com.org.example.my.rulemachine.api.Facts;
import com.org.example.my.rulemachine.api.Rules;
import com.org.example.my.rulemachine.api.RulesEngine;
import com.org.example.my.rulemachine.core.DefaultRulesEngine;
import org.junit.Test;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/9 3:04 下午
 * @description：规则引擎单测
 */
public class RuleMachineTest {

    @Test
    public void testRuleMachine() {
        Facts facts = new Facts();

        Rules rules = new Rules();
        rules.register(new HelloWorldRule());

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }

}
