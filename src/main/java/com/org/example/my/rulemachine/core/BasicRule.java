package com.org.example.my.rulemachine.core;

import com.org.example.my.rulemachine.api.Facts;
import com.org.example.my.rulemachine.api.Rule;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/10 5:06 下午
 * @description：basic rule
 */
public class BasicRule implements Rule {

    protected String name;
    protected String description;
    protected int priority;

    public BasicRule(final String name, final String description, final int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public BasicRule() {
        this(Rule.DEFAULT_NAME, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
    }

    public BasicRule(final String name) {
        this(name, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
    }

    public BasicRule(final String name, final String description) {
        this(name, description, Rule.DEFAULT_PRIORITY);
    }

    @Override
    public boolean evaluate(Facts facts) {
        return false;
    }

    @Override
    public void execute(Facts facts) throws Exception {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(final Rule rule) {
        if (getPriority() < rule.getPriority()) {
            return -1;
        } else if (getPriority() > rule.getPriority()) {
            return 1;
        } else {
            return getName().compareTo(rule.getName());
        }
    }
}
