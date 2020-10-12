package com.org.example.my.rulemachine.core;

import com.org.example.my.rulemachine.api.Action;
import com.org.example.my.rulemachine.api.Condition;
import com.org.example.my.rulemachine.api.Facts;

import java.util.List;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/10 5:19 下午
 * @description：default rule
 */
public class DefaultRule extends BasicRule {
    private final Condition condition;
    private final List<Action> actions;

    public DefaultRule(String name, String description, int priority, Condition condition, List<Action> actions) {
        super(name, description, priority);
        this.condition = condition;
        this.actions = actions;
    }

    @Override
    public boolean evaluate(Facts facts) {
        return condition.evaluate(facts);
    }

    @Override
    public void execute(Facts facts) throws Exception {
        for (Action action : actions) {
            action.execute(facts);
        }
    }
}
