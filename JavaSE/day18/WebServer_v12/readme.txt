本次改动
使用反射机制,完成Servlet的动态创建.这样做可以使得
请求与对应的Servlet变为可以配置的.而不需因为一个新
的业务修改ClientHandler添加分支的作法.

1:在com.tedu.webserver.core中添加一个新的类:
  ServerContext,用于保存服务端配置的信息.
  
2:在ServerContext中添加一个静态属性:
  private static Map<String,String> SERVLET_MAPPING;
  
3:定义一个初始化Servlet映射信息的方法:
  private static void initServletMapping();        
  
4:添加静态代码块,初始化ServerContext相关信息. 

5:对外提供用于获取Servlet信息的相关方法



完善:
1:在conf目录下新建一个servlets.xml文件,并定义好所有
  Servlet的配置信息

2:修改ServerConext的initServletMapping()方法,
    改为加载conf/servlets.xml文件,将所有Servlet
    配置信息设置到SERVLET_MAPPING属性中.
    
3:完成后,添加修改用户密码功能.
  3.1:在webapps/myweb/下新建update.html页面
           该页面要求用户输入用户名及新的密码,然后form
           表单action="update"
      
  3.2:在com.tedu.webserver.servlet包中添加:
      UpdateServlet,继承自HttpServlet并完成
      service功能    
          修改成功跳转修改成功页面,否则跳转修改失败页面
  
  3.3:在conf/servlets.xml文件中添加该Servlet配置
          信息,如:
      <servlet>
			<url>/myweb/update</url>
			<className>com.tedu.webserver.servlet.UpdateServlet</className>
		</servlet>    







 
  
  
  