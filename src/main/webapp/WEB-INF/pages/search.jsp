<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<head>

  <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" rel="stylesheet">

</head>
</head>
<body>

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
            <li><a href=""> Поиск </a> </li>
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

    <div class="col-md-9 col-lg-9 col-sm-9">

      <table class="table" cellpadding="0" cellspacing="0">
        <tr>
          <td style = "text-align: center; background-color: white;">
            <img src="${pageContext.request.contextPath}/resources/css/img/ph1.jpg" class="img-polaroid">
            <p> Имя : Возраст </p>
            <p> Мой напряг : Его/ее напряг </p>


          </td>
          <td style = "text-align: center; background-color: white; ">
            <img src="${pageContext.request.contextPath}/resources/css/img/ph1.jpg" class="img-polaroid">
            <p> Имя : Возраст </p>
            <p> Мой напряг : Его/ее напряг </p>


          </td>
          <td style = "text-align: center; background-color: white; ">
            <img src="${pageContext.request.contextPath}/resources/css/img/ph1.jpg" class="img-polaroid">
            <p> Имя : Возраст </p>
            <p> Мой напряг : Его/ее напряг </p>


          </td>
          <td style = "text-align: center; background-color: white; ">
            <img src="${pageContext.request.contextPath}/resources/css/img/ph1.jpg" class="img-polaroid">
            <p> Имя : Возраст </p>
            <p> Мой напряг : Его/ее напряг </p>


          </td>
        </tr>




      </table>

    </div>



    <div class="col-md-3 col-lg-3 col-sm-3" style="font-family: Helvetica, Arial, sans-serif;border-left: solid 1px rgba(0, 0, 0, 0.15)">
      <div class="row" style=" margin-left: 10px;  ">
        <form class="form-inline" method="get" name="searchFilter" id="searchFilter">

          <h3> Пол </h3>
          <div class="btn-group " role="group" >



            <div class="btn-group" role="group">
              <button type="button" class="btn btn-default">М</button>
            </div>
            <div class="btn-group" role="group">
              <button type="button" class="btn btn-default">Ж</button>
            </div>

          </div>

          <h3> Город </h3> <br>


          <select style="width: 60%">

            <option>Минск </option>
            <option>Гомель </option>
            <option>Гродно </option>
            <option>Могилев </option>
            <option>Гадюкино </option>

          </select>

          <h3>Возраст</h3>
          <input type="number" placeholder="18" style="width: 20%" > - <input type="number" placeholder="118" style="width: 20%" >


          <h3>Цель знакомства</h3>
          <br>
          <select style="width: 60%">
            <option>Семья </option>
            <option>Дружба </option>
            <option>Совместное рыдание в  подушку </option>


          </select>
          <p> </p>
          <h4>
            <input type = "button" name = "addSearchData" value = "применить">
          </h4>
        </form>

      </div>
    </div>
  </div>
</body>
</html>
