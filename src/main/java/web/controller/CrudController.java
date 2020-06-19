package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import web.model.User;
import web.util.CrudSupporting;
import web.service.Service;

@Controller
@RequestMapping("/")
public class CrudController {

    private Service service;

    @Autowired
    public CrudController(Service service){
        this.service = service;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getPageAdmin(ModelMap modelMap) {
        modelMap.addAttribute("users", service.getAllUser());
        return "pageadmin";
    }

    @RequestMapping(value = "/admin/adduser", method = RequestMethod.POST)
    public String getAddUser(WebRequest webRequest) {
        User user = new User();
        user.setName(webRequest.getParameter("name"));
        user.setTelephone(webRequest.getParameter("telephone"));
        user.setRole(new CrudSupporting().createRole(webRequest));
        user.setPassword(webRequest.getParameter("password"));
        service.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteuser", method = RequestMethod.POST)
    public String getDeleteUser(WebRequest webRequest) {
        User user = new User();
        user.setId(Integer.parseInt(webRequest.getParameter("id")));
        user.setName(webRequest.getParameter("name"));
        user.setTelephone(webRequest.getParameter("telephone"));
        user.setRole(new CrudSupporting().createRole(webRequest));
        user.setPassword(webRequest.getParameter("password"));
        service.deleteUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/updateuser", method = RequestMethod.POST)
    public String getUpdateUser(WebRequest webRequest) {
        User user = new User();
        user.setId(Integer.parseInt(webRequest.getParameter("id")));
        user.setName(webRequest.getParameter("name"));
        user.setTelephone(webRequest.getParameter("telephone"));
        user.setRole(new CrudSupporting().createRole(webRequest));
        user.setPassword(webRequest.getParameter("password"));
        service.editUser(user);
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
