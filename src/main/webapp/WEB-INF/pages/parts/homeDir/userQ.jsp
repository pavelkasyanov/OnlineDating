<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row" style="background: rgba(255, 255, 255, 0.38);margin-top: 40px; ">
    <div class="col-md-12 col-lg-12 col-sm-12">
        <div class="myQuestion">
            <h3>Мои вопросы</h3>
            <hr>
            <!-- TODO border + buttons (важно, неважно, добавить) + statist -->
            <h4>
                <p class="ask">
                <table cellpadding="4" cellspacing="3" border="1">

                    <tr>
                        <th>
                            Для меня это
                        </th>
                        <th>
                            Вопрос
                        </th>
                        <th>
                            Если меня попросят, я отвечу
                        </th>
                        <th>
                            Оценило
                        </th>
                        <th>
                            Ответило
                        </th>
                    </tr>
                    <c:forEach var="askRow" items="${myAskList}">

                        <tr>

                                <%--
                             <td>
                                 <c:choose>

                                     <c:when test="${not empty askRow.answer}">
                                         <c:out value="${askRow.answer.importance}"/>
                                         <c:out value="${askRow.answer.importanceText}"/>
                                     </c:when>
                                     <c:otherwise>
                                         <a onclick="rateQuestion(${askRow.question.questionID},1);">Важно</a>
                                         &nbsp;
                                         <a onclick="rateQuestion(${askRow.question.questionID},0);">Пофиг</a>

                                         &nbsp;
                                         <a onclick="answerQuestion(${askRow.question.questionID},1);">Да, легко</a>
                                         &nbsp;
                                         <a onclick="answerQuestion(${askRow.question.questionID},2);">Да, с трудом</a>
                                         &nbsp;
                                         <a onclick="answerQuestion(${askRow.question.questionID},3);">Нет</a>
                                     </c:otherwise>
                                 </c:choose>
                             </td>
                                 --%>

                                <%--another variant--%>

                            <c:choose>
                                <c:when test="${empty askRow.answer}">
                                    <td id="rate${askRow.question.questionID}">
                                        <a onclick="rateQuestion(${askRow.question.questionID},1);">Важно</a>
                                        &nbsp;
                                        <a onclick="rateQuestion(${askRow.question.questionID},0);">Пофиг</a>
                                        &nbsp;
                                    </td>

                                    <td>
                                        <c:out value="${askRow.question.text}"/>
                                    </td>

                                    <td id="answer${askRow.question.questionID}">
                                        <a onclick="answerQuestion(${askRow.question.questionID},1);">Да, легко</a>
                                        &nbsp;
                                        <a onclick="answerQuestion(${askRow.question.questionID},2);">Да, с
                                            трудом</a>
                                        &nbsp;
                                        <a onclick="answerQuestion(${askRow.question.questionID},3);">Нет</a>
                                    </td>
                                </c:when>


                                <c:otherwise>
                                    <td id="rate${askRow.question.questionID}">
                                        <c:choose>
                                            <c:when test="${askRow.answer.importance!=-1}">
                                                <c:out value="${askRow.answer.importance}"/>
                                                <c:out value="${askRow.answer.importanceText}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <a onclick="rateQuestion(${askRow.question.questionID},1);">Важно</a>
                                                &nbsp;
                                                <a onclick="rateQuestion(${askRow.question.questionID},0);">Пофиг</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>

                                    <td>
                                        <c:out value="${askRow.question.text}"/>
                                    </td>

                                    <td id="answer${askRow.question.questionID}">
                                        <c:choose>
                                            <c:when test="${not empty askRow.answer.answer}">
                                                <c:out value="${askRow.answer.answer}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <a onclick="answerQuestion(${askRow.question.questionID},1);">Да,
                                                    легко</a>
                                                &nbsp;
                                                <a onclick="answerQuestion(${askRow.question.questionID},2);">Да, с
                                                    трудом</a>
                                                &nbsp;
                                                <a onclick="answerQuestion(${askRow.question.questionID},3);">Нет</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </c:otherwise>
                            </c:choose>

                            </td>

                            <td>
                                <c:out value="${askRow.countValued}"/>
                            </td>
                            <td>
                                <c:out value="${askRow.countAnswered}"/>
                                    <%--<c:out value="${askRow.countImportant}" />--%>
                                    <%--<c:out value="${askRow.countAgreed}" />--%>

                            </td>
                        </tr>

                    </c:forEach>
                </table>
                </p>
            </h4>

            <br>


        </div>
    </div>
</div>

