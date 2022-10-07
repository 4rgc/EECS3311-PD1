package org.example;

public class LocalJsonTableDataSourceFactory implements ITableDataSourceFactory {

    private final String fileName;

    public LocalJsonTableDataSourceFactory(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ITableDataSource createTableDataSource() {
        return new LocalJsonTableDataSource(fileName);
    }
}
