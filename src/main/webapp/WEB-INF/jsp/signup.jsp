<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp" />

<div class="container">
	<h2 class="text-success text-center">Sigup</h2>
	<form action="/signup" method="post">
		<div class="form-group">
			<label for="firstName">First Name:</label> <input type="text"
				class="form-control" id="firstName" placeholder="Enter First Name"
				name="firstName" value="${firstName }" required>
		</div>
		<div class="form-group">
			<label for="lastName">lastName:</label> <input type="email"
				class="form-control" id="lastName" placeholder="Enter Last Name"
				name="lastName" value="${lastName }" required>
		</div>
		<div class="form-group">
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="mail" value="${mail}" required>
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" id="pwd" placeholder="Enter password"
				name="password" value="${password}" required>
		</div>
		<div class="form-group">
			<label for="repeat-pwd">Repeat Password:</label> <input type="password"
				class="form-control" id="repeat-pwd" placeholder="Enter repeat password"
				name="repeatPassword" value="${repeatPassword}" required>
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox" name="remember">
				Remember me
			</label>
		</div>
		<div style="color: red;">${error}</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>


<c:import url="footer.jsp" />