<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String name=(String)session.getAttribute("name");  // 세션객체에 바인딩된 name을 가져온다
session.setAttribute("address", "서울시 강남구"); // 세션객체에 address를 바인딩한다.
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름은 <%=name %> 입니다.<br>
<a href=session2.jsp> 두번째 페이지로 이동</a>
</body>
</html>