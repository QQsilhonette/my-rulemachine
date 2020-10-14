package com.org.example.my.rulemachine.core;

import java.lang.reflect.Method;

class ActionMethodOrderBean implements Comparable<ActionMethodOrderBean> {

    private final Method method;
    private final int order;

    ActionMethodOrderBean(final Method method, final int order) {
        this.method = method;
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public int compareTo(final ActionMethodOrderBean actionMethodOrderBean) {
        if (order < actionMethodOrderBean.getOrder()) {
            return -1;
        } else if (order > actionMethodOrderBean.getOrder()) {
            return 1;
        } else {
            return method.equals(actionMethodOrderBean.getMethod()) ? 0 : 1;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActionMethodOrderBean)) {
            return false;
        }

        ActionMethodOrderBean that = (ActionMethodOrderBean) o;

        if (order != that.order) {
            return false;
        }
        return method.equals(that.method);
    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + order;
        return result;
    }

}