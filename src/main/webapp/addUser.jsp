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
    <title>addUser</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
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
                    minlength: "长度在8-10之间",
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
<center>
    <s:form action="addUser" id="form" method="POST">
        <table bgcolor="#0099CC">
            <tr><s:textfield id="name" name="name" label="联系人姓名" /></tr>
            <tr><s:textfield id="phone" name="phone" label="联系人电话" /></tr>
            <tr><s:textfield id="mail" name="mail" label="联系人邮箱" /></tr>
            <tr><s:textfield id="description" name="description" label="联系人描述"/></tr>
            <tr><s:select name="category" label="联系人分类" list="categoryList" listKey="id" listValue="name"/></tr>
            <tr>
                <td><s:submit id="button" value="提交"/></td>
            </tr>
        </table>
    </s:form>
</center>


</body>
</html>
