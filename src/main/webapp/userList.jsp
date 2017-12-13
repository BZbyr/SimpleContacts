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
    <s:a action="userAction" method="toAddUser">添加联系人</s:a><br>

    <a href="deleteContact.jsp">删除联系人</a><br>

    <a href="viewContact.jsp">查看所有联系人</a><br>

    <hr>
</center>
</body>
</html>
