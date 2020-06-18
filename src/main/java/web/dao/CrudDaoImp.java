package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CrudDaoImp implements CrudDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return entityManager.createQuery(" from User  ").getResultList();
    }

    @Transactional(readOnly = false)
    public void addUser(User user) {
            entityManager.persist(user);
    }

    @Transactional(readOnly = false)
    public void editUser(User user) {
            entityManager.merge(user);
    }

    @Transactional(readOnly = false)
    public void deleteUser(User user) {
        Query query = entityManager.createQuery("delete User where id = :param");
        query.setParameter("param", user.getId());
        query.executeUpdate();
    }

    @Transactional(readOnly = true)
    public boolean searchUser(String name, String password) {
        int result = entityManager.
                createQuery("FROM User where name = '" + name + "'"
                        + " and password='" + password + "'").getResultList().size();
        return result > 0;
    }

    @Transactional(readOnly = true)
    public User returnUser(String name, String password) {
        try {
            User user = (User) entityManager.createQuery("FROM User where name = '" + name + "'"
                    + " and password='" + password + "'").getResultList().get(0);
            return entityManager.find(User.class, user.getId());
        } catch (Exception e) {
            return new User();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByName(String name) {
        return (User) entityManager.createQuery("FROM User where " +
                "name = '" + name + "'").getResultList().get(0);
    }
}
