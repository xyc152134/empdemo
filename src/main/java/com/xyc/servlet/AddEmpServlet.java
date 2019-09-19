package com.xyc.servlet;

import com.xyc.entity.Emp;
import com.xyc.service.EmpListService;
import com.xyc.service.impl.EmpListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/add"})
public class AddEmpServlet extends HttpServlet {
    EmpListService empListService=new EmpListServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String name=req.getParameter("name");
          Integer age=Integer.parseInt(req.getParameter("age"));
          String sex=req.getParameter("sex");
        BigDecimal bigDecimal=new BigDecimal(req.getParameter("salary"));
        Integer deptId=Integer.parseInt(req.getParameter("deptId"));
        if(name!=null) {
            Emp emp = new Emp();
            emp.setName(name);
            emp.setAge(age);
            emp.setSex(sex);
            emp.setSalary(bigDecimal);
            emp.setDeptId(deptId);
            empListService.inset(emp);
            resp.sendRedirect("/empList");
        }

    }
}
