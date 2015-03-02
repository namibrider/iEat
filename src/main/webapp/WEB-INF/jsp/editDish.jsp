<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>


<form:form method="post" modelAttribute="dish" cssClass="form-horizontal adForm" enctype="multipart/form-data">
	<h4>Dish</h4>
	<div id="editForm">
			<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Dish Name:</label>
						<div class="col-sm-10">
							<form:input path="dishName" class="form-control" />
							<form:errors path="dishName" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Description:</label>
						<div class="col-sm-10">
							<form:textarea path="description" class="form-control" row="3"/>
							<form:errors path="description" />
						</div>
					</div>
					<%--<div class="form-group">--%>
						<%--<label for="name" class="col-sm-2 control-label">Cook:</label>--%>
						<%--<div class="col-sm-10">--%>
							<%--<form:input path="user" class="form-control" />--%>
							<%--<form:errors path="user" />--%>
						<%--</div>--%>
					<%--</div>--%>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Cook:</label>
                        <div class="col-sm-10">
                            <form:input path="cook" class="form-control" />
                            <form:errors path="cook" />
                        </div>
                    </div>
<!-- 					<div class="form-group"> -->
<!-- 						<label for="name" class="col-sm-2 control-label">City:</label> -->
<!-- 						<div class="col-sm-10"> -->
<%-- 							<form:input path="city" class="form-control" /> --%>
<%-- 							<form:errors path="city" /> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="name" class="col-sm-2 control-label">Number of -->
<!-- 							rooms:</label> -->
<!-- 						<div class="col-sm-10"> -->
<%-- 							<form:select path="nbrRooms" class="formControl" --%>
<%-- 								style="width:100%;" tabindex="6"> --%>
<%-- 								<c:if test="${ad.nbrRooms > 0}"> --%>
<%-- 								    <option value="${ad.nbrRooms}"> --%>
<%-- 								    ${ad.nbrRooms } --%>
<!-- 								    </option> -->
<%-- 								</c:if> --%>
<!-- 								<option value="1">1</option> -->
<!-- 								<option value="1.5">1.5</option> -->
<!-- 								<option value="2">2</option> -->
<!-- 								<option value="2.5">2.5</option> -->
<!-- 								<option value="3">3</option> -->
<!-- 								<option value="3.5">3.5</option> -->
<!-- 								<option value="4">4</option> -->
<!-- 								<option value="4.5">4.5</option> -->
<!-- 								<option value="5">5</option> -->
<!-- 								<option value="5.5">5.5</option> -->
<!-- 								<option value="6">6</option> -->
<!-- 								<option value="6.5">6.5</option> -->
<!-- 								<option value="7">7</option> -->
<!-- 								<option value="7.5">7.5</option> -->
<!-- 								<option value="8">8</option> -->
<!-- 								<option value="8.5">8.5</option> -->
<!-- 								<option value="9">9</option> -->
<!-- 								<option value="9.5">9.5</option> -->
<!-- 								<option value="10">10</option> -->
<!-- 								<option value="10.5">10.5</option> -->
<!-- 								<option value="11">11</option> -->
<!-- 								<option value="11.5">11.5</option> -->
<!-- 								<option value="12">12</option> -->
<!-- 								<option value="12.5">12.5</option> -->
<%-- 							</form:select> --%>
<%-- 							<form:errors path="nbrRooms" /> --%>
<!-- 						</div> -->
<!-- 					</div> -->

					<%--<c:if test="${fn:length(selectedRoomMates) > 0}">--%>
					<%--<div class="form-group">--%>
						<%--<label for="name" class="col-sm-2 control-label">Already selected cooks:</label>--%>
						<%--<div class="col-sm-10">--%>
							<%--<c:forEach items="${selectedRoomMates}" var="items">--%>
								<%--<p>${items.user.name}--%>
									<%--<a href="<spring:url value="/dish/deleteRoomMate/${ad.id}/${items.user.id}.html"/>"--%>
										<%--class="btn btn-danger btn-xs" role="button">Delete</a>--%>
								<%--</p>--%>
							<%--</c:forEach>--%>

						<%--</div>--%>
					<%--</div>--%>
					<%--</c:if>--%>

					<%--<div class="form-group">--%>
						<%--<label for="name" class="col-sm-2 control-label">Add room mates:</label>--%>
						<%--<div class="col-sm-10">--%>
							<%--<form:select multiple="" name="roomMates" id="roomMateSelection" class="form-control" path="roomMates">--%>
								<%--<form:options items="${users}" var="users" itemValue="id"--%>
  									<%--itemLabel="name"/>--%>
							<%--</form:select>--%>
						<%--</div>--%>
					<%--</div>--%>


					<%--<c:if test="${fn:length(selectedRoomMates) > 0}">--%>
					<%--<div class="form-group">--%>
						<%--<label for="name" class="col-sm-2 control-label">Already selected room mates:</label>--%>
						<%--<div class="col-sm-10">--%>
							<%--<c:forEach items="${selectedRoomMates}" var="items">--%>
								<%--<p>${items.ingredients.name}--%>
									<%--<a href="<spring:url value="/dish/deleteIngredients/${dish.id}/${items.dish.id}.html"/>"--%>
										<%--class="btn btn-danger btn-xs" role="button">Delete</a>--%>
								<%--</p>--%>
							<%--</c:forEach>--%>

						<%--</div>--%>
					<%--</div>--%>
					<%--</c:if>--%>
					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="name" class="col-sm-2 control-label">Add ingredients:</label> -->
<!-- 						<div class="col-sm-10"> -->
<%-- 							<form:select multiple="" name="ingredients" id="ingredientsSelection" class="form-control" path="ingredients"> --%>
<%-- 								<form:options items="${ingredients}" var="ingredients" itemValue="id" --%>
<%--   									itemLabel="ingredientName"/> --%>
<%-- 							</form:select> --%>
<!-- 						</div> -->
<!-- 					</div>					 -->

					<c:if test="${fn:length(selectedImages) > 0}">					
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Already stored images:</label>
						<div class="col-sm-10">
							<c:forEach items="${selectedImages}" var="items">
								<p>
								<img id="img${item.id}" src="data:image/jpeg;base64,${items.imageAsString}" alt="image" style="width:15%;height:15%;" class="img-thumbnail">
									<a href="<spring:url value="/ad/deleteImage/${ad.id}/${items.id}.html"/>"
										class="btn btn-danger btn-xs" role="button">Delete</a>
								</p>
							</c:forEach>
							
						</div>
					</div>
					</c:if>
					
					<div id="fileinput" class="form-group">
						<label for="name" class="col-sm-2 control-label">Add Image:</label>
						<div  class="col-sm-10">
							<input type="file" name="image[]" class="form-control" />
							<button id="addFile" type="button"
								class="btn btn-default btn-sm right-block">
								<span class="glyphicon glyphicon-plus"></span>
							</button>
						</div>
					</div>
	</div>
	<div class="form-group">
		<div class="pager">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	  </div>   
</form:form>


<script>
	$(document).ready(
			function() {
				$(".triggerRemove").click(
						function(e) {
							e.preventDefault();
							$("#modalRemove .removeBtn").attr("href",
									$(this).attr("href"));
							$("#modalRemove").modal();
						});

				$(".adForm").validate(
						{
							rules : {
								name : {
									required : true,
									minlength : 1
								},
								title : {
									required : true,
									title : true
								}
							},
							highlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-success').addClass('has-error');
							},
							unhighlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-error').addClass('has-success');
							}
						});

				if ($.trim($("#bookmarked").html()) == '') {
					$('#bookmarked').html("No bookmarks");
				}
				if ($.trim($("#alerts").html()) == '') {
					$('#alerts').html("No alerts");
				}
				if ($.trim($("#createdAds").html()) == '') {
					$('#createdAds').html("No ads");
				}
				if ($.trim($("#messages").html()) == '') {
					$('#messages').html("No messages");
				}
				if ($.trim($("#appointments").html()) == '') {
					$('#appointments').html("No appointments");
				}
			});
</script>

<!-- multiple roommate dropdown selection -->
<script>
     $(document).ready(function() { 
    	 $("#roomMateSelection").select2({
    		 placeholder: "Select a room mate",
    		    allowClear: true
    	 }
    		 
     
     ); });
 </script> 



<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Remove ad</h4>
			</div>
			<div class="modal-body">Really remove?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a href="" class="btn btn-danger removeBtn">Remove</a>
			</div>
		</div>
	</div>
</div>




<!-- adding more fileinputs -->
<script>
	$(document)
			.ready(
					function() {
						//add more file components if Add is clicked
						$('#addFile')
								.click(
										function() {
											var fileIndex = $('#fileTable tr')
													.children().length - 1;
											$('#fileinput')
													.append(
															'<div class="form-group">'
																	+ '<label for="name" class="col-sm-2 control-label">Image:</label>'
																	+ '<div class="col-sm-10">'
																	+ '<input type="file" name="image[]" cssClass="form-control" />'
																	+ '</div>');
										});

					});
</script>

<!-- adding more appointments -->
<script>
	$(document)
			.ready(
					function() {
						//add more file components if Add is clicked
						$('#addAppointment')
								.click(
										function() {
											$('#firstDatePicker')
													.append(
															'<label for="name" class="col-sm-2 control-label">Appointment:</label>'
																	+ '<div class="col-sm-10">'
																	+ '<a id="datetimepicker1" class="input-append">'
																	+ '<input data-format="dd-MM-yyyy"'+
					'type="date" name="appointments"></input> '
																	+ '</a>'
																	+ '<a id="datetimepicker2" class="input-append">'
																	+ '	<input type="time"'+
					'		name="appointments"></input> '
																	+ '</a>'
																	+ '<a id="datetimepicker3" class="input-append">'
																	+ '	<input type="time"'+
					'		name="appointments"></input> '
																	+ '</a>'
																	+ '</div>'
																	+ '<label for="name" class="col-sm-2 control-label">Number'
																	+ '	of Visitors:</label>'
																	+ '<div class="col-sm-10">'
																	+ '	<input name="appointments" class="form-control" />'
																	+ '</div>'
																	+ '</div>'
																	+ '</div>'

													);
										});

					});
</script>

<!-- copy appointment starttime to endtime -->
<script>
var $appointmentTo = $("#appointmentTo");

$("#appointmentFrom").keyup(function() {
    $appointmentTo.val(this.value);
});
$("#appointmentFrom").blur(function() {
    $appointmentTo.val(this.value);
});
</script>
