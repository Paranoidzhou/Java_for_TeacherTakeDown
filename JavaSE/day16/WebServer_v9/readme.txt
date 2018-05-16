本次改动
添加404响应.当客户端请求的路径无效时,服务端会回复
404错误,表示客户端请求无效.

响应中第一行为状态行,其中的状态代码404就表示客户端
请求无效.

1:在webapps目录中添加一个目录sys
    这里面存放一些共用的资源.比如404错误页面,无论哪个
    应用(web,myweb)对应的资源没有找到,都使用这个页面
    响应.
    
2:将HttpResponse的状态代码改变为可以进行设置的.
  2.1:添加属性:int statusCode
           添加属性:String statusReason
  2.2:添加设置状态代码的方法:
      void setStatusCode(int code)
           设置给定的状态代码,并根据状态代码从HttpContext
           中找到对应的描述设置到属性上.
  2.3:修改sendStatusLine()方法,将设置的状态代码
           与状态描述发送

3:在HttpContext中添加一个静态属性:
  private static Map<Integer,String> STATUS_CODE_REASON_MAPPING    
  
4:在HttpContext中定义一个静态方法:
  private static void initStatusCodeReasonMapping()    
   初始化状态代码与描述的映射关系

5:在HttpContext中定义一个静态方法:
  public static String getStatusReason(int code) 
    给以根据给定的状态代码获取对应的状态描述   
    
6:在ClientHandler中添加响应404的分支.
    
  
  
  
  
  
  
    
    
    
    
    
    
    