package org.example;

public interface IRecord {
    String getKey(String id);

    Object getCell(String name);

    String[] getColumns();
}
