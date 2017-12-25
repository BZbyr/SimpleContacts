<%--
  Created by IntelliJ IDEA.
  Project: SimpleContacts
  Desc: 
  Author: Boyang
  Date: 2017/12/13 09:57
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" import="java.util.*, com.boyang.model.*, java.io.*" %>
<%@ page import="com.boyang.dao.CategoryDAO" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>addUser</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<jsp:useBean id="category" class="com.boyang.dao.CategoryDAO" scope="page"/>
<body>
<script language="JavaScript">
    <!--
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
    //-->
</script>
<center>
    <s:form action="addUser">
        <table bgcolor="#0099CC">
            <tr><s:textfield id="name" name="user.name" label="联系人姓名"/></tr>
            <tr><s:textfield id="phone" name="user.phone" label="联系人电话"/></tr>
            <tr><s:textfield id="mail" name="user.mail" label="联系人邮箱"/></tr>
            <tr><s:textfield id="description" name="user.description" label="联系人描述"/></tr>
            <tr><s:select name="user.category" label="联系人分类" list="categoryList" listKey="id" listValue="name"/></tr>
            <tr>
                <td><s:submit value="提交" onClick="return RgTest()"/></td>
            </tr>
        </table>
    </s:form>
</center>


</body>
</html>
