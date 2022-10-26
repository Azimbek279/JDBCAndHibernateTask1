package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoJdbcImpl();

    public void createUsersTable() {
        userDao.createUsersTable();

    }

    public void dropUsersTable() {
        dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {

        userDao.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {

        userDao.removeUserById(id);
    }

    public List<User> getAllUsers()throws SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
