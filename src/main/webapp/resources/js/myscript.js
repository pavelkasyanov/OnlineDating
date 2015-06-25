function message() {
    alert("hello");
}


function rateQuestion(questionId, valuation) {
    //alert("valuation" + questionId + " " + valuation);

    var ajaxCall = $.post('valuate',
        {questionId: questionId,
         valuation: valuation
        }
    );

    ajaxCall.done(function (data) {
        //alert("please reload page");
        //var element = $('#' + 'myAsk_' + askId);
       // element.hide();
        document.getElementById("rate"+questionId).innerHTML=valuation;

    });
}

function answerQuestion(questionId, answer) {
    //alert("valuation" + questionId + " " + valuation);

    var ajaxCall = $.post('answer',
        {questionId: questionId,
            answer: answer
        }
    );

    ajaxCall.done(function (data) {
//        alert("please reload page");
        //var element = $('#' + 'myAsk_' + askId);
        // element.hide();
        document.getElementById("answer"+questionId).innerHTML=answer;
    });
}
