package com.xyc.service.impl;

import com.xyc.entity.Emp;
import com.xyc.mapper.EmpListMapper;
import com.xyc.service.EmpListService;
import com.xyc.until.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpListServiceImpl implements EmpListService {
    @Override
    public List<Emp> empList() {
        SqlSession session= MybatisUtil.getSqlSession();
        EmpListMapper empListMapper= session.getMapper(  EmpListMapper.class);
       List<Emp>empList= empListMapper.empList();
        session.close();
        return empList;
    }

    @Override
    public List<Emp> empdept() {
        SqlSession session= MybatisUtil.getSqlSession();
        EmpListMapper empListMapper= session.getMapper(  EmpListMapper.class);

        List<Emp>empList= empListMapper.empdept();
        session.close();
        return empList;
    }

    @Override
    public Emp EmpByid(String id) {
        SqlSession session= MybatisUtil.getSqlSession();
        EmpListMapper empListMapper= session.getMapper(  EmpListMapper.class);
         Emp emp=empListMapper.EmpByid(id);
        return emp;
    }

    @Override
    public int inset(Emp emp) {
        SqlSession session= MybatisUtil.getSqlSession();
        EmpListMapper empListMapper= session.getMapper(  EmpListMapper.class);
        empListMapper.inset(emp);
        session.close();
        return 0;
    }

    @Override
    public void delete(String string) {
        SqlSession session= MybatisUtil.getSqlSession();
        EmpListMapper empListMapper= session.getMapper(  EmpListMapper.class);
        empListMapper.delete(string);
        session.close();
    }


    @Override
    public void update(Emp emp) {
        SqlSession session= MybatisUtil.getSqlSession();
        EmpListMapper empListMapper= session.getMapper(  EmpListMapper.class);
        empListMapper.update(emp);
        session.close();
    }

    @Override
    public List<Emp> findbyname(String name) {
        SqlSession session= MybatisUtil.getSqlSession();
        EmpListMapper empListMapper= session.getMapper(  EmpListMapper.class);
        empListMapper.findbyname(name);
        List<Emp>empList= empListMapper.empList();
        session.close();
        return empList;
    }
}
