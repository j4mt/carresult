package com.j4mt.app.component;

import com.j4mt.app.BaseTest;
import com.j4mt.app.component.impl.CarResultProcessorImpl;
import com.j4mt.app.model.CarResult;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarResultProcessorTest extends BaseTest {

    @Test
    public void test_CarResultProcessor_check_ordering() {
        CarResultProcessor carResultProcessor = new CarResultProcessorImpl();
        List<CarResult> list = carResultProcessor.processCars(Arrays.asList(carResultNC1, carResult6));

        assertThat(list.get(0), is(carResult6));
        assertThat(list.get(1), is(carResultNC1));
    }

    @Test
    public void test_CarResultProcessor_check_duplicate_not_added() {
        CarResultProcessor carResultProcessor = new CarResultProcessorImpl();
        List<CarResult> list = carResultProcessor.processCars(Arrays.asList(carResult7, carResult8));

        assertThat(list.size(), is(1));
    }

    @Test
    public void test_CarResultProcessor_check_medion_FullFull_not_added() {
        CarResultProcessor carResultProcessor = new CarResultProcessorImpl();
        List<CarResult> list = carResultProcessor.processCars(Arrays.asList(carResult6, carResult7));

        assertThat(list.size(), is(1));
    }
}
