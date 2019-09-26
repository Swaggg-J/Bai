package com.lucky.socket.lesson9;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		traversalFiles("file");
	}

	public static Socket getSocket() throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.92.147",16888);
		return socket;
	}
	public static void traversalFiles(String path) {
		File f = new File(path);

		if(!f.isDirectory()) {
			return;
		}
		File[] files = f.listFiles();
		if(files == null) {
			return;
		}
		for(File file : files) {
			if(file.isFile()) {
				new Thread() {
					public void run() {
						DataOutputStream dos = null;
						BufferedInputStream bis = null;
						Socket socket = null;
						try {
							socket = getSocket();
							dos = new DataOutputStream(socket.getOutputStream());
							dos.writeUTF(file.getName());
							dos.flush();
							bis = new BufferedInputStream(new FileInputStream(file));
							byte[] buf = new byte[1024];
							int length = bis.read(buf);
							if(length != -1) {
								dos.writeUTF(new String(buf,0,length));
								length = bis.read(buf);
							}
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
								bis.close();
								socket.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					};
				}.start();
			}
			if(file.isDirectory()) {
				traversalFiles(file.getAbsolutePath());
			}
		}

	}
}

