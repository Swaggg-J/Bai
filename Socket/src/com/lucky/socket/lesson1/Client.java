package com.lucky.socket.lesson1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//通过IP和port连接服务器
		//Scoket中IP表示目标主机，端口号表示目标主机上的网络应用
		Socket socket = new Socket("127.0.0.1",6666);
		
		//数据传输
		String str = "Hello";
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(str.getBytes());
		
		outputStream.close();
		socket.close();
	}
}
