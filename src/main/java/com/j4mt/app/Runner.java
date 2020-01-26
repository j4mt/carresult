package com.j4mt.app;

import com.j4mt.app.modal.CarResult;
import com.j4mt.app.modal.CarSet;
import com.j4mt.app.util.CarResultHelper;
import com.j4mt.app.view.Display;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        CarSet carList = new CarSet();
        CarResultHelper.fillCarListData(carList);

        Display display = new Display();
        List<CarResult> sortedList = carList.sort();

        display.render(carList);
        System.out.println("\n\nSet Size: = " + sortedList.size() + ".\n\n");

        display.render(sortedList);
        System.out.println("\n\nList Size after Sort: = " + sortedList.size() + ".\n\n");

        display.render(CarResultHelper.filterAboveMedionFPFullFull(sortedList));
        System.out.println("\n\nList after medion rental cost fuel Policy Full Full: = " + sortedList.size() + ".\n\n");
    }
}
