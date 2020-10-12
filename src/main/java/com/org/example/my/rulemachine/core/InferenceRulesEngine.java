package com.org.example.my.rulemachine.core;

import com.org.example.my.rulemachine.api.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/10 5:58 下午
 * @description：rules循环执行器，直到没有符合条件的rule为止
 */

@Slf4j
public class InferenceRulesEngine extends AbstractRulesEngine {

    private final DefaultRulesEngine delegate;


    public InferenceRulesEngine() {
        this(new RulesEngineParameters());
    }

    public InferenceRulesEngine(RulesEngineParameters parameters) {
        super(parameters);
        delegate = new DefaultRulesEngine(parameters);
    }

    @Override
    public void fire(Rules rules, Facts facts) {
        Set<Rule> selectedRules;
        do {
            log.debug("Selecting candidate rules based on the following facts: {}", facts);
            selectedRules = selectCandidates(rules, facts);
            if (!selectedRules.isEmpty()) {
                delegate.fire(new Rules(selectedRules), facts);
            } else {
                log.debug("No candidate rules found for facts: {}", facts);
            }
        } while (!selectedRules.isEmpty());
    }

    private Set<Rule> selectCandidates(Rules rules, Facts facts) {
        Set<Rule> candidates = new TreeSet<>();
        for (Rule rule : rules) {
            if (rule.evaluate(facts)) {
                candidates.add(rule);
            }
        }
        return candidates;
    }
}
