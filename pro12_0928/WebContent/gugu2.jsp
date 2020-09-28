<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int dan=Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="800">
	<tr align="center" bgcolor="yellow" >
	<td colspan="2">
	<h1><%=dan %>출력</h1></td>
	</tr>

<%
	for(int i=1; i<10; i++) {
%>

<%
	if(i%2==1) {
%>
	<tr bgcolor="#CCFF66">
<% 
	} else {
%>
	<tr bgcolor="#CCCCFF">
<%
	}
%>

	<td width='400'>
	<%=dan %> * <%=i %>
	</td>
	<td width='400'>
	<%=i*dan  %>
	</td>
	</tr>
<%
}
%>
</table>

</body>
</html>