package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Role findRoleByName(String role) {
        return (Role) entityManager.createQuery("FROM Role where " +
                "role = '" + role + "'").getResultList().get(0);
    }

    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }
}
