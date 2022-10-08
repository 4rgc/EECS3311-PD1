package org.example;

public interface ITableDataSource extends AutoCloseable {
    String[] getKeys();

    String[] getColumns();

    IRecord getRecord(String key);

    IRecord updateRecord(String key, IRecord newRecord);

    IRecord createRecord(IRecord newRecord);

    IRecord removeRecord(String key);

    class TableDataSourceException extends Exception {
        public TableDataSourceException(String message) {
            super("TableDataSource exception: " + message);
        }
    }
}
