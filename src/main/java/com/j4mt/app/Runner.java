package com.j4mt.app;

import com.j4mt.app.modal.CarSet;
import com.j4mt.app.util.CarResultHelper;
import com.j4mt.app.view.Display;

public class Runner {

    public static void main(String[] args) {

        CarSet carList = new CarSet();
        CarResultHelper.fillCarListData(carList);

        Display display = new Display();

        display.render(carList.sort());
    }
}
