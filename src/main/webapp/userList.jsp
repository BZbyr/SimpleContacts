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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>userList</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">

</head>
<body>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.0.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">我的通讯录</a>
        </div>
    </div>
</nav>

<div class="container theme-showcase" role="main">
    <div class="page-header">
        <h1>通讯录</h1>
    </div>
    <p>
        <s:a action="toAddUser" type="button" class="btn btn-lg btn-link">添加联系人</s:a>
    </p>
    <p>
        <s:a action="showUserList" type="button" class="btn btn-lg btn-link">查看所有联系人</s:a>
    </p>

    <%
        int num = 1;
    %>
    <div class="page-header">
        <h1>Tables</h1>
    </div>

    <div class="row">
        <div class="col-md-6">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>姓名</th>
                    <th>分类</th>
                    <th>电话</th>
                    <th>邮件</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator var="user" value="#request.userList">
                    <tr>
                        <td>
                            <%=num++%>
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
                        <td>
                            <s:a action="delUser" type="button" class="btn btn-xs btn-danger">
                                删除
                                <s:param name="id">${user.id}</s:param>
                            </s:a>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
