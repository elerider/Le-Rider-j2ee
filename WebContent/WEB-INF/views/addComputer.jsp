<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="include/header.jsp" />


<div class="container-fluid">
	<div class="row">
	<div class="col-md-12">
		<h1>Add Computer</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<form role="form" action="addComputer" method="POST">
				<div class="form-group">
					<label for="name">Computer name</label> <input type="text"
						class="form-control" id="name" name="name" placeholder="Enter name">
					<p class="help-block">Required</p>
				</div>
				<div class="form-group">
					<label for="introduced">Introduced date</label> <input type="date"
						class="form-control" id="introduced" name="introduced" pattern="YY-MM-dd"
						placeholder="Introduced"> <span class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="discontinued">Discontinued date</label> <input
						type="date" class="form-control" id="discontinued" name="discontinued"
						pattern="YY-MM-dd" placeholder="Discontinued"> <span
						class="help-block">YYYY-MM-DD</span>
				</div>
				<div class="form-group">
					<label for="company">Company Name:</label>
					<div class="input">
						<select name="company" class="form-control">
						<c:forEach items="${companies}" var="company">
							<option value="${company.id}">${company.name}</option>
						</c:forEach>
						</select>
					</div>
				</div>

				<div class="actions">
					<button type="submit" class="btn btn-success">Submit</button>
					or <a href="dashboard" class="btn btn-danger">Cancel</a>
				</div>
			</form>


		</div>
	</div>
</div>

<jsp:include page="include/footer.jsp" />