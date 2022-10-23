package org.example.userDb;

public interface IUser extends IDbRecord, Cloneable {
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String newPassword);
}
