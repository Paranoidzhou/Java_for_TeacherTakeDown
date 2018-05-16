本次改动,完成HttpRequest中对请求中的消息头的解析工
作.

1:在HttpRequest中添加一个属性:
  private Map<String,String> headers
   用于保存该请求中所有的消息头内容.
   
2:添加一个方法:parseHeaders
    在该方法中读取所有的消息头,并存入到headers中
    
3:在构造方法中解析完请求行后,调用parseHeaders来
    解析消息头
    
4:对外提供一个getHeader(String name)方法,可以通过
   消息头的名字获取其对应的值
   
   
   
              