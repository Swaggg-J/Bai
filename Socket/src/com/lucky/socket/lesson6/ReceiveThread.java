package com.lucky.socket.lesson6;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread extends Thread{
	private Socket socket;

	public ReceiveThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(socket.getInputStream());
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}






