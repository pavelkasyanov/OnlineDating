<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="parts/pageHeader.jsp">
<jsp:param name="title" value="home"/>
</jsp:include>
<jsp:include page="parts/Header.jsp"/>

<!-- menu -->
<div class="container" style="margin-top: 150px">

  <jsp:include page="parts/homeDir/userInfo.jsp"/>
  <jsp:include page="parts/homeDir/userQ.jsp"/>

</div>

<jsp:include page="parts/Footer.jsp"/>
<jsp:include page="parts/pageFooter.jsp"/>


























