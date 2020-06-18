package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.service.CrudSupporting;
import web.service.Service;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class CrudController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private Service service;

    @Autowired
    private CrudSupporting crudSupporting;


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getPageAdmin(ModelMap modelMap) {
        modelMap.addAttribute("users", service.getAllUser());
        return "pageadmin";
    }

    @RequestMapping(value = "/admin/adduser", method = RequestMethod.POST)
    public String getAddUser() {
        service.addUser(crudSupporting.createUser(request));
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteuser", method = RequestMethod.POST)
    public String getDeleteUser() {
        service.deleteUser(crudSupporting.editUser(request));
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/updateuser", method = RequestMethod.POST)
    public String getUpdateUser() {
        service.editUser(crudSupporting.editUser(request));
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
