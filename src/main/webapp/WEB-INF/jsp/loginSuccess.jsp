<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp" />
<div>
<h1>welcome back ${username} (^.^)</h1>
</div>
<a href="/redirect.html" class="btn btn-success">Back to Home page.</a>
<c:import url="footer.jsp" />