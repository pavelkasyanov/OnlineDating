<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

  <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet">

</head>

<body >
<!-- menu -->

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

            <li><a href="home"> Моя страница </a> </li>
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

    <div class="col-md-2 col-lg-2 col-sm-2" style="border-right: solid 1px rgba(30, 30, 30, 0.23); background-color: rgba(30, 30, 30, 0.05); height: 200px ">
      <div class="myMenu">
      <ul class="list-unstyled" style=" text-align: justify">

        <li><h4> <a href="#"> Контакты<br> </a></h4></li>
        <li><h4> <a href="#"> Уведомления <br></a></h4></li>
        <li><h4> <a href="#"> Сообщения <br></a></h4></li>
        <li><h4> <a href="ask"> Редактирование  <br></a></h4></li>

      </ul>
    </div>


  </div>



  <div class="col-md-3 col-lg-3 col-sm-3" style="text-align: center; border-right:solid 1px rgba(30, 30, 30, 0.23); ">


    <img src="${avatartUrl}" class="img-polaroid"  width="200" height="200">


  </div>

  <div class="col-md-7 col-lg-7 col-sm-7"  style="height: 200px; border-bottom: solid 1px rgba(30, 30, 30, 0.23)">
    <h3>О себе</h3>
    <p style="text-align: justify; margin-left: 0 ">
      <c:out value="${aboutMeText}" />
    </p>

  </div>

</div>
<div class="row" style="background: rgba(255, 255, 255, 0.38);margin-top: 40px; ">
  <div class="col-md-12 col-lg-12 col-sm-12">
    <div class="myQuestion">
      <h3>Мои вопросы</h3>
      <hr>
      <br>

        <c:forEach var="ask" items="${myAskList}">

           <h4>
              <p class="ask">
                <c:out value="${ask.text}" />
              </p>
           </h4>

        </c:forEach>

    </div>
  </div>
</div>
</div>



























</body>
</html>
