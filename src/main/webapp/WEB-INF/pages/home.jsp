<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

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

            <li><a href="#"> Моя страница </a> </li>
            <li><a href="#"> Поиск </a> </li>
            <li><a href="#"> Вопросы </a> </li>
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
        <li><h4> <a href="#"> Редактирование  <br></a></h4></li>

      </ul>
    </div>


  </div>



  <div class="col-md-3 col-lg-3 col-sm-3" style="text-align: center; border-right:solid 1px rgba(30, 30, 30, 0.23); ">
    <img src="${pageContext.request.contextPath}/resources/css/img/ph1.jpg" class="img-polaroid"  >
  </div>

  <div class="col-md-7 col-lg-7 col-sm-7"  style="height: 200px; border-bottom: solid 1px rgba(30, 30, 30, 0.23)">
    <h3>О себе</h3>
    <p style="text-align: justify; margin-left: 0 "> С шести лет и до шестнадцати я занималась музыкой. И две мои сестры занимались музыкой. В коридоре
      висел специальный ремень для тех, кто отказывался заниматься музыкой. Говорили, у меня талант. Мой
      плейлист – это песни, которые берут в долгую дорогу, чтобы не заснуть. Там рядом Тэйлор Свифт и Михаил
      Шуфутинский. Я усердно учусь и моей профессией будет преподавание русского языка и литературы в старших классах.
      Парни думают, что быть учительницей – это моя сексуальная фантазия. Нет. Это призвание. А ещё мне нравится
      готовить пироги и торты. Только сама я их не ем. Чтобы другим больше было </p>

  </div>

</div>
<div class="row" style="background: rgba(255, 255, 255, 0.38);margin-top: 40px; ">
  <div class="col-md-12 col-lg-12 col-sm-12">
    <div class="myQuestion">
      <h3>Мои вопросы</h3>
      <hr>
      <br>
      <ul >
        <li>
          <p>
            Ну что, похудела к лету, принцесска толстожопенькая?
          </p>
        </li>
        <li>
          <p>
            У вас тоже перед сном возникает вопрос: "Какую же жизнь придумать сегодня."?
          </p>
        </li>
        <li>
          <p>
            Наливаю пол кружки горячей воды, завариваю чай и доливаю пол кружки холодной, я же не один такой?
          </p>
        </li>
        <li>
          <p>
            А вы тоже измеряете дорогу в песнях?
          </p>
        </li>
        <li>
          <p>
            А вы замечали, что если в автобусе или маршрутке много свободных мест, люди стараются сесть как можно дальше друг от друга?
          </p>
        </li>
        <li>
          <p>
            Кто-нибудь пробовал худеть лёжа на диване?
          </p>
        </li>

      </ul>
    </div>
  </div>
</div>
</div>



























</body>
</html>
