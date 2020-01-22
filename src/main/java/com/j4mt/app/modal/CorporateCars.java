package com.j4mt.app.modal;

public enum CorporateCars {
    AVIS("AVIS"),
    BUDGET("BUDGET"),
    ENTERPRISE("ENTERPRISE"),
    FIREFLY("FIREFLY"),
    HERTZ("HERTZ"),
    SIXT("SIXT"),
    THRIFTY("THRIFTY");

    private final String text;

    CorporateCars(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("CorporateCars{text='%s'}", text);
    }
}
