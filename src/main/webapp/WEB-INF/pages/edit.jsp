<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="parts/pageHeader.jsp">
<jsp:param name="title" value="home"/>
</jsp:include>
<jsp:include page="parts/Header.jsp"/>
<script type="text/javascript">
  jQuery(document).ready(function ($) {
    $('#mytabs').tab();

    $('.btn-toggle').click(function() {
      $(this).find('.btn').toggleClass('active');

      if ($(this).find('.btn-primary').size()>0) {
        $(this).find('.btn').toggleClass('btn-primary');
      }
    });
  });

  function addAsk(){
    var text = $('#questionText').val();
    var category = $('#category_new').val();

    var loginResp = $.post( '${pageContext.request.contextPath}/ask/add_ask',
            {questionText: text,
              category_new:category}
    );

    loginResp.done(function( data ) {
      var obj = JSON.parse(data);
      var askLI = '<li id="myAsk_' + obj.questionID + '">';
      var delLink = '<a onclick="deleteQuestion('+obj.questionID+');">delete</a>';
      var result = askLI+'<h4><br>'+obj.text+delLink+'</h4> </li>';
      $('#my_question_list').append(result);
      $('textarea').val('');



    });

    loginResp.error(function() { alert("Ошибка выполнения"); })

    return false;
  }

  function getLastQuestions() {

    var lastQuestionRequest = $.get('${pageContext.request.contextPath}/ask/last_ask');

    lastQuestionRequest.done(function( data ) {
      var obj = JSON.parse(data);
      var cont = $('#lastAskList');
      cont.empty();

      obj.forEach( function(item, i, obj) {
        var result = '<li><h4><br>'+item.text+'</h4> </li>';
        cont.append(result);
      });
    });
  }

  function getLastCategoryQuestions() {
    var category = $('#category_new1').val();

    var lastQuestionRequest = $.post('${pageContext.request.contextPath}/category_last', {

            category_new1:category})
            ;

    lastQuestionRequest.done(function( data ) {
      var obj = JSON.parse(data);

      var cont = $('#lastAskCategoryList');
      cont.empty();

      obj.forEach( function(item, i, obj) {
        var result = '<li><h4><br>'+item.text+'</h4> </li>';
        cont.append(result);
      });
    });
  }

  function deleteQuestion(askId) {
    var deleteAsk = $.post('${pageContext.request.contextPath}/ask/delete_ask',
            {askId: askId});

    deleteAsk.done(function( data ){
      var element = $('#'+'myAsk_'+askId);
      element.hide();
    });
  }
</script>

<div class="container" style="margin-top: 150px">
  <div class="row">
    <div class="col-md-8 col-lg-8 col-sm-8">
      <div class="tabs" id="mytabs">
        <ul class="nav nav-tabs">
          <li class="active"><a href="#tab1" data-toggle="tab"> Мои вопросы </a></li>
          <li><a href="#tab2" data-toggle="tab"> Вопросы друзей </a></li>
          <li><a href="#tab3" data-toggle="tab"> Топ </a></li>
          <li><a href="#tab4" data-toggle="tab" onclick="getLastQuestions();"> Последние вопросы </a></li>
        </ul>

        <div  class="tab-content">
          <jsp:include page="parts/editDir/tabPane_1.jsp"/>
          <jsp:include page="parts/editDir/tabPane_2.jsp"/>
          <jsp:include page="parts/editDir/tabPane_3.jsp"/>
          <jsp:include page="parts/editDir/tabPane_4.jsp"/>
       </div>
      </div>
    </div>
<div class="col-md-4 col-lg-4 col-sm-4" style="border-left: solid 1px rgba(12, 3, 52, 0.29)">
<jsp:include page="parts/editDir/filtersForQ.jsp"/>
</div>
</div>
</div>

<jsp:include page="parts/Footer.jsp"/>
<jsp:include page="parts/pageFooter.jsp"/>
