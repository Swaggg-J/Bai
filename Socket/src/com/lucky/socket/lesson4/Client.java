package com.lucky.socket.lesson4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//通过IP和port连接服务器
		//Scoket中IP表示目标主机，端口号表示目标主机上的网络应用
		Socket socket = new Socket("127.0.0.1",6666);
		
		//数据传输
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		InputStream ins = socket.getInputStream();
		OutputStream ops = socket.getOutputStream();
		DataInputStream dip = new DataInputStream(ins);
		DataOutputStream dos = new DataOutputStream(ops);
		
		while(flag) {
			dos.writeUTF(str);
			dos.flush();
			System.out.println(dip.readUTF());
			str = sc.nextLine();
		}

		sc.close();		
		socket.close();
	}
}
