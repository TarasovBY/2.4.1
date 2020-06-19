package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private web.service.Service service;

    @Autowired
    public UserDetailsServiceImp(web.service.Service service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = service.findUserByName(name);
        if(user == null) {
            throw new UsernameNotFoundException(name);
        }
        return user;
    }
}
