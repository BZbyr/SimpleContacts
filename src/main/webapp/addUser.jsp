<%--
  Created by IntelliJ IDEA.
  Project: SimpleContacts
  Desc: 
  Author: Boyang
  Date: 2017/12/13 09:57
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" import="java.util.*, com.boyang.model.*, java.io.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>addUser</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.0.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/additional-methods.js"></script>
<script type="text/javascript">
    $.validator.setDefaults({
        submitHandler: function(form) {
            alert("提交事件!");form.submit();
        }
    });

    $(document).ready(function(){
        var validator = $("#form").validate({

            rules: {
                name: "required",
                phone: {
                    required: true,
                    minlength: 8,
                    maxlength: 11
                },
                mail: {
                    required: true,
                    email: true
                }
            },
            messages: {
                name: "（必需字段）",
                phone: {
                    required: "（必需字段）",
                    minlength: "长度在8-11之间",
                    maxlength: "长度在8-11之间"
                },
                mail:{
                    required: "（必需字段）",
                    email:"请输入一个正确的邮箱"
                }
            }
        });
    });
</script>
<!--
<script language="JavaScript">

    /**
     * @return {boolean}
     */
function RgTest() {
        if(document.getElementById("name").value==="") {
            window.alert("name请输入完整的信息");
            document.getElementById("name").focus();
            return false;
        }
        if(document.getElementById("phone").value==="") {
            window.alert("phone请输入完整的信息");
            document.getElementById("phone").focus();
            return false;
        }
        if(document.getElementById("mail").value==="") {
            window.alert("mail请输入完整的信息");
            document.getElementById("mail").focus();
            return false;
        }
        return true;
    }
    //
</script>-->

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">我的通讯录</a>
        </div>
    </div>
</nav>

<div class="container">

    <s:form class="form-signin" action="addUser" id="form" method="POST">
        <h2 class="form-signin-heading">添加联系人</h2>
        <label for="name" class="sr-only">Name</label>
        <s:textfield id="name" name="name" placeholder="Name" />
        <label for="phone" class="sr-only">Phone</label>
        <s:textfield id="phone" name="phone" placeholder="Phone"/>
        <label for="mail" class="sr-only">Mail</label>
        <s:textfield id="mail" name="mail" placeholder="mail"/>
        <label for="description" class="sr-only">description</label>
        <s:textfield id="description" name="description" placeholder="description"/>
        <s:select name="category" list="categoryList" listKey="id" listValue="name"/>
        <s:submit class="btn btn-lg btn-primary btn-block" id="button" value="提交" />
    </s:form>

</div>
</body>
</html>
