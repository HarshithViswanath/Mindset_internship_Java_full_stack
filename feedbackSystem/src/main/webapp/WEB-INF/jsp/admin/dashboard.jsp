<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Dashboard — Admin</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/admin-nav.jsp"><jsp:param name="nav" value="dash"/></jsp:include>
<main>
  <section class="hero">
    <h1>Dashboard</h1>
    <p class="lead">Signed in as <strong>${sessionScope.email}</strong></p>
  </section>
  <div class="grid-2">
    <div class="card">
      <h2>Registered users</h2>
      <p class="stat">${userCount}</p>
      <p class="muted">Rows in <code>REGISTRTION</code></p>
      <p><a href="${pageContext.request.contextPath}/admin/users">Open users list →</a></p>
    </div>
    <div class="card">
      <h2>Feedback received</h2>
      <p class="stat">${feedbackCount}</p>
      <p class="muted">Rows in <code>FEEDBACK</code></p>
      <p><a href="${pageContext.request.contextPath}/admin/feedbacks">View feedback →</a></p>
    </div>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC · Admin</footer>
</body>
</html>
