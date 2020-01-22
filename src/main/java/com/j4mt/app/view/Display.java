package com.j4mt.app.view;

import com.j4mt.app.modal.CarSet;
import com.j4mt.app.modal.CarResult;

public class Display {
    public void render(CarSet carList) {
        for (CarResult car : carList.getList()) {
            System.out.println (car);
        }
    }
}