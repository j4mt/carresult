package com.j4mt.app.util;

import com.j4mt.app.BaseTest;
import com.j4mt.app.model.CarResult;
import com.j4mt.app.model.CarSet;
import com.j4mt.app.view.Display;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static com.j4mt.app.testUtils.TestConstants.SORTED_LIST_SIZE;

public class CarResultHelperTest extends BaseTest {

    @Test
    public void test_CarResultHelper_filldata(){

        CarSet carList = new CarSet();

        CarResultHelper.fillCarListData(carList);

        assertThat(carList.size(), is(SORTED_LIST_SIZE));
    }

    @Test
    public void test_CarResultHelper_calculateMedion(){
        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);

        List<CarResult> carResultList = carSet.sort();

        Display display = new Display();
        display.render(carSet);

        assertThat(CarResultHelper.calculateMedianRentalCost(carResultList), is(carResult5.getRentalCost()));
    }

}
