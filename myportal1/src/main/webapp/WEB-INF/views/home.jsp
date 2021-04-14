<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/home.css"/>"/>
</head>
<body>
<div id="container">
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
<div id="wapper">
<div id="content">

	<div id="site-introduction">
	
	<p>Spring으로 만든 홈페이지입니다</p>
	</div>
	</div>
	</div>
	</div>
</body>
</html>