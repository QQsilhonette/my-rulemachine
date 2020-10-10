package com.org.example.my.rulemachine.api;

import java.util.Objects;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/9/18 5:55 下午
 * @description：Fact
 */
public class Fact<T> {

    private final String name;

    private final T value;

    public Fact(String name, T value) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(value, "value must not be null");
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fact<?> fact = (Fact<?>) o;
        return Objects.equals(name, fact.name) &&
                Objects.equals(value, fact.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Fact{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
