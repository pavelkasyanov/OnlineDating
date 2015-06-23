<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="tab-pane fade" id = "tab2">
  <ul>
    <c:forEach var="question" items="${questionList}">
      <li>
        <h4><br>
          <c:out value="${question}" />
        </h4>
      </li>
    </c:forEach>
  </ul>
</div>