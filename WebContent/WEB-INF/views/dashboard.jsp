<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	</head>
<body>

<jsp:include page="include/header.jsp" />

<div class="container-fluid">
  <div class="row">
  	<div class="col-md-12">
	<h1 id="homeTitle">456 Computers found</h1>
	</div>
  </div>
  
	<div class="row" id="actions">
		<div class="col-md-10">
		<form action="" method="GET" class="form-inline" role="form">
			<input type="search" id="searchbox" name="search" class="form-control"
				value="" placeholder="Search name">
			<input type="submit" id="searchsubmit"
				value="Filter by name"
				class="btn btn-primary">
		</form>
		</div>
		<div class="col-md-2">
		<a id="add" href="addComputer" role="button" class="btn btn-success pull-right">Add Computer</a>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<form method="POST" action="dashboard" method="POST">
				<table class="computers table table-striped table-bordered" id="table">
				
					<thead>
						<tr>
							<!-- Variable declarations for passing labels as parameters -->
							<!-- Table header for Computer Name -->
							<th>Computer ID</th>
							<th>Computer Name</th>
							<th>Introduced Date</th>
							<!-- Table header for Discontinued Date -->
							<th>Discontinued Date</th>
							<!-- Table header for Company -->
							<th>Company</th>
						</tr>
					</thead>
					<tbody>
						<!-- <form role="form" action="removeComputer" method="POST">
						</form> -->
						<c:forEach items="${computers}" var="computer">
					
							<tr>
								<td>${computer.id}</td>
								<td>${computer.name}</td>
								<td>${computer.introduced}</td>
								<td>${computer.discontinued}</td>
								<td>${computer.company.name}</td>
								<td>
										<div class = delete>
											<button type="submit" class="btn btn-danger btn-xs" id="id" name="id" value="${computer.id}">-</button>
										</div>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</div>
<script>
	var $rows = $('#table tr');
	$('#searchbox').keyup(function() {
	    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
	
	    $rows.show().filter(function() {
	        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
	        return !~text.indexOf(val);
	    }).hide();
	});
</script>
</body>
</html>

<jsp:include page="include/footer.jsp" />
