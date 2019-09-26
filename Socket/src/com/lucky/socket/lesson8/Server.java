package com.lucky.socket.lesson8;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//通过ip与port与服务器上某网络应用取得连接
		ServerSocket serverSocket = new ServerSocket(1688);
		Socket socket = serverSocket.accept();
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		String fileName = dis.readUTF();
		File file =new File("copy"+File.separator+fileName);
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		byte[] buf = new byte[1024];
		int length = dis.read(buf);
		while(length != -1) {
			bos.write(buf,0,length);
			length = dis.read(buf);
		}
		
		serverSocket.close();
		bos.flush();
		bos.close();
		socket.close();
		dis.close();
	}
}
