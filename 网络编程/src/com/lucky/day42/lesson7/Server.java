package com.lucky.day42.lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6666);
		ArrayList<Socket> list = new ArrayList<Socket>(); 
		while(true) {
			//等待客户端连接
			Socket socket = serverSocket.accept();
			list.add(socket);

			new Thread() {
				public void run() {
					DataInputStream dis = null;
					try {
						dis = new DataInputStream(socket.getInputStream());
						while(true) {
							String message = dis.readUTF();
							sendToAll(message, list);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						try {
							dis.close();
							list.remove(socket);
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
				};
			}.start();
			serverSocket.close();
		}
	} 





	public static void sendToAll(String message,ArrayList<Socket> list) {
		DataOutputStream dos = null;
		try {
			for(Socket socket : list) {
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(message);
				dos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dos.flush();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
