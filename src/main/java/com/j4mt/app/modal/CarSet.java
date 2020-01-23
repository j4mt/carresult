package com.j4mt.app.modal;

import java.util.*;
import java.util.stream.Collectors;

public class CarSet {

    private final Set<CarResult> set = new HashSet<>();

    public void addCarResult(CarResult carResult) {

        set.add(carResult);
    }

    public int size() {

        return set.size();
    }

    public Set<CarResult> getSet() {

        return set;
    }


    public List<CarResult> sort() {

        List<CarResult> list = new ArrayList<>();
        list.addAll(partitionCorporate());
        list.addAll(partitionNonCorporate());
        return list;
    }

    public List<CarResult> partitionCorporate() {

        return set.stream()
                .filter(this::isCorporate)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }
//    • Within both the corporate and non-corporate groups, sort the cars into “mini”, “economy”, “compact” and “other” based on SIPP beginning with M, E, C respectively.

    public List<CarResult> partitionCorporateMini(){

        return  partitionCorporate().stream()
                .filter(this::isCorporateMini)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionCorporateEconomy(){

        return  partitionCorporate().stream()
                .filter(this::isCorporateEconomy)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionCorporateCompact(){

        return  partitionCorporate().stream()
                .filter(this::isCorporateCompact)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionCorporateOther(){

        return  partitionCorporate().stream()
                .filter(this::isCorporateOther)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionNonCorporate() {

        return set.stream()
                .filter(s -> !isCorporate(s))
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

    private boolean isCorporate(CarResult s) {
        return s.getSupplierName().equals("AVIS")
                || s.getSupplierName().equals("BUDGET")
                || s.getSupplierName().equals("ENTERPRISE")
                || s.getSupplierName().equals("FIREFLY")
                || s.getSupplierName().equals("HERTZ")
                || s.getSupplierName().equals("SIXT")
                || s.getSupplierName().equals("THRIFTY");
    }

    private boolean isCorporateMini(CarResult s) {
        return s.getSippCode().startsWith("M");
    }

    private boolean isCorporateEconomy(CarResult s) {
        return s.getSippCode().startsWith("E");
    }

    private boolean isCorporateCompact(CarResult s) {
        return s.getSippCode().startsWith("C");
    }

    private boolean isCorporateOther(CarResult s) {
        return !isCorporateMini(s) || !isCorporateEconomy(s) || !isCorporateCompact(s) ;
    }

}
