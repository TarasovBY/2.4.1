package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Transactional
@org.springframework.stereotype.Service
public class UserServiceDaoImp implements UserServiceDao {

    private final UserDao userDao;

    @Autowired
    public UserServiceDaoImp(UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public boolean searchUser(String name, String password) {
        return userDao.searchUser(name, password);
    }

    @Override
    public User returnUser(String name, String password) {
        return userDao.returnUser(name, password);
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }


}
