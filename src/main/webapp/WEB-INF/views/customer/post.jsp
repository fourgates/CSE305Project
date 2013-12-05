<%-- 
    Document   : post
    Created on : Dec 4, 2013, 11:57:59 AM
    Author     : funfun
--%>

<%@page contentType="text/html" pageEncoding="x-windows-950"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>

        <meta charset="utf-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link href="${pageContext.request.contextPath}/resources/mytheme/bootstrap/css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            .post-unit {
                background-color: lightblue;
            }
            .post-unit:hover {
                background-color: lightgrey;
            }
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
        </style>
       <link href="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-responsive.css" />
      
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#">Facebook +</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                            <li><a href="#contact">Logout</a></li>
                        </ul>
                        <form class="form-search">
                            <input type="text" class="input-medium search-query">
                            <button type="submit" class="btn">Search</button>
                        </form>
                    </div><!--/.nav-collapse-->
                </div>
            </div>
        </div>
        
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            <li class="nav-header">Sidebar</li>
                            <li class="active"><a href="#"></a></li>
                             <li><a href="circle">Circle</a></li>
                            <li><a href="post">Post</a></li>
                            <li><a href="message">Message</a></li>
                       
                        </ul>
                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9">
                    <div class="hero-unit">
                        <h1></h1>
                        <h2>Post</h2>
                        <table class="table table-striped">
                            <tr>
                                <th style="width: 84px"><span style="font-size: 10pt">
                                    </span></th>
                                <th style="width: 84px"><span style="font-size: 10pt"> Post
                                        ID</span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Date
                                    </span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">
                                        Content </span></th>    
                                <th style="width: 84px"><span style="font-size: 10pt">Comment Count</span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Circle </span></th>
                                <th style="width: 84px"><span style="font-size: 10pt">Author</span></th>
                            </tr>

                            <c:forEach items="${posts}" var="item">

                                    <td>${item.postID}</td>
                                    <td>${item.date}</td>
                                    <td>${item.content}</td>
                                    <td>${item.commentCount}</td>
                                    <td>${item.circle}</td>
                                    <td>${item.author}</td>
                            </c:forEach>

                        </table>
                                
                                
                        <div class="panel panel-default">
                            <div class="panel-body" style="background-color: white">
                                
                                <textarea class="form-control" rows="3"></textarea><br>
                                <button class="btn btn-default" type="button">comment </button>

                                <button class="btn btn-default" type="button">like</button>

                                <button class="btn btn-default" type="button">unlike</button>

                                <button class="btn btn-default" type="button">edit</button>

                                <button class="btn btn-default" type="button"> delete </button><br>
                                
                            </div>
                        </div>
                                


                    </div>
                </div>
            </div>

        </div>
        
        <script language="javascript">
            $('#commentbutton[1]').click(function(e){
                $('#inputtext[1]').removeClass('hidden');
            });
        </script>
        
        <script src="src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/jquery.js"></script>
        <!-- <c:url value="/resources/mytheme/bootstrap/js/jquery.js" /> -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-transition.js"></script>
       	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-alert.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-alert.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-modal.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-dropdown.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-scrollspy.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-tab.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-tooltip.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-popover.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-button.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-collapse.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-carousel.js"></script>
        <script src="${pageContext.request.contextPath}/resources/mytheme/bootstrap/js/bootstrap-typeahead.js"></script>

    </body>
</html>
