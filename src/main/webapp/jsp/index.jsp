<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">       
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">    
    </head>
    <body>
        <br>
        <div class="container">
            <div class="jumbotron">
                <h2>
                    Vending Machine
                </h2>
                <p>
                    This is a Software Guild assignment.
                </p>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-8">
                    <div class="row" id="itemCards">
                        <c:forEach var = "currentItem" items = "${itemButtons}">
                            <div class="col-md-4">
                                <a href ="${pageContext.request.contextPath}/chooseItem/${currentItem.itemId}" class="btn btn-primary btn-block">
                                    <!-- where the item cards go... -->
                                    # ${currentItem.itemId}<br>
                                    ${currentItem.name}<br>
                                    $${currentItem.price}<br>
                                    Quantity: ${currentItem.count}
                                </a>
                                <br>        
                                <br>
                            </div>

                        </c:forEach>
                    </div>
                </div>

                <div class="col-md-4">
                    <div>
                        <form class="form-horizontal" role="form" id="purchaseForm" class="form-group">

                            <label for="deposit"> <h2>Total $ In</h2></label>
                            <br>
                            <input type="text" value="${deposit}" class ="form-control" readonly>
                            <br>

                            <a href="${pageContext.request.contextPath}/addDollar" class="btn btn-info">
                                Dollar</a>
                            <a href="${pageContext.request.contextPath}/addQuarter" class="btn btn-info">
                                Quarter</a>
                            <a href="${pageContext.request.contextPath}/addDime" class="btn btn-info">
                                Dime</a>
                            <a href="${pageContext.request.contextPath}/addNickel" class="btn btn-info">
                                Nickel</a>
                                

                            <hr>
                            <label for="msg"><h2>Message</h2></label>
                            <input value="${msg}" type="text" class="form-control" id="msg" name="msg" readonly>

                            <br>

                            <label for="itemId" class="form-label">Item #</label>
                            <input value="${itemId}" type="text" class="form-control" id="itemId" name="itemId" readonly>
                            <br>

                            <a href="vendItem" class="btn btn-warning">Purchase</a>
                            <hr>

                            <label for="change"><h2>Change</h2></label>
                            <input value="${change.quarters} quarter(s), ${change.dimes} dime(s), ${change.nickels} nickel(s), ${change.pennies} pennie(s)" class="form-control" type="text" id="change" name="change" readonly>
                            <br>

                            <a href="returnChange" class="btn btn-success">Return Change</a>

                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

