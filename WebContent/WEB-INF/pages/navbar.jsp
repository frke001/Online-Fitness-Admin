
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand fs-4 text-white fw-bold me-auto" href="#">Admin</a>

			<div class="offcanvas offcanvas-end" tabindex="-1"
				id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasNavbarLabel">Admin</h5>
					<button type="button" class="btn-close ms-2" data-bs-dismiss="offcanvas"
						aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-center flex-grow-1 pe-3">
						<li class="nav-item">
						
						<a class="nav-link mx-lg-2"
							aria-current="page" href="NavbarController?action=categories"><img src="images/categories.png">Categories</a></li>
						<li class="nav-item"><a class="nav-link  mx-lg-2" href="NavbarController?action=users"><img src="images/users.png">Users</a>
						</li>
						<li class="nav-item"><a class="nav-link  mx-lg-2" href="NavbarController?action=statistics"><img src="images/statistics.png">Statistics</a>
						</li>
					</ul>

				</div>
			</div>
			<a href="LoginController?action=logout" class="logout-button"><img src="images/logout.png">Logout</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

		</div>
	</nav>
