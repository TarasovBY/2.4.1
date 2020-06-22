package web.service;

import web.model.Role;
import web.model.User;
import java.util.List;

public interface UserServiceDao {
    List<User> getAllUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    boolean searchUser(String name, String password);

    User returnUser(String name, String password);

    User findUserByName(String name);


}
