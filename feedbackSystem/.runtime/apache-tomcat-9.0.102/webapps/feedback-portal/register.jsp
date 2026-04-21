<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.role}">
  <c:redirect url="${pageContext.request.contextPath}/index.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Register — Feedback Analysis Portal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/public-nav.jsp"><jsp:param name="nav" value="register"/></jsp:include>
<main>
  <section class="hero">
    <h1>Register</h1>
    <p class="lead">Registration is only for end users. Administrators are defined in the <code>ADMIN</code> table.</p>
  </section>
  <div class="card" style="max-width: 480px;">
    <c:if test="${param.error == 'missing'}">
      <div class="alert alert-error">Please fill in every field.</div>
    </c:if>
    <c:if test="${param.error == 'duplicate'}">
      <div class="alert alert-error">That email is already registered.</div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/register">
      <div class="form-row">
        <label for="name">Name</label>
        <input id="name" name="name" type="text" required autocomplete="name">
      </div>
      <div class="form-row">
        <label for="mobile">Mobile</label>
        <input id="mobile" name="mobile" type="text" required autocomplete="tel">
      </div>
      <div class="form-row">
        <label for="email">Email</label>
        <input id="email" name="email" type="email" required autocomplete="email">
      </div>
      <div class="form-row">
        <label for="pwd">Password</label>
        <input id="pwd" name="pwd" type="password" required autocomplete="new-password">
      </div>
      <button type="submit" class="btn">Create account</button>
    </form>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC</footer>
</body>
</html>
