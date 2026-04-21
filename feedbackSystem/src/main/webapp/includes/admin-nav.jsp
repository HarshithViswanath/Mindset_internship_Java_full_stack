<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<header class="site-header">
  <div class="inner">
    <a href="${ctx}/admin/dashboard" class="brand">Admin <span>Console</span></a>
    <nav>
      <ul>
        <li><a href="${ctx}/admin/dashboard" class="${param.nav == 'dash' ? 'active' : ''}">Dashboard</a></li>
        <li><a href="${ctx}/admin/users" class="${param.nav == 'users' ? 'active' : ''}">Users list</a></li>
        <li><a href="${ctx}/admin/feedbacks" class="${param.nav == 'feedback' ? 'active' : ''}">View feedback</a></li>
        <li><a href="${ctx}/logout">Logout</a></li>
      </ul>
    </nav>
  </div>
</header>
