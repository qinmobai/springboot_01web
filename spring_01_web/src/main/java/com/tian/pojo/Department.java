package com.tian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 * @author 会飞的Java
 * @date 2021年06月11日 12:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer id;
    private String name;
}
