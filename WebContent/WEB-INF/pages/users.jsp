<%@page import="dto.ClientDTO"%>
<%@page import="dto.AdvisorDTO"%>
<%@page import="java.util.*"%>
<%@page import="beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="userBean" type="beans.UserBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Users</title>
<link href="bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script src="bootstrap-5.3.2-dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<link href="styles/users.css" rel="stylesheet">
<link href="styles/navbar.css" rel="stylesheet">
</head>
<body class="bg-secondary">
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<%
	Boolean clients = (Boolean) session.getAttribute("clients");
	String clientsActive = "";
	String advisorsActive = "";

	if (clients != null && clients) {
		clientsActive = "active";
	} else {
		advisorsActive = "active";
	}
	%>
	<div class="container-fluid">
		<div class="content">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation"><a
					class="nav-link <%=clientsActive%>" id="users-tab"
					data-bs-toggle="tab" data-bs-target="#users-tab-pane" role="tab"
					aria-controls="users-tab-pane" aria-selected="true">Clients</a></li>
				<li class="nav-item" role="presentation"><a
					class="nav-link <%=advisorsActive%>" id="advisors-tab"
					data-bs-toggle="tab" data-bs-target="#advisors-tab-pane" role="tab"
					aria-controls="advisors-tab-pane" aria-selected="false">Advisors</a>
				</li>

			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show <%=clientsActive%>"
					id="users-tab-pane" role="tabpanel" aria-labelledby="users-tab"
					tabindex="0" style="overflow-x: auto ">
					<h1 class="title-users m-2">Clients</h1>
					<table
						class="table h-100 table-striped table-primary table-responsive table-bordered border-dark table-hover
					text-center fs-5">
						<thead class="table-dark table-active text-uppercase text-white">
							<tr>
								<th scope="col">#</th>
								<th scope="col"><div class="t-h">
										<img src="images/name.png">Name
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/surname.png">Surname
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/username.png">Username
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/mail.png">Mail
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/city.png">City
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/settings.png">Actions
									</div></th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = 0;
							for (ClientDTO client : userBean.getAllClients()) {
								i++;
							%>
							<tr>
								<td><%=i%></td>
								<td><%=client.getName()%></td>
								<td><%=client.getSurname()%></td>
								<td><%=client.getUsername()%></td>
								<td><%=client.getMail()%></td>
								<td><%=client.getCity()%></td>

								<td>
									<%
									if (client.getDeleted()) {
									%> <a
									href="UserController?action=unblockUser&id=<%=client.getId()%>"><img
										src="images/unblock.png" data-bs-toggle="tooltip"
										data-bs-title="Unblock client"></a> <%
 } else {
 %> <a href="UserController?action=blockUser&id=<%=client.getId()%>"
									data-bs-toggle="tooltip" data-bs-title="Block client"><img
										src="images/block.png"></a> <%
 }
 %>
								</td>

							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade show <%=advisorsActive%>"
					id="advisors-tab-pane" role="tabpanel"
					aria-labelledby="advisors-tab" tabindex="0" style="overflow-x: auto ">

					<div class="d-flex justify-content-between align-items-center m-2 head">
						<h1 style="color: white;">Advisors</h1>
						<button
							class="btn btn-success d-flex align-items-center gap-1 fw-semibold fs-5 rounded-pill"
							data-bs-toggle="modal" data-bs-target="#addAdvisorModal">
							<img src="images/add.png"><span class="add-text">Add
								advisor</span>
						</button>
					</div>
					<table
						class="table table-striped table-primary table-responsive table-bordered border-dark table-hover
					text-center fs-5">
						<thead class="table-dark table-active text-uppercase text-white">
							<tr>
								<th scope="col">#</th>
								<th scope="col"><div class="t-h">
										<img src="images/name.png">Name
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/surname.png">Surname
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/username.png">Username
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/mail.png">Mail
									</div></th>
								<th scope="col"><div class="t-h">
										<img src="images/settings.png">Actions
									</div></th>
							</tr>
						</thead>
						<tbody>
							<%
							int k = 0;
							for (AdvisorDTO advisor : userBean.getAllAdvisors()) {
								k++;
							%>
							<tr>
								<td><%=k%></td>
								<td><%=advisor.getName()%></td>
								<td><%=advisor.getSurname()%></td>
								<td><%=advisor.getUsername()%></td>
								<td><%=advisor.getMail()%></td>

								<td>
									<%
									if (advisor.getDeleted()) {
									%> <a
									href="UserController?action=unblockAdvisor&id=<%=advisor.getId()%>"><img
										src="images/unblock.png" data-bs-toggle="tooltip"
										data-bs-title="Unblock advisor"></a> <%
 } else {
 %> <a href="UserController?action=blockAdvisor&id=<%=advisor.getId()%>"
									data-bs-toggle="tooltip" data-bs-title="Block advisor"><img
										src="images/block.png"></a> <%
 }
 %>
								</td>

							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="toast-container position-fixed bottom-0 end-0 p-3">
		<div id="liveToastUnsuccess" class="toast" role="alert" aria-live="assertive"
			aria-atomic="true">
			<div class="toast-header">
				<img src="images/alarm.png" class="rounded me-2" alt="..."> <strong
					class="me-auto">Warning</strong> <small>just now</small>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
			<div class="toast-body fw-semibold fs-6">You can not add advisor with duplicate
				username or e-mail.</div>
		</div>
	</div>
	<div class="toast-container position-fixed bottom-0 end-0 p-3">
		<div id="liveToastSuccess" class="toast" role="alert" aria-live="assertive"
			aria-atomic="true">
			<div class="toast-header">
				<img src="images/success.png" class="rounded me-2" alt="..."> <strong
					class="me-auto">Success</strong> <small>just now</small>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
			<div class="toast-body fw-semibold fs-6">Action successful.</div>
		</div>
	</div>
	<div class="modal fade" id="addAdvisorModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Add new
						advisor</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form method="post" action="UserController?action=addAdvisor"
						class="needs-validation" novalidate>
						<div class="mb-3">
							<label for="name" class="form-label">Name</label>

							<div class="input-group has-validation">
								<input type="text" class="form-control rounded-end shadow"
									id="name" name="name" placeholder="Enter name" required>
								<div class="invalid-feedback">Please insert name.</div>

							</div>
							<br> <label for="name" class="form-label">Surname</label>

							<div class="input-group has-validation">
								<input type="text" class="form-control rounded-end shadow"
									id="surname" name="surname" placeholder="Enter surname"
									required>
								<div class="invalid-feedback">Please insert surname.</div>

							</div>
							<br> <label for="name" class="form-label">Username</label>
							<div class="input-group has-validation">
								<input type="text" class="form-control rounded-end shadow"
									id="username" name="username" placeholder="Enter username"
									required>
								<div class="invalid-feedback">Please insert username.</div>

							</div>
							<br> <label for="name" class="form-label">Password</label>
							<div class="input-group has-validation">
								<input type="password" class="form-control rounded-end shadow"
									id="password" name="password" placeholder="Enter password"
									required>
								<div class="invalid-feedback">Please insert password.</div>

							</div>
							<br> <label for="name" class="form-label">Retype
								password</label>
							<div class="input-group has-validation">
								<input type="password" class="form-control rounded-end shadow"
									id="retypePassword" name="retypePassword"
									placeholder="Enter password" required>
								<div class="invalid-feedback">Please insert password.</div>
								<div id="passwordMatchError" class="invalid-feedback">Passwords
									do not match. Please re-enter.</div>

							</div>
							<br> <label for="name" class="form-label">E-mail</label>
							<div class="input-group has-validation">
								<input type="email" class="form-control rounded-end shadow"
									id="mail" name="mail" placeholder="Enter mail" required>
								<div class="invalid-feedback">Please insert valid mail.</div>

							</div>
						</div>
						<br>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" name="submit" class="btn btn-success">Save</button>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>
	<script>
	 const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }
	   // Provera da li su šifra i ponovna šifra iste
          const password = form.querySelector('#password').value;
          const retypePassword = form.querySelector('#retypePassword').value;
          const passwordMatchError = document.querySelector('#passwordMatchError');

          if (password !== retypePassword) {
              passwordMatchError.style.display = 'block';
              event.preventDefault();
              event.stopPropagation();
              return; // Dodajte ovu liniju kako biste se osigurali da se forma ne šalje ako šifre nisu iste
          } else {
              passwordMatchError.style.display = 'none';
          }
	      form.classList.add('was-validated')
	    }, false);
	  });
	 
	 const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
		const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
		
		window.addEventListener('load', () => {
        	const toastShown = <%= session.getAttribute("showToastAdvisor")%>
        	const toastShownSuccess = <%= session.getAttribute("showToastAdvisorSuccess")%>
            if (toastShown) {
                const toastLiveExample = document.getElementById('liveToastUnsuccess');

                const toastBootstrap = new bootstrap.Toast(toastLiveExample, { autohide: false });
                toastBootstrap.show();

                <% session.setAttribute("showToastAdvisor", "false");%>
            }
            if (toastShownSuccess) {
                const toastLiveExample = document.getElementById('liveToastSuccess');

                const toastBootstrap = new bootstrap.Toast(toastLiveExample, { autohide: false });
                toastBootstrap.show();

                <% session.setAttribute("showToastAdvisorSuccess", "false");%>
            }
        });
	</script>
	
</body>
</html>