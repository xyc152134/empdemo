package com.xyc.servlet;

import com.xyc.entity.Dept;
import com.xyc.service.DeptLsitService;
import com.xyc.service.impl.DeptLsitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {"/dept"})
public class DeptListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptLsitService deptLsitService=new DeptLsitServiceImpl();
        List<Dept> deptList= deptLsitService.deptList();
        req.setAttribute("deptList" ,deptList);
        req.getRequestDispatcher("empList").forward(req, resp);

    }
}
