<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
<link href="bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script src="bootstrap-5.3.2-dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<link href="styles/404.css" rel="stylesheet">
<link href="styles/navbar.css" rel="stylesheet">
</head>
<body class="bg-secondary">
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div class="content">
		<div class="card p-5 bg-light align-items-center">
		<p class="error">404 - Page Not Found</p>
		<p class="eror-mess">Oops! Looks like you're lost.</p>
		</div>
	</div>
</body>
</html>