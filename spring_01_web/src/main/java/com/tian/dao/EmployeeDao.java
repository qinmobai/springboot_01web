package com.tian.dao;

import com.tian.pojo.Department;
import com.tian.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 会飞的Java
 * @date 2021年06月11日 12:42
 */
@Repository
public class EmployeeDao {
    @Autowired
    private DepartmentDao departmentDao;
    /**
     * id自增长
     */
    private Integer initId = 1006;

    private static Map<Integer, Employee> employeeMap;



    static {
        employeeMap = new HashMap<Integer, Employee>();

        employeeMap.put(1001,new Employee(1001,"AA","A563467162@qq.com",1,new Department(101,"教学部")));
        employeeMap.put(1002,new Employee(1002,"BB","B563467162@qq.com",0,new Department(102,"计划部")));
        employeeMap.put(1003,new Employee(1003,"CC","C563467162@qq.com",1,new Department(103,"实验部")));
        employeeMap.put(1004,new Employee(1004,"DD","D563467162@qq.com",0,new Department(104,"政教部")));
        employeeMap.put(1005,new Employee(1005,"FF","E563467162@qq.com",1,new Department(105,"后勤部")));
    }

    /**
     * 返回所有员工信息
     * @return
     */
    public Collection<Employee> findAll(){
        return employeeMap.values();
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    public Employee findEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    /**
     * 增加员工信息
     * @param employee
     */
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.findDepartmentById(employee.getDepartment().getId()));

        employeeMap.put(employee.getId(),employee);
    }

    public void deleteEmp(Integer id){
        employeeMap.remove(id);
    }
}
