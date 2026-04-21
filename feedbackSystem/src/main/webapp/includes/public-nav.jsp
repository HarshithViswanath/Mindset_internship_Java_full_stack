<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<header class="site-header">
  <div class="inner">
    <a href="${ctx}/index.jsp" class="brand">Feedback<span>Portal</span></a>
    <nav>
      <ul>
        <li><a href="${ctx}/index.jsp" class="${param.nav == 'home' ? 'active' : ''}">Home</a></li>
        <li><a href="${ctx}/about.jsp" class="${param.nav == 'about' ? 'active' : ''}">About</a></li>
        <li><a href="${ctx}/contact.jsp" class="${param.nav == 'contact' ? 'active' : ''}">Contact</a></li>
        <c:choose>
          <c:when test="${empty sessionScope.role}">
            <li><a href="${ctx}/register.jsp" class="${param.nav == 'register' ? 'active' : ''}">Register<span class="badge">users</span></a></li>
            <li><a href="${ctx}/login" class="${param.nav == 'login' ? 'active' : ''}">Login<span class="badge">admin / user</span></a></li>
          </c:when>
          <c:when test="${sessionScope.role == 'USER'}">
            <li><a href="${ctx}/submit-feedback.jsp" class="${param.nav == 'feedback' ? 'active' : ''}">Submit feedback</a></li>
            <li><a href="${ctx}/logout">Logout</a></li>
          </c:when>
          <c:when test="${sessionScope.role == 'ADMIN'}">
            <li><a href="${ctx}/admin/dashboard">Admin</a></li>
            <li><a href="${ctx}/logout">Logout</a></li>
          </c:when>
        </c:choose>
      </ul>
    </nav>
  </div>
</header>
