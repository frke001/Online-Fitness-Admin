<%@page import="dto.CategoryDTO"%>
<%@page import="dto.CategoryAttributeDTO"%>
<%@page import="java.util.*"%>
<%@page import="beans.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="categoryBean" type="beans.CategoryBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Categories</title>
<link href="bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script src="bootstrap-5.3.2-dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<link href="styles/categories.css" rel="stylesheet">
<link href="styles/navbar.css" rel="stylesheet">
</head>
<body class="bg-secondary">
	<%@include file="/WEB-INF/pages/navbar.jsp"%>
	<div class="container-fluid">
		<div class="title-button m-5">
			<h1 style="color: white;">Categories</h1>
			<button class="btn btn-success" data-bs-toggle="modal"
				data-bs-target="#addCategoryModal">
				<img src="images/add.png"><span class="add-text">Add
					category</span>
			</button>
		</div>

		<div
			class="row row-cols-xs-1 row-cols-sm-1 row-cols-md-3 row-cols-lg-4 row-cols-xl-4 row-cols-xxl-4 gx-3 gy-3">
			<%
			for (CategoryDTO category : categoryBean.getAll()) {
				List<CategoryAttributeDTO> attributes = categoryBean.getAllAttributesForCategory(category.getId());
			%>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 col-xxl-3">
				<div class="card">
					<div class="card-header">
						<h5><%=category.getName()%></h5>
						<button data-bs-toggle="modal"
							data-bs-target="#modifyCategoryModal"
							class="modify-btn btn btn-primary"
							data-category-id="<%=category.getId()%>">
							<img src="images/modify.png">Change name
						</button>
					</div>

					<div class="card-body">
						<h5>Attributes:</h5>

						<ul>
							<%
							for (CategoryAttributeDTO attribute : attributes) {
							%>
							<li><div class="li-content">
									<%=attribute.getName()%>
									<a
										href="CategoryController?action=deleteAttribute&id=<%=attribute.getId()%>"
										data-bs-toggle="tooltip" data-bs-title="Delete attribute"><img
										src="images/delete.png"></a>
								</div></li>

							<%
							}
							%>
						</ul>
					</div>
					<div class="card-footer">
						<button class="add-btn btn btn-success" data-bs-toggle="modal"
							data-bs-target="#addAttributeModal"
							data-category-id="<%=category.getId()%>">
							<img src="images/add.png">Add attribute
						</button>
						<a
							href="CategoryController?action=deleteCategory&id=<%=category.getId()%>"
							class="btn btn-danger"><img src="images/delete.png">Delete</a>
					</div>
				</div>
			</div>
			<%
			}
			%>


		</div>
	</div>
	<div class="modal fade" id="addCategoryModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Add new
						category</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form method="post" action="CategoryController?action=addCategory"
						class="needs-validation" novalidate>
						<div class="mb-3">
							<label for="name" class="form-label">Category name</label>

							<div class="input-group has-validation">
								<input type="text" class="form-control rounded-end shadow"
									id="name" name="name" placeholder="Enter name" required>
								<div class="invalid-feedback">Please insert category name.</div>

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
	<div class="modal fade" id="addAttributeModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Add new
						attribute</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form method="post" action="CategoryController?action=addAttribute"
						class="needs-validation" novalidate>
						<input type="hidden" id="categoryIdInputAttr" class="form-control"
							name="categoryId">
						<div class="mb-3">
							<label for="name" class="form-label">Atribute name</label>

							<div class="input-group has-validation">
								<input type="text" class="form-control rounded-end shadow"
									id="name" name="name" placeholder="Enter name" required>
								<div class="invalid-feedback">Please insert attribute
									name.</div>

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
	<div class="modal fade" id="modifyCategoryModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Modify
						category</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form method="post"
						action="CategoryController?action=modifyCategory"
						class="needs-validation" novalidate>
						<input type="hidden" id="categoryIdInput" class="form-control"
							name="categoryId">

						<div class="mb-3">
							<label for="name" class="form-label">Category name</label>

							<div class="input-group has-validation">
								<input type="text" class="form-control rounded-end shadow"
									id="name" name="name" placeholder="Enter name" required>
								<div class="invalid-feedback">Please insert category name.</div>

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
	<div class="toast-container position-fixed bottom-0 end-0 p-3">
		<div id="catToastUnsuccess" class="toast" role="alert" aria-live="assertive"
			aria-atomic="true">
			<div class="toast-header">
				<img src="images/alarm.png" class="rounded me-2" alt="..."> <strong
					class="me-auto">Warning</strong> <small>just now</small>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
			<div class="toast-body fw-semibold fs-6">Action unsuccessful</div>
		</div>
	</div>
	<div class="toast-container position-fixed bottom-0 end-0 p-3">
		<div id="catToastSuccess" class="toast" role="alert" aria-live="assertive"
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
	<script>
    document.addEventListener('DOMContentLoaded', function() {
        const modifyButtons = document.querySelectorAll('.modify-btn');
        const addButtons = document.querySelectorAll('.add-btn');

        modifyButtons.forEach(button => {
            button.addEventListener('click', function() {
                const categoryId = this.getAttribute('data-category-id');
                document.getElementById('categoryIdInput').value = categoryId;
            });
        });
        addButtons.forEach(button => {
            button.addEventListener('click', function() {
                const categoryId = this.getAttribute('data-category-id');
                document.getElementById('categoryIdInputAttr').value = categoryId;
            });
        });
    });
    window.addEventListener('load', () => {
    	const toastShown = <%= session.getAttribute("categoryUnsuccess")%>
    	const toastShownSuccess = <%= session.getAttribute("categorySuccess")%>
        if (toastShown) {
            const toastLiveExample = document.getElementById('catToastUnsuccess');

            const toastBootstrap = new bootstrap.Toast(toastLiveExample, { autohide: false });
            toastBootstrap.show();

            <% session.setAttribute("categoryUnsuccess", "false");%>
        }
        if (toastShownSuccess) {
            const toastLiveExample = document.getElementById('catToastSuccess');

            const toastBootstrap = new bootstrap.Toast(toastLiveExample, { autohide: false });
            toastBootstrap.show();

            <% session.setAttribute("categorySuccess", "false");%>
        }
    });
	</script>
	<script>
	 const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false);
	  });
	</script>
	<script type="text/javascript">
	const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
	const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
	</script>
</body>
</html>