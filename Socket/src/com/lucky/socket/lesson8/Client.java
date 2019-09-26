package com.lucky.socket.lesson8;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("192.168.92.147",1688);
		
		
		File file = new File("file"+File.separator+"Java基础编程.md");
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(file.getName());
		
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buf = new byte[1024];
		int length = bis.read(buf);
		while(length != -1){
			dos.writeUTF(new String(buf, 0, length));
			length = bis.read(buf);
		}
		
		bis.close();
		dos.flush();
		dos.close();
		socket.close();
	}
}
