<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="templates/baseHeaderComponents.jsp" %>
		<title>Recherche</title>
	</head>
	<body>
    <%@ include file="templates/elements/header.jsp" %>
	
    <div class="container">
      <h2><c:out value="${ results.size() }" /> résultat(s) de recherche pour <small><c:out value="${ criteria }" /></small></h2>
	    <hr/>
	    <c:forEach items="${ results }" var="result" varStatus="loop">
        <div class="thumbnail row">
          <div class="row show-grid">
              <div class="col-md-6">
                  <h3>
                      <c:out value="${ result.name }" />
                  </h3>
              </div>
              <div class="col-md-6">
                  <h3 class="text-right">
                      <small>Du <strong><joda:format value="${ result.dateStart }" pattern="dd MMM" style="F-" dateTimeZone="America/Montreal"/></strong> au <strong><joda:format value="${ result.dateEnd }" pattern="dd MMM yyyy" style="F-" dateTimeZone="America/Montreal"/></strong></small>
                  </h3>
              </div>
          </div>
  
          <hr/>
          <div class="row show-grid">
              <div class="col-md-4">
                  <img src="<c:url value="${ result.imageThumbUrl }" />" alt="<c:out value="${ result.name }" />" class="img-rounded" width="200px" height="133px" />
              </div>
  
              <div class="col-md-6">
                  <c:out value="${ result.description }" />
              </div>
  
              <div class="col-md-2">
                  <a class="btn btn-default" href="/ticketz/detail?id=<c:out value="${ result.id }" />" role="button">Détail</a>
              </div>
          </div>
        </div>
	    </c:forEach>
    </div>
	
		<%@ include file="templates/elements/footer.jsp" %>
		<%@ include file="templates/baseFooterComponents.jsp" %>
	
	</body>
</html>