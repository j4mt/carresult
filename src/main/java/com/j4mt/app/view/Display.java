package com.j4mt.app.view;

import com.j4mt.app.modal.CarSet;
import com.j4mt.app.modal.CarResult;

import java.util.List;

public class Display {
    public void render(List<CarResult> carList) {
        for (CarResult car : carList) {
            System.out.println (car);
        }
    }
}