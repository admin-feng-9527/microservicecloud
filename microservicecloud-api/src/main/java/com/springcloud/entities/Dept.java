package com.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor//全参构造函数
@NoArgsConstructor//空参构造函数
@Data
@Accessors(chain = true)
public class Dept implements Serializable{
    private Long deptNo;//部门编码 主键
    private String deptName;
    private String dbSource;
}
