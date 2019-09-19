package com.xyc.service.impl;

import com.xyc.entity.Dept;
import com.xyc.mapper.DeptListMapper;
import com.xyc.service.DeptLsitService;
import com.xyc.until.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptLsitServiceImpl implements DeptLsitService {
    @Override
    public List<Dept> deptList() {
        SqlSession session= MybatisUtil.getSqlSession();
        DeptListMapper deptListMapper= session.getMapper(DeptListMapper.class);
         List<Dept> deptList=deptListMapper.deptList();
        return deptList;
    }
}
