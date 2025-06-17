package com.example;

public class AlwaysSwitchStrategy implements GameStrategy {
    @Override
    public boolean shouldSwitch() {
        return true;
    }
}

