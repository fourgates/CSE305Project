<%-- 
    Document   : advertisement
    Created on : Dec 4, 2013, 12:03:59 PM
    Author     : funfun
--%>

<%@page contentType="text/html" pageEncoding="x-windows-950"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=x-windows-950">
        <title>JSP Page</title>
        <style>
            #header {
                background-color: dodgerblue;
            }
            #header ul {
                list-style-type: none;
                margin:0;
                padding:0;
            }
            #header ul a {
                color: white;
            }
            #header ul a:hover {
                color: yellow;
            }
            #header li{
                display: inline;
            }
            #menu ul {
                list-style-type: none;
                margin:0;
                padding:0;
            }
            #outer{
                width: 700px;
                height: 600px;
                background: buttonface;
                margin: 0 auto;
                display: block;
            }
            #inner{
                background: buttonface;
                margin: 50px 50px 500px 50px;
                padding: 0;
                display: block;
            }
            #TABLE {
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <div id="header" style="">
                <div>
                    <h1 style ="color: white; margin-bottom: 0;">FB+</h1>
                </div>
                <div>
                    <ul>
                        <li><a href="#Home">Home</a></li>                    
                        <li><a href="#Logout">Logout</a></li>
                    </ul>
                </div>
            </div>
            <div id ="menu" style="background-color: lightblue ; height: 400px;width: 200px; float: left;">
                <ul>                  
                    <li><a href="record_transaction">Transaction</a></li>
                    <li><a href="customerInfo">Customer Information</a></li>
                    <li><a href="advertisement">Advertisement</a></li>
                </ul>
            </div>
        </div>
        <div id ="content" style="background-color: white; height: 200px; width: 500px;float: left">
            <form>
                <div id="outer">
                    <div id="inner"> <div> <span style="font-size: 20pt; font-family: Arial">Advertisement</span> <br>
                            <div>  <table border="3" id="TABLE">
                                    <tr>
                                        <th style="width: 100px"><span style="font-size: 10pt">Advertisement id</span></th>
                                        <th style="width: 84px"><span style="font-size: 10pt">Employee</span></th>
                                        <th style="width: 84px"><span style="font-size: 10pt">Type</span></th>
                                        <th style="width: 84px"><span style="font-size: 10pt">Date</span></th>
                                        <th style="width: 84px"><span style="font-size: 10pt">Company</span></th>
                                        <th style="width: 130px"><span style="font-size: 10pt">Item Name</span></th>
                                        <th style="width: 84px"><span style="font-size: 10pt">Content</span></th>
                                        <th style="width: 100px"><span style="font-size: 10pt">Unit Price</span></th>
                                        <th style="width: 100px"><span style="font-size: 10pt">Available Units</span></th>





                                    </tr>

                                </table>
                                <table>
                                    <tr>
                                        <td><button type="button">Create</button> </td>
                                        <td><button type = "button"> Delete</button></td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                    </div>
            </form>

        </div>

    </div>

</body>
</body>
</html>
