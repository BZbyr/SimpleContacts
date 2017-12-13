<%--
  Created by IntelliJ IDEA.
  Project: SimpleContacts
  Desc: 
  Author: Boyang
  Date: 2017/12/13 09:57
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" import="java.util.*, model.*, java.io.*" %>
<%@ page import="dao.CategoryDAO" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>addUser</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<jsp:useBean id="category" class="dao.CategoryDAO" scope="page"/>
<body>
    <script language="JavaScript">
        <!--
        function RgTest() {
            if(document.getElementsByName("name").value==="") {
                window.alert("请输入完整的信息");
                document.getElementById("name").focus();
                return false;
            }
            if(document.getElementById("phone").value==="") {
                window.alert("请输入完整的信息");
                document.getElementById("phone").focus();
                return false;
            }
            if(document.getElementById("mail").value==="") {
                window.alert("请输入完整的信息");
                document.getElementById("mail").focus();
                return false;
            }
            if(document.getElementById("description").value==="") {
                window.alert("请输入完整的信息");
                document.getElementById("description").focus();
                return false;
            }
            return true;
        }
        //-->
    </script>

<center>
    <s:form action="userAction" name="User" theme="simple" method="GET">
        <table border="1" bgcolor="#0099CC">
            <tr><td>联系人姓名：<s:textfield id="name" theme="simple"></s:textfield></td></tr>
            <tr><td>联系人电话：<s:textfield id="phone" theme="simple"></s:textfield></td></tr>
            <tr><td>联系人邮箱：<s:textfield id="mail" theme="simple"></s:textfield></td></tr>
            <tr><td>联系人描述：<s:textfield id="description" theme="simple"></s:textfield></td></tr>
            <tr><td>联系人分类：
                <select id="categoryId">
                    <%
                        Collection categoryList;
                        categoryList= CategoryDAO.getAllList();
                        Iterator it;
                        it=categoryList.iterator();
                        while(it.hasNext()) {
                            Category temp = (Category)it.next();
                            out.println("<s:option value="+temp.getId()+">"+temp.getId()+"</s:option>");
                        }
                    %>
                </select>
            </td></tr>
            <tr><td><s:submit value="提交" method="addUser" theme="simple" onClick="return RgTest()"></s:submit></td></tr>
        </table>
    </s:form>
</center>


</body>
</html>
