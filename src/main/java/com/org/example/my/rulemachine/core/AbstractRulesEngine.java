package com.org.example.my.rulemachine.core;

import com.org.example.my.rulemachine.api.RulesEngine;
import com.org.example.my.rulemachine.api.RulesEngineParameters;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/9 5:42 下午
 * @description：规则引擎实现抽象类
 */
public abstract class AbstractRulesEngine implements RulesEngine {

    RulesEngineParameters parameters;

    AbstractRulesEngine() {
        this(new RulesEngineParameters());
    }

    AbstractRulesEngine(final RulesEngineParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public RulesEngineParameters getParameters() {
        return new RulesEngineParameters(
                parameters.isSkipOnFirstAppliedRule(),
                parameters.isSkipOnFirstFailedRule(),
                parameters.isSkipOnFirstNonTriggeredRule(),
                parameters.getPriorityThreshold()
        );
    }
}
