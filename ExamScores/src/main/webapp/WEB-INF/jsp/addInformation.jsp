<%--
  Created by IntelliJ IDEA.
  User: wxq
  Date: 17-9-17
  Time: 上午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加信息</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .header {
            height: 150px;
            background-color: orange;
        }

        .footer {
            height: 160px;
            background-color: purple;
        }

        .text {
            border-color: skyblue;
            width: 181px;
            height: 20px;
            display: inline-block;
            margin-top: 30px;
            border-radius: 5px;
        }

        .middle {
            width: 300px;
            height: 330px;
            margin:30px auto;

        }
        h3 {
            font-size:30px;
        }
        .button {
            border-radius: 10px 10px 10px 10px;
            width:80px;
            height:30px;
            display: inline-block;
            margin-top: 20px;
            margin-left: 55px;
            color:black;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="header"> </div>
<h3>请输入 信息</h3>
<%!  Integer flag;%>
<%
    flag = (Integer) request.getAttribute("flag");
    if(flag==0){
%><form:form commandName="student" method="post" action="">
    <div class="middle">
        <table>
            <tr>
                <td>
                    <label for="id">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:
                        <form:input cssClass="text" path="id" id="id" />
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
                        <form:input path="name" id="name" cssClass="text"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="class">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:
                        <form:input path="className" id="class" cssClass="text"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="classId">班级编号:
                        <form:input path="classId" id="classId" cssClass="text"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:
                        <form:input path="password" id="password" cssClass="text"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="添加" class="button"/>
                    <input type="reset" value="重置" class="button" />
                </td>

            </tr>
        </table>
    </div>
</form:form>
<% }else if(flag ==1){
%>
<form:form commandName="teacher" method="post" action="">
<div class="middle">
    <table>
        <tr>
            <td>
                <label for="id">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:
                    <form:input path="tid" id="id" cssClass="text" />
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
                    <form:input path="tname" id="name2" cssClass="text"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label for="name">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:
                    <form:input path="tpassword" id="password2" cssClass="text"/>
                </label>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="添加" class="button"/>
                <input type="reset" value="重置" class="button" />
            </td>

        </tr>
    </table>
</div>
</form:form>
<%
    }
    %>
<div class="footer"></div>
</body>
</html>
