package com.j4mt.app.model;

public enum CarType {

    MINI("M"),
    ECONOMY("E"),
    COMPACT("C"),
    OTHER("O");

    private final String code;

    CarType(String code) {

        this.code = code;
    }

    public static CarType getCarType(String code) {

        for (CarType carType : CarType.values())
            if (carType.code.equals(code))
                return carType;
        return OTHER;
    }
}
