package com.j4mt.app.model;

import java.util.Objects;

public class CarResult {
    private final String description;
    private final String supplierName;
    private final String sippCode;
    private final double rentalCost;
    private final FuelPolicy fuelPolicy;

    public enum FuelPolicy {

        FULLFULL,
        FULLEMPTY
    }

    public CarResult(String description, String supplierName, String sipp, double cost, FuelPolicy fuelPolicy) {

        this.description = description;
        this.supplierName = supplierName;
        this.sippCode = sipp;
        this.rentalCost = cost;
        this.fuelPolicy = fuelPolicy;
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

    public boolean isMini() {
        return getSippCode().startsWith("M");
    }

    public boolean isEconomy() {
        return getSippCode().startsWith("E");
    }

    public boolean isCompact() {
        return getSippCode().startsWith("C");
    }

    public boolean isOther() {
        return !isMini() && !isEconomy() && !isCompact() ;
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
}