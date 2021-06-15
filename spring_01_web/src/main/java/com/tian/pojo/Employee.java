package com.tian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @author 会飞的Java
 * @date 2021年06月11日 12:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private Integer id;
    private String name;
    @Email
    private String email;
    private Integer gender;
    private Date birthday;
    private Department department;
}
