package com.j4mt.app;

import com.j4mt.app.component.impl.CarResultProcessorImpl;
import com.j4mt.app.model.CarResult;
import com.j4mt.app.repository.impl.CarResultRepositoryImpl;
import com.j4mt.app.service.CarResultService;
import com.j4mt.app.service.impl.CarResultServiceImpl;
import com.j4mt.app.view.Display;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        CarResultService carResultService =
                new CarResultServiceImpl(
                        new CarResultProcessorImpl(),
                        new CarResultRepositoryImpl()
                );
        List<CarResult> carResults = carResultService.getAll();

        Display display = new Display();
        display.render(carResults);

        System.out.println("\n\nSize : " + carResults.size());
    }
}
