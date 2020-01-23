package com.j4mt.app.modal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CarSetTest {

    CarResult carResult1, carResult2, carResult3, carResult4, carResult5, carResult6, carResult7, carResult8, carResult9;
    @BeforeEach
    public void setUpCarSet(){

        //    • Within both the corporate and non-corporate groups, sort the cars into “mini”, “economy”, “compact” and “other” based on SIPP beginning with M, E, C respectively.
        carResult1 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY);
        carResult2 = new CarResult("Peugeot 107", "CENTAURO", "MCMR", 9.78d, CarResult.FuelPolicy.FULLEMPTY);
        carResult3 = new CarResult("Toyota Avensis", "GOLDCAR", "CWMR", 301.95d, CarResult.FuelPolicy.FULLEMPTY);
        carResult4 = new CarResult("Toyota Avensis", "AVIS", "IDMR", 373.69d, CarResult.FuelPolicy.FULLFULL);
        carResult5 = new CarResult("Peugeot 107", "HERTZ", "MCMR", 67.98d, CarResult.FuelPolicy.FULLFULL);
        carResult6 = new CarResult("Volkswagen Polo", "FIREFLY", "EDMR", 29.79d, CarResult.FuelPolicy.FULLEMPTY);
        carResult7 = new CarResult("Ford Focus Estate", "AVIS", "EDMR", 291.28d, CarResult.FuelPolicy.FULLFULL);
        carResult8 = new CarResult("Ford Focus Estate", "AVIS", "EDMR", 281.28d, CarResult.FuelPolicy.FULLFULL);
        carResult9 = new CarResult("Citroen Berlingo", "ENTERPRISE", "CMMV", 212.23d, CarResult.FuelPolicy.FULLFULL);

    }

    @Test
    public void test_CarList_add_duplicate_carResult() {

        CarSet carList = new CarSet();

        carList.addCarResult(carResult7);
        carList.addCarResult(carResult8);

        assertThat(carList.size(), is(1));
    }

    @Test
    public void test_CarList_partition_corporate() {

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);
        carSet.addCarResult(carResult6);

        List<CarResult> list = carSet.partitionCorporate();

        assertThat(list.size(), is(3));
        assertThat(list.get(0).getSupplierName(), is("FIREFLY"));
    }


    @Test
    public void test_CarList_partition_non_corporate() {

        CarResult carResult1 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult2 = new CarResult("Peugeot 107", "CENTAURO", "MCMR", 9.78d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult3 = new CarResult("Toyota Avensis", "GOLDCAR", "IDMR", 301.95d, CarResult.FuelPolicy.FULLEMPTY);
        CarResult carResult4 = new CarResult("Toyota Avensis", "AVIS", "IDMR", 373.69d, CarResult.FuelPolicy.FULLFULL);
        CarResult carResult5 = new CarResult("Toyota Avensis", "AVIS", "IDMR", 363.69d, CarResult.FuelPolicy.FULLFULL);
        CarResult carResult6 =new CarResult("Volkswagen Polo", "FIREFLY", "EDMR", 29.79d, CarResult.FuelPolicy.FULLEMPTY);

        CarSet carSet = new CarSet();
        carSet.addCarResult(carResult1);
        carSet.addCarResult(carResult2);
        carSet.addCarResult(carResult3);
        carSet.addCarResult(carResult4);
        carSet.addCarResult(carResult5);
        carSet.addCarResult(carResult6);

        List<CarResult> list = carSet.partitionNonCorporate();

        assertThat(list.size(), is(3));
        assertThat(list.get(0).getSupplierName(), is("CENTAURO"));
    }
}
