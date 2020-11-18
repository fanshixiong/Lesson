#include "winsock2.h"
#include "stdio.h"

#pragma comment(lib, "ws2_32.lib")

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd) {
	WSADATA wsaData;
	int r = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (r != 0) {
		char err[80];
		sprintf(err, "winsock2装载出现了错误！错误号：%d ", WSAGetLastError());
		MessageBox(NULL, err, "Winsock2测试", 0);
		return -1;
	}
	if (LOBYTE(wsaData.wVersion) != 2 || HIBYTE(wsaData.wVersion) != 2) {
		MessageBoxA(NULL, "Winsock2装载的版本不对！", "Winsock2测试", 0);
		WSACleanup();
		return -1;
	}

	char data[80];
	sprintf(data, "WSAStartup加载成功!\n版本 : % d. % d \n描述： % s\n状态： % s\n", HIBYTE(wsaData.wHighVersion), LOBYTE(wsaData.wVersion), wsaData.szDescription, wsaData.szSystemStatus);
	MessageBoxA(NULL, data, "WSAStartUp", 0);
}