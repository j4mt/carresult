package com.j4mt.app.view;

import com.j4mt.app.model.CarSet;
import com.j4mt.app.model.CarResult;

import java.util.List;

public class Display {

    public void render(CarSet carSet) {
       carSet.getSet().forEach(System.out::println);
    }

    public void render(List<CarResult> carList) {
        for (CarResult car : carList) {
            System.out.println (car);
        }
    }
}