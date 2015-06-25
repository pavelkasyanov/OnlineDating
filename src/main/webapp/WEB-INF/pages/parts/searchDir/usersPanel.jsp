<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-9 col-lg-9 col-sm-9">

  <table class="table" cellpadding="0" cellspacing="0">

    <tr>
      <c:forEach var="searchUserPanel" items="${searchRow}">

      <td style = "text-align: center; background-color: white;">
        <img src= " <c:out value="${searchRow.imgUrl}" />   " class="img-polaroid">
        <p> <c:out value="${searchRow.userName}" />   :  <c:out value="${searchRow.userAge}" />   </p>
        <p>
<!-- TODO шкала отношений
        <div class="progress">
          <div class="grayback"></div>
          <div class="strips"></div>
        </div>
        <p>
        <div class="progress">
          <div class="grayback"></div>
          <div class="strips"></div>
        </div>
 -->
      </td>

      </c:forEach>






    </tr>




  </table>

</div>