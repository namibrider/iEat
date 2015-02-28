<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="name" value="${nbrUnreadMessages}" scope="session" />
	

<div id="carousel" class="carousel slide" data-ride="carousel" data-interval="5000">
 
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
        <img src="http://i.imgur.com/6sCMy.jpg" alt="spaghetti"   style="width: 100%; height: 100%;">
    </div>
    <div class="item">
      <img src="http://i.imgur.com/6sCMy.jpg" alt="spaghetti">
      <div class="carousel-caption">
          <h3>Yummi</h3>
      </div>
    </div>
  </div>
 
  <!-- Controls -->
  <a class="left carousel-control no-background" href="#carousel-example-generic" role="button" data-slide="prev">
  </a>
  <a class="right carousel-control no-background" href="#carousel-example-generic" role="button" data-slide="next">
  </a>
</div> <!-- Carousel -->

<div class="jumbotron home-container">
	<div class="left-area float-left">
		<p>Welcome to iEat, the new place to find a suggestion for the next meal!</p>
	</div>
  	<div class="right-area float-left">
  		<a class="btn btn-primary btn-lg btn-home" href="dishes.html" role="button">Browse dishes</a>
  		<security:authorize access="isAuthenticated()">
  			<a class="btn btn-primary btn-lg btn-home" href="<spring:url value="/placeNewDish.html"/>">Place new dish</a>
  		</security:authorize>
  		<security:authorize access="! isAuthenticated()">
  			<a class="btn btn-primary btn-lg btn-home" href="<spring:url value="/register.html" />">Register</a>
  		</security:authorize>
  	</div>
</div>
