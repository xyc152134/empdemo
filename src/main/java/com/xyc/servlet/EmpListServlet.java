package com.xyc.servlet;

import com.xyc.entity.Dept;
import com.xyc.entity.Emp;
import com.xyc.service.DeptLsitService;
import com.xyc.service.EmpListService;
import com.xyc.service.impl.DeptLsitServiceImpl;
import com.xyc.service.impl.EmpListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/empList"})
public class EmpListServlet extends HttpServlet {
    EmpListService empListService = new EmpListServiceImpl();

    @Override
    //获取数据
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DeptLsitService deptLsitService = new DeptLsitServiceImpl();
        List<Dept> deptList = deptLsitService.deptList();
        req.setAttribute("deptList", deptList);
        List<Emp> empList = empListService.empdept();
        //把数据绑定到rep上
        req.setAttribute("empList", empList);

        //发送jsp
        req.getRequestDispatcher("WEB-INF/pages/emp-list.jsp").forward(req, resp);


    }
}
