package com.lucky.socket.lesson6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
	private Socket socket;

	public SendThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataOutputStream dos = null;
		Scanner sc  =new Scanner(System.in);
		String str = sc.nextLine();
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(str);
			dos.flush();
			str = sc.nextLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dos.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



