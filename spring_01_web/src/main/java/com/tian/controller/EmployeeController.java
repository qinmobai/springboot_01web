package com.tian.controller;

import com.tian.dao.EmployeeDao;
import com.tian.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author 会飞的Java
 * @date 2021年06月11日 14:35
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/emp")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.findAll();
        model.addAttribute("employees",employees);
        return "emps/emps";
    }

}
