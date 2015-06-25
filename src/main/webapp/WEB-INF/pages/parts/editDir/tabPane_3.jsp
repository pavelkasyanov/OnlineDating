<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="tab-pane fade" id = "tab3">
  <select style="width: 60%" name="category_new1" id="category_new1" onchange="getLastCategoryQuestions();">
    <c:forEach var="category" items="${categoryList}">
      <option value="${category}"><c:out value="${category}"/></option>
    </c:forEach>
  </select>
  <ul id="lastAskCategoryList">

  </ul>
</div>