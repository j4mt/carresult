package com.j4mt.app.view;

import com.j4mt.app.modal.CarSet;
import com.j4mt.app.modal.CarResult;

import java.util.List;
import java.util.Set;

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