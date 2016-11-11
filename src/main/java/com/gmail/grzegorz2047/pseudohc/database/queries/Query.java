package com.gmail.grzegorz2047.pseudohc.database.queries;

import com.gmail.grzegorz2047.pseudohc.database.DatabaseConnector;

/**
 * Created by grzegorz2047 on 11.11.2016.
 */
public abstract class Query implements Tables {
    protected final DatabaseConnector databaseConnector;
    protected final String table;

    public Query(DatabaseConnector databaseConnector, String table, String prefix) {
        this.databaseConnector = databaseConnector;
        this.table = prefix + table;
    }
}
