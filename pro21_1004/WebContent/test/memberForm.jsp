<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>

<style>
   .text_center{
     text-align:center;
   }
</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form name="frmlogin" method="post" action="${contextPath}/test/memberInfo.do">
 	<h1 class="text_center">회원 가입창</h1>
 	<table border="1" align="center">
 		<tr>
 			<td width="200"><p align="right">아이디</p></td>
 			<td width="400"><input type="text" name="id"></td>
 		</tr>
 		<tr>
 			<td width="200"><p align="right">비밀번호</p></td>
 			<td width="400"><input type="password" name="pwd"></td>
 		</tr>
 		<tr>
 			<td width="200"><p align="right">이름</p></td>
 			<td width="400"><input type="text" name="name"></td>
 		</tr>
 		<tr>	
 			<td width="200"><p align="right">이메일</p></td>
 			<td width="400"><input type="text" name="email"></td>
 		</tr>
 		
 		<tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시입력"></td>
 	</table>
 
 
 </form>
</body>
</html>