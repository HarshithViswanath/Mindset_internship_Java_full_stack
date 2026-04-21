<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>About — Feedback Analysis Portal</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/public-nav.jsp"><jsp:param name="nav" value="about"/></jsp:include>
<main>
  <section class="hero">
    <h1>About this project</h1>
    <p class="lead">This portal follows the Model–View–Controller pattern using Java servlets as controllers, JSP as views, and plain JDBC data access as the model layer.</p>
  </section>
  <div class="card">
    <h2>Stack</h2>
    <p class="muted">Java 11, Maven, Servlet API, JSP/JSTL, MySQL. You can develop in Eclipse, IntelliJ, or VS Code and deploy the generated WAR to Apache Tomcat.</p>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC</footer>
</body>
</html>
