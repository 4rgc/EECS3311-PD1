package org.example;

public interface ITableDataSource extends AutoCloseable {
    public String[] getKeys();

    public IRecord getRecord(String key);

    public IRecord updateRecord(String key, IRecord newRecord);

    public IRecord createRecord(IRecord newRecord);

    public IRecord removeRecord(String key);

    public class TableDataSourceException extends Exception {
        public TableDataSourceException(String message) {
            super("TableDataSource exception: " + message);
        }
    }
}
