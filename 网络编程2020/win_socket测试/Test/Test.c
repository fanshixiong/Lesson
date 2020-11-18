#include "winsock2.h"
#include "stdio.h"

#pragma comment(lib, "ws2_32.lib")

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd) {
	WSADATA wsaData;
	int r = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (r != 0) {
		char err[80];
		sprintf(err, "winsock2װ�س����˴��󣡴���ţ�%d ", WSAGetLastError());
		MessageBox(NULL, err, "Winsock2����", 0);
		return -1;
	}
	if (LOBYTE(wsaData.wVersion) != 2 || HIBYTE(wsaData.wVersion) != 2) {
		MessageBoxA(NULL, "Winsock2װ�صİ汾���ԣ�", "Winsock2����", 0);
		WSACleanup();
		return -1;
	}

	char data[80];
	sprintf(data, "WSAStartup���سɹ�!\n�汾 : % d. % d \n������ % s\n״̬�� % s\n", HIBYTE(wsaData.wHighVersion), LOBYTE(wsaData.wVersion), wsaData.szDescription, wsaData.szSystemStatus);
	MessageBoxA(NULL, data, "WSAStartUp", 0);
}