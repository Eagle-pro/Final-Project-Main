package com.example.abyssiniancoffee.model;

public enum CultivationArea {
    HIGHLAND("Highland"),
    LOWLAND("Lowland");

    private final String label;

    CultivationArea(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
