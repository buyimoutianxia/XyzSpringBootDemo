## SpringBoot 内置SpirngMVC静态文件地址修改
通过自定义路径"/xyz/test/"代替"classpath"，使用户不能直接访问static下面的内容，提高了安全性。

访问url:
http://localhost:8080/xyz/test/test.png
http://localhost:8080/xyz/test/img/test1.png