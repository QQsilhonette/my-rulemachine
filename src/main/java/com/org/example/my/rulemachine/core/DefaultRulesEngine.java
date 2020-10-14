package com.org.example.my.rulemachine.core;

import com.org.example.my.rulemachine.api.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/9 5:41 下午
 * @description：规则引擎默认实现
 */

@Slf4j
public class DefaultRulesEngine extends AbstractRulesEngine {

    public DefaultRulesEngine() {
        super();
    }

    public DefaultRulesEngine(final RulesEngineParameters parameters) {
        super(parameters);
    }


    @Override
    public void fire(Rules rules, Facts facts) {
        doFire(rules, facts);
    }

    private void doFire(Rules rules, Facts facts) {
        if (rules.isEmpty()) {
            log.warn("No rules registered! Nothing to apply");
            return;
        }
        logParamsDebug(rules, facts);
        log.debug("Rules evaluation started");
        for (Rule rule : rules) {
            final String name = rule.getName();
            final int priority = rule.getPriority();

            if (priority > parameters.getPriorityThreshold()) {
                log.debug("Rule priority threshold ({}) exceeded at rule '{}' with priority={}, next rules will be skipped",
                        parameters.getPriorityThreshold(), name, priority);
                break;
            }

            boolean evaluationResult = false;
            try {
                evaluationResult = rule.evaluate(facts);
            } catch (RuntimeException exception) {
                log.error("Rule '" + name + "' evaluated with error", exception);
                // give the option to either skip next rules on evaluation error or continue by considering the evaluation error as false
                if (parameters.isSkipOnFirstNonTriggeredRule()) {
                    log.debug("Next rules will be skipped since parameter skipOnFirstNonTriggeredRule is set");
                    break;
                }
            }

            if (evaluationResult) {
                log.debug("Rule '{}' triggered", name);
                try {
                    rule.execute(facts);
                    log.debug("Rule '{}' performed successfully", name);
                    if (parameters.isSkipOnFirstAppliedRule()) {
                        log.debug("Next rules will be skipped since parameter skipOnFirstAppliedRule is set");
                        break;
                    }
                } catch (Exception exception) {
                    if (parameters.isSkipOnFirstFailedRule()) {
                        log.debug("Next rules will be skipped since parameter skipOnFirstFailedRule is set");
                        break;
                    }
                    log.error("Rule '" + name + "' performed with error", exception);
                }
            } else {
                log.debug("Rule '{}' has been evaluated to false, it has not been executed", name);
                if (parameters.isSkipOnFirstNonTriggeredRule()) {
                    log.debug("Next rules will be skipped since parameter skipOnFirstNonTriggeredRule is set");
                    break;
                }
            }
        }
    }

    private void logParamsDebug(Rules rules, Facts facts) {
        log.debug("{}", parameters);

        log.debug("Registered rules:");
        for (Rule rule : rules) {
            log.debug("Rule { name = '{}', description = '{}', priority = '{}'}",
                    rule.getName(), rule.getDescription(), rule.getPriority());
        }

        log.debug("Known facts:");
        for (Fact<?> fact : facts) {
            log.debug("{}", fact);
        }
    }
}
