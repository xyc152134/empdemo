package com.xyc.mapper;

import com.xyc.entity.Emp;

import java.util.List;

public interface EmpListMapper {
    List<Emp> empList();

    List<Emp> empdept();
     Emp EmpByid(String id);

    int inset(Emp emp);

    void delete(String s);

    void update(Emp emp);

    List<Emp> findbyname(String name);

}
