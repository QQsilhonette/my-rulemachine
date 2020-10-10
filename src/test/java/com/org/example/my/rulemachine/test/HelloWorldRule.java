package com.org.example.my.rulemachine.test;

import com.org.example.my.rulemachine.api.Facts;
import com.org.example.my.rulemachine.api.Rule;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/9 5:37 下午
 * @description：hello world
 */
public class HelloWorldRule implements Rule {


    @Override
    public boolean evaluate(Facts facts) {
        return true;
    }

    @Override
    public void execute(Facts facts) throws Exception {
        System.out.println("hello world");
    }

    @Override
    public int compareTo(Rule o) {
        return 0;
    }
}
