package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import web.model.User;
import web.util.CrudSupporting;
import web.service.UserServiceDao;
import java.util.Objects;


@Controller
@RequestMapping("/")
public class CrudController {

    private final UserServiceDao userServiceDao;
    private final PasswordEncoder encoder;
    private final CrudSupporting crudSupporting;


    @Autowired
    public CrudController(UserServiceDao userServiceDao, PasswordEncoder encoder, CrudSupporting crudSupporting){
        this.encoder = encoder;
        this.userServiceDao = userServiceDao;
        this.crudSupporting = crudSupporting;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getPageAdmin(ModelMap modelMap) {
        modelMap.addAttribute("users", userServiceDao.getAllUser());
        return "pageadmin";
    }

    @RequestMapping(value = "/admin/adduser", method = RequestMethod.POST)
    public String getAddUser(WebRequest webRequest) {
        User user = new User();
        user.setName(webRequest.getParameter("name"));
        user.setTelephone(webRequest.getParameter("telephone"));
        user.setRole(crudSupporting.createRole(webRequest));
        user.setPassword(encoder.encode(webRequest.getParameter("password")));
        userServiceDao.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteuser", method = RequestMethod.POST)
    public String getDeleteUser(WebRequest webRequest) {
        User user = new User();
        user.setId(Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("id"))));
        userServiceDao.deleteUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/updateuser", method = RequestMethod.POST)
    public String getUpdateUser(WebRequest webRequest) {
        User user = new User();
        user.setId(Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("id"))));
        user.setName(webRequest.getParameter("name"));
        user.setTelephone(webRequest.getParameter("telephone"));
        user.setRole(crudSupporting.createRole(webRequest));
        user.setPassword(webRequest.getParameter("password"));
        userServiceDao.editUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap modelMap) {
        modelMap.addAttribute("userSolo", SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
        return "user";
    }




}
