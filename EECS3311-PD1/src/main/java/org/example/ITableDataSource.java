package org.example;

public interface ITableDataSource extends AutoCloseable {
    public String[] getKeys();

    public IRecord getRecord(String key);

    public IRecord updateRecord(String key, IRecord newRecord);

    public IRecord createRecord(String key, IRecord newRecord);

    public IRecord removeRecord(String key);
}
