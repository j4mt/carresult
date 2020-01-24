package com.j4mt.app.util;

import com.j4mt.app.modal.CarSet;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static com.j4mt.app.testUtils.TestConstants.SORTED_LIST_SIZE;

public class CarResultHelperTest {

    @Test
    public void test_CarResultHelper_filldata(){

        CarSet carList = new CarSet();

        CarResultHelper.fillCarListData(carList);

        assertThat(carList.size(), is(SORTED_LIST_SIZE));
    }
}
