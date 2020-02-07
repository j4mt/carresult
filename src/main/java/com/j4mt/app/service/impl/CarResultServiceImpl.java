package com.j4mt.app.service.impl;

import com.j4mt.app.component.CarResultProcessor;
import com.j4mt.app.model.CarResult;
import com.j4mt.app.repository.CarResultRepository;
import com.j4mt.app.service.CarResultService;

import java.util.List;

public class CarResultServiceImpl implements CarResultService {

    private CarResultProcessor carResultProcessor;
    private CarResultRepository carResultRepository;

    public CarResultServiceImpl(CarResultProcessor carResultProcessor, CarResultRepository carResultRepository) {

        this.carResultProcessor = carResultProcessor;
        this.carResultRepository = carResultRepository;
    }

    @Override
    public List<CarResult> getAll() {

        List<CarResult> carResults = carResultRepository.getAll();
        return carResultProcessor.processCars(carResults);
    }
}
