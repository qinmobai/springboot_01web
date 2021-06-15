package com.tian.mapper;


import com.tian.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author Hasee
 */
@Mapper
@Repository
public interface EmployeeMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    Collection<Employee> findAll();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    Employee findEmployeeById(Integer id);

    /**
     * 保存用户信息
     * @param employee
     * @return
     */
    int save(Employee employee);

    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    int update(Employee employee);

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    int deleteEmp(Integer id);
}
