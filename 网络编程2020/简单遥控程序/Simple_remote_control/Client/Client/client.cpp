#include <iostream>
#include <cstring>
#include <cstdlib>
#include <ctime>
#include <WinSock2.h>
using namespace std;

int main(void)
{
	WSADATA wsaData;
	WSAStartup(0x0202, &wsaData);
	SOCKET s = socket(AF_INET, SOCK_STREAM, 0);

	sockaddr_in sip;
	memset(&sip, 0, sizeof(sip));
	sip.sin_family = AF_INET;
	sip.sin_port = htons(9999);
	sip.sin_addr.s_addr = inet_addr("127.0.0.1");
	connect(s, (sockaddr*)&sip, sizeof(sip));
	char data[254];
	do {
		gets_s(data);
		send(s, data, strlen(data), 0);
		char rd[254];
		int n = recv(s, rd, 253, 0);
		rd[n] = '\0';
		printf("TCP����������Ӧ�ǣ�%s\n", rd);
	} while (strcmp(data, "quit") != 0);
	printf("�ټ���\n");
	closesocket(s);
	WSACleanup();
	return 0;
}//main