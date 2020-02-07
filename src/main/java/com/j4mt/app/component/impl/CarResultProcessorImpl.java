package com.j4mt.app.component.impl;

import com.j4mt.app.component.CarResultProcessor;
import com.j4mt.app.model.CarResult;
import com.j4mt.app.model.CarType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarResultProcessorImpl implements CarResultProcessor {

    @Override
    public List<CarResult> processCars(List<CarResult> carResults) {

        List<CarResult> list = new ArrayList<>();

        Map<Boolean, List<CarResult>> partitionCorporate =
                carResults.stream()
                        .distinct()
                        .collect(Collectors.partitioningBy(CarResult::isCorporate));

        Map<CarType, List<CarResult>> partitionCorporateByType =
                partitionCorporate.getOrDefault(true, new ArrayList<>()).stream()
                        .collect(Collectors.groupingBy(CarResult::getCarType));

        list.addAll(filterMedianRentalCost(partitionCorporateByType.getOrDefault(CarType.MINI, new ArrayList<>())));
        list.addAll(filterMedianRentalCost(partitionCorporateByType.getOrDefault(CarType.ECONOMY, new ArrayList<>())));
        list.addAll(filterMedianRentalCost(partitionCorporateByType.getOrDefault(CarType.COMPACT, new ArrayList<>())));
        list.addAll(filterMedianRentalCost(partitionCorporateByType.getOrDefault(CarType.OTHER, new ArrayList<>())));

        Map<CarType, List<CarResult>> partitionNonCorporateByType =
                partitionCorporate.getOrDefault(false, new ArrayList<>()).stream()
                        .collect(Collectors.groupingBy(CarResult::getCarType));

        list.addAll(filterMedianRentalCost(partitionNonCorporateByType.getOrDefault(CarType.MINI, new ArrayList<>())));
        list.addAll(filterMedianRentalCost(partitionNonCorporateByType.getOrDefault(CarType.ECONOMY, new ArrayList<>())));
        list.addAll(filterMedianRentalCost(partitionNonCorporateByType.getOrDefault(CarType.COMPACT, new ArrayList<>())));
        list.addAll(filterMedianRentalCost(partitionNonCorporateByType.getOrDefault(CarType.OTHER, new ArrayList<>())));

        return list;
    }

    private List<CarResult> filterMedianRentalCost(List<CarResult> list) {

        if (list.size() > 0) {
            Double medianRentalCost = calculateMedianRentalCost(list);
            return list.stream()
                    .filter(c -> c.isFullEmpty() || c.getRentalCost() <= medianRentalCost)
                    .sorted(Comparator.comparing(CarResult::getRentalCost))
                    .collect(Collectors.toList());
        } else {
            return list;
        }
    }

    public Double calculateMedianRentalCost(List<CarResult> carResultList) {

        List<Double> rentalCostList =
                carResultList.stream()
                        .map(CarResult::getRentalCost)
                        .sorted()
                        .collect(Collectors.toList());

        if (rentalCostList.size() % 2 == 0)
            return (rentalCostList.get(rentalCostList.size() / 2) + rentalCostList.get(rentalCostList.size() / 2 - 1)) / 2;
        else
            return rentalCostList.get(rentalCostList.size() / 2);
    }
}
