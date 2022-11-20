package org.example;

import org.springframework.stereotype.Component;

@Component
public class Manul {
    private String name="Мурзик";
    private int weight=10;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
