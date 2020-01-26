package com.j4mt.app.modal;

import com.j4mt.app.BaseTest;
import com.j4mt.app.util.CarResultHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.j4mt.app.testUtils.TestConstants.SORTED_LIST_SIZE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class CarSetTest extends BaseTest {

    @Test
    public void test_CarSet_add_duplicate_carResult() {

        CarSet carList = new CarSet();

        carList.addCarResult(carResult7);
        carList.addCarResult(carResult8);

        assertThat(carList.size(), is(1));
    }

    @Test
    public void test_CarSet_partition_corporate() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);
        carSet.addCarResult(carResult6);

        List<CarResult> list = carSet.filterCorporate();

        assertThat(list.size(), is(3));
        assertThat(list.get(0).getSupplierName(), is("FIREFLY"));
    }

    @Test
    public void test_CarSet_partition_corporate_mini() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);

        List<CarResult> list = carSet.filterCorporateMini();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("HERTZ"));
    }

    @Test
    public void test_CarSet_partition_corporate_economy() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult7);

        List<CarResult> list = carSet.filterCorporateEconomy();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("AVIS"));
    }

    @Test
    public void test_CarSet_partition_corporate_compact() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult9);

        List<CarResult> list = carSet.filterCorporateCompact();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("ENTERPRISE"));
    }

    @Test
    public void test_CarSet_partition_corporate_other() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult9);

        List<CarResult> list = carSet.filterCorporateOther();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("AVIS"));
        assertThat(list.get(0).getSippCode().startsWith("M"), is(false));
        assertThat(list.get(0).getSippCode().startsWith("C"), is(false));
        assertThat(list.get(0).getSippCode().startsWith("E"), is(false));
    }

    @Test
    public void test_CarSet_partition_non_corporate_mini() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);

        List<CarResult> list = carSet.filterNonCorporateMini();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("CENTAURO"));
    }

    @Test
    public void test_CarSet_partition_non_corporate_economy() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult7);

        List<CarResult> list = carSet.filterNonCorporateEconomy();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("NIZA"));
    }

    @Test
    public void test_CarSet_partition_non_corporate_compact() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult9);

        List<CarResult> list = carSet.filterNonCorporateCompact();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("GOLDCAR"));
    }

    @Test
    public void test_CarSet_partition_non_corporate_other() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult9);
        carSet.addCarResult(carResult10); // Non Corporate other this should only be return in list,

        List<CarResult> list = carSet.filterNonCorporateOther();

        assertThat(list.size(), is(1));
        assertThat(list.get(0).getSupplierName(), is("GOLDCAR"));
        assertThat(list.get(0).getSippCode().startsWith("M"), is(false));
        assertThat(list.get(0).getSippCode().startsWith("E"), is(false));
        assertThat(list.get(0).getSippCode().startsWith("C"), is(false));
    }

    @Test
    public void test_CarSet_partition_non_corporate() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);
        carSet.addCarResult(carResult6);

        List<CarResult> list = carSet.filterNonCorporate();

        assertThat(list.size(), is(3));
        assertThat(list.get(0).getSupplierName(), is("CENTAURO"));
        assertThat(list.get(0).getDescription(), is("Peugeot 107"));
    }

    @Test
    public void test_CarSet_sort() {

        CarSet carList = new CarSet();
        CarResultHelper.fillCarListData(carList);

        List<CarResult> carResults = carList.sort();

        System.out.println("Car List Size : " + carList.size());

        assertThat(carResults.get(0).getSippCode().startsWith("M"), is(true));
        assertThat(carResults.get(carResults.size() - 1).getSippCode().startsWith("M"), is(false));
        assertThat(carResults.get(carResults.size() - 1).getSippCode().startsWith("C"), is(false));
        assertThat(carResults.get(carResults.size() - 1).getSippCode().startsWith("E"), is(false));

        assertThat(carResults.size(), is(SORTED_LIST_SIZE));
    }

    @Test
    public void test_CarSet_filterMedionRentalPriceFPFF(){
        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);
        carSet.addCarResult(carResult6);

        List<CarResult> sortedList = carSet.sort();

        Double medionRentalCost = CarResultHelper.calculateMedionRentalCost(sortedList);

        List<CarResult> carResultListMFFPFF = CarResultHelper.filterAboveMedionFPFullFull(sortedList);

        assertThat(carResultListMFFPFF.get(0).getFuelPolicy(), is(CarResult.FuelPolicy.FULLEMPTY));
        assertThat(carResultListMFFPFF.get(1).getFuelPolicy(), is(CarResult.FuelPolicy.FULLEMPTY));
        assertThat(carResultListMFFPFF.get(2).getFuelPolicy(), is(CarResult.FuelPolicy.FULLEMPTY));
        assertThat(carResultListMFFPFF.get(0).getRentalCost(), lessThan(medionRentalCost));
        assertThat(carResultListMFFPFF.get(1).getRentalCost(), lessThan(medionRentalCost));
        assertThat(carResultListMFFPFF.get(2).getRentalCost(), lessThan(medionRentalCost));

    }
}
