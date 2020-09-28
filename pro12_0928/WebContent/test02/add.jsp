<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException.jsp"   
    %>
    <!--  예외 발생시 예외를 처리할 jsp 페이지를 지정 -->
<%
	int num=Integer.parseInt(request.getParameter("num"));
	int sum=0;
	for(int i=1; i<= num; i++) {
		sum+=i;
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>합계구하기</h1>
<h1>1부터 <%=num %> 까지의 합은 <%=sum %>이당 </h1>
</body>
</html>