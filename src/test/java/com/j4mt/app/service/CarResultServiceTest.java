package com.j4mt.app.service;

import com.j4mt.app.component.impl.CarResultProcessorImpl;
import com.j4mt.app.model.CarResult;
import com.j4mt.app.repository.impl.CarResultRepositoryImpl;
import com.j4mt.app.service.impl.CarResultServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarResultServiceTest {

    @Test
    public void test_CarResultService_(){
        CarResultService carResultService =
                new CarResultServiceImpl(
                        new CarResultProcessorImpl(),
                        new CarResultRepositoryImpl()
                );
        List<CarResult> carResults = carResultService.getAll();

        assertThat(carResults.size(),is(143));
    }
}
