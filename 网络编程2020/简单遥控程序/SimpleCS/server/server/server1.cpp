#include "pch.h"
#include <iostream>
#include <cstring>
#include <cstdlib>
#include <direct.h>
#include <vector>
#include <io.h>
#include <WinSock2.h>
using namespace std;

#define PORT 8087 // 服务的端口
#define SERVER_IP "127.0.0.1" // 服务端的IP地址
#define BUFFER_SIZE 1024 // 缓冲区的大小
#define FILE_NAME_MAX_SIZE 512 // 文件名的最大长度

#pragma comment(lib, "WS2_32")
#pragma warning(disable: 4996)

/* 常用函数声明 */
bool initSocket(); // 启动winsock并初始化
bool connectProcess(); // 连接

/* 发送文件所需的函数的声明 */
bool sendFile(SOCKET datatcps, FILE *file); // 发送文件
bool sendFileList(SOCKET datatcps); // 发送文件列表
bool getFiles(string path, vector<string>& files); // 获取目录下的所有文件

/* 全局变量声明 */
SOCKET sockClient, sockServer; // socket对象
sockaddr_in server_addr, client_addr; // 地址结构
WSADATA wsaData; // socket dll 结构
char fileName[FILE_NAME_MAX_SIZE]; // 文件名
char order[20]; // 命令
char rbuff[BUFFER_SIZE]; // 接收缓冲区
char sbuff[BUFFER_SIZE]; // 发送缓冲区

/// 启动winsock并初始化
bool initSocket()
{
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
	server_addr.sin_addr.S_un.S_addr = INADDR_ANY;
	server_addr.sin_port = htons(PORT); // 设置端口号，htons用于将主机字节序改为网络字节序

	// 初始化socket dll
	/*
	 * int WSAStartup(
	 *     WORD       wVersionRequested,
	 *     LPWSADATA  lpWSAData
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

	// 绑定socket和服务端地址
	/*
	 * bind()用来将socket和地址结构绑定
	 * int bind(
	 *     SOCKET                 s,       // 等待客户端连接的socket
	 *     const struct sockaddr  *name,   // 指向要进行绑定的地址结构
	 *     int                    namelen  // 表示要传递的，由协议决定的地址结构长度
	 * );
	 * 一旦绑定出错，bind()返回SOCKET_ERROR
	 * 对bind()而言，最常见的错误如下:
	 * WSAEADDRINUSE 表示另一个进程已经同本地IP及端口号绑定，或者该IP和端口号处于TIME-WAIT状态
	 * WSAEFAULT     表示调用的socket已经被绑定
	 */
	if (SOCKET_ERROR == bind(sockClient, (LPSOCKADDR)&server_addr, sizeof(server_addr)))
	{
		cout << "Server bind failed: " << WSAGetLastError() << endl;
		exit(1);
	}

	return true;
}

/// 连接
bool connectProcess()
{
	int addrLen = sizeof(client_addr);

	// 监听
	/*
	 * int listen(
	 *     SOCKET  s,       // 被绑定的socket
	 *     int     backlog  // 监听队列中允许保持的尚未处理的最大连接数量
	 * );
	 * backlog参数指定了被搁置的连接的最大队列长度
	 * 比如backlog参数为3，但是有4台客户端同时发出请求，那么前3个会被放在挂起队列中，而第四个会连接请求失败返回WSAECONNREFUSED错误
	 */
	if (SOCKET_ERROR == listen(sockClient, 10))
	{
		cout << "Server listen failed: " << WSAGetLastError() << endl;
		exit(1);
	}
	cout << "Listening to client..." << endl;

	while (1)
	{
		/*
		 * 从s的等待连接队列中抽取第一个连接，创建一个与s同类的新的socket并返回其句柄
		 * SOCKET accept(
		 *     SOCKET           s,         // 一个处于监听模式的socket
		 *     struct sockaddr  *addr,     // 一个指向sockaddr_in结构的指针，用于取得对方的地址信息
		 *     int              *addrlen   // addr结构的长度
		 * );
		 */
		sockServer = accept(sockClient, (sockaddr*)&client_addr, &addrLen);
		if (SOCKET_ERROR == sockServer)
		{
			cout << "Server accept failed: " << WSAGetLastError() << endl;
			exit(1);
		}

		while (1)
		{
			// 初始化
			memset(sbuff, 0, sizeof(sbuff));
			memset(rbuff, 0, sizeof(rbuff));

			// 接收消息
			/*
			 * int recv(
			 *     SOCKET  s,      // 套接字句柄
			 *     char    *buf,   // 要接收数据的缓冲区的地址
			 *     int     len,    // 缓冲区的长度
			 *     int     flags   // 指定了的调用方式，通常设为0
			 * );
			 * recv()通过sockClient套接口接受数据并存入rbuff缓冲区，返回接收到的字节数
			 */
			if (recv(sockServer, rbuff, sizeof(rbuff), 0) <= 0)
			{
				break;
			}
			cout << endl << "Execute: " << rbuff << endl;

			// 执行不同的命令
			if (0 == strncmp(rbuff, "get", 3))
			{
				// 往客户端发送文件

				FILE *file;
				strcpy(fileName, rbuff + 4); // 获取文件名
				file = fopen(fileName, "rb"); // 打开文件，只读

				if (file)
				{
					sprintf(sbuff, "get %s", fileName);

					/*
					 * 发消息
					 * int send(
					 *     SOCKET      s,      // 发送端的socket
					 *     const char  *buf,   // 要发送的数据
					 *     int         len,    // 要发送的数据的字节数
					 *     int         flags   // 一般为0
					 * );
					 */
					if (SOCKET_ERROR == send(sockServer, sbuff, sizeof(sbuff), 0))
					{
						fclose(file);
						cout << "Send message failed, maybe have some problems." << endl;
						return false;
					}
					else
					{
						// 创建额外的数据连接用于传输数据
						if (false == sendFile(sockServer, file))
						{
							cout << "Send file failed!" << endl;
							return false;
						}
						fclose(file);
					}
				}
				else
				{
					strcpy(sbuff, "Cannot open the file!\n");
					if (SOCKET_ERROR == send(sockServer, sbuff, sizeof(sbuff), 0))
					{
						cout << "Open file failed!" << endl;
						return false;
					}
				}
			}
			else if (0 == strncmp(rbuff, "put", 3))
			{
				// 接收客户端发来的文件

				FILE *file;
				strcpy(fileName, rbuff + 4); // 获取文件名
				file = fopen(fileName, "wb"); // 打开文件，写入

				if (file)
				{
					sprintf(sbuff, "put %s", fileName);

					if (SOCKET_ERROR == send(sockServer, sbuff, sizeof(sbuff), 0))
					{
						cout << "Send message failed, maybe have some problems." << endl;
						fclose(file);
						return false;
					}
					else
					{
						// 接收数据，recv()返回接收到的字节数
						int cnt = 0;
						while ((cnt = recv(sockServer, rbuff, sizeof(rbuff), 0)) > 0)
						{
							fwrite(rbuff, sizeof(char), cnt, file);
						}
						cout << "Get " << fileName << " successfully." << endl;

						fclose(file);
					}
				}
				else
				{
					cout << "Cannot open " << fileName << "!" << endl;
					return false;
				}
			}
			else if (0 == strncmp(rbuff, "pwd", 3))
			{
				// 发送当前所在目录

				char path[1024];
				//GetCurrentDirectory(sizeof(path), (LPWSTR)path); // 获取进程的当前目录
				getcwd(path, 1024); // 获取当前目录

				strcpy(sbuff, path);
				if (SOCKET_ERROR == send(sockServer, sbuff, sizeof(sbuff), 0))
				{
					cout << "Send message failed, maybe have some problems." << endl;
					return false;
				}
			}
			else if (0 == strncmp(rbuff, "dir", 3))
			{
				// 发送文件列表
				sendFileList(sockServer);
			}
			else if (0 == strncmp(rbuff, "cd", 2))
			{
				// 改变路径

				strcpy(fileName, rbuff + 3); // 获取路径
				chdir(fileName); // 设置当前路径
			}

			closesocket(sockServer);
		}
	}
}

/// 发送文件
bool sendFile(SOCKET datatcps, FILE *file)
{
	cout << "Sending file..." << endl;

	memset(sbuff, 0, sizeof(sbuff)); // 发送缓冲区清零

	// 从文件中循环读取数据并发送至客户端
	while (1)
	{
		int len = fread(sbuff, 1, sizeof(sbuff), file); // 把文件内容读取到sbuff中
		//cout << sbuff;

		if (SOCKET_ERROR == send(datatcps, sbuff, len, 0)) // 发送数据
		{
			cout << "Connect error!" << endl;
			closesocket(datatcps);
			WSACleanup();
			return false;
		}

		if (len < sizeof(sbuff)) // 文件传输结束
		{
			break;
		}
	}

	closesocket(datatcps);
	cout << "Send successfully!" << endl;

	return true;
}

/// 获取目录下的所有文件
bool getFiles(string path, vector<string>& files)
{
	long hFile = 0; // 文件句柄
	struct _finddata_t fileinfo; // 文件信息
	string p;

	if ((hFile = _findfirst(p.assign(path).append("\\*").c_str(), &fileinfo)) == -1)
	{
		return false;
	}
	else
	{
		do
		{
			// 如果是目录就迭代，如果不是就加入列表
			if ((fileinfo.attrib & _A_SUBDIR))
			{
				if (strcmp(fileinfo.name, ".") != 0 && strcmp(fileinfo.name, "..") != 0)
				{
					getFiles(p.assign(path).append("\\").append(fileinfo.name), files);
				}
			}
			else
			{
				files.push_back(p.assign(path).append("\\").append(fileinfo.name));
			}
		} while (0 == _findnext(hFile, &fileinfo));

		_findclose(hFile);
	}

	return true;
}

/// 发送文件列表
bool sendFileList(SOCKET datatcps)
{
	vector<string> files;

	char currentPath[1024];
	getcwd(currentPath, 1024);

	if (false == getFiles(currentPath, files))
	{
		const char *errStr = "An error occurred while listing the file list!\n";
		cout << errStr << endl;

		if (SOCKET_ERROR == send(datatcps, errStr, strlen(errStr), 0))
		{
			cout << "Send message failed!" << endl;
		}

		closesocket(datatcps);

		return false;
	}

	int size = files.size();
	for (int i = 0; i < size; i++)
	{
		memset(sbuff, 0, sizeof(sbuff));
		strcpy(sbuff, files[i].c_str()); // 获取文件信息
		strcat(sbuff, "\n");
		//cout << sbuff;

		if (SOCKET_ERROR == send(datatcps, sbuff, sizeof(sbuff), 0))
		{
			cout << "Send message failed: " << WSAGetLastError() << endl;
			closesocket(datatcps);
			return false;
		}
	}

	closesocket(datatcps);

	return true;
}

int main()
{
	if (false == initSocket() || false == connectProcess())
	{
		return -1;
	}

	return 0;
}
