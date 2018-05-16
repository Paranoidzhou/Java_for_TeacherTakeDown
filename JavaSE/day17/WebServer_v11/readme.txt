本次改动
完成处理业务操作:登录功能

1:在webapps/myweb目录下创建用于登录功能的页面:
  login.html  登录页
  form表单中只需要用户名及密码输入框.
  action指定地址"login"
    这样当点击登录时,form提交的路径应当为:
  /myweb/login?username=xxx&password=xxx
  
  
  login_success.html  登录成功提示页
  login_fail.html 登录失败的提示页
  
2:在com.tedu.webserver.servlet包中新建一个类:
  LoginServlet并定义方法:
  public void service(HttpRequest request,HttpResponse response)  
  
3:在ClientHandler中添加一个新的分支,当请求的是登录
    业务时,实例化LoginServlet并调用service方法.  
    
4:完成LoginServlet的service方法
  4.1:先从request中获取login.html表单中用户输入的
           用户名以及密码
  4.2:使用RandomAccessFile读取user.dat文件,首先
           读取32字节判断用户名,若不是,则直接移动指针
           到下一条记录,直到找到该用户.若找到该用户后,
           再读取32字节比对密码,若密码输入一致则设置
      response跳转登录成功页面,否则跳转登录失败
          页面.             

    
抽象出一个HttpServlet,作为所有Servlet的超类.定义
共性.
比如,所有Servlet都有service方法,以及都会进行跳转
页面操作.

HttpServlet定义为抽象类.
因为所有派生类都有service方法,但是里面处理的业务
不同,代码不同,所以service方法适合定义为抽象方法.

而所有派生类需要跳转页面,这个操作大家都一致,那么
就定义一个实现方法,共派生类使用.









    
    
    
    
    