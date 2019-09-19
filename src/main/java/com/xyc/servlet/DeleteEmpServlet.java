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

@WebServlet(urlPatterns = {"/delete"})
public class DeleteEmpServlet extends HttpServlet {
    EmpListService empListService=new EmpListServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("id");
            empListService.delete(id);
            resp.sendRedirect("/empList");
        }
    }

