package org.example;

public interface IUser extends IDbRecord {
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String newPassword);
}
