package com.lucky.day42.lesson6;

import java.io.IOException;
import java.net.Socket;

public class Client1 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",6666);
			new ReceiveThread(socket).start();
			new SendThread(socket).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
