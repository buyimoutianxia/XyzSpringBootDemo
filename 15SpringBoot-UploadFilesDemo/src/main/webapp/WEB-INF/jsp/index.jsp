<%@page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<br>
    单个文件上传</br>
    <form method="post" action="/upload" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
    </br>
</body>
</html>