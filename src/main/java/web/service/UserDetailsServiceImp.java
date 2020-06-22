package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserServiceDao userServiceDao;

    @Autowired
    public UserDetailsServiceImp(UserServiceDao userServiceDao) {
        this.userServiceDao = userServiceDao;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userServiceDao.findUserByName(name);
        if(user == null) {
            throw new UsernameNotFoundException(name);
        }
        return user;
    }
}
