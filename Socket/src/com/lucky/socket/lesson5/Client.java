package com.lucky.socket.lesson5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1",6666);
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		while(flag) {		
			dos.writeUTF(message);
			dos.flush();
			System.out.println(dis.readUTF());
			message = sc.nextLine();
		}
		
		sc.close();
		socket.close();
	}
}
