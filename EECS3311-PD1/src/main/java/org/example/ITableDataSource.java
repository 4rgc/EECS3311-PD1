package org.example;

public interface ITableDataSource extends AutoCloseable {
    String[] getKeys() throws TableDataSourceException;

    String[] getColumns() throws TableDataSourceException;

    IRecord getRecord(String key) throws TableDataSourceException;

    IRecord updateRecord(String key, IRecord newRecord) throws TableDataSourceException;

    IRecord createRecord(IRecord newRecord) throws TableDataSourceException;

    IRecord removeRecord(String key) throws TableDataSourceException;

    class TableDataSourceException extends Exception {
        public TableDataSourceException(String message) {
            super("TableDataSource exception: " + message);
        }
    }
}
