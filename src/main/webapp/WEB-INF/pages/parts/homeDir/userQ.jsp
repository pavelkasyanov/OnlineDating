<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row" style="background: rgba(255, 255, 255, 0.38);margin-top: 40px; ">
  <div class="col-md-12 col-lg-12 col-sm-12">
    <div class="myQuestion">
      <h3>Мои вопросы</h3>
      <hr>
      <br>


      <!-- TODO border + buttons (важно, неважно, добавить) + statist -->




      <c:forEach var="askRow" items="${askRowList}">

        <h4>
          <p class="ask">
            <c:out value="${askRow.question.text}" />

            <c:out value="${askRow.countAnswered}" />
            <c:out value="${askRow.countDenied}" />
            <%--<c:out value="${askRow.countImportant}" />--%>
            <%--<c:out value="${askRow.countAgreed}" />--%>
          </p>
        </h4>

      </c:forEach>

    </div>
  </div>
</div>

