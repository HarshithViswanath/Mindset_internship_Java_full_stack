<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Users list — Admin</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/includes/admin-nav.jsp"><jsp:param name="nav" value="users"/></jsp:include>
<main>
  <section class="hero">
    <h1>Users list</h1>
    <p class="lead">Data from <code>REGISTRTION</code> (name, mobile, email).</p>
  </section>
  <div class="card" style="overflow-x: auto;">
    <table class="data">
      <thead>
      <tr>
        <th>Name</th>
        <th>Mobile</th>
        <th>Email</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="u" items="${users}">
        <tr>
          <td><c:out value="${u.name}"/></td>
          <td><c:out value="${u.mobile}"/></td>
          <td><c:out value="${u.email}"/></td>
        </tr>
      </c:forEach>
      <c:if test="${empty users}">
        <tr><td colspan="3" class="muted">No users registered yet.</td></tr>
      </c:if>
      </tbody>
    </table>
  </div>
</main>
<footer class="site-footer">Feedback Analysis Portal MVC · Admin</footer>
</body>
</html>
