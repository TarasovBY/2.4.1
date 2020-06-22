package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

@Transactional
@Service
public class RoleServiceDaoImp implements RoleServiceDao{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceDaoImp(RoleDao dao) {
        this.roleDao = dao;
    }

    @Override
    public Role findRoleByName(String role) {
        return roleDao.findRoleByName(role);
    }

    @Override
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }
}
