package com.lucky.day42.lesson1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	public static void main(String[] args) throws IOException {
		
		//1、启动服务器监听，端口范围0~65535(2^16-1)
		ServerSocket serversocket = new ServerSocket(6666);
		//2、等待客户端连接，accept()会阻塞直到有客户端连接
		Socket socket = serversocket.accept();
		
		//3、接受数据
		InputStream ins = socket.getInputStream();
		byte[] buf = new byte[1024];
		int length = ins.read(buf);
		while(length != -1) {
			String str = new String(buf,0,length);
			System.out.println(str);
			length = ins.read(buf);
		}
		
		ins.close();
		serversocket.close();
		socket.close();
	}
}
