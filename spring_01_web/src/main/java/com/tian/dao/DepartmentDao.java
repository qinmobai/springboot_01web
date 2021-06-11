package com.tian.dao;

import com.tian.pojo.Department;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 会飞的Java
 * @date 2021年06月11日 12:38
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentMap;

    static {
        departmentMap = new HashMap<Integer, Department>();

        departmentMap.put(101,new Department(101,"教学部"));
        departmentMap.put(102,new Department(102,"计划部"));
        departmentMap.put(103,new Department(103,"实验部"));
        departmentMap.put(104,new Department(104,"政教部"));
        departmentMap.put(105,new Department(105,"后勤部"));
    }

    /**
     * 查询所有部门信息
     * @return
     */
    public Collection<Department> findAll(){
        return departmentMap.values();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    public Department findDepartmentById(Integer id){
        return departmentMap.get(id);
    }

}
