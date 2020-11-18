# SimpleCS

#### 介绍
计网实验，winsock实现的简易CS，可传输文件。

#### 软件架构
client和server均使用visual studio开发。

#### 使用说明
1.  注意visual studio在打开其中一个项目并编译运行的时候，可能无法打开另一个项目，因此可以在编译后在debug目录下直接打开exe文件。
2.  pwd命令可以查看当前的目录，注意传输文件的时候，想要传输的文件在哪个目录下。
3.  最初在client的debug目录中只有client.txt文件，用于测试客户端能否正常put文件，同理最初在server的debug目录中只有server.txt文件，用于测试客户端能否正常get文件。