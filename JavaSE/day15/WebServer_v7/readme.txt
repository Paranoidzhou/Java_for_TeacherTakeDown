本次改动
让响应中的响应头:Content-Type可以根据客户端请求的
实际资源的类型来匹配对应的值.
例如:
请求页面xxx.html时,Content-Type: text/html
请求图片xxx.png时,Content-Type: image/png

思路:
创建一个Map,key保存资源的后缀名,value保存对应的
Content-Type的值.将来得到用户请求的资源文件后,根据
名字的后缀作为key取出对应的Content-Type值响应给
客户端.


1:在http包中定义一个类:HttpContext
    这个类中保存HTTP协议的相关内容

2:在HttpContext中定义一个静态属性:MIME_MAPPING
    它是一个Map,key保存资源后缀名,
   value保存Content-Type对应的值

注:MIME 是描述消息内容类型的英特网标准 W3C制定.
相关介绍参看网站:www.w3school.com.cn

3:在HttpContext的静态代码块中作初始化静态属性操作

4:改动HttpResponse,发送响应头改为可以进行设置的.
    在HttpResponse中定义一个Map类型的属性headers
    并提供对应的get,set方法

5:修改sendHeaders方法,发送响应头只需要遍历headers
    中的头信息并全部发送给客户端.    
    
6:在setEntity方法中做一个操作,当设置了一个要响应
    的实体文件后,将Content-Type与Content-Length
    这两个头设置好.








