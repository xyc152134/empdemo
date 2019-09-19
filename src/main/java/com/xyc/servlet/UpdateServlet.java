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
@WebServlet(urlPatterns = {"/updateServlet"})
public class UpdateServlet extends HttpServlet {
    EmpListService empListService = new EmpListServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        Emp emp= empListService.EmpByid(id);
        req.setAttribute("emp", emp);
        req.getRequestDispatcher("/empList").forward(req, resp);

    }
}
