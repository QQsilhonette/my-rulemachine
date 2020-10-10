package com.org.example.my.rulemachine.api;

public interface Rule extends Comparable<Rule> {

    /**
     * 默认规则名
     */
    String DEFAULT_NAME = "rule";

    /**
     * 默认规则描述
     */
    String DEFAULT_DESCRIPTION = "description";

    /**
     * 默认规则优先级
     */
    int DEFAULT_PRIORITY = Integer.MAX_VALUE - 1;

    default String getName() {
        return DEFAULT_NAME;
    }

    default String getDescription() {
        return DEFAULT_DESCRIPTION;
    }

    default int getPriority() {
        return DEFAULT_PRIORITY;
    }

    /**
     * 执行方法的rule的condition
     * @param facts
     * @return
     */
    boolean evaluate(Facts facts);

    /**
     * 执行rule的action
     * @param facts
     * @throws Exception
     */
    void execute(Facts facts) throws Exception;

}
