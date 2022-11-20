package org.example;

import org.springframework.stereotype.Component;

@Component
public class Sphynx {
    private String name="Рамзес";
    private int weight=5;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
