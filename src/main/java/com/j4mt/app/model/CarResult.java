package com.j4mt.app.model;

import java.util.Objects;

public class CarResult {

    private final String description;
    private final String supplierName;
    private final String sippCode;
    private final double rentalCost;
    private final FuelPolicy fuelPolicy;

    private final CarType carType;

    public CarResult(String description, String supplierName, String sipp, double cost, FuelPolicy fuelPolicy) {

        this.description = description;
        this.supplierName = supplierName;
        this.sippCode = sipp;
        this.rentalCost = cost;
        this.fuelPolicy = fuelPolicy;

        this.carType = CarType.getCarType(sipp.substring(0, 1).toUpperCase());
    }

    public CarType getCarType() {
        return carType;
    }

    public String getDescription() {

        return this.description;
    }

    public String getSupplierName() {

        return this.supplierName;
    }

    public String getSippCode() {

        return this.sippCode;
    }

    public double getRentalCost() {

        return this.rentalCost;
    }

    public FuelPolicy getFuelPolicy() {

        return this.fuelPolicy;
    }

    public boolean isFullEmpty() {
        return fuelPolicy == FuelPolicy.FULLEMPTY;
    }

    public boolean isCorporate() {
        return getSupplierName().equals("AVIS")
                || getSupplierName().equals("BUDGET")
                || getSupplierName().equals("ENTERPRISE")
                || getSupplierName().equals("FIREFLY")
                || getSupplierName().equals("HERTZ")
                || getSupplierName().equals("SIXT")
                || getSupplierName().equals("THRIFTY");
    }

    public String toString() {

        return this.supplierName + " : " +
                this.description + " : " +
                this.sippCode + " : " +
                this.rentalCost + " : " +
                this.fuelPolicy;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResult carResult = (CarResult) o;
        return Objects.equals(description, carResult.description) &&
                Objects.equals(supplierName, carResult.supplierName) &&
                Objects.equals(sippCode, carResult.sippCode) &&
                fuelPolicy == carResult.fuelPolicy;
    }

    @Override
    public int hashCode() {

        return Objects.hash(description, supplierName, sippCode, fuelPolicy);
    }
}