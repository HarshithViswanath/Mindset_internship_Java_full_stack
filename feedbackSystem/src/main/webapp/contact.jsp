<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Contact — Feedback Analysis Portal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/public-nav.jsp"><jsp:param name="nav" value="contact"/></jsp:include>
<main>
  <section class="hero">
    <h1>Contact</h1>
    <p class="lead">Product feedback goes through the portal once you are registered and signed in. For other inquiries, use your course or team channel.</p>
  </section>
  <div class="card">
    <h2>Submit feedback in the app</h2>
    <p class="muted">After <a href="${pageContext.request.contextPath}/login">login</a> as a user, open <strong>Submit feedback</strong> in the navigation bar.</p>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC</footer>
</body>
</html>
