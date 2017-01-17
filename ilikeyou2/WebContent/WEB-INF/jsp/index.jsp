<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/nice/css/animate.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/nice/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/nice/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/nice/css/templatemo_misc.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/nice/css/templatemo_style.css">
    <!-- JavaScripts -->
	<script src="${pageContext.request.contextPath}/nice/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/nice/js/jquery.singlePageNav.js"></script>
	<script src="${pageContext.request.contextPath}/nice/js/jquery.flexslider.js"></script>
	
	<script src="${pageContext.request.contextPath}/nice/js/custom.js"></script>
     <script src="${pageContext.request.contextPath}/nice/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/nice/js/jquery.lightbox.js"></script>
	<script src="${pageContext.request.contextPath}/nice/js/templatemo_custom.js"></script>
    <script src="${pageContext.request.contextPath}/nice/js/jquery-git2.js"></script><!-- previous next script -->
  </head>
  <body>
  <!-- title start -->
  	<div class="container">
    	<div class="row">
        	<div class="col-md-6 col-sm-6">
            	<div class="templatemo_title"><a href="#">welcome dear:</a></div>
                <div class="templatemo_subtitle">${user.name}</div>
            </div>
            <div class="col-md-6 col-sm-6">
            	<form id="search_form" action="//www.baidu.com.cn/s">
            		<div class="templatemo_search">
                    	<input name="wd" type="text" placeholder="Search here .... " id="search">
                    	<input type="hidden" name="cl" value="3">
                    </div>
                </form>
            </div>
        </div>
    </div>
  <!-- title end -->
  	<div class="site-header">
		<div class="main-navigation">
			<div class="container">
            	<div class="row">
            	<div class="col-md-12">
                	<!-- This one in here is responsive menu for tablet and mobiles -->
                  <div class="responsive-navigation visible-sm visible-xs">
                   <a href="#" class="menu-toggle-btn">
                    <i class="fa fa-bars fa-2x"></i>
                  </a>
       			 <div class="navigation responsive_menu">
          			 <ul>
					<li><a class="show-1 templatemo_home" href="#">Main Page</a></li>
					<li><a class="show-2 templatemo_page2" href="#">Service</a></li>
					<li><a class="show-3 templatemo_page3" href="#">Portfolio</a></li>
					<li><a class="show-5 templatemo_page5" href="#">Contact</a></li>
				</ul>
    	    </div> <!-- /.responsive_menu -->
   		 </div> <!-- /responsive_navigation -->
                </div>
            </div>
            </div>
			<div class="container">
				<div class="row">
                     <div class="col-md-12 navigation">
						<div class="row main_menu">
                    		<div class="col-md-2"><a id="prev">Pref</a></div>
							<div class="col-md-2"><a class="show-1 templatemo_home" href="#"><div class="fa fa-home"></div></a></div>
							<div class="col-md-2"><a class="show-2 templatemo_page2" href="#"><div class="fa fa-wrench"></div></a></div>
							<div class="col-md-2"><a class="show-3 templatemo_page3" href="#"><div class="fa fa-picture-o"></div></a></div>
							<div class="col-md-2"><a class="show-5 templatemo_page5" href="#"><div class="fa fa-phone"></div></a></div>
                            <div class="col-md-2"><a id="next">NEXT</a></div>
							
						</div> 
                    </div>
				</div> 
			</div> 
		</div> 
	</div> 
    <div id="menu-container">

	<div class="divs">
<!-- homepage start -->
	<div class="content homepage" id="menu-1">
	<div class="container">
    	<div class="row">
        	<div class="col-md-12">
            	<div class="main-slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="slider-caption">
								<h2>Paradise</h2>
								<p>Well you done done me and you bet I felt it,I tried to be chill but you’re so hot that I melted. </p>
							</div>
							<img src="${pageContext.request.contextPath}/nice/images/slide1.jpg" alt="Slide 1">
						</li>

						<li>
							<div class="slider-caption">
								<h2>Eternity</h2>
								<p>I fell right through the cracks,and now I’m trying to get back .</p>
							</div>
							<img src="${pageContext.request.contextPath}/nice/images/slide2.jpg" alt="Slide 2">
						</li>

                        <li>
							<div class="slider-caption">
								<h2>Sunshine</h2>
								<p>Before the cool done run out I’ll be giving it my bestest ,Nothing’s going to stop me but divine intervention  .</p>
							</div>
							<img src="${pageContext.request.contextPath}/nice/images/slide3.jpg" alt="Slide 3">
						</li>
                        
                        <li>
							<div class="slider-caption">
								<h2>Rainbow</h2>
								<p>I won’t hesitate no more, no more. It cannot wait, I’m yours  .</p>
							</div>
							<img src="${pageContext.request.contextPath}/nice/images/slide4.jpg" alt="Slide 4">
						</li>

					</ul>
				</div>
			</div>
            </div>
        </div>
    </div>
    </div>
<!-- homepage end -->
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>

<!-- service start -->
	 <div class="content service" id="menu-2">
    <!-- <div class="container">
         <div class="row">
        	<div class="col-md-12">
        		<h1>Our Services</h1>
            </div>
        </div>
        <div class="row">
        	 <div class="col-md-3 col-sm-12 templatemo_servicegap">
            	<div class="templatemo_icon">
                	<span class="fa fa-flask"></span>
                </div>
            	<div class="templatemo_greentitle">Mobile Ready</div>
                <div class="clear"></div>
                <p>Solidity is free responsive template for everyone. Donec euismod, justo sed convallis blandit, ipsum erat mattis lectus, vel pharetra neque enim tristique risus.</p>
            </div>
            <div class="col-md-3 col-sm-12 templatemo_servicegap">
           		 <div class="templatemo_icon">
                	<span class="fa fa-bug"></span>
                </div>
            	<div class="templatemo_greentitle">Fixing Bugs</div>
                <div class="clear"></div>
                <p>Credit goes to <a rel="nofollow" href="#">Unsplash</a> for images used in homepage slider and portfolio section. Donec euismod, justo sed convallis blandit, ipsum erat mattis lectus.</p>
            </div> 
             <div class="col-md-3 col-sm-12 templatemo_servicegap">
            	<div class="templatemo_icon">
                	<span class="fa fa-pencil-square-o"></span>
                </div>
            	<div class="templatemo_greentitle">HTML5 Coding</div>
                <div class="clear"></div>
                <p>Nam auctor elementum dolor. Donec euismod, justo sed convallis blandit, ipsum erat mattis lectus, vel pharetra neque enim tristique risus. Ut consequat nisi vel justo. </p>
            </div>
             <div class="col-md-3 col-sm-12 templatemo_servicegap">
            	<div class="templatemo_icon">
                	<span class="fa fa-shield"></span>
                </div>
            	<div class="templatemo_greentitle">High Quality</div>
                <div class="clear"></div>
                <p>Nam auctor elementum dolor. Donec euismod, justo sed convallis blandit, ipsum erat mattis lectus, vel pharetra neque enim tristique risus. Ut consequat nisi vel justo. </p>
            </div>
        </div>
    </div> -->
    <div class="clear"></div>
    <div class="container">
    	<div class="row">
        	<div class="col-md-12">
            	<h1>so beautiful girl</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div class="row">
        	<div class="col-md-4 col-sm-12 templatemo_servicegap">
            <img src="${pageContext.request.contextPath}/nice/images/member1.jpg" alt="Tracy - Designer">
            	<div class="templatemo_email">
                	<a href="#"><div class="fa fa-envelope"></div></a>
                </div>
                <div class="clear"></div>
                <div class="templatemo_teamtext">
                    <div class="templatemo_teamname">
                        <div class="templatemo_teamtitle">阳关雪</div>
                        <div class="templatemo_teampost">good figure</div>
                    </div>
                    <!-- <div class="templatemo_teamsocial">
                        Find me on:
                        <div>  
                            <a href="#"><div class="fa fa-facebook"></div></a>
                            <a href="#"><div class="fa fa-twitter"></div></a>
                            <a href="#"><div class="fa fa-linkedin"></div></a>
                            <a href="#"><div class="fa fa-rss"></div></a>
                        </div>
                    </div> -->
               </div>
            </div>
            <div class="col-md-4 col-sm-12 templatemo_servicegap">
            	<img src="${pageContext.request.contextPath}/nice/images/member2.jpg" alt="service 02">
                <div class="templatemo_email">
                	<a href="#"><div class="fa fa-envelope"></div></a>
                </div>
                <div class="clear"></div>
                <div class="templatemo_teamtext">
                    <div class="templatemo_teamname">
                        <div class="templatemo_teamtitle">Fayruz</div>
                        <div class="templatemo_teampost">Beautiful</div>
                    </div>
                   <!--  <div class="templatemo_teamsocial">
                        Find me on:
                        <div>  
                            <a href="#"><div class="fa fa-facebook"></div></a>
                            <a href="#"><div class="fa fa-twitter"></div></a>
                            <a href="#"><div class="fa fa-linkedin"></div></a>
                            <a href="#"><div class="fa fa-rss"></div></a>
                        </div>
                    </div> -->
               </div>
             </div>
            <div class="col-md-4 col-sm-12 templatemo_servicegap">
            	<img src="${pageContext.request.contextPath}/nice/images/member3.jpg" alt="service 03">
                <div class="templatemo_email">
                	<a href="#"><div class="fa fa-envelope"></div></a>
                </div>
                <div class="clear"></div>
                <div class="templatemo_teamtext">
                    <div class="templatemo_teamname">
                        <div class="templatemo_teamtitle">谢耳朵</div>
                        <div class="templatemo_teampost">so beautiful</div>
                    </div>
                    <!-- <div class="templatemo_teamsocial">
                        Find me on:
                        <div>  
                            <a href="#"><div class="fa fa-facebook"></div></a>
                            <a href="#"><div class="fa fa-twitter"></div></a>
                            <a href="#"><div class="fa fa-linkedin"></div></a>
                            <a href="#"><div class="fa fa-rss"></div></a>
                        </div>
                    </div> -->
               </div>
            </div>
        </div>
    </div>
    </div>
<!-- service end -->

<!-- portfolio start -->
<div class="content portfolio" id="menu-3">
  <div class="container">
  		<div class="row">
        	<div class="col-md-12">
            	<h1>look at these</h1>
            </div>
        </div>
        <div class="clear"></div>
        <div class="row templatemo_portfolio">
        	<div class="col-md-4 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image01.jpg" alt="gallery 1">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image01.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
          </div>
            <div class="col-md-4 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image02.jpg" alt="gallery 2">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image02.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-4 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image03.jpg" alt="gallery 3">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image03.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
        </div>
        <div class="row templatemo_portfolio">
        	<div class="col-md-3 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image04.jpg" alt="gallery 4">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image04.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-3 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image05.jpg" alt="gallery 5">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image05.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-3 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image06.jpg" alt="gallery 6">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image06.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-3 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image07.jpg" alt="gallery 7">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image07.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
        </div>
        <div class="row templatemo_portfolio">
        	<div class="col-md-2 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image08.jpg" alt="gallery 8">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image08.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-2 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image09.jpg" alt="gallery 9">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image09.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-4 col-sm-12 templatemo_imagecontrol">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image10.jpg" alt="gallery 10">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image10.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-2 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image11.jpg" alt="gallery 11">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image11.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
            <div class="col-md-2 col-sm-12">
            	<div class="gallery-item">
							<img src="${pageContext.request.contextPath}/nice/images/portfolio/image12.jpg" alt="gallery 12">
							<div class="overlay">
								<a href="${pageContext.request.contextPath}/nice/images/portfolio/image12.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>
            </div>
        </div>
  </div>
  </div>
<!-- portfolio end -->

<!-- contact start -->
<div class="content contact" id="menu-5">
  <div class="container">
  	<div class="row">
    	<div class="col-md-12">
        	<h1>contact me</h1>
        </div>
    </div>
      <div class="clear"></div>
    <div  class="row">
    	<div class="col-md-12">
        	<div class="templatemo_contactmap">
		    	<div id="templatemo_map"></div>                        
        	</div>
        </div>
    </div>
    <div class="clear"></div>
    <div class="row">
    	<div class="col-md-8 col-sm-12">
        	<form action="#" id="contact_form">
        	<div class="templatemo_textbox"><input name="fullname" type="text" class="form-control" id="fullname" placeholder="你的姓名"></div>
            <div class="clear"></div>
             <div class="templatemo_textareabox"><textarea name="message" class="form-control" id="message"  placeholder="你想说的..... "></textarea>
             <div class="clear"></div>
             <button type="button" class="btn btn-primary" id="submitMsg">发送给我</button>
             </div>
             </form>
             <div class="clear"></div>
        </div>
        <div class="col-md-4 col-sm-12 templatemo_address">
        	<ul>
            	<li class="fa fa-phone"></li>
                <li class="text">156-7329-1306</li>
                <li class="fa fa-map-marker"></li>
                <li class="text">北京市, 朝阳区 北苑路北,北辰泰岳大厦</li>
                <li class="fa fa-envelope"></li>
                <li class="text">wyyxlfp@163.com</li>
                <li class="fa fa-globe"></li>
                <li class="text"><a href="https://www.baidu.com">www.baidu.com</a></li>
            </ul>
        </div>
    </div>
  </div>
  </div>
  <div class="content contact" id="menu-6">
  <div class="container">
  	<div class="row">
    	<div class="col-md-12">
        	<h1>message list</h1>
        </div>
    </div>
      <div class="clear"></div>
    <div class="clear"></div>
    <div class="row">
    	<div class="col-md-8 col-sm-12">
             <table>
             	<tr>
             		<c:forEach items="${messages}" var="message">
             		<div class="templatemo_textareabox"><textarea name="message" class="form-control" id="message"  placeholder=${message.message}></textarea>	
             		<div class="fa fa-map-marker">${message.ipName}(message.ip)</div>
             		</c:forEach>
             	</tr>
             </table>
             <div class="clear"></div>
        </div>
    </div>
  </div>
  </div>
<!-- contact end -->
	</div>
</div>
	<!-- footer start -->
    <div class="clear"></div>
		<div class="templatemo_footer">
            <div class="container">
            	<div class="row">
                	<div class="col-md-12">
                    Copyright &copy; 2017.Company name All rights reserved.
                    </div>
                </div>
            </div>
        </div>
    <!-- footer end --> 
    <div style="display:none"><script src='${pageContext.request.contextPath}/nice/js/stat.js' language='JavaScript' charset='gb2312'></script></div>
	<script type="text/javascript">
		$("#submitMsg").click(function (){
			var message=document.getElementById("message").value;
			var name=document.getElementById("fullname").value;
			if (name!=''&&message!=''){
		$.ajax({
            cache: true,
            type: "POST",
            url:'<c:url value="/data/msg" />',
            data:$('#contact_form').serialize(),
            async: false,
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
            	if(data.success==true){
            		alert("发送成功！");
            	}else{
            		alert("发送失败");
            	}
            }
        	});
		}else{
			alert("每个空都要填");
		}
	})
	/* /* var emailId=${user.email};
	alert(emailId);
	$.ajax({
            cache: true,
            type: "post",
            url:'<c:url value="/data/getEmailList" />',
            data:emailId,
            async: false,
            success: function(data) {
            	window.location.reload();
            }
        	}); */ 
	</script>
</body>
</html>