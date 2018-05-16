本次改动
使用tomcat安装目录中conf/web.xml文件,该文件有所有
介质类型映射信息.将这些信息读取出来,初始化HttpContext
中的静态属性:MIME_MAPPING

1:在当前项目目录中新建一个目录:conf
2:将tomcat安装目录中conf/web.xml复制到我们的conf中
3:修改HttpContext初始化介质类型映射的方法:
  initMimeMapping()
    该方法用dom4j进行解析,将所有的介质类型映射信息
    存入到MIME_MAPPING中.