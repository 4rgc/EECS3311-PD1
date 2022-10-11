package org.example.userDb;

public class User implements IUser {
    private final String key;
    private String username;
    private String password;

    public User(IRecord record) throws ClassCastException {
        this.key = record.getKey();
        this.username = (String) record.getCell("username");
        this.password = (String) record.getCell("password");
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
