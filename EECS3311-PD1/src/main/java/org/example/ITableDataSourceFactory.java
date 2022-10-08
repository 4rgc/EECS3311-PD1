package org.example;

import org.example.ITableDataSource.TableDataSourceException;

public interface ITableDataSourceFactory {
    ITableDataSource createTableDataSource() throws TableDataSourceException;
}
