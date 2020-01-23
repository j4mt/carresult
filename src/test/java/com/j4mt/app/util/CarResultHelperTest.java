package com.j4mt.app.util;

import com.j4mt.app.modal.CarSet;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CarResultHelperTest {

    @Test
    public void test_CarResultHelper_filldata(){
        CarSet carList = new CarSet();

        CarResultHelper.fillCarListData(carList);

        assertThat(carList.size(), is(239));
    }
}
