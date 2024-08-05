package method;

import pojo.EmployeeInform;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EmployeeInform em=new EmployeeInform("20210216","李四",
                30010.00,30,"5", "qd");
        List<EmployeeInform> emp= new ArrayList<>();
        emp=EmployeeController.searchAll();
        for(EmployeeInform emp1:emp){
            System.out.println(emp1);
        }
    }
}
