package org.example;

public interface ISingleTableDatabase<T> {
    public String[] getKeys(T record) throws AccessToDatabaseException;

    public T createRecord(T record) throws AccessToDatabaseException;

    public T updateRecord(Object recordId, T updatedRecord) throws AccessToDatabaseException;

    public T getRecord(Object id) throws AccessToDatabaseException;

    public T removeRecord(Object id) throws AccessToDatabaseException;

    public class DatabaseException extends Exception {
        public DatabaseException(String message) {super(String.format("Database exception: %s", message));}
    }

    public class AccessToDatabaseException extends DatabaseException {
        public AccessToDatabaseException(String message) {super(String.format("Exception when accessing database: %s", message));}
    }
}
