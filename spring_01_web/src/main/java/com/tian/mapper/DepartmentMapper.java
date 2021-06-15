package com.tian.mapper;

import com.tian.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Hasee
 */
@Mapper
@Repository
public interface DepartmentMapper {
    /**
     * 查询所有部门
     * @return
     */
    Collection<Department> findAll();
}
