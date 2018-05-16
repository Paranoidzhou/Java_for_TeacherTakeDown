本次改动,结构调整.将响应也定义为一个类HttpResponse
然后将ClientHandler中响应客户端的细节操作全部移到
HttpResponse中进行.

1:在http包中定义一个类HttpResponse
    定义构造方法,参数为Socket.
    
2:在HttpResponse中定义flush方法,用于响应客户端

3:定义属性entity,该属性用来记录这个响应要给客户端
    实际发送的文件内容(发送响应正文中的内容)    

4:ClientHandler中调整代码,上来解析完request后
    先创建好response对象,将来将需要给客户端发送的内容
    设置到响应对象上.在最后调用flush方法响应客户端.






