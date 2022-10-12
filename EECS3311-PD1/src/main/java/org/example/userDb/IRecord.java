package org.example.userDb;

public interface IRecord {
    String getKey();

    Object getCell(String name);

    String[] getColumns();
}
