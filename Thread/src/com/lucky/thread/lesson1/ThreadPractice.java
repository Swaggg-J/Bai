package com.lucky.thread.lesson1;

/**
 * 创建两个线程，一个打印100以内奇数，一个打印100以内偶数
 * @author admin
 *
 */

public class ThreadPractice {
	public static void main(String[] args) {
		/**
		 * 方法一
		 * 通过创建两个Thread子类并创建两个实例出来
		 */
		/*OneThread oneThread = new OneThread();
		AnotherThread anotherThread = new AnotherThread();
		
		oneThread.start();
		anotherThread.start();*/
		
		/**
		 * 方法二
		 * 使用两个匿名内部类，重写run()方法，创建出后直接start()
		 */
		new Thread() {
			public void run() {
				for(int i=0;i<=100;i++) {
					if(i%2 == 0) {
						System.out.println(Thread.currentThread().getName()+"："+i);
					}
				}
			};
		}.start();
		new Thread() {
			public void run() {
				for(int i=0;i<=100;i++) {
					if(i%2 != 0) {
						System.out.println(Thread.currentThread().getName()+"："+i);
					}
				}
			};
		}.start();
		
	}
}

class OneThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=100;i++) {
			if(i%2 == 0) {
				System.out.println(Thread.currentThread().getName()+"："+i);
			}
		}
	}
}
class AnotherThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=100;i++) {
			if(i%2 != 0) {
				System.out.println(Thread.currentThread().getName()+"："+i);
			}
		}
	}
}










