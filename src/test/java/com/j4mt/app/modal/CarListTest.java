package com.j4mt.app.modal;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CarListTest {

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
    public void test_CarList_removeDuplicates() {

        CarResult carResult1 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult2 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY);
        CarSet carList = new CarSet();

        carList.addCarResult(carResult1);
        carList.addCarResult(carResult2);
        carList.removeDuplicates();

        assertThat(carList.size(), is(1));
    }
}
