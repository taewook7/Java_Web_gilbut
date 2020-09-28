<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int score=Integer.parseInt(request.getParameter("score"));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>시험점수 <%=score  %>점</h1>
<%
if(score>=90 && score <=100) {
%>
<h1>A학점이다.</h1>
<%
} else if(score>=80 && score <90) {
%>
<h1>B학점이다.</h1>
<%
} else if(score >=70 && score <80) {
%>
<h1>C학점이다.</h1>
<%
} else if(score >=0 && score <70){
%>
<h1>F다.</h1>
<%
} else {
%>
<h1>허용하지않는값입니다.</h1>
<a href="scoreTest.html">다시 입력하기</a>
<%
}
%>
<br>
<a href="scoreTest.html">시험점수 입력</a>

</body>
</html>