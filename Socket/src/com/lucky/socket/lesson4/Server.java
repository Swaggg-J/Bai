package com.lucky.socket.lesson4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		OutputStream ops = socket.getOutputStream();
		DataInputStream dip = new DataInputStream(ins);
		DataOutputStream dos = new DataOutputStream(ops);
		
		String str = dip.readUTF();
		while(str != null) {
			System.out.println(str);
			dos.writeUTF("OK");
			dos.flush();
			str = dip.readUTF();
		}


		ins.close();
		serversocket.close();
		socket.close();
	}
}
