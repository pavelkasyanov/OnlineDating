<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="tab-pane fade in active" id = "tab1">

  <div class="row">


    <div class="col-md-6  col-lg-6 col-sm-6  ">

      <br>
      <form action="add_ask" method="post" class="form-horizontal">

        <h3>Выбор категории вопроса</h3>

        <select style="width: 60%" name="category_new" id="category_new">
          <c:forEach var="category" items="${categoryList}">
            <option value="${category}"><c:out value="${category}"/></option>
          </c:forEach>
        </select>
        <textarea rows="5" style="width: 100%; resize: none" name="questionText" id="questionText"></textarea>
        <div class="form-actions">
          <button type="submit" class="btn btn-primary">Сохранить изменения</button>

          <button type="reset" class="btn">Отмена</button>
        </div>

      </form>


    </div>

    <div class="col-md-6  col-lg-6 col-sm-6 ">


      <div class="btn-group btn-toggle" style="margin-left: 15px; margin-top: 0">
        <h3>Приоритет вопроса</h3>
        <br>
        <button class="btn btn-lg btn-default" id="askImport">Важно</button>
        <button class="btn btn-lg btn-primary active" id="askNotImport">Не важно</button>
      </div>
    </div>
  </div>
  <div class="row" id="my_question_list_div">
    <ul id="my_question_list">
      <c:forEach var="question" items="${myQuestionList}">
        <li id="myAsk_${question.questionID}">
          <h4><br>
            <c:out value="${question}" /><a onclick="deleteQuestion(${question.questionID});">delete</a>
          </h4>
        </li>
      </c:forEach>
    </ul>
  </div>

</div>