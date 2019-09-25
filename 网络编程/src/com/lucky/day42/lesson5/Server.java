package com.lucky.day42.lesson5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6666);
		Socket socket = serverSocket.accept();
		
		new ReceiveThread(socket).start();
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		String response = sc.nextLine();
		while(flag) {
			dos.writeUTF(response);
			dos.flush();
			response = sc.nextLine();
		}
		
		sc.close();
		serverSocket.close();
		socket.close();
	}
}
