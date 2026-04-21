<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.role}">
  <c:choose>
    <c:when test="${sessionScope.role == 'ADMIN'}">
      <c:redirect url="${pageContext.request.contextPath}/admin/dashboard"/>
    </c:when>
    <c:otherwise>
      <c:redirect url="${pageContext.request.contextPath}/index.jsp"/>
    </c:otherwise>
  </c:choose>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login — Feedback Analysis Portal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/public-nav.jsp"><jsp:param name="nav" value="login"/></jsp:include>
<main>
  <section class="hero">
    <h1>Login</h1>
    <p class="lead">The same form authenticates <strong>admin</strong> accounts (from the <code>ADMIN</code> table) and <strong>users</strong> (from <code>REGISTRTION</code>).</p>
  </section>
  <div class="card" style="max-width: 420px;">
    <c:if test="${param.registered == '1'}">
      <div class="alert alert-ok">Registration successful. Sign in below.</div>
    </c:if>
    <c:if test="${param.error == 'missing'}">
      <div class="alert alert-error">Email and password are required.</div>
    </c:if>
    <c:if test="${param.error == 'credentials'}">
      <div class="alert alert-error">Invalid email or password.</div>
    </c:if>
    <c:if test="${param.error == 'admin'}">
      <div class="alert alert-error">Administrator access only. Please log in as admin.</div>
    </c:if>
    <c:if test="${param.error == 'feedback'}">
      <div class="alert alert-error">Sign in as a user to submit feedback.</div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/login">
      <div class="form-row">
        <label for="email">Email</label>
        <input id="email" name="email" type="email" required autocomplete="username">
      </div>
      <div class="form-row">
        <label for="password">Password</label>
        <input id="password" name="password" type="password" required autocomplete="current-password">
      </div>
      <button type="submit" class="btn">Sign in</button>
    </form>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC</footer>
</body>
</html>
