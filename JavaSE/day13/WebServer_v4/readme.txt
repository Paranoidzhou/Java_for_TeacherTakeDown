本次改动,将用户在浏览器请求的页面响应给客户端

1:在项目目录下新建一个目录webapps,用这个目录保存
    所有网站需要用到的资源.
2:在webapps下再新建一个子目录myweb,存放我们测试
    用的资源    
3:在myweb目录下新建一个index.html文件并完成页面
    内容

4:在ClientHandler中从HttpRequest中获取url,得到
    用户想请求的资源的路径
    
5:对应的从webapps目录中找到该资源
例如:
浏览器输入的地址:
http://localhost:8080/myweb/index.html
那么在请求行中,可以获取的url部分内容为:
/myweb/index.html

ClientHandler在得到该url后,对应的从webapps目录找
File file = new File("webapps"+request.getUrl());

6:用一个Http标准的响应将该资源回复客户端    












