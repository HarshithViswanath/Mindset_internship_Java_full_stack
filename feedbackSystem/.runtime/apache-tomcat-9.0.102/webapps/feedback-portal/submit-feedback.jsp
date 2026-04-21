<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.role != 'USER'}">
  <c:redirect url="${pageContext.request.contextPath}/login.jsp?error=feedback"/>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Submit feedback — Feedback Analysis Portal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/public-nav.jsp"><jsp:param name="nav" value="feedback"/></jsp:include>
<main>
  <section class="hero">
    <h1>Your feedback</h1>
    <p class="lead">Entries are stored in the <code>FEEDBACK</code> table for administrators to review.</p>
  </section>
  <div class="card" style="max-width: 560px;">
    <c:if test="${param.success == '1'}">
      <div class="alert alert-ok">Thank you — your feedback was saved.</div>
    </c:if>
    <c:if test="${param.error == 'missing'}">
      <div class="alert alert-error">Please complete all fields.</div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/feedback/submit">
      <div class="form-row">
        <label for="name">Name</label>
        <input id="name" name="name" type="text" required value="${sessionScope.displayName}">
      </div>
      <div class="form-row">
        <label for="emailId">Email</label>
        <input id="emailId" name="emailId" type="email" required value="${sessionScope.email}">
      </div>
      <div class="form-row">
        <label for="feedback">Feedback</label>
        <textarea id="feedback" name="feedback" required placeholder="Describe your experience or suggestion…"></textarea>
      </div>
      <button type="submit" class="btn">Send feedback</button>
    </form>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC</footer>
</body>
</html>
