package servlets;

import method.EmployeeController;
import pojo.EmployeeInform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EmployeeInform> employees;
        jdbc:mysql://hostname:port/dbname?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
        try {
            employees= EmployeeController.searchAll();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("List", employees);
        req.getRequestDispatcher("EMS.jsp").forward(req, resp);
    }

}
