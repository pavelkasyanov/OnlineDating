<%@ page contentType="text/html;charset=UTF-8" language="java" %>
'<div class="col-md-3 col-lg-3 col-sm-3" style="font-family: Helvetica, Arial, sans-serif;border-left: solid 1px rgba(0, 0, 0, 0.15)">
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