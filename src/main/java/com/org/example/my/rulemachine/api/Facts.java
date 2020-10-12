package com.org.example.my.rulemachine.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/3 11:30 上午
 * @description：Fact集合类
 */
public class Facts implements Iterable<Fact<?>> {

    private final Set<Fact<?>> facts = new HashSet<>();

    public <T> void put(String name, T value) {
        Objects.requireNonNull(name, "fact name must not be null");
        Objects.requireNonNull(value, "fact value must not be null");
        Fact<?> retrievedFact = getFact(name);
        if (retrievedFact != null) {
            remove(retrievedFact);
        }
        add(new Fact<>(name, value));
    }

    public <T> void add(Fact<T> fact) {
        Objects.requireNonNull(fact, "fact must not be null");
        Fact<?> retrievedFact = getFact(fact.getName());
        if (retrievedFact != null) {
            remove(retrievedFact);
        }
        facts.add(fact);
    }

    public <T> T get(String factName) {
        Objects.requireNonNull(factName, "fact name must not be null");
        Fact<?> fact = getFact(factName);
        if (null != fact) {
            return (T) fact.getValue();
        }
        return null;
    }

    public Fact<?> getFact(String factName) {
        Objects.requireNonNull(factName, "fact name must not be null");
        return facts.stream()
                .filter(fact -> fact.getName().equals(factName))
                .findFirst()
                .orElse(null);
    }

    /**
     * remove by fact name
     * @param factName
     */
    public void remove(String factName) {
        Objects.requireNonNull(factName, "fact name must not be null");
        Fact<?> fact = getFact(factName);
        if (null != fact) {
            remove(fact);
        }
    }

    public <T> void remove(Fact<T> fact) {
        Objects.requireNonNull(fact, "fact name must not be null");
        facts.remove(fact);
    }


    @Override
    public Iterator<Fact<?>> iterator() {
        return facts.iterator();
    }

    @Override
    public String toString() {
        Iterator<Fact<?>> iterator = facts.iterator();
        StringBuilder stringBuilder = new StringBuilder("[");
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString());
            if (iterator.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
