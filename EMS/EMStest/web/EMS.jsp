<%@ page import="java.util.List" %>
<%@ page import="pojo.EmployeeInform" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 12940
  Date: 2024/8/2
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EMS</title>
    <link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<style>
    div{
        margin: 200px;
    }
</style>
<body>
    <%
        List<EmployeeInform> employeelist = new ArrayList<EmployeeInform>();
        employeelist=(List<EmployeeInform>)request.getAttribute("List");
    %>
    <div>
    <h1 class="h1">员工管理系统</h1>
    <input class="input-group-lg"><button class="btn-success">搜索</button>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <button class="btn-success">添加</button>
    <table class=" table table-hover">
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>薪资</td>
            <td>地址</td>
            <td>权限</td>
            <td></td>
        </tr>
            <%
                for (EmployeeInform emp : employeelist) {
            %>
        <tr>
                <td><%=emp.getJob_number()%></td>
                <td><%=emp.getName()%></td>
                <td><%=emp.getAge()%></td>
                <td><%=emp.getSalary()%></td>
                <td><%=emp.getAddress()%></td>
                <td><%=emp.getPower()%></td>
                <td><button class="btn-danger">删除</button></td>
        </tr>
            <%
                }
            %>
    </table>
    </div>
</body>
</html>
