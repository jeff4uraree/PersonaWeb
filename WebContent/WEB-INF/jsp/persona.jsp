<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="/PersonaWeb/addPersona">
   <table>
    <tr>
        <td><form:label path="persona1">Persona 1</form:label></td>
        <td><form:input path="persona1" /></td>
    </tr>
    <tr>
        <td><form:label path="persona2">Persona 2</form:label></td>
        <td><form:input path="persona2" /></td>
    </tr>
    <tr>
        <td><form:label path="persona3">Persona 3</form:label></td>
        <td><form:input path="persona3" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>