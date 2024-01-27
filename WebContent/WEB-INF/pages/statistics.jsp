<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="dto.LogDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="statisticBean" type="beans.StatisticBean"
	scope="session"></jsp:useBean>
<!DOCTYPE html>

<%
List<LogDTO> logs = statisticBean.getLogsByPage(statisticBean.getPageSize(), statisticBean.getCurrentPage());
Map<String, String[]> levelMappings = Map.of("Warning",
		new String[] { "images/warning.png", "bg-warning", "border-warning" }, "Error",
		new String[] { "images/error.png", "bg-danger", "border-danger" }, "Info",
		new String[] { "images/info.png", "bg-info", "border-info" });
%>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Statistics</title>
<link href="bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script src="bootstrap-5.3.2-dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<link href="styles/navbar.css" rel="stylesheet">
<link href="styles/statistics.css" rel="stylesheet">
</head>
<body class="bg-secondary">
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div class="container-fluid">
		<h1 class="m-5 text-white">Logs</h1>
		<div class="custom-scrollbar">
			<div class="container">

				<%
				for (LogDTO log : logs) {
				%>
				<div
					class="card text-center mb-4 border border-3 <%=levelMappings.get(log.getLevel())[2]%>">
					<div class="card-header fw-semibold text-white">
						<span
							class="badge <%=levelMappings.get(log.getLevel())[1]%> rounded-pill fs-4 fw-semibold"><%=log.getLevel()%></span>
					</div>
					<div class="card-body ">
						<p class="fw-semibold fs-6"><%=new SimpleDateFormat("dd MMM, yyy").format(log.getCreationDate())%></p>
						<button class="btn btn-success fw-semibold fs-6" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#collapse_<%=log.getId()%>"
							aria-expanded="false" aria-controls="collapseExample">
							<img src="<%=levelMappings.get(log.getLevel())[0]%>">&nbsp;View
							log message
						</button>
						<div class="collapse" id="collapse_<%=log.getId()%>">
							<p class="card-text fs-5 fw-semibold"><%=log.getMessage()%></p>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
		<div class="container mt-2 d-flex justify-content-end">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li
						class="page-item <%=(statisticBean.getCurrentPage() == 1) ? "disabled" : ""%>">
						<a class="page-link"
						href="StatisticController?action=page&page=<%=statisticBean.getCurrentPage() - 1%>"
						aria-label="Previous"> <span aria-hidden="true">&laquo;
								Previous</span>
					</a>
					</li>

					<%
					for (int pg = 1; pg <= statisticBean.getTotalPages(statisticBean.getPageSize()); pg++) {
					%>
					<li
						class="page-item <%=(pg == statisticBean.getCurrentPage()) ? "active" : ""%>">
						<a class="page-link"
						href="StatisticController?action=page&page=<%=pg%>"><%=pg%></a>
					</li>
					<%
					}
					%>

					<li
						class="page-item <%=(statisticBean.getCurrentPage() == statisticBean.getTotalPages(statisticBean.getPageSize())) ? "disabled" : ""%>">
						<a class="page-link"
						href="StatisticController?action=page&page=<%=statisticBean.getCurrentPage() + 1%>"
						aria-label="Next"> <span aria-hidden="true">Next
								&raquo;</span>
					</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>