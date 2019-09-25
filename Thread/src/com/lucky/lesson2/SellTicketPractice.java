package com.lucky.lesson2;

public class SellTicketPractice {
	public static void main(String[] args) {
		TestThread thread1 = new TestThread();
		TestThread thread2 = new TestThread();
		TestThread thread3 = new TestThread();
		
		thread1.setName("线程1");
		thread2.setName("线程2");
		thread3.setName("线程3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
class TestThread extends Thread{
	private static int ticket=100;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(ticket>0){
				System.out.println(getName()+":售出 "+ticket);
				ticket--;
			}else{
				break;
			}
		}
	}
}
