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
	<%
		for(int i=0; i<= 10; i++){
			out.print("i: "+i+"<br>");
		}
		
		String[] str = {"홍길동", "김유신", "주은하"};
		for(String name : str){
			System.out.print(name);
		}
		
		String fruits = "사과, 바나나, 수박, 망고, 자두, 체리";
		
	%>
	
	<!-- fruits를 참조해 fruits2에 저장 -->
	<c:set var="fruits2" value="<%=fruits %>" />
	<ul>
		<!-- 반복해서 ,를 중심으로 fruit에 담을 것 -->
		<c:forTokens items="${fruits2 }" delims="," var="fruit">
			<li>${fruit }</li>
		</c:forTokens>
	</ul>
	
	<!-- 반복문 -->  
	<!-- 변수 i , 시작값 1, 끝나는 값 10이 될 때 까지, 1씩 증가 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i }"></c:out><br>
	</c:forEach>
	
	<!-- names 변수는 str의 값을 참조함 -->
	<c:set var="names" value="<%=str %>" />
	<!-- names들을 다 받아 name이라는 변수에 저장 후 출력 -->
	<ul>		
		<c:forEach var="name" items="${names }">
			<li>${name }</li>
		</c:forEach>	
	</ul>
	
</body>
</html>