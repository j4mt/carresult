package com.j4mt.app;

import com.j4mt.app.model.CarResult;
import com.j4mt.app.model.FuelPolicy;
import org.junit.Before;

public class BaseTest {

    protected CarResult carResultNC1, carResultNC2, carResultNC3, carResult4, carResult5, carResult6, carResult7, carResult8, carResult9, carResultNC10;

    @Before
    public void setUpCarSet() {

        //    Note corporate cars are those supplied by AVIS, BUDGET, ENTERPRISE, FIREFLY, HERTZ, SIXT, THRIFTY.
        carResultNC1 = new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, FuelPolicy.FULLEMPTY);
        carResultNC2 = new CarResult("Peugeot 107", "CENTAURO", "MCMR", 9.78d, FuelPolicy.FULLEMPTY);
        carResultNC3 = new CarResult("Toyota Avensis", "GOLDCAR", "CWMR", 301.95d, FuelPolicy.FULLEMPTY);
        carResult4 = new CarResult("Toyota Avensis", "AVIS", "IDMR", 373.69d, FuelPolicy.FULLFULL);
        carResult5 = new CarResult("Peugeot 107", "HERTZ", "MCMR", 67.98d, FuelPolicy.FULLFULL);
        carResult6 = new CarResult("Volkswagen Polo", "FIREFLY", "EDMR", 29.79d, FuelPolicy.FULLEMPTY);
        carResult7 = new CarResult("Ford Focus Estate", "AVIS", "EDMR", 291.28d, FuelPolicy.FULLFULL);
        carResult8 = new CarResult("Ford Focus Estate", "AVIS", "EDMR", 281.28d, FuelPolicy.FULLFULL);
        carResult9 = new CarResult("Citroen Berlingo", "ENTERPRISE", "CMMV", 212.23d, FuelPolicy.FULLFULL);
        carResultNC10 = new CarResult("Toyota Avensis", "GOLDCAR", "IDMR", 301.95d, FuelPolicy.FULLEMPTY);
    }
}
