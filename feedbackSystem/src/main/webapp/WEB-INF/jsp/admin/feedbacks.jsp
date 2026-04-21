<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>View feedback — Admin</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/admin-nav.jsp"><jsp:param name="nav" value="feedback"/></jsp:include>
<main>
  <section class="hero">
    <h1>View feedback</h1>
    <p class="lead">Columns: <code>NAME</code>, <code>EMAILID</code>, <code>FEEDBACK</code>.</p>
  </section>
  <c:forEach var="f" items="${feedbacks}">
    <div class="card">
      <p class="muted" style="margin:0 0 0.5rem;">
        <strong><c:out value="${f.name}"/></strong>
        · <c:out value="${f.emailId}"/>
        <c:if test="${not empty f.createdAt}"> · <c:out value="${f.createdAt}"/></c:if>
      </p>
      <div class="feedback-body"><c:out value="${f.feedback}"/></div>
    </div>
  </c:forEach>
  <c:if test="${empty feedbacks}">
    <div class="card muted">No feedback submitted yet.</div>
  </c:if>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC · Admin</footer>
</body>
</html>
