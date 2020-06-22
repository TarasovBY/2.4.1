package web.dao;

import web.model.Role;

public interface RoleDao {

    Role findRoleByName(String role);

    Role getRoleById(int id);
}
