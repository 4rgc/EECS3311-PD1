package org.example.userDb;

import org.example.userDb.ITableDataSource.TableDataSourceException;

public class LocalJsonTableDataSourceFactory implements ITableDataSourceFactory {

    private final String fileName;

    public LocalJsonTableDataSourceFactory(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ITableDataSource createTableDataSource() throws TableDataSourceException {
        return new LocalJsonTableDataSource(fileName);
    }
}
