
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="parts/pageHeader.jsp">
  <jsp:param name="title" value="search"/>
</jsp:include>
<jsp:include page="parts/Header.jsp"/>








<div class="container" style="margin-top: 150px">

  <div class="row">

    <jsp:include page="parts/searchDir/usersPanel.jsp"/>
    <jsp:include page="parts/searchDir/searchFilters.jsp"/>




  </div>
  </div>

<jsp:include page="parts/Footer.jsp"/>
<jsp:include page="parts/pageFooter.jsp"/>
