package org.example.userDb;

import org.example.userDb.ISingleTableDatabase.DatabaseException;

public class UserDbModel {
    private final ISingleTableDatabase<IUser> db;

    public UserDbModel(ISingleTableDatabase<IUser> db) {
        this.db = db;
    }

    public IUser createUser(IUser newUser) throws DatabaseException {
        return db.createRecord(newUser);
    }

    public IUser getUserById(String id) throws DatabaseException {
        return db.getRecord(id);
    }

    public IUser getUserByUsername(String username) throws DatabaseException {
        String[] keys = db.getKeys();
        for (String key: keys) {
            IUser curUser = db.getRecord(key);
            if (curUser.getUsername().equals(username)) {
                return curUser;
            }
        }
        return null;
    }

    public IUser changeUserPassword(String id, String newPassword) throws DatabaseException {
        IUser user = db.getRecord(id);
        if(user == null)
            return null;
        user.setPassword(newPassword);
        return db.updateRecord(user);
    }

    public IUser changeUserUsername(String id, String newUsername) throws DatabaseException {
        IUser user = db.getRecord(id);
        if(user == null)
            return null;
        user.setUsername(newUsername);
        return db.updateRecord(user);
    }

    public IUser deleteUser(String id) throws DatabaseException {
        return db.removeRecord(id);
    }
}
