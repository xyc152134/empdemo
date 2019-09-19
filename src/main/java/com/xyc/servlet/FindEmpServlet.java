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
import java.util.List;

@WebServlet(urlPatterns = {"/find"})
public class FindEmpServlet extends HttpServlet {
    EmpListService empListService=new EmpListServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String findname=req.getParameter("findname");
            List<Emp> empList = empListService.findbyname(findname);
            req.removeAttribute("empList");
            req.setAttribute("empList", empList);
            System.out.println(req.getAttribute("empList"));
            req.getRequestDispatcher("WEB-INF/pages/emp-list.jsp").forward(req, resp);

//        System.out.println(empList);
//        resp.sendRedirect("/empList");

    }
}
