#include <stdio.h>
#include <stdlib.h>
#include <WinSock2.h>

#pragma comment(lib, "ws2_32.lib")

void main()
{
	WSADATA wsaData;
	int n;
	char hostname[256];	//�����������
	hostent *pHostent;//������Ϣ��ָ��
	protoent *pProtoent;//Э�����Ϣָ��
	struct sockaddr_in sa;

	if(WSAStartup(MAKEWORD(2,2), &wsaData) != 0 )
	{
		printf(" Load Failed \n");
		return ;
	}

	//��ȡ��������
	if(gethostname(hostname, sizeof(hostname))!=0)
	{
		printf("!!!get hostname!!!Error:%u!!!!\n", WSAGetLastError());
		return ;
	}
	printf("gethostname()���������Ϣ����\n");
	printf("Local host name:%s\n", hostname);
	printf("-------------------------------------\n");

	//����������ȡ������Ϣ
	pHostent = gethostbyname(hostname);
	if(pHostent == NULL)
	{
		printf("gethostbyname()Error:%u\n", WSAGetLastError());
		return ;
	}

	//�������ص�hostent�ṹ�еĸ���Ϣ
	printf("gethostbyname()�����Ϣ����\n");
	printf("name:%s,\naliases:%s,\naddrtype:%d,\nlength:%d\n",
		pHostent->h_name,
		pHostent->h_aliases,
		pHostent->h_addrtype,
		pHostent->h_length);

	//����hostent�ṹ��������ַ
	for(n=0; pHostent->h_addr_list[n]; n++)
	{
		memcpy(&sa.sin_addr.s_addr, pHostent->h_addr_list[n], pHostent->h_length);
		printf("Address:%s\n", inet_ntoa(sa.sin_addr));//�������IP��ַ
	}
	printf("-----------------------------------\n");

	//����Э�������Э����Ϣ
	pProtoent = getprotobyname("tcp");
	if(pProtoent == NULL)
	{
		printf("!!!!get proto !!!!Error:%u!!!!\n", WSAGetLastError());
		return ;
	}

	//����protoent�ṹ��Ϣ
	printf("getprotobyname()���������Ϣ����\n");
	printf("name:%s\n, proto:%d\n",pProtoent->p_name, pProtoent->p_proto);
	for(n=0; pProtoent->p_aliases[n]; n++)
	{
		printf("aliases:%s\n", pProtoent->p_aliases[n]);
	}


	WSACleanup();
}

