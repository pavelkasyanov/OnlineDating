<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            <li><a href="search"> Поиск </a> </li>
            <li><a href="ask"> Вопросы </a> </li>
            <!--TODO add condition -->
            <li><a href="logout"> Log Out </a> </li>
          </ul>

        </div>

      </div>
    </div>
  </div>
</div>
