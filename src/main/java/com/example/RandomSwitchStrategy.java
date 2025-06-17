package com.example;

public class RandomSwitchStrategy implements GameStrategy {
    @Override
    public boolean shouldSwitch() {
        return Math.random() < 0.5;
    }
}
