package web.dao;

import web.model.User;

import java.util.List;

public interface CrudDao{

    List<User> getAllUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    boolean searchUser(String name, String password);

    User returnUser(String name, String password);

    User findUserByName(String name);


}
