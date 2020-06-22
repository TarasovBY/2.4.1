package web.service;

import web.model.Role;

public interface RoleServiceDao {

    public Role findRoleByName(String role);

    public Role getRoleById(int id);
}
