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

    private List<CarResult> partitionCorporate() {

        return set.stream()
                .filter(this::isCorporate)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

    private List<CarResult> partitionNonCorporate() {

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
}
