package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CrudDao;
import web.model.User;
import java.util.List;


@org.springframework.stereotype.Service
public class UserService implements Service {

    private CrudDao crudDao;

    @Autowired
    public UserService(CrudDao dao) {
        this.crudDao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return crudDao.getAllUser();
    }

    @Override
    @Transactional(readOnly = false)
    public void addUser(User user) {
        crudDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void editUser(User user) {
        crudDao.editUser(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(User user) {
        crudDao.deleteUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean searchUser(String name, String password) {
        return crudDao.searchUser(name, password);
    }

    @Override
    @Transactional(readOnly = true)
    public User returnUser(String name, String password) {
        return crudDao.returnUser(name, password);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByName(String name) {
        return crudDao.findUserByName(name);
    }

}
