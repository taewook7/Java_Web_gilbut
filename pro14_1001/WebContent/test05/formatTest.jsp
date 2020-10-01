<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"
    isELIgnored="false"
    %>
<% request.setCharacterEncoding("utf-8"); %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fmt의 number 태그를 이용한 숫자 포멧팅 예제.	</h2>
	<c:set var="price" value="100000000000" />
	<fmt:formatNumber value="${price}" type="number" var="priceNumber "/>
	통화로 표현시:
	<fmt:formatNumber type="currency" currencySymbol="\\" value="${price}" groupingUsed="true" /><br>
	
	퍼센트로 표현시:
	<fmt:formatNumber value="${price }" type="percent" groupingUsed="false" /><br>
	일반숫잘 표현시: ${priceNumber}<br>
	
	<h2>formatDate 예제2</h2>
	<c:set var="now" value="<%=new Date()  %>" />
	<fmt:formatDate value="${now }" type="date" dateStyle="full" /><br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short" /><br>
	<fmt:formatDate value="${now }" type="time"  /><br>
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"  /><br>
	<fmt:formatDate value="${now }" pattern="YYYY-MM-dd : hh:mm:ss"  /><br>
	<br><br>
	한국 현재 시간:
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /><br><br>

<fmt:timeZone value="America/New York">	
	뉴욕시간대로 변경:
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /><br>
	</fmt:timeZone>
	
	
</body>
</html>