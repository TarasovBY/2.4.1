package web.util;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import web.model.Role;
import java.util.HashSet;
import java.util.Set;

@Service
public class CrudSupporting {

    public Set<Role> createRole(WebRequest webRequest) {
        Set<Role> roleList = new HashSet<>();
        for(int a = 0; a < webRequest.getParameterValues("roles").length; a++ ) {
            roleList.add(new Role(webRequest.getParameterValues("roles")[a]));
        }
        return roleList;
    }



}
