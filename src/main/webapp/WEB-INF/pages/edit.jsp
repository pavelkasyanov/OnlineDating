<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel=" stylesheet ">

<link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script type="text/javascript">
  jQuery(document).ready(function ($) {
    $('#mytabs').tab();
  });

  $('.btn-toggle').click(function() {
    $(this).find('.btn').toggleClass('active');

    if ($(this).find('.btn-primary').size()>0) {
      $(this).find('.btn').toggleClass('btn-primary');
    }
    if ($(this).find('.btn-danger').size()>0) {
      $(this).find('.btn').toggleClass('btn-danger');
    }
    if ($(this).find('.btn-success').size()>0) {
      $(this).find('.btn').toggleClass('btn-success');
    }
    if ($(this).find('.btn-info').size()>0) {
      $(this).find('.btn').toggleClass('btn-info');
    }

    $(this).find('.btn').toggleClass('btn-default');

  });

  $('form').submit(function(){
    alert($(this["options"]).val());
    return false;
  });

</script>


<body >


<div class="container-fluid">
  <div class="row">
    <div class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">

          <button type="button" class="navbar-toggle" data-toggle = "collapse"  data-target = "#resp_menu " style="width: 50px;">
            <span class="sr-only"> открыть меню</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>


        </div>

        <div class="collapse navbar-collapse" id = "resp_menu">

          <ul class="nav navbar-nav" >
            <li><a href="home"> Моя страница </a>   </li>
            <li><a href="#"> Поиск </a> </li>
            <li><a href="ask"> Вопросы </a> </li>
            <li><a href="#"> Link </a> </li>
          </ul>

        </div>

      </div>
    </div>
  </div>
</div>




<div class="container" style="margin-top: 150px">

  <div class="row">

    <div class="col-md-8 col-lg-8 col-sm-8">

      <div class="tabs" id="mytabs">
        <ul class="nav nav-tabs">
          <li class="active"><a href="#tab1" data-toggle="tab"> Мои вопросы </a></li>
          <li><a href="#tab2" data-toggle="tab"> Вопросы друзей </a></li>
          <li><a href="#tab3" data-toggle="tab"> Топ </a></li>
          <li><a href="#tab3" data-toggle="tab"> Последние вопросы </a></li>

        </ul>

        <div  class="tab-content">

          <div class="tab-pane fade in active" id = "tab1">

            <div class="row">


              <div class="col-md-6  col-lg-6 col-sm-6  ">

                <br>
                <form action="/add_ask" method="post" class="form-horizontal">

                  <textarea rows="5" style="width: 100%" name="questionText"></textarea>
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
                  <button class="btn btn-lg btn-default">Важно</button>
                  <button class="btn btn-lg btn-primary active">Не важно</button>
                </div>
              </div>



            </div>


          </div>
          <div class="tab-pane fade" id = "tab2">
            <ul>
              <c:forEach var="question" items="${questionList}">
              <li>
                <h4><br>
                  <c:out value="${question.text}" />
                </h4>
              </li>
              </c:forEach>
          </div>
          <div class="tab-pane fade" id = "tab3">
            <ul>
              <c:forEach var="question" items="${questionList}">
                <li>
                  <h4><br>
                    <c:out value="${question.text}" />
                  </h4>
                </li>
              </c:forEach>
            </ul>
          </div>

          <div class="tab-pane fade" id = "tab4">
            <ul>
              <c:forEach var="question" items="${questionList}">
                <li>
                  <h4><br>
                    <c:out value="${question.text}" />
                  </h4>

                  <input type="button" value="добавить">
                </li>
              </c:forEach>
            </ul>
          </div>

        </div>

      </div>

    </div>

    <div class="col-md-4 col-lg-4 col-sm-4" style="border-left: solid 1px rgba(12, 3, 52, 0.29)">

      <div class="row" style="margin-left: 40px;  ">
        <div class="btn-group">

          <h3>Категории вопросов</h3>

          <select style="width: 60%">

            <option>Отдых </option>
            <option>Личное </option>
            <option>Карьера</option>
            <option>Ценности </option>


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

    </div>

  </div>

</div>

<!--
<div class="container">


        <div class="row">
            <div class = "col_color">

            <div class="col-md-6  col-lg-6 col-sm-6  "> 1<br>1<br>1 </div>
            <div class="col-md-6  col-lg-6 col-sm-6  "> 2<br>2<br>2 </div>

            </div>

        </div>
    </div>
-->

<div class="container">

</div>



</body>

</html>
