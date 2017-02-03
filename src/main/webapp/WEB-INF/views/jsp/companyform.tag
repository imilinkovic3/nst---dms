<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
    <div class="form-group>
		<form:input path="companyByCompany.pib" type="text" name="pib"
			placeholder="PIB" id="pib" tabindex="1" class="form-control"
			value="" />
	</div>
	<div class="form-group">
		<form:input path="companyByCompany.name" type="text" name="companyName"
			placeholder="Company name" id="companyName" tabindex="1"
			class="form-control" value="" />
	</div>
	<div class="form-group">
		<form:input path="companyByCompany.address" type="text" name="address"
			placeholder="Address" id="address" tabindex="1" class="form-control"
			value="" />
	</div>
	<div class="form-group">
		<form:input path="companyByCompany.city" type="text" name="city"
			placeholder="City" id="city" tabindex="1" class="form-control"
			value="" />
	</div>
	<div class="form-group">
		<form:input path="companyByCompany.postalcode" type="text"
			name="postalCode" placeholder="Postal Code" id="postalCode"
			tabindex="1" class="form-control" value="" />
	</div>
	<div class="form-group">
		<form:input path="companyByCompany.country" type="text" name="country"
			placeholder="Country" id="country" tabindex="1" class="form-control"
			value="" />
	</div>
	<div class="form-group">
		<form:input path="companyByCompany.fax" type="text" name="fax"
			placeholder="FAX" id="fax" tabindex="1" class="form-control" value="" />
	</div>
	<div class="form-group">
		<form:input path="companyByCompany.phone" type="text" name="phone"
			placeholder="Phone" id="phone" tabindex="1" class="form-control"
			value="" />
	</div>
</div>
