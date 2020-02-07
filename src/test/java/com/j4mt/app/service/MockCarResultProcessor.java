package com.j4mt.app.service;

import com.j4mt.app.component.CarResultProcessor;
import com.j4mt.app.model.CarResult;

import java.util.List;

public class MockCarResultProcessor implements CarResultProcessor {

    public boolean processCarsCalled = false;

    @Override
    public List<CarResult> processCars(List<CarResult> carResults) {
        processCarsCalled = true;
        return carResults;
    }
}
