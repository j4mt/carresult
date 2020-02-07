package com.j4mt.app.service;

import com.j4mt.app.BaseTest;
import com.j4mt.app.service.impl.CarResultServiceImpl;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarResultServiceTest extends BaseTest {

    @Test
    public void test_CarResultService_() {

        MockCarResultProcessor carResultProcessor = new MockCarResultProcessor();
        MockCarResultRepository carResultRepository = new MockCarResultRepository();

        CarResultService carResultService = new CarResultServiceImpl(carResultProcessor, carResultRepository);
        carResultService.getAll();

        assertThat(carResultProcessor.processCarsCalled, is(true));
        assertThat(carResultRepository.getAllCalled, is(true));
    }
}
