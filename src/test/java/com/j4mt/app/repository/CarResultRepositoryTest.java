package com.j4mt.app.repository;

import com.j4mt.app.model.CarResult;
import com.j4mt.app.repository.impl.CarResultRepositoryImpl;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarResultRepositoryTest {

    @Test
    public void test_CarResultRepository_getAll(){
        CarResultRepository carResultRepository = new CarResultRepositoryImpl();

        List<CarResult> carResults = carResultRepository.getAll();

        assertThat(carResults.size(), is(309));
    }

}
