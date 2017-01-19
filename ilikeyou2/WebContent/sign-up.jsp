<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- Title -->
    <title>Guri Guri Nyoi &mdash; nice to meet you</title>

    <!-- Templates core CSS -->
    <link href="${pageContext.request.contextPath}/nice/stylesheets/application.css" rel="stylesheet">

    <!-- Favicons -->
    <link href="${pageContext.request.contextPath}/nice/images/favicon/favicon.png" rel="shortcut icon">
    <link href="${pageContext.request.contextPath}/nice/images/favicon/apple-touch-icon-57-precomposed.png" rel="apple-touch-icon">
    <link href="${pageContext.request.contextPath}/nice/images/favicon/apple-touch-icon-72-precomposed.png" rel="apple-touch-icon" sizes="72x72">
    <link href="${pageContext.request.contextPath}/nice/images/favicon/apple-touch-icon-144-precomposed.png" rel="apple-touch-icon" sizes="114x114">

    <!-- Modernizr Scripts -->
    <script src="${pageContext.request.contextPath}/nice/javascript/vendor/modernizr-2.7.1.min.js"></script>
  </head>
  <body class="sign-in-up" id="to-top">

    <!-- Sign In/Sign Up section -->
    <section class="sign-in-up-section">

      <div class="container">

        <div class="row">

         <%--  <div class="col-md-12">

            <!-- Logo -->
            <figure class="text-center">
              <a href="./index.html">
                <img class="img-logo" src="${pageContext.request.contextPath}/nice/images/logo.png" alt="">
              </a>
            </figure> <!-- /.text-center -->
            
          </div> --%> <!-- /.col-md-12 -->

        </div> <!-- /.row -->




        <section class="sign-in-up-content">

          <div class="row">

            <div class="col-md-12">

              <h4 class="text-center">Create an account</h4>

              <form class="sign-in-up-form" id="myForm" role="form" >
                
                <!-- Input 1 -->
                <div class="form-group">
                  <input class="form-control" id="exampleInputName1" type="text" name="name" placeholder="Your Chinese name">
                </div> <!-- /.form-group -->

                <!-- Input 2 -->
                <div class="form-group">
                  <input class="form-control" id="exampleInputEmail3" type="email" name="email" placeholder="Enter email address" onblur="checkEmail();">
                </div> <!-- /.form-group -->

                <!-- Input 3 -->
                <div class="form-group">
                  <input class="form-control" id="exampleInputPassword2" type="password" name="password" placeholder="Password">
                </div> <!-- /.form-group -->

                <!-- Button -->
                <button class="btn btn-success btn-block" type="submit" id="submit">Sign Up</button>

                <!-- Checkbox -->
                <section class="text-center">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox"> I agree to Termsand Privacy Policy</a>
                    </label>
                  </div> <!-- /.checkbox -->
                </section> <!-- /.text-center -->

                <!-- Sign In/Sign Up links -->
                <section class="text-center">
                  <p>Already have an account? <a href="./sign-in.jsp">Sign In here</a></p>
                </section> <!-- /.sign-in-up-links -->
                
              </form> <!-- /.sign-in-up-form -->
              
            </div> <!-- /.col-md-12 -->

          </div> <!-- /.row -->
          
        </section> <!-- /.sign-in-up-content -->




        <div class="row">

          <div class="col-md-12">

            <section class="footer-copyright text-center">

              <p>Made with <i class="fa fa-heart"></i> by liufangpu.</p>
              
            </section> <!-- /.footer-section -->
            
          </div> <!-- /.col-md-12 -->


        </div> <!-- /.row -->
        
      </div> <!-- /.container -->

    </section> <!-- /.sign-in-up-section -->
    
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/nice/javascript/vendor/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/nice/javascript/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/nice/javascript/assets/application.js"></script>
  <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
	<script type="text/javascript">
		function checkEmail(){
			var email=document.getElementById("exampleInputEmail3").value;
			$.ajax({
	    		type:"get",
	    		url:'<c:url value="/user/checkEmail" />',
	    		data:{"email":email},
	    		success:function(data) {
	    				if(data.success==false){
	    					alert("邮箱已被注册！请更换邮箱");
	    				    window.location.reload();
	    				}
	    			}
			});
		}
		$("#submit").click(function (){
			var password=document.getElementById("exampleInputPassword2").value;
			var name=document.getElementById("exampleInputName1").value;
			var email=document.getElementById("exampleInputEmail3").value;
			if (name!=''&&email!=''&&password!=''){
		$.ajax({
            cache: true,
            type: "POST",
            url:'<c:url value="/user/addUser" />',
            data:$('#myForm').serialize(),
            async: false,
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
            	if(data=='true'){
            		alert("注册成功,跳转至登录页面");
            		window.open('sign-in.jsp');
            	}else{
            		alert("注册失败");
            		window.location.href='sign-up.jsp';
            	}
            }
        	});
		}else{
			alert("每个空都要填");
		}
	})
	</script>
</body>
</html>
