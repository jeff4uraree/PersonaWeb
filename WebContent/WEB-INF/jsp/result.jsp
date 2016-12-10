<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Persona Fusion Table Calculator</title>
</head>
<body>

<h2>Your outcome persona is: </h2>
   <table>
    <tr>
        <td>Output Persona: </td>
        <td>${outputPersonaName}</td>
    </tr>
    <tr>
        <td>Output Persona Arcana: </td>
        <td>${outputPersonaArcana}</td>
    </tr>
    <tr>
        <td>Output Persona base level: </td>
        <td>${outputPersonaLevel}</td>
    </tr>
</table>  
</body>
</html>