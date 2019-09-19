package com.xyc.service;

import com.xyc.entity.Emp;

import java.util.List;

public interface EmpListService {
    List<Emp> empList();

    List<Emp> empdept();
    Emp EmpByid(String id);

    int inset(Emp emp);

    void delete(String string);

    void update(Emp emp);

    List<Emp> findbyname(String name);

}
