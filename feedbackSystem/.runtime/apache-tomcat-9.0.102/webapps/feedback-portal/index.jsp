<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home — Feedback Analysis Portal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/public-nav.jsp"><jsp:param name="nav" value="home"/></jsp:include>
<main>
  <section class="hero">
    <h1>Feedback Analysis Portal</h1>
    <p class="lead">A simple MVC web application: users register, sign in, and share feedback. Administrators review submissions and registered users from a dedicated console.</p>
  </section>
  <c:if test="${param.welcome == '1'}">
    <div class="alert alert-ok">Welcome, ${sessionScope.displayName}. You can submit feedback from the menu.</div>
  </c:if>
  <c:if test="${param.logout == '1'}">
    <div class="alert alert-ok">You have been logged out.</div>
  </c:if>
  <div class="grid-2">
    <div class="card">
      <h2>For users</h2>
      <p class="muted">Create an account from <a href="${pageContext.request.contextPath}/register.jsp">Register</a>, then sign in to send feedback we can analyze and act on.</p>
    </div>
    <div class="card">
      <h2>For administrators</h2>
      <p class="muted">Use <a href="${pageContext.request.contextPath}/login">Login</a> with admin credentials to open the dashboard, user list, and feedback inbox.</p>
    </div>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC · Model · View · Controller</footer>
</body>
</html>
