package method;

import pojo.EmployeeInform;
import util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
// 全部搜索
    public  static List<EmployeeInform> searchAll() throws SQLException, ClassNotFoundException {
        Connection connection= JDBCUtil.getConnection();
        String sql="select * from employee";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultset = statement.executeQuery();
        List<EmployeeInform> em_list = new ArrayList<EmployeeInform>();
        while (resultset.next()) {
            EmployeeInform em = new EmployeeInform(resultset.getString("job_number"), resultset.getString("name"),
                    resultset.getDouble("salary"), resultset.getInt("age"), resultset.getString("power"),resultset.getString("address"));
            em_list.add(em);
        }
        resultset.close();
        statement.close();
        connection.close();
        return  em_list;
    }
//按工号搜索
    public static EmployeeInform searchByJobNumber(String id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2b8", "root", "admin");
        String sql ="select * from employee_management_system where job_number = id";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultset = statement.executeQuery(sql);
        EmployeeInform em = new EmployeeInform();
        while (resultset.next()) {
            em =new EmployeeInform(resultset.getString("job_number"), resultset.getString("name"),
                    resultset.getDouble("salary"), resultset.getInt("age"), resultset.getString("power"),resultset.getString("address"));
        }
        resultset.close();
        statement.close();
        connection.close();
        return  em;
    }
    //插入
    public static int insertEmployee(EmployeeInform em) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2b8", "root", "admin");
        String sql="insert into employee(Job_number,name,age,salary,address,power) values(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, em.getJob_number());
        statement.setString(2, em.getName());
        statement.setDouble(3, em.getAge());
        statement.setDouble(4, em.getSalary());
        statement.setString(5, em.getAddress());
        statement.setString(6, em.getPower());
        int result=statement.executeUpdate();
        statement.close();
        connection.close();
        return result;
    }

    public static int deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from employee where job_number = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, id);
        int result=statement.executeUpdate();
        statement.close();
        conn.close();
        return result;
    }

    public  static  int  updateEmployee(EmployeeInform em) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCUtil.getConnection();
        String sql ="update employee set name=?,age=?,salary=?,address=? ,power=?where Job_number = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, em.getName());
        statement.setDouble(2, em.getAge());
        statement.setDouble(3, em.getSalary());
        statement.setString(4, em.getAddress());
        statement.setString(5, em.getPower());
        statement.setString(6, em.getJob_number());
        System.out.println(statement);
        int result=statement.executeUpdate();
        statement.close();
        conn.close();
        return result;
    }

}
