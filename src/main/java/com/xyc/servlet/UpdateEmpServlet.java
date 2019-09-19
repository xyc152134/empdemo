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

@WebServlet(urlPatterns = {"/update"})
public class UpdateEmpServlet extends HttpServlet {
    EmpListService empListService = new EmpListServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updatename = req.getParameter("updatename");
        Integer age = Integer.parseInt(req.getParameter("updateage"));
        String sex = req.getParameter("updatesex");
        Integer empId = Integer.parseInt(req.getParameter("id"));
        BigDecimal bigDecimal = new BigDecimal(req.getParameter("updatesalary"));
        Integer deptId = Integer.parseInt(req.getParameter("updatedeptId"));
            Emp emp = new Emp();
            emp.setName(updatename);
            emp.setAge(age);
            emp.setEmpId(empId);
            emp.setSex(sex);
            emp.setSalary(bigDecimal);
            emp.setDeptId(deptId);
            empListService.update(emp);
        resp.sendRedirect("/empList");

    }
}
