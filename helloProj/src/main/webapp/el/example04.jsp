<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- num이라는 변수에 80이 들어온다면 -->
	<c:set var="num" value="${200 }"></c:set>
	
	<!-- 점수 80 은~ -->
	<c:out value="${num }" />점은
	
	<!-- 조건문 60과 같거나 크면 -->
	<c:if test="${num>=60 }">
		합격입니다.
	</c:if>
	<!-- 60보다 작으면~ -->
	<c:if test="${num lt 60 }">
		불합격입니다.
	</c:if>
	
	<!-- if else구문 = :choose -->
	<!-- when이 if/ otherwise가 else임 -->
	
	<c:out value="${num }" />점은
	<c:choose>
		<c:when test="${num >= 90 }">A등급입니다.</c:when>
		<c:when test="${num >= 80 }">B등급입니다.</c:when>
		<c:when test="${num >= 70 }">C등급입니다.</c:when>
		<c:otherwise>D등급입니다.</c:otherwise>
	</c:choose>
</body>
</html>