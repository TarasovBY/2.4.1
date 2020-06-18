package web.service;

import org.springframework.stereotype.Service;
import web.model.Role;
import web.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Service
public class CrudSupporting {

    public Set<Role> createRole(HttpServletRequest request) {
        Set<Role> roleList = new HashSet<>();
        for(int a = 0; a < request.getParameterValues("roles").length; a++ ) {
            roleList.add(new Role(request.getParameterValues("roles")[a]));
        }
        return roleList;
    }

    public User createUser(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setTelephone(request.getParameter("telephone"));
        user.setRole(new CrudSupporting().createRole(request));
        user.setPassword(request.getParameter("password"));
        return user;
    }

    public User editUser(HttpServletRequest request) {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setTelephone(request.getParameter("telephone"));
        user.setRole(new CrudSupporting().createRole(request));
        user.setPassword(request.getParameter("password"));
        return user;
    }


}
