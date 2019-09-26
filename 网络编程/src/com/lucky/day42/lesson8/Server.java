package com.lucky.day42.lesson8;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		//启动服务器监听
		ServerSocket serverSocket = new ServerSocket(6666);
		//等待客户端连接
		Socket socket = serverSocket.accept();
		File file = new File("file"+File.separator+"Java基础编程.md");
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(file.getName());
		
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buf = new byte[1024];
		int length = fis.read(buf);
		while(length != -1){
			dos.writeUTF(new String(buf, 0, length));
			length = fis.read(buf);
		}
		
		fis.close();
		dos.flush();
		dos.close();
		socket.close();
		serverSocket.close();
	}
}
