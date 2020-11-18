#define _WINSOCK_DEPRECATED_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include <string>
#include<WinSock2.h>
#include <iostream>
#include <WS2tcpip.h>
#pragma comment(lib,"ws2_32.lib")
using namespace std;


#pragma comment(lib, "Ws2_32.lib")   

int main()
{
	//使用Ws2_32.dll的初始化  
	WORD wVersionRequested = 0;
	WSADATA wsaData = {};
	int err = 0;

	wVersionRequested = MAKEWORD(2, 2);

	err = WSAStartup(wVersionRequested, &wsaData);
	if (err != 0)
	{
		return -1;
	}

	if (LOBYTE(wsaData.wVersion) != 2 ||
		HIBYTE(wsaData.wVersion) != 2)
	{

		WSACleanup();
		return -1;
	}

	//////////////////////////  
	char** pptr = NULL;
	char szHostName[256] = {};
	cout << "--------------------------------------" << endl;
	cout << "输入域名：";
	while (cin.getline(szHostName, sizeof(szHostName)))
	{
		HOSTENT* pHostEntry = gethostbyname(szHostName);
		if (NULL != pHostEntry && szHostName[0] != '\0')
		{
			//将主机的规范名输出 
			cout << "主机规范名：" << pHostEntry->h_name << endl;

			//主机别名，可含多个 
			int i = 0;
			for (i = 1, pptr = pHostEntry->h_aliases; *pptr != NULL; ++pptr)
			{
				cout << "主机别名" << i++ << "：" << *pptr << endl;
			}


			//将主机地址列表输出，可含多个 
			char szIpBuff[32] = { 0 };
			for (i = 1, pptr = pHostEntry->h_addr_list; *pptr != NULL; ++pptr)
			{
				memset(szIpBuff, 0, sizeof(szIpBuff));
				//inet_ntop的返回值为NULL，则表示失败，否则返回相应的IP地址（此时szIpRet指向的是szIpBuff） 
				const char* szIpRet = inet_ntop(pHostEntry->h_addrtype, *pptr, szIpBuff, sizeof(szIpBuff));
				if (szIpBuff != NULL)
				{
					cout << "解析IP地址" << i++ << "：" << szIpRet << endl;
				}

			}

		}
		else
		{
			cout << "解析失败！" << endl;
		}


		memset(szHostName, 0, sizeof(szHostName));
		cout << "--------------------------------------" << endl;
		cout << "输入域名：";
	}


	WSACleanup();
	return 0;
}
