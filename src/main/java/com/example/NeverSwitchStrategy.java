package com.example;

public class NeverSwitchStrategy implements GameStrategy {
    @Override
    public boolean shouldSwitch() {
        return false;
    }
}
