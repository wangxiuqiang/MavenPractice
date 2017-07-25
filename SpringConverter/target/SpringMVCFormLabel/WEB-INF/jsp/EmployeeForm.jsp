<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee_input</title>
</head>
<body>
	<div id="global">
		<form:form commandName="employee" method="post" action="employee_save">
			<fieldset>
				<legend>
					<p>
						<label for="firstName">FirstName:</label>
						<form:input path="firstName" tabindex="1" />
					</p>
					<p>
						<label for="lastName">LastName:</label>
                        <form:input path="lastName" tabindex="2"/>					
					</p>
					<p>
					<form:errors path="birthDay" cssClass="error"/>
					</p>
					<p><label for="birthDay">BirthDay:</label>
					<form:input path="birthDay" tabindex="3"/>
					</p>
					<p>
					<input id="reset" type="reset" tabindex="4"/>
					<input id ="submit" type="submit" tabindex="5"/>
					</p>
				</legend>
			</fieldset>

		</form:form>
	</div>
</body>
</html>