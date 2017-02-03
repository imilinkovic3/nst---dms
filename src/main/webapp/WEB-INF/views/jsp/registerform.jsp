<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<form:form id="register-form" style="display: none;"
	modelAttribute="user">

	<div class="form-group">
		<form:input path="firstname" type="text" name="firstname"
			placeholder="Firstname" id="firstname" tabindex="1"
			class="form-control" value="" />
		<div class="has-error">
			<form:errors path="firstname" class="help-inline" />
		</div>
	</div>
	<div class="form-group">
		<form:input path="lastname" type="text" name="lastname"
			placeholder="Lastname" id="lastname" tabindex="1"
			class="form-control" value="" />
	</div>
	<%--<div class="form-group">--%>
		<%--<form:select path="roleBean" items="${roles}" multiple="true"--%>
			<%--itemValue="id" itemLabel="name" class="form-control input-sm" />--%>
	<%--</div>--%>
	<spring:bind path="email">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<div class="form-group">
				<form:input path="email" type="email" name="email"
					placeholder="Email" id="email" tabindex="1" class="form-control" />
			</div>
		</div>
	</spring:bind>
	<div class="form-group">
		<form:input path="username" type="text" name="username"
			placeholder="Username" id="username" tabindex="1"
			class="form-control" value="" />
	</div>
	<div class="form-group">
		<input type="password" name="password" placeholder="Password"
			id="password" tabindex="2" class="form-control">
	</div>
	<div class="form-group">
		<form:input path="password" type="password" name="confirmPassword"
			placeholder="Confirm password" id="confirm-password" tabindex="2"
			class="form-control" />
	</div>

	<%@include file="companyform.tag"%>

	<div class="form-group">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<form:button path="register-submit" type="submit"
					id="register-submit" tabindex="4"
					class="form-control btn btn-register">REGISTER</form:button>
			</div>
		</div>
	</div>
</form:form>