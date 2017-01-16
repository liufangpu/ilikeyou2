<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <meta name="googlebot" content="index,follow">

    <!-- Title -->
    <title>DayDayUp &mdash;  App Templates</title>

    <!-- Templates core CSS -->
    <link href="${pageContext.request.contextPath}/nice/stylesheets/application.css" rel="stylesheet">

    <!-- Favicons -->
    <link href="${pageContext.request.contextPath}/nice/images/favicon/favicon.png" rel="shortcut icon">
    <link href="${pageContext.request.contextPath}/nice/images/favicon/apple-touch-icon-57-precomposed.png" rel="apple-touch-icon">
    <link href="${pageContext.request.contextPath}/nice/images/favicon/apple-touch-icon-72-precomposed.png" rel="apple-touch-icon" sizes="72x72">
    <link href="${pageContext.request.contextPath}/nice/images/favicon/apple-touch-icon-144-precomposed.png" rel="apple-touch-icon" sizes="114x114">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <!-- Modernizr Scripts -->
    <script src="${pageContext.request.contextPath}/nice/javascript/vendor/modernizr-2.7.1.min.js"></script>
  </head>
  <body class="sign-in-up" id="to-top">

    <!-- Sign In/Sign Up section -->
    <section class="sign-in-up-section">

      <div class="container">

        <div class="row">

          <div class="col-md-12">

            <!-- Logo -->
            <figure class="text-center">
              <a href="./index.html">
                <img class="img-logo" src="${pageContext.request.contextPath}/nice/images/logo.png" alt="">
              </a>
            </figure> <!-- /.text-center -->
            
          </div> <!-- /.col-md-12 -->

        </div> <!-- /.row -->




        <section class="sign-in-up-content">

          <div class="row">

            <div class="col-md-12">

              <h4 class="text-center">Sign In to your account</h4>

              <form class="sign-in-up-form" action="${pageContext.request.contextPath}/user/login" role="form" method="post">
                
                <!-- Input 1 -->
                <div class="form-group">
                  <input class="form-control" id="exampleInputEmail2" name="username" type="email" placeholder="Enter email address">
                </div> <!-- /.form-group -->

                <!-- Input 2 -->
                <div class="form-group">
                  <input class="form-control" id="exampleInputPassword1" name="password" type="password" placeholder="Password">
                </div> <!-- /.form-group -->

                <!-- Button -->
                <button class="btn btn-success btn-block" type="submit">Sign In</button>

                <!-- Checkbox -->
                <section class="text-center">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox" checked> Keep me logged in
                    </label>
                  </div> <!-- /.checkbox -->
                </section> <!-- /.text-center -->

                <!-- Sign In/Sign Up links -->
                <section class=" text-center">
                  <p><a href="./forgot-password.jsp">Forgot password?</a> <span class="sep">&ndash;</span> <a href="./sign-up.jsp">Need an account?</a></p>
                </section> <!-- /.sign-in-up-links -->
                
              </form> <!-- /.sign-in-up-form -->
              
            </div> <!-- /.col-md-12 -->

          </div> <!-- /.row -->
          
        </section> <!-- /.sign-in-up-content -->




        <div class="row">

          <div class="col-md-12">

            <section class="footer-copyright text-center">

              <p>Made with <i class="fa fa-heart"></i> by Aryandhani.</p>
              
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
</body>
</html>
