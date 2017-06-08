<%@ page language="java" contentType="text/html"%>
<%@include file="GeneralHeader.jsp" %>

User Home Page
<div class="container">
<c:forEach items="${prodlist}" var="prdt">
<div class = "row">
   <div class = "col-sm-6 col-md-3">
   	<a href = "ProductDesc/${prdt.prodid}" class = "thumbnail">
   	 <img src= "<c:url value="/resources/images/${prdt.prodid}.jpg"/>" alt = "Generic placeholder thumbnail"/>
   	</a>
   	  <div class = "caption">
         <h4>${prdt.prodname}</h4>
         <p> Rs.${prdt.price}</p>
      </div>
	</div>
</div>
</c:forEach>
</div>
<%@include file="GeneralFooter.jsp" %>
</body>
</html>