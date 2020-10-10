package com.org.example.my.rulemachine.api;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/9 3:42 下午
 * @description：规则引擎参数对象
 */
public class RulesEngineParameters {

    /**
     * 默认优先级的阈值
     */
    public static final int DEFAULT_RULE_PRIORITY_THRESHOLD = Integer.MAX_VALUE;

    /**
     * 当一个规则被应用可以跳过
     */
    private boolean skipOnFirstAppliedRule;

    /**
     * 当一个规则未触发可以跳过
     */
    private boolean skipOnFirstNonTriggeredRule;

    /**
     * 当一个规则失败可以跳过
     */
    private boolean skipOnFirstFailedRule;

    /**
     * 用户定义的优先级阈值，大于阈值的规则跳过
     */
    private int priorityThreshold;

    public RulesEngineParameters(final boolean skipOnFirstAppliedRule, final boolean skipOnFirstNonTriggeredRule, final boolean skipOnFirstFailedRule, final int priorityThreshold) {
        this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
        this.skipOnFirstNonTriggeredRule = skipOnFirstNonTriggeredRule;
        this.skipOnFirstFailedRule = skipOnFirstFailedRule;
        this.priorityThreshold = priorityThreshold;
    }

    public RulesEngineParameters() {
        this.priorityThreshold = DEFAULT_RULE_PRIORITY_THRESHOLD;
    }

    public int getPriorityThreshold() {
        return priorityThreshold;
    }

    public void setPriorityThreshold(int priorityThreshold) {
        this.priorityThreshold = priorityThreshold;
    }

    public boolean isSkipOnFirstAppliedRule() {
        return skipOnFirstAppliedRule;
    }

    public void setSkipOnFirstAppliedRule(boolean skipOnFirstAppliedRule) {
        this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
    }

    public boolean isSkipOnFirstNonTriggeredRule() {
        return skipOnFirstNonTriggeredRule;
    }

    public void setSkipOnFirstNonTriggeredRule(boolean skipOnFirstNonTriggeredRule) {
        this.skipOnFirstNonTriggeredRule = skipOnFirstNonTriggeredRule;
    }

    public boolean isSkipOnFirstFailedRule() {
        return skipOnFirstFailedRule;
    }

    public void setSkipOnFirstFailedRule(boolean skipOnFirstFailedRule) {
        this.skipOnFirstFailedRule = skipOnFirstFailedRule;
    }

    @Override
    public String toString() {
        return "RulesEngineParameters{" +
                "skipOnFirstAppliedRule=" + skipOnFirstAppliedRule +
                ", skipOnFirstNonTriggeredRule=" + skipOnFirstNonTriggeredRule +
                ", skipOnFirstFailedRule=" + skipOnFirstFailedRule +
                ", priorityThreshold=" + priorityThreshold +
                '}';
    }
}
