package com.org.example.my.rulemachine.api;

import java.util.*;

public class Rules implements Iterable<Rule> {

    private Set<Rule> rules = new TreeSet<>();

    public Rules(Set<Rule> rules) {
        this.rules = rules;
    }

    public Rules(Rule... rules) {
        Collections.addAll(this.rules, rules);
    }

    public Rules(Object... rules) {
        this.register(rules);
    }

    public void register(Object... rules) {
        Objects.requireNonNull(rules);
        for (Object rule : rules) {
            Objects.requireNonNull(rule);
            if (rule instanceof Rule) {
                this.rules.add((Rule) rule);
            }
        }
    }

    public void unregister(Object... rules) {
        Objects.requireNonNull(rules);
        for (Object rule : rules) {
            Objects.requireNonNull(rule);
            if (rule instanceof Rule) {
                this.rules.remove((Rule) rule);
            }
        }
    }

    public void unregister(final String ruleName) {
        Objects.requireNonNull(rules);
        Rule rule = findRuleByName(ruleName);
        if (null != rule) {
            unregister(rule);
        }
    }

    private Rule findRuleByName(String ruleName) {
        return rules.stream()
                .filter(rule -> rule.getName().equalsIgnoreCase(ruleName))
                .findFirst()
                .orElse(null);
    }

    public boolean isEmpty() {
        return rules.isEmpty();
    }

    @Override
    public Iterator<Rule> iterator() {
        return rules.iterator();
    }
}
