<%--
  Created by IntelliJ IDEA.
  User: chiyume
  Date: 2022/9/27
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><input type="file" name="file" placeholder="请选择上传文件"></td>
            <td><input type="text" name="fileName" placeholder="文件新命名"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
