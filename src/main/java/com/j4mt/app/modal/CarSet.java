package com.j4mt.app.modal;

import java.util.HashSet;
import java.util.Set;

public class CarSet {

    private final HashSet<CarResult> list;

    public CarSet() {

        this.list = new HashSet<>();
    }

    public void addCarResult(CarResult carResult){

        list.add(carResult);
    }

    public void removeDuplicates() {

        HashSet<CarResult> carResults = new HashSet<>(this.list);
    }

    public int size() {

        return list.size();
    }

    public Set<CarResult> getList() {

        return list;
    }


}
