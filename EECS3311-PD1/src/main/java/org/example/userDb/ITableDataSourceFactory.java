package org.example.userDb;

import org.example.userDb.ITableDataSource.TableDataSourceException;

public interface ITableDataSourceFactory {
    ITableDataSource createTableDataSource() throws TableDataSourceException;
}
