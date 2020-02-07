package com.j4mt.app.component;

import com.j4mt.app.model.CarResult;

import java.util.List;

public interface CarResultProcessor {

    List<CarResult> processCars(List<CarResult> carResults);
}
