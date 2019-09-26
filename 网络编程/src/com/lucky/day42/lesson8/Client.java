package com.lucky.day42.lesson8;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//通过ip与port与服务器上某网络应用取得连接
		Socket socket = new Socket("127.0.0.1",6666);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		String fileName = dis.readUTF();
		File file =new File("copy"+File.separator+fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(dis.readUTF().getBytes());
		
		fos.flush();
		fos.close();
		socket.close();
		dis.close();
	}
}
