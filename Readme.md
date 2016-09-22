###项目介绍:实验db(jdbc+mybatis+hibernate)
数据库使用com.huacaoke.web的数据库，复制到cn.codehero.db  
用于实验mysql等数据库(sql,jdbc等的用法)
## 技术列表:
ide:IntelliJ IDEA 或 eclipse4.4.2 build使用gradle5.2.1    
## 项目结构
|--db/***.sql  用于实验的数据库脚本  
1.项目jdbc:jdbc的javase实验
2.项目orm-hibernate：hibernate的javase实验
3.项目orm-mybatis：mybatis的javase实验
## 使用方法
使用gradle生成javadoc文档查看项目结构，源码使用intellij idea查看。  

##refence（感谢):  
疯狂Java:第13章 mysql数据库与jdbc编程
Hibernate视频教程   佟刚 http://edu.51cto.com/course/course_id-957.html 
JAVA开发专家·精通Hibernate：Java对象持久化技术详解（第2版）  
Mybatis培训视频教程  尚硅谷zxfjd3g  张晓飞
Mybatis培训视频教程01_mybatis快速入门
Mybatis培训视频教程02_Mybatis的CRUD操作
疯狂java讲义(第2版) 执行sql语句的方式 

 
### todo
/13文件夹下：疯狂java的mysql+JDBC内容  
13.5  13.6
13.7  13.8

保留多个版本的sql文件，因为有的模块使用的是老的数据库sql文件。
要记录下来，等有空时再测试升级到最新版本数据库：
db-mybatis中users.name变成了users.username,要重新调通。
