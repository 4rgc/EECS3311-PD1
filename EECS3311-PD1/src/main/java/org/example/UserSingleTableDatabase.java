package org.example;

import org.example.ITableDataSource.TableDataSourceException;

public class UserSingleTableDatabase implements ISingleTableDatabase<IUser> {
    private final ITableDataSourceFactory dataSourceFactory;

    public UserSingleTableDatabase(ITableDataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override
    public String[] getKeys() throws DatabaseException {
        try(ITableDataSource dataSource = dataSourceFactory.createTableDataSource()) {
            return dataSource.getKeys();
        } catch(TableDataSourceException e) {
            //FIXME: throw a DatabaseException
            System.out.println("Data source exception: " + e.getMessage());
        } catch(Exception e) {
            //FIXME: throw a DatabaseException
            System.out.println("Other exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public IUser createRecord(IUser newUser) throws DatabaseException {
        try(ITableDataSource dataSource =
                    dataSourceFactory.createTableDataSource()
        ) {
            IRecord createdRecord = dataSource.createRecord(new UserRecord(newUser));
            return new User(createdRecord);
        } catch(TableDataSourceException e) {
            //FIXME: throw a DatabaseException
            System.out.println("Data source exception: " + e.getMessage());
        } catch(Exception e) {
            //FIXME: throw a DatabaseException
            System.out.println("Other exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public IUser updateRecord(IUser updatedUser) throws DatabaseException {
        try(ITableDataSource dataSource =
                    dataSourceFactory.createTableDataSource()
        ) {
            IRecord updatedRecord = dataSource.updateRecord(new UserRecord(updatedUser));
            return new User(updatedRecord);
        } catch(TableDataSourceException e) {
            //FIXME: throw a DatabaseException
            System.out.println("Data source exception: " + e.getMessage());
        } catch(Exception e) {
            //FIXME: throw a DatabaseException
            System.out.println("Other exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public IUser getRecord(String id) throws DatabaseException {
        try(ITableDataSource dataSource =
                    dataSourceFactory.createTableDataSource()
        ) {
            IRecord record = dataSource.getRecord(id);
            return new User(record);
        } catch(TableDataSourceException e) {
            //FIXME: throw a DatabaseException
            System.out.println("Data source exception: " + e.getMessage());
        } catch(Exception e) {
            //FIXME: throw a DatabaseException
            System.out.println("Other exception: " + e.getMessage());
        }
        return null;
    }

    @Override
    public IUser removeRecord(String id) throws DatabaseException {
        try(ITableDataSource dataSource =
                    dataSourceFactory.createTableDataSource()
        ) {
            IRecord record = dataSource.removeRecord(id);
            return new User(record);
        } catch(TableDataSourceException e) {
            //FIXME: throw a DatabaseException
            System.out.println("Data source exception: " + e.getMessage());
        } catch(Exception e) {
            //FIXME: throw a DatabaseException
            System.out.println("Other exception: " + e.getMessage());
        }
        return null;
    }
}
