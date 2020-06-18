package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.CrudDao;
import web.model.User;
import java.util.List;


@org.springframework.stereotype.Service
public class UserService implements Service {

    @Autowired
    CrudDao crudDao;

    @Override
    public List<User> getAllUser() {
        return crudDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        crudDao.addUser(user);
    }

    @Override
    public void editUser(User user) {
        crudDao.editUser(user);
    }

    @Override
    public void deleteUser(User user) {
        crudDao.deleteUser(user);
    }

    @Override
    public boolean searchUser(String name, String password) {
        return crudDao.searchUser(name, password);
    }

    @Override
    public User returnUser(String name, String password) {
        return crudDao.returnUser(name, password);
    }

    @Override
    public User findUserByName(String name) {
        return crudDao.findUserByName(name);
    }

}
