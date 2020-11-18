#include "pch.h"
#include <iostream>
#include <cstring>
#include <cstdlib>
#include <ctime>
#include <WinSock2.h>
using namespace std;

#define PORT 8087 // 服务的端口
#define BUFFER_SIZE 1024 // 缓冲区的大小
#define FILE_NAME_MAX_SIZE 512 // 文件名的最大长度

#pragma comment(lib, "WS2_32")
#pragma warning(disable: 4996)

/* 常用函数声明 */
bool initSocket(); // 启动socket并初始化
bool callServer(); // 发送连接请求

/* 函数声明 */
void help(); // 帮助菜单
void list(SOCKET sockfd); // 列出服务端当前目录
bool sendTCP(char data[]); // 发送要执行的命令到服务端
bool sendFile(SOCKET datatcps, FILE *file); // 传送给服务端一个文件

/* 全局变量定义 */
SOCKET sockClient; // socket对象
sockaddr_in server_addr; // 服务端IP
WSADATA wsaData; // socket dll 结构
char inputIP[20]; // 存储输入的服务端IP
char fileName[FILE_NAME_MAX_SIZE]; // 文件名
char rbuff[BUFFER_SIZE]; // 接收缓冲区
char sbuff[BUFFER_SIZE]; // 发送缓冲区

/// 启动socket并初始化
bool initSocket()
{
	char a[20];
	memset(a, 0, sizeof(a));

	/* 如果inputIP和a一样数组内容全部是0，说明还没有输入服务器IP，此时执行输入操作 */
	if (0 == strncmp(inputIP, a, sizeof(a)))
	{
		cout << "Please enter the server IP：";
		cin >> inputIP;
	}

	// 声明并初始化一个服务端的地址结构
	/*
	 * 设置地址结构，sockaddr_in是sockaddr的TCP/IP版本
	 * struct sockaddr_in {
	 *     short	        sin_family;
	 *     u_short	        sin_port;
	 *     struct in_addr	sin_addr;
	 *     char	            sin_zero[8];
	 * };
	 * sin_zero[8]是为了使sockaddr和sockaddr_in结构具有相同的尺寸，使用sockaddr_in的时候要把sin_zero全部置零
	 */
	server_addr.sin_family = AF_INET; // 表明底层是使用哪种通信协议来传输数据的，AF_INET表示使用TCP/IPv4
	server_addr.sin_addr.S_un.S_addr = inet_addr(inputIP); // 指定服务端IP，十进制转化为二进制IPv4地址
	server_addr.sin_port = htons(PORT); // 设置端口号，htons用于将主机字节序改为网络字节序

	/*
	 * int WSAStartup(
	 *     WORD      wVersionRequested,
	 *     LPWSADATA lpWSAData
	 * );
	 * WSAStartup()函数使用合适的winsock动态链接库，成功就返回0
	 * wVersionRequested指定了想载入的winsock版本，其高字节指定了次版本号，而低字节指定了主版本号
	 * 可以使用宏MAKEWORD(x,y)来指定版本号，其中x代表主版本，y代表次版本
	 * lpWSAData是一个指向WSADATA结构的指针，WSAStartup会向该结构中填充其载入的winsock动态链接库
	 */
	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
	{
		cout << "Initialize winsock dll error!" << endl;
		exit(1);
	}

	// 创建socket
	/*
	 * 要使用套接字，首先必须调用socket()函数创建一个套接字描述符
	 * 就如同操作文件时，首先得调用fopen()函数打开一个文件
	 * SOCKET socket(
	 *     int af,      // 协议的地址族，使用IPv4来描述winsock，设置为AF_INET
	 *     int type,    // 套接字类型，TCP/IP设置为SOCK_STREAM，UDP/IP设置为SOCK_DGRAM
	 *     int protocol // 用于给定地址族和类型具有多重入口的传送限定，TCP设置为IPPROTO_TCP，UDP设置为IPPROTO_UDP
	 * );
	 * SOCK_STREAM（流式套接字）：TCP连接，提供序列化的、可靠的、双向连接的字节流，支持带外数据传输
	 */
	sockClient = socket(AF_INET, SOCK_STREAM, 0);
	if (SOCKET_ERROR == sockClient)
	{
		cout << "Create socket error!" << endl;
		exit(1);
	}

	return true;
}

/// 发送连接请求
bool callServer()
{
	initSocket();

	/*
	 * 创建与指定外部端口的连接
	 * int connect(
	 *     SOCKET                 s,       // socket对象
	 *     const struct sockaddr  *name,   // 地址
	 *     int                    namelen  // 地址长度
	 * );
	 */
	if (SOCKET_ERROR == connect(sockClient, (struct sockaddr *)&server_addr, sizeof(server_addr)))
	{
		cout << "Connect failed!" << endl;
		memset(inputIP, 0, sizeof(inputIP)); // 把输入的IP地址清零
		return false;
	}

	return true;
}

/// 帮助菜单
void help()
{
	cout << "     _______________________________________________________________    " << endl
		<< "    |                            Help menu                          |   " << endl
		<< "    | 1. download [get {filename}]                                  |   " << endl
		<< "    | 2. upload   [put {filename}]                                  |   " << endl
		<< "    | 3. Display the files of the current directory in server [dir] |   " << endl
		<< "    | 4. Display current directory in server [pwd]                  |   " << endl
		<< "    | 5. Change the current directory and path in server [cd {...}] |   " << endl
		<< "    |         Enter the subordinate directory: cd {pathname}        |   " << endl
		<< "    |         Enter the superior directory:    cd ..                |   " << endl
		<< "    | 6. Open the help menu [? | help]                              |   " << endl
		<< "    | 7. Quit [quit]                                                |   " << endl
		<< "    |_______________________________________________________________|   " << endl;
}

/// 发送要执行的命令到服务端
bool sendTCP(char data[])
{
	/*
	 * 发消息
	 * int send(
	 *     SOCKET      s,      // 发送端的socket
	 *     const char  *buf,   // 要发送的数据
	 *     int         len,    // 要发送的数据的字节数
	 *     int         flags   // 一般为0
	 * );
	 */
	if (send(sockClient, data, strlen(data), 0) <= 0)
	{
		cout << "Send order failed!" << endl;
		closesocket(sockClient);
		WSACleanup();
		return false;
	}

	return true;
}

/// 发送文件
bool sendFile(SOCKET datatcps, FILE *file)
{
	int iResult;

	cout << "Sending files…" << endl;
	memset(sbuff, 0, sizeof(sbuff));

	// 从文件中循环读取数据并发送
	while (1)
	{
		// fread从file文件中读取sizeof(sbuff)长度的数据到sbuff，返回成功读取的数据个数
		int len = fread(sbuff, 1, sizeof(sbuff), file);

		/*
		 * int send(
		 *     SOCKET      s,      // socket句柄
		 *     const char  *buf,   // 要发送的数据的缓冲区地址
		 *     int         len,    // 缓冲区的长度
		 *     int         flags   // 指定了的调用方式，通常设为0
		 * );
		 */
		iResult = send(datatcps, sbuff, len, 0);
		if (SOCKET_ERROR == iResult)
		{
			cout << "Send failed: " << WSAGetLastError() << endl;
			closesocket(datatcps);
			WSACleanup();
			return 0;
		}

		// 当读取到的数据个数小于发送缓冲区的大小时，说明读完了，跳出循环
		if (len < sizeof(sbuff))
		{
			break;
		}
	}

	iResult = shutdown(datatcps, 1); // 关闭连接，如果不行的话下面会强行关闭
	if (SOCKET_ERROR == iResult)
	{
		cout << "Shutdown failed: " << WSAGetLastError() << endl;
		closesocket(datatcps);
		WSACleanup();
		return true;
	}

	cout << "Transfer complete." << endl;

	return true;
}

/// 列出服务端当前目录
void list(SOCKET sockfd)
{
	int nRead;
	memset(sbuff, 0, sizeof(sbuff));

	// 循环接收数据
	while (1)
	{
		memset(rbuff, 0, sizeof(rbuff));
		/*
		 * int recv(
		 *     SOCKET  s,      // 套接字句柄
		 *     char    *buf,   // 要接收数据的缓冲区的地址
		 *     int     len,    // 缓冲区的长度
		 *     int     flags   // 指定了的调用方式，通常设为0
		 * );
		 * recv()通过sockClient套接口接受数据并存入rbuff缓冲区，返回接收到的字节数
		 */
		nRead = recv(sockClient, rbuff, sizeof(rbuff), 0);

		if (nRead > 0)
		{
			cout << "Bytes received: " << nRead << endl;
			cout << rbuff;
		}
		else if (0 == nRead)
		{
			cout << "Connection close" << endl;
			break;
		}
		else
		{
			cout << "Receive error: " << WSAGetLastError() << endl;
			exit(1);
		}
	}
}

int main()
{
	while (1)
	{
		char operation[10], name[20]; // 操作与文件名
		char order[30] = "\0"; // 输入的命令
		char buff[80]; // 用来存储经过字符串格式化的order
		FILE *fd1, *fd2; // File协议主要用于访问本地计算机中的文件，fd指针指向要访问的目标文件

		initSocket(); // 启动winsock并初始化
		if (false == callServer()) // 发送连接请求失败
		{
			continue;
		}

		// 发送连接请求成功，初始化数据
		memset(operation, 0, sizeof(operation));
		memset(name, 0, sizeof(name));
		memset(order, 0, sizeof(order));
		memset(buff, 0, sizeof(buff));
		memset(rbuff, 0, sizeof(rbuff));
		memset(sbuff, 0, sizeof(sbuff));

		cout << endl << "Please enter the order (enter ? or help can open the help menu): ";
		cin >> operation;

		if (0 == strncmp(operation, "get", 3) || 0 == strncmp(operation, "put", 3) || 0 == strncmp(operation, "cd", 2))
		{
			// 输入文件名
			cin >> name;
		}
		else if (strncmp(operation, "quit", 4) == 0)
		{
			// 退出
			cout << "Thanks for your use." << endl;
			closesocket(sockClient);
			WSACleanup();
			break;
		}
		else if (strncmp(operation, "?", 1) == 0 || strncmp(operation, "help", 4) == 0)
		{
			// 帮助菜单
			help();
			closesocket(sockClient);
			WSACleanup();
			continue;
		}

		// 将指令整合进order，并存放进buff
		strcat(order, operation), strcat(order, " "), strcat(order, name);
		sprintf(buff, order);

		sendTCP(buff); // 发送指令

		// 接收消息
		/*
		 * recv(
		 *     SOCKET  s,      // socket句柄
		 *     char    *buf,   // 要接收数据的缓冲区的地址
		 *     int     len,    // 缓冲区的长度
		 *     int     flags   // 指定了的调用方式，通常设为0
		 * );
		 * recv()通过sockClient套接口接受数据并存入rbuff缓冲区，返回接收到的字节数
		 */
		recv(sockClient, rbuff, sizeof(rbuff), 0);
		cout << rbuff << endl;

		if (strncmp(operation, "get", 3) == 0)
		{
			// 下载文件

			fd1 = fopen(name, "wb"); // 打开文件，写入
			if (NULL == fd1)
			{
				cout << "Open or create " << name << " error!" << endl;
				continue;
			}

			memset(rbuff, 0, sizeof(rbuff)); // 清空rbuff

			/*
			 * recv(
			 *     SOCKET  s,      // socket句柄
			 *     char    *buf,   // 要接收数据的缓冲区的地址
			 *     int     len,    // 缓冲区的长度
			 *     int     flags   // 指定了的调用方式，通常设为0
			 * );
			 * recv()通过sockClient套接口接受数据并存入rbuff缓冲区，返回接收到的字节数
			 */
			int cnt = 0;
			while ((cnt = recv(sockClient, rbuff, sizeof(rbuff), 0)) > 0)
			{
				fwrite(rbuff, sizeof(char), cnt, fd1); // 往文件中写入数据
			}

			fclose(fd1); // 关闭文件
		}
		else if (strncmp(operation, "put", 3) == 0)
		{
			// 上传文件

			strcpy(fileName, rbuff + 4);
			fd2 = fopen(fileName, "rb"); // 打开文件，只读
			if (fd2)
			{
				if (false == sendFile(sockClient, fd2))
				{
					cout << "Send failed!" << endl;
					return 0;
				}

				fclose(fd2);
			}
			else
			{
				strcpy(sbuff, "Cannot open the file!\n");
				if (SOCKET_ERROR == send(sockClient, sbuff, sizeof(sbuff), 0))
				{
					return 0;
				}
			}
		}
		else if (strncmp(operation, "dir", 3) == 0)
		{
			// 获取文件列表
			list(sockClient);
		}

		closesocket(sockClient);
		WSACleanup();
	}

	return 0;
}