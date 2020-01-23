package com.j4mt.app.modal;

import com.j4mt.app.util.CarResultHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CarSetTest {

    @Test
    public void test_CarList_add_carResult() {

        CarResult carResult1 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult2 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY);
        CarSet carList = new CarSet();

        carList.addCarResult(carResult1);
        carList.addCarResult(carResult2);

        assertThat(carList.size(), is(1));
    }

    @Test
    public void test_CarList_sort_list() {

        CarResult carResult1 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult2 = new CarResult("Peugeot 107", "CENTAURO", "MCMR", 9.78d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult3 = new CarResult("Toyota Avensis", "GOLDCAR", "IDMR", 301.95d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult4 = new CarResult("Toyota Avensis", "AVIS", "IDMR", 373.69d, CarResult.FuelPolicy.FULLFULL);

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);

        List<CarResult> list = carSet.sort();

        assertThat(list.get(0).getSupplierName(), is("AVIS"));
    }
}
