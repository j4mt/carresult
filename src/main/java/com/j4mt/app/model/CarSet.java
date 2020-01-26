package com.j4mt.app.model;

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

        List<CarResult> corporateCarResults = filterCorporate();
        List<CarResult> nonCorporateCarResults = filterNonCorporate();

        list.addAll(filterMini(corporateCarResults));
        list.addAll(filterEconomy(corporateCarResults));
        list.addAll(filterCompact(corporateCarResults));
        list.addAll(filterOther(corporateCarResults));

        list.addAll(filterMini(nonCorporateCarResults));
        list.addAll(filterEconomy(nonCorporateCarResults));
        list.addAll(filterCompact(nonCorporateCarResults));
        list.addAll(filterOther(nonCorporateCarResults));

        return list;
    }

    public List<CarResult> filterCorporate() {

        return set.stream()
                .filter(CarResult::isCorporate)
                .collect(Collectors.toList());
    }

    public List<CarResult> filterNonCorporate() {

        return set.stream()
                .filter(s -> !s.isCorporate())
                .collect(Collectors.toList());
    }

    public List<CarResult> filterMini(List<CarResult> carResults) {

        return carResults.stream()
                .filter(CarResult::isMini)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

    public List<CarResult> filterEconomy(List<CarResult> carResults) {

        return carResults.stream()
                .filter(CarResult::isEconomy)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

    public List<CarResult> filterCompact(List<CarResult> carResults) {

        return carResults.stream()
                .filter(CarResult::isCompact)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

    public List<CarResult> filterOther(List<CarResult> carResults) {

        return carResults.stream()
                .filter(CarResult::isOther)
                .sorted(Comparator.comparingDouble(CarResult::getRentalCost))
                .collect(Collectors.toList());
    }

}
