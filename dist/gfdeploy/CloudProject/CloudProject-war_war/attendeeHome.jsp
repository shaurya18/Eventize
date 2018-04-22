<%@page import="java.util.List"%>
<%@page import="entitybeans.Eventrequest"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>BUILD &mdash; A free Responsive HTML5 Template by FREEHTML5.CO</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
        <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
        <meta name="author" content="FREEHTML5.CO" />

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

        <!-- Google Webfont -->
        <!--  <link href='https://fonts.googleapis.com/css?family=PT+Mono' rel='stylesheet' type='text/css'>-->
        <!-- Themify Icons -->
        <link rel="stylesheet" href="css/themify-icons.css">
        <!-- Icomoon Icons -->
        <link rel="stylesheet" href="css/icomoon-icons.css">
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">
        <!-- Easy Responsive Tabs -->
        <link rel="stylesheet" href="css/easy-responsive-tabs.css">
        <!-- Theme Style -->
        <link rel="stylesheet" href="css/style2.css">
        <link rel="stylesheet" href="css/product-list-vertical.css">	


        <!-- FOR IE9 below -->
        <!--[if lte IE 9]>
        <script src="js/modernizr-2.6.2.min.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>
    <body class="fh5co-inner">
        <header id="fh5co-header" role="banner">

            <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <!-- Mobile Toggle Menu Button -->
                        <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#fh5co-navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                        <a class="navbar-brand" href="index.html">Eventize</a>
                    </div>
                    <div id="fh5co-navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="logoutAttendeeServlet" class="btn btn-calltoaction btn-primary">Logout</a></li>            
                        </ul>
                    </div>
                </div>
            </nav>

        </header>

        <div id="fh5co-page-title" style="background-image: url(images/hero_2.jpg)">
            <div class="overlay"></div>
            <div class="container">
                <div class="text">
                    <h1>Eventize</h1>  
                </div>

            </div>
        </div>

        <main role="main" id="fh5co-main">
            <div class="container">
                <div class="row">
                    <div class="col-md-3" id="fh5co-sidebar">
                        <div class="fh5co-side-block">
                            <h3>Welcome <%= session.getAttribute("name")%></h3> 
                            <%--   <h3>Welcome <%= request.getParameter("name") %></h3> --%>
                            <ul class="fh5co-links">
                                <li><a href="editAttendeeProfile.jsp" target="_blank">Edit Profile</a></li>
                                <!--      <li><a href="#" target="_blank" onclick="myFunction()">View Upcoming Events</a></li>-->

                            </ul>
                        </div>
                        <div class="fh5co-side-block">
                            <h3>About Eventize</h3>
                            <p>Eventize is an event management company dedicated to organize your events in a hastle-free manner.</p>
                        </div>

                    </div>
                    <!--        <div class="col-md-8 col-md-push-1" id="fh5co-content">
                    
                              <div class="row">
                                <div class="col-md-12"><h2>Eventize</h2></div>
                                <div class="col-md-6">
                                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur totam cumque quaerat, quos quia maxime corporis dignissimos tenetur natus consectetur repellat provident ipsa nam accusamus et labore sequi praesentium expedita nobis, dicta cum voluptate. Nam necessitatibus aliquid laboriosam, cum accusantium recusandae eveniet aspernatur blanditiis deserunt maxime adipisci natus praesentium obcaecati.</p>
                                </div>
                                <div class="col-md-6">
                                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tempore autem deserunt minus molestiae omnis natus porro esse cumque nam facilis sed labore, doloribus earum voluptatem necessitatibus asperiores modi aspernatur veritatis.</p>
                                </div>
                              </div>
                              <div class="fh5co-spacer fh5co-spacer-sm"></div>
                              <p><img src="images/big_image.jpg" alt="Image" class="img-responsive"></p>
                              <div class="fh5co-spacer fh5co-spacer-sm"></div>
                              <div class="row">
                                
                                <div class="col-md-6">
                                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur totam cumque quaerat, quos quia maxime corporis dignissimos tenetur natus consectetur repellat provident ipsa nam accusamus et labore sequi praesentium expedita nobis, dicta cum voluptate. Nam necessitatibus aliquid laboriosam, cum accusantium recusandae eveniet aspernatur blanditiis deserunt maxime adipisci natus praesentium obcaecati.</p>
                                </div>
                                <div class="col-md-6">
                                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tempore autem deserunt minus molestiae omnis natus porro esse cumque nam facilis sed labore, doloribus earum voluptatem necessitatibus asperiores modi aspernatur veritatis.</p>
                                </div>
                              </div>
                            </div>-->
                    <ul class="product-list-vertical">
                        <h2>Upcoming Events</h2>
                        <% System.out.println("DDD"); %>
                        <%List<Eventrequest> attendee_events = (List<Eventrequest>) session.getAttribute("attendee_event_list");
    for (Eventrequest e : attendee_events) {%>


                        <li>

                            <a href="#" class="product-photo">
                                <img src="css/yo.jpg" height="160" alt="MY EVENT" />
                            </a>

                            <div class="product-details">
                                <!--                <a href="#" class="product-compare">compare</a>-->

                                <h2><a href="#"><%=e.getEventName()%></a></h2>

                                <div class="product-rating">
                                    <!--               <div>
                                                       <span class="product-stars" style="width: 60px" >
                                                           <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                                                       </span>
                                                   </div>-->

                                    <span><a href="#"><%=e.getStartDate()%></a></span>
                                </div>


                                <p class="product-description"><%=e.getEventDescription()%></p>
                                <form action="registerUpcomingEvent" method = "POST">
                                    <input type ="hidden" value="<%=e.getEId()%>" name="book">
                                    <button>Book Now!</button>
                                </form>
                                <p class="product-price"><%=e.getStartTime()%></p>
                            </div>

                        </li>

                        <!--        <li>
                        
                                    <a href="#" class="product-photo">
                                        <img src="assets/images/products/htc-one.jpg" height="160" alt="Sony Xperia Z3" />
                                    </a>
                        
                                    <div class="product-details">
                                        <a href="#" class="product-compare">compare</a>
                        
                                        <h2><a href="#">HTC One</a></h2>
                        
                                        <div class="product-rating">
                                            <div>
                                                <span class="product-stars" >
                                                    <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>
                                                </span>
                                            </div>
                        
                                            <span><a href="#">43 reviews</a></span>
                                        </div>
                        
                        
                                        <p class="product-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ornare sem sed nisl dignissim, facilisis dapibus lacus vulputate. Sed lacinia lacinia magna.</p>
                        
                                        <button>Book Now!</button>
                                        <p class="product-price">$599.00</p>
                                    </div>
                        
                                </li>-->

                        <%}%>
                    </ul>
                </div>
            </div>
        </main>

        <footer role="contentinfo" id="fh5co-footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="footer-box border-bottom">
                            <h3 class="footer-heading">About Us</h3>
                            <p>Eventize is an event management company dedicated to organize your events in a hastle-free manner. </p>
                        </div>

                        <p><strong></strong></p>

                        <div class="fh5co-spacer fh5co-spacer-sm"></div>

                    </div>
                    <div class="col-md-3 col-sm-6">

                        <h3 class="footer-heading"></h3>
                        <ul class="footer-list">

                        </ul>

                    </div>


                    <div class="visible-sm clearfix"></div>
                    <div class="col-md-3 col-sm-6">

                        <h3 class="footer-heading"></h3>
                        <ul class="footer-list">
                            <li><a href="#"><abbr title="Hypertext Markup Language 5"></abbr></a></li>
                            <li><a href="#"><abbr title="Cascading Stylesheets 3"></abbr></a></li>

                        </ul>

                    </div>


                    <div class="col-md-3 col-sm-6 clearfix">

                        <div class="row">
                            <div class="col-md-6 col-sm-6">
                                <div class="footer-box">
                                    <h3 class="footer-heading"></h3>
                                    <ul class="footer-list">


                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <div class="footer-box">
                                    <h3 class="footer-heading"></h3>
                                    <ul class="footer-list">

                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="copyright">
                            <p class="text-center"><small>

                        </div>
                    </div>
                </div>
            </div>
        </footer>


        <!-- Go To Top -->
        <a href="#" class="fh5co-gotop"><i class="ti-shift-left"></i></a>


        <!-- jQuery -->
        <script src="js/jquery-1.10.2.min.js"></script>
        <!-- jQuery Easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.js"></script>
        <!-- Owl carousel -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- Magnific Popup -->
        <script src="js/jquery.magnific-popup.min.js"></script>
        <!-- Easy Responsive Tabs -->
        <script src="js/easyResponsiveTabs.js"></script>
        <!-- FastClick for Mobile/Tablets -->
        <script src="js/fastclick.js"></script>


        <!--     Google Map 
            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
            <script src="js/google_map.js"></script>-->


        <!-- Main JS -->
        <script type ="text/javascript" src="js/main.js">
    //            function book(evid)
    //            {
    //               // document.location.href = "registerUpcomingEvent?book="+evid;
    //               System.out.println("Inside Me");
    //               window.location = 'registerUpcomingEvent?book=' + evid;
    //            }
        </script>



    </body>
</html>
