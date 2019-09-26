package com.lucky.socket.lesson9;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		//监听端口号
		ServerSocket serverSocket = new ServerSocket(16888);
		//等待客户端连接
		Socket socket = serverSocket.accept();
		
		boolean flag = true;
		while(flag) {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			File file = new File("copy"+File.separator+dis.readUTF());
			BufferedOutputStream bos = 
					new BufferedOutputStream(new FileOutputStream(file));
			byte[] buf = new byte[1024];
			int length = dis.read(buf);
			while(length != -1) {
				bos.write(buf);
				bos.flush();
				length = dis.read(buf);
			}
			dis.close();
			bos.close();
		}
		socket.close();
	}
}
