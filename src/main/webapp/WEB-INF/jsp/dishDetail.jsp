<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<div class="container-fluid">

<div class="row">
  <div class="col-md-6">

  <h1><c:out value="${dish.dishName}" /></h1>
  <p></p>		

		<form class="form-horizontal" role="form">
		  <div class="form-group">
		    <label class="col-sm-4">Description</label>
		    <div class="col-sm-8">
		      <p> <c:out value="${dish.description}" /><p/>
		    </div>
		  </div>
		  
          <div class="form-group">
            <label for="numberOfRooms" class="col-sm-4">Cook</label>
            <div class="col-sm-8">
                <div class="input-group">
                    <p>${dish.user.name}</p>
                </div>
            </div>
          </div>

        <div class="form-group">
            <label for="Images" class="col-sm-4">Images</label>
            <div class="col-sm-8">
                <div class="input-group">
                    <div id="adImages2">
                        <c:forEach items="${dish.images}" var="image">
                            <img id="img${image.id}" src="data:image/jpeg;base64,${image.imageAsString}" alt="image" style="width:25%;height:25%;" class="img-thumbnail">

                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        </form>
      </div>

</div>



<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBEGI1Wn8tNYbkCxFF0lupb81SQgLhtHEU&sensor=false">
</script>

<script type="text/javascript">
    $('.confirm').on('click', function () {
        return confirm('Add me to the appointment ?');
    });
</script>


<script>
  var geocoder;
  var map;
  var mapCenter;
  function initialize(adr) {
	var street = "${ad.street}";
	var zip=${ad.zip};
	var city="${ad.city}";
	var address=street+", "+zip+""+city;
    geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(46.952106, 7.444181);
    var mapOptions = {
      zoom: 8,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);
   codeAddress(address);
  }

 
 	google.maps.event.addDomListener(window, 'load', initialize);
 	
 	//Resize google map after showing in modal
 	$(document).ready(function(){
  	$("#locationModal").on('shown.bs.modal', function () {
  		 google.maps.event.trigger(map, "resize");
  		 map.setCenter(mapCenter);
  	});
  	

 	$('#adImages2 img${image.id}').on({
 	    mouseenter: function(){
 	        $(this).animate({width: '100%', height: '100%'}, 500);
 	    },
 	    mouseleave: function(){
 	        $(this).animate({width: '25%', height: '25%'}, 500);
 	    }
 	});

 });



</script>

			

</div>