<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL 연습</title>
</head>
<body>

${"조희진"}
${'조희진'}
${10}
${null}
${true}<br>

<%=10 + "20" %>, ${10+"20"}, ${10 * 20 }, ${10 mod 20}<br>
${true && false }, ${true and false }<br>

${empty null }
${empty "" }

</body>
</html>