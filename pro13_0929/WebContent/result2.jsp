<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8"); %>

<%!String msg="아이디를 입력하지않았다 다시 ㄱ "; %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String userID=request.getParameter("userID");
if(userID.length()==0) {
%>
<jsp:forward page="login2.jsp">
<jsp:param value="<%=msg %>" name="msg"/>
</jsp:forward>

<%
}
%>
</body>
</html>