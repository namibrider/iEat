<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<c:if test="${param.success eq true}">
	<div class="alert alert-success">Message sent!</div>
</c:if>



<div class="container">

	<h2>${user.name}</h2>
	
		<!-- Collect the nav links, forms, and other content for toggling -->
	<ul class="nav nav-tabs">
		<li><a href="#section-1" data-toggle="tab">Delete my account</a></li>
	</ul>

	<div class="scroll-area" data-spy="scroll" data-target="navbarCollapse"
		data-offset="0">


		<div class="tab-content">
			
			<div class="tab-pane" id="section-1">
				<h4 class="section">Delete my account</h4>
				<div id="Layout" class="container">
					<div class="row" id="deleteAccount">	
					<a href="<spring:url value="/account/remove/${user.id}.html" />"
					class="btn btn-danger btn-large triggerRemove"> Delete
					my account </a>
					</div>
				</div>
			</div><!-- @end #section1 -->
	</div>
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




