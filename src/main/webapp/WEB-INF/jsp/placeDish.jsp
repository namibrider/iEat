<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="container">

	<h2>${user.name}</h2>

	<a href="<spring:url value="/placeNewDish.html"/>"
		class="btn btn-primary btn-lg active pull-right" role="button">Place
		new dish</a>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<ul class="nav nav-tabs">
		<li class="active"><a href="#section-1" data-toggle="tab">My Dishes
				</a></li>
	</ul>

	<div class="scroll-area" data-spy="scroll" data-target="navbarCollapse"
		data-offset="0">


		<div class="tab-content">
			<div class="tab-pane active" id="section-1">

				<h4 class="section">My Dishes</h4>
				<div id="Layout" class="container">
					<div class="row" id="createdDishes">


						<c:forEach items="${user.dishes}" var="dish">
							<div class="col-md-6 col-md-4 user-ads">
								<div style="width: 75%; height: 75%; padding-bottom: 5%"
									id="thumbnail" class="thumbnail">

									<a href="<spring:url value="/dishes/${dish.id}.html"/>"> <c:choose>
											<c:when test="${not empty dish.images}">
												<img
													src="data:image/jpeg;base64,${dish.images[0].imageAsString}"
													class="img-responsive"  style="width:250px;height:200px"/>
											</c:when>
											<c:otherwise>
												<img
													src="data:image/png;base64,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"
													class="img-responsive"/>
											</c:otherwise>
										</c:choose>
									</a>

									<div class="caption">
										<h4>${dish.dishName}</h4>

										<a href="<spring:url value="/dishes/${dish.id}.html"/>"
											class="btn btn-primary" role="button"> View Details </a>
										<p></p>
										<a href="<spring:url value="/dish/edit/${dish.id}.html" />"
											class="btn btn-primary" role="button"> edit dish </a>
										<p></p>
										<a href="<spring:url value="/dish/remove/${dish.id}.html" />"
											class="btn btn-danger triggerRemove"> remove dish </a>


									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
			<!-- @end #section1 -->
		</div>



		<br /> <br />
	</div>
</div>



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
			});
</script>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Remove element</h4>
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
											$('#myModalContent')
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

<script>
	function showAlertedAds(data1, data2) {
		$.ajax({
			url : "searchDishes.html",
			type : "post",
			data : json / array / whatever,

			success : function() { // trigger when request was successfull
				window.location.href = 'somewhere'
			}
		});
	}
</script>


<script>
	$(function{
		  $('#myTab a').click(function(e) {
		    e.preventDefault();
		    $(this).tab('show');
		  });
		});
</script>


