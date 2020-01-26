package com.j4mt.app.modal;

import com.j4mt.app.util.CarResultHelper;

import java.util.*;
import java.util.stream.Collectors;

public class CarSet {

    private final Set<CarResult> set = new HashSet<>();

    public void addCarResult(CarResult carResult) {

        set.add(carResult);
    }

    public Set<CarResult> getSet() {
        return set;
    }

    public int size() {

        return set.size();
    }

    public List<CarResult> sort() {

        List<CarResult> list = new ArrayList<>();

        list.addAll(filterCorporateMini());
        list.addAll(filterCorporateEconomy());
        list.addAll(filterCorporateCompact());
        list.addAll(filterCorporateOther());
        list.addAll(filterNonCorporateMini());
        list.addAll(filterNonCorporateEconomy());
        list.addAll(filterNonCorporateCompact());
        list.addAll(filterNonCorporateOther());

        return list;
    }

    public List<CarResult> filterCorporate() {

        return set.stream()
                .filter(this::isCorporate)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

    public List<CarResult> filterNonCorporate() {

        return set.stream()
                .filter(s -> !isCorporate(s))
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }
//    • Within both the corporate and non-corporate groups, sort the cars into “mini”, “economy”, “compact” and “other” based on SIPP beginning with M, E, C respectively.

    public List<CarResult> filterCorporateMini(){

        return  filterCorporate().stream()
                .filter(CarResult::isMini)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterCorporateEconomy(){

        return  filterCorporate().stream()
                .filter(CarResult::isEconomy)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterCorporateCompact(){

        return  filterCorporate().stream()
                .filter(CarResult::isCompact)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterCorporateOther(){

        return  filterCorporate().stream()
                .filter(CarResult::isOther)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterNonCorporateMini(){

        return  filterNonCorporate().stream()
                .filter(CarResult::isMini)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterNonCorporateEconomy(){

        return  filterNonCorporate().stream()
                .filter(CarResult::isEconomy)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterNonCorporateCompact(){

        return  filterNonCorporate().stream()
                .filter(CarResult::isCompact)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterNonCorporateOther(){

        return  filterNonCorporate().stream()
                .filter(CarResult::isOther)
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
}
