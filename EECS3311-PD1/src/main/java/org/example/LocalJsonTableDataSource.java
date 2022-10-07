package org.example;

import java.io.File;

public class LocalJsonTableDataSource implements ITableDataSource {
    private String fileName;

    private File file;

    public LocalJsonTableDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String[] getKeys() {
        return new String[0];
    }

    @Override
    public IRecord getRecord(String key) {
        return null;
    }

    @Override
    public IRecord updateRecord(String key, IRecord newRecord) {
        return null;
    }

    @Override
    public IRecord createRecord(String key, IRecord newRecord) {
        return null;
    }

    @Override
    public IRecord removeRecord(String key) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
