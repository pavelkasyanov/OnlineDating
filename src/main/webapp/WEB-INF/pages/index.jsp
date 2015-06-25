<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel=" stylesheet " type="text/css">

<link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>

<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $('form').submit(function(){
            var userLogin = $('#login').val();
            var userPass = $('#pass').val();

            var loginResp = $.post( 'login',
                    {login: userLogin,
                        pass:userPass}
            );

            loginResp.done(function( data ) {
                var obj = JSON.parse(data);
                if (obj.answer != '') {
                    document.getElementById('error_user_login_alert').style.display = "block"
                    $('#error_user_login_alert').text(obj.answer);
                    document.getElementById('pass').value = '';
                } else {
                    /*TODO fix url*/
                    alert("545345");
                    window.location.replace('${pageContext.request.contextPath}/home');
                }
            });

            return false;
        });
    });
</script>
<body>


    <div class="row">

        <div class="col-md-5 col-lg-5 col-sm-5 col-xs-5">

        </div>

        <div class="col-md-2 col-lg-2 col-sm-2 col-xs-2" style=" top: 150px; color: black; background-color: rgba(0, 0, 0, 0.21)" >

            <div >

                <div class="alert alert-danger" style = "display:none" id="error_user_login_alert"></div>
                <form action="login" method="post" >
                    <p>Name:<input type="text" name="login" id="login" /></p>
                    <p>Password:<input type="text" name="pass" id="pass"/></p>
                    <input type="submit" value="login">
                </form>

            </div>

        </div>

        <div class="col-md-5 col-lg-5 col-sm-5 col-xs-5">

        </div>

    </div>

</body>
</html>