<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
