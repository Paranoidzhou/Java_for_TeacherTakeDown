本版本搭建WebServer服务端基本结构.
创建com.tedu.webserver.core包,并在包中添加主类:
WebServer

该类负责循环接受客户端的连接.并启动线程处理某个客户
端的交互操作.该结构与之前聊天室服务端结构一致.

线程任务由CilentHandler类完成.并定义在core包中.


2
在ClientHandler的run方法中读取客户端发送过来的内容
并输出查看










