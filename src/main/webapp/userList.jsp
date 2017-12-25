<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  Project: SimpleContacts
  Desc: 
  Author: Boyang
  Date: 2017/12/13 09:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>userList</title>
</head>
<body>
<center>
    <hr>
    <h1>通讯录</h1>
    <s:a action="toAddUser">添加联系人</s:a><br>

    <s:a href="deleteContact.jsp">删除联系人</s:a><br>

    <s:a action="showUserList">查看所有联系人</s:a><br>

    <hr>
    <table>
        <tr>
            <td>行数</td>
            <td>姓名</td>
            <td>分类</td>
            <td>电话</td>
            <td>邮件</td>
            <td>描述</td>
        </tr>

        <s:iterator var="user" value="#request.userList">
            <tr>
                <td>
                    <s:property value="#user.id"/>
                </td>
                <td>
                    <s:property value="#user.name"/>
                </td>
                <td>
                    <s:property value="#user.category"/>
                </td>
                <td>
                    <s:property value="#user.phone"/>
                </td>
                <td>
                    <s:property value="#user.mail"/>
                </td>
                <td>
                    <s:property value="#user.description"/>
                </td>
            </tr>
        </s:iterator>
    </table>
</center>
</body>
</html>
