<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel=" stylesheet ">

<body>


    <div class="row">

        <div class="col-md-5 col-lg-5 col-sm-5 col-xs-5">

        </div>

        <div class="col-md-2 col-lg-2 col-sm-2 col-xs-2" style=" top: 150px; color: black; border: solid 1px black" >

            <div >



                <form action="login" method="post" >
                    <p>Name:<input type="text" name="login" /></p>
                    <p>Password:<input type="text" name="password" /></p>
                    <input type="submit" value="ok">
                </form>



            </div>

        </div>

        <div class="col-md-5 col-lg-5 col-sm-5 col-xs-5">

        </div>

    </div>

</body>
</html>