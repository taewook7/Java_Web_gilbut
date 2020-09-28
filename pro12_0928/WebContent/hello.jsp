<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! String name="듀크";
public String getName(){
return name;
} %>
<!--  선언문을 이용해 멤버 변수 name 과 멤버 메서드 getName()을 선언합니다.  
서블릿 클래스의 멤버변수와 멤버 메서드로 변환된 것을 알수 있습니다. 따라서 선언문에서 선언된 변수는 JSP 안에서 자유롭게 접근할수 있습니다.-->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세여 <%=name %> 님 </h1>   
	<!--  표현식을 이용해 선언문에서 선언한 name 의 값을 출력합니다. -->
	
</body>
</html>