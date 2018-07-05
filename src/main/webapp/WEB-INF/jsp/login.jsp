<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body onload='document.f.name.focus();'>
<h3>登录页面</h3>
<form name='f' action='/login' method='POST'>
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type='text' name='name1' value=''></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </table>
</form>

</body>
</html>
