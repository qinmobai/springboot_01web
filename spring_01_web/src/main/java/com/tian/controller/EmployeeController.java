package com.tian.controller;

import com.tian.dao.DepartmentDao;
import com.tian.dao.EmployeeDao;
import com.tian.pojo.Department;
import com.tian.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private DepartmentDao departmentDao;


    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.findAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    @GetMapping("/addEmp")
    public String toAddPage(Model model){
        Collection<Department> dept = departmentDao.findAll();

        model.addAttribute("dept",dept);

        return "emp/add";
    }

    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        System.out.println("employee =>" + employee);
        //调用底层业务方法保存员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/updateEmp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //查出原来的数据
        Employee employee = employeeDao.findEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.findAll();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        System.out.println("employee =>" +employee);

        employeeDao.save(employee);

        return "redirect:emps";
    }

    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id")Integer id){
        employeeDao.deleteEmp(id);
        return "redirect:emps";
    }
}
