#include <stdio.h>
#include <stdlib.h>
#include <WinSock2.h>

#pragma comment(lib, "ws2_32.lib")

void main()
{
	WSADATA wsaData;
	int n;
	char hostname[256];	//存放主机名字
	hostent *pHostent;//主机信息的指针
	protoent *pProtoent;//协议的信息指针
	struct sockaddr_in sa;

	if(WSAStartup(MAKEWORD(2,2), &wsaData) != 0 )
	{
		printf(" Load Failed \n");
		return ;
	}

	//获取主机名字
	if(gethostname(hostname, sizeof(hostname))!=0)
	{
		printf("!!!get hostname!!!Error:%u!!!!\n", WSAGetLastError());
		return ;
	}
	printf("gethostname()函数获得信息如下\n");
	printf("Local host name:%s\n", hostname);
	printf("-------------------------------------\n");

	//从主机名获取主机信息
	pHostent = gethostbyname(hostname);
	if(pHostent == NULL)
	{
		printf("gethostbyname()Error:%u\n", WSAGetLastError());
		return ;
	}

	//解析返回的hostent结构中的各信息
	printf("gethostbyname()获得信息如下\n");
	printf("name:%s,\naliases:%s,\naddrtype:%d,\nlength:%d\n",
		pHostent->h_name,
		pHostent->h_aliases,
		pHostent->h_addrtype,
		pHostent->h_length);

	//解析hostent结构中主机地址
	for(n=0; pHostent->h_addr_list[n]; n++)
	{
		memcpy(&sa.sin_addr.s_addr, pHostent->h_addr_list[n], pHostent->h_length);
		printf("Address:%s\n", inet_ntoa(sa.sin_addr));//输出主机IP地址
	}
	printf("-----------------------------------\n");

	//根据协议名获得协议信息
	pProtoent = getprotobyname("tcp");
	if(pProtoent == NULL)
	{
		printf("!!!!get proto !!!!Error:%u!!!!\n", WSAGetLastError());
		return ;
	}

	//解析protoent结构信息
	printf("getprotobyname()函数获得信息如下\n");
	printf("name:%s\n, proto:%d\n",pProtoent->p_name, pProtoent->p_proto);
	for(n=0; pProtoent->p_aliases[n]; n++)
	{
		printf("aliases:%s\n", pProtoent->p_aliases[n]);
	}


	WSACleanup();
}

