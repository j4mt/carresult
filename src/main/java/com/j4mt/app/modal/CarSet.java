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

    public List<CarResult> sort() {

        List<CarResult> list = new ArrayList<>();

        list.addAll(partitionCorporateMini());
        list.addAll(partitionCorporateEconomy());
        list.addAll(partitionCorporateCompact());
        list.addAll(partitionCorporateOther());
        list.addAll(partitionNonCorporateMini());
        list.addAll(partitionNonCorporateEconomy());
        list.addAll(partitionNonCorporateCompact());
        list.addAll(partitionNonCorporateOther());

        return list;
    }

    public List<CarResult> partitionCorporate() {

        return set.stream()
                .filter(this::isCorporate)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionNonCorporate() {

        return set.stream()
                .filter(s -> !isCorporate(s))
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }
//    • Within both the corporate and non-corporate groups, sort the cars into “mini”, “economy”, “compact” and “other” based on SIPP beginning with M, E, C respectively.

    public List<CarResult> partitionCorporateMini(){

        return  partitionCorporate().stream()
                .filter(this::isMini)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionCorporateEconomy(){

        return  partitionCorporate().stream()
                .filter(this::isEconomy)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionCorporateCompact(){

        return  partitionCorporate().stream()
                .filter(this::isCompact)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionCorporateOther(){

        return  partitionCorporate().stream()
                .filter(this::isOther)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionNonCorporateMini(){

        return  partitionNonCorporate().stream()
                .filter(this::isMini)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionNonCorporateEconomy(){

        return  partitionNonCorporate().stream()
                .filter(this::isEconomy)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionNonCorporateCompact(){

        return  partitionNonCorporate().stream()
                .filter(this::isCompact)
                .collect(Collectors.toList());
    }

    public List<CarResult> partitionNonCorporateOther(){

        return  partitionNonCorporate().stream()
                .filter(this::isOther)
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

    private boolean isMini(CarResult s) {
        return s.getSippCode().startsWith("M");
    }

    private boolean isEconomy(CarResult s) {
        return s.getSippCode().startsWith("E");
    }

    private boolean isCompact(CarResult s) {
        return s.getSippCode().startsWith("C");
    }

    private boolean isOther(CarResult s) {
        return !isMini(s) && !isEconomy(s) && !isCompact(s) ;
    }

}
