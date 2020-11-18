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

int main(){
    
	WORD wVersionRequested = 0;
	WSADATA wsaData = {};
	int err = 0;

	wVersionRequested = MAKEWORD(2, 2);

	err = WSAStartup(wVersionRequested, &wsaData);
	if (err != 0){
		return -1;
	}

	if (LOBYTE(wsaData.wVersion) != 2 ||
		HIBYTE(wsaData.wVersion) != 2){
		WSACleanup();
		return -1;
	}

	char** pptr = NULL;
	char szHostName[256] = {};
	cout << "--------------------------------------" << endl;
	cout << "����������";
	while (cin.getline(szHostName, sizeof(szHostName))){
		HOSTENT* pHostEntry = gethostbyname(szHostName);
		if (NULL != pHostEntry && szHostName[0] != '\0'){
			cout << "�����淶����" << pHostEntry->h_name << endl;

			int i = 0;
			for (i = 1, pptr = pHostEntry->h_aliases; *pptr != NULL; ++pptr){
				cout << "��������" << i++ << "��" << *pptr << endl;
			}


			char szIpBuff[32] = { 0 };
			for (i = 1, pptr = pHostEntry->h_addr_list; *pptr != NULL; ++pptr){
				memset(szIpBuff, 0, sizeof(szIpBuff));
				const char* szIpRet = inet_ntop(pHostEntry->h_addrtype, *pptr, szIpBuff, sizeof(szIpBuff));
				if (szIpBuff != NULL){
					cout << "����IP��ַ" << i++ << "��" << szIpRet << endl;
				}

			}

		}
		else{
			cout << "����ʧ�ܣ�" << endl;
		}


		memset(szHostName, 0, sizeof(szHostName));
		cout << "--------------------------------------" << endl;
		cout << "����������";
	}

	WSACleanup();
	return 0;
}
