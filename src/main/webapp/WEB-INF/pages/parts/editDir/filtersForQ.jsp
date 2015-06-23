<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="row" style="margin-left: 40px;  ">
  <div class="btn-group">

    <h3>Категории вопросов</h3>

    <!--TODO контроллеры -->

    <select style="width: 60%" >
      <c:forEach var="category" items="${categoryList}">
        <option><c:out value="${category}"/></option>
      </c:forEach>
    </select>


  </div>

  <div class="btn-group " role="group" >
    <h2> Вопросы </h2>
    <div class="btn-group" role="group">
      <button type="button" class="btn btn-default">М</button>
    </div>
    <div class="btn-group" role="group">
      <button type="button" class="btn btn-default">Ж</button>
    </div>
    <div class="btn-group" role="group">
      <button type="button" class="btn btn-default">Общие</button>
    </div>
  </div>

</div>
