package com.lucky.day42.lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket =new Socket("192.168.92.147",6666);
		
		new Thread() {
			public void run() {
				DataInputStream dis = null;
				try {
					dis = new DataInputStream(socket.getInputStream());
					while(true) {						
						System.out.println(dis.readUTF());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						dis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			String message = sc.nextLine();
			dos.writeUTF(message);
			dos.flush();
		}
		
		dos.flush();
		dos.close();
		socket.close();
		sc.close();

	}
}
