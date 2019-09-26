package com.lucky.socket.lesson9;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//利用IP和端口号访问服务器上的网络程序
		


	}
	
	public static Socket getSocket() throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.92.147",16888);
		return socket;
	}
	public static void traversalFiles(String path) {
		File file = new File(path);
		if(!file.exists()) {
			return;
		}
		if(file.isFile()) {
			new Thread() {
				public void run() {
					DataOutputStream dos = null;
					try {
						dos = new DataOutputStream(getSocket().getOutputStream());
						dos.writeUTF(file.getName());
						dos.flush();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
				};
			}.start();
		}

	}
}
