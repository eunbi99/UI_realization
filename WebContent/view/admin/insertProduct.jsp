<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>BIT KURLY</title>
<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />
<style>
    *{
        font-family: sans-serif;
    }  
    .com-sm-3{
        width: 500px;
    }
    
    
  .btn_insert, .btn_list {
    width:80px;
    height:45px;
    color:#fff;
    border-radius: 5px;
    border:none;
    
}
    
    
</style>
<script>
     $(document).ready(function(){
         $("#submit").click(function(){
            if ($('#catagory').val()==""){
                  alert('카테고리를 선택해주세요.');
                 return false;
             }
             if ($('#p_id').val()==""){
                  alert('상품명을 입력해주세요.');
                 return false;
             }
             if ($('#p_name').val()==""){
                  alert('상품명을 입력해주세요.');
                 return false;
             }
             if ($('#p_price').val()==""){
                  alert('가격을 입력해주세요.');
                 return false;                      
                }
             if ($('#p_content').val()==""){
                  alert('내용을 입력해주세요.');
                 return false;        
                }
             if ($('#p_img').val()==""){
                  alert('상품이미지를 선택해주세요.');
                 return false;        
                }
            });
        });
</script>

  <!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FREEHTML5.CO
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'> -->
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="../assets/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="../assets/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="../assets/css/bootstrap.css">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="../assets/css/owl.carousel.min.css">
	<link rel="stylesheet" href="../assets/css/owl.theme.default.min.css">

	<link rel="stylesheet" href="../assets/css/style.css">
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
	<header style="padding-bottom: 3px">
		<div class="container text-center">
			<div class="fh5co-navbar-brand">
				 <a class="fh5co-logo" href="../index.jsp"><img src="../assets/images/logo.png" style="height: 110px"></a>
			</div>
			<nav id="fh5co-main-nav" role="navigation" style="font-family: sans-serif">
				<ul>
		            <li><a href="../admin/productList.jsp">상품목록</a></li>
					<li><a href="../admin/adminMember.jsp">회원목록</a></li>
					<li><a href="../admin/adminBoard.jsp">게시판목록</a></li>
            	</ul>
			</nav>
		</div>
	</header>
<!--관리자 상품 등록-->

 <section style="margin: 0 100px 0 100px ;">
<h3 style="font-weight: bold; font-family: sans-serif;">상품등록</h3>
<div class="container">
<form name="newProduct" action="//작성" class="form-horizontal" method="post" 
		enctype="multipart/form-data">
		
<div>
 <table class="table" style="border-top: 2px solid #333;">
   <tr>
   	<td width="70" align="center">카테고리</td>
   	<td>
   	    <select id="catagory">
   	        <option value="">==선택==</option>
   	        <option value="fruit">과일</option>
   	        <option value="vegetalbe">채소</option>
   	        <option value="fish">생선</option>
   	    </select>
   	</td>
  </tr>
   <tr>
   	<td width="70" align="center">상품 ID</td>
   	<td>
   	    <input type="text" size="98" maxlength="100" id="p_id" placeholder="상품ID를 입력해주세요.">
   	</td>
   </tr>
   
   <tr>
   	<td width="70" align="center">상품 이름</td>
   	<td>
   	    <input type="text" size="98" maxlength="100" id="p_name" placeholder="상품명을 입력해주세요.">
   	</td>
   </tr>
   
  <tr>
   	<td width="70" align="center"> 가격 </td>
   	<td>
	   	<input type="text" size="98" maxlength="100" name="p_price" placeholder="가격을 입력해주세요.">
   	</td>
  </tr>
  
   <tr>
   	<td width="70" align="center"> 상세 내용 </td>
   	<td width="300" align="left"><textarea name="content" rows="13" cols="100" id ="p_content" placeholder="상세 내용을 입력해주세요."></textarea></td>
  </tr>
  <tr>
      <td width="70" align="center">상품 이미지</td>
      <td><input type="file" name="productImage" class="form-control" id="p_img"></td>
    </tr>
   <tr>
       <td align="right" colspan="2"> 
   		    <input type="submit" class="btn_insert" value="등록" style="background-color: #378bb3 ;">
            <input type="button" class="btn_list" value="목록" style="background-color: #378bb3 ;" onclick="location.href='productList.jsp'">
   		</td>
  </tr>
 </table>
</div>
</form>
</div>
</section>
<!--푸터-->
	<footer>
		<div id="footer" class="fh5co-border-line">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<p>Copyright 2016 Free Html5 <a href="#">Neos</a>. All Rights Reserved. <br>Made with <i class="icon-heart3 love"></i> by <a href="http://freehtml5.co/" target="_blank">Freehtml5.co</a> / Demo Images: <a href="https://www.pexels.com/" target="_blank">Pexels</a> &amp; <a href="http://plmd.me/" target="_blank">PLMD</a> </p>
						<p class="fh5co-social-icons">
							<a href="#"><i class="icon-twitter-with-circle"></i></a>
							<a href="#"><i class="icon-facebook-with-circle"></i></a>
							<a href="#"><i class="icon-instagram-with-circle"></i></a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Owl carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>

	</body>
</html>

