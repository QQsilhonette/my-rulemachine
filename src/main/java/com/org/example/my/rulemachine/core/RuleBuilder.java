package com.org.example.my.rulemachine.core;

import com.org.example.my.rulemachine.api.Action;
import com.org.example.my.rulemachine.api.Condition;
import com.org.example.my.rulemachine.api.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/10 4:41 下午
 * @description：Rule构造器
 */
public class RuleBuilder {

    private String name = Rule.DEFAULT_NAME;
    private String description = Rule.DEFAULT_DESCRIPTION;
    private int priority = Rule.DEFAULT_PRIORITY;

    private Condition condition = Condition.FALSE;
    private final List<Action> actions = new ArrayList<>();

    public RuleBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RuleBuilder description(String description) {
        this.description = description;
        return this;
    }

    public RuleBuilder priority(int priority) {
        this.priority = priority;
        return this;
    }

    public RuleBuilder when(Condition condition) {
        this.condition = condition;
        return this;
    }

    public RuleBuilder then(Action action) {
        this.actions.add(action);
        return this;
    }

    public Rule build() {
        return new DefaultRule(name , description, priority, condition, actions);
    }
}
