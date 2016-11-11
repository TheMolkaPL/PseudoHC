package com.gmail.grzegorz2047.pseudohc;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public class Regions implements Storage {

    Table<Integer, Integer, String> regions = HashBasedTable.create();


    @Override
    public void load() {

    }
}
