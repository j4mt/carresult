package com.j4mt.app.service;

import com.j4mt.app.model.CarResult;
import com.j4mt.app.repository.CarResultRepository;

import java.util.Collections;
import java.util.List;

public class MockCarResultRepository implements CarResultRepository {

    public boolean getAllCalled = false;

    @Override
    public List<CarResult> getAll() {
        getAllCalled = true;
        return Collections.emptyList();
    }
}
