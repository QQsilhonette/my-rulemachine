package com.org.example.my.rulemachine.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Rule {

    String name() default com.org.example.my.rulemachine.api.Rule.DEFAULT_NAME;

    String description() default com.org.example.my.rulemachine.api.Rule.DEFAULT_DESCRIPTION;

    int priority() default com.org.example.my.rulemachine.api.Rule.DEFAULT_PRIORITY;
}
