package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import web.model.Role;
import web.service.RoleServiceDao;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class CrudSupporting {

    private final RoleServiceDao roleServiceDao;

    @Autowired
    public CrudSupporting(RoleServiceDao roleServiceDao) {
        this.roleServiceDao = roleServiceDao;
    }

    public Set<Role> createRole(WebRequest webRequest) {
        Set<Role> roleList = new HashSet<>();
        for(int a = 0; a < Objects.requireNonNull(webRequest
                .getParameterValues("roles")).length; a++ ) {
            roleList.add(roleServiceDao.findRoleByName(Objects
                    .requireNonNull(webRequest.getParameterValues("roles"))[a]));
        }

        return roleList;
    }


}
