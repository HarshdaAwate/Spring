<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sf:form modelAttribute="product" >
	
		<table align="center" border="1">
			<tr>
				<td>ProductNo </td>
				<td> <sf:input id="txtProductNo" path="productNo"/> </td>
			</tr>
			<tr>
				<td>Price </td>
				<td><sf:input id="txtPrice" path="price"/></td>
			</tr>
			<tr>
				<td>Stock </td>
				<td><sf:input id="txtStock" path="stock"/></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				  	<input type="submit" value="Save">
				</td>
			</tr>
		</table>
		
	</sf:form>

</body>
</html>