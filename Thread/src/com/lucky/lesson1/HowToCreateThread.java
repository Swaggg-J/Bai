package com.lucky.lesson1;

public class HowToCreateThread {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		
		/**
		 * start()方法的两种作用
		 * 1、启动当前线程
		 * 2、调用当前线程的run()方法
		 */		
		myThread.start();
		
		//通过Thread对象调用run()方法就只是普通的对象调用方法，不会再开辟一个线程出来
		//myThread.run();
		
		//一个Thread对象只能调用一次start方法
		myThread.start();
		
		for(int i=1;i<=100;i++) {
			if(i%2 == 0 ) {
				System.out.println(Thread.currentThread().getName()+"："+i);
			}
		}
	}
}

/**
 * 创建线程方式一
 * @author admin
 *
 */
//创建一个继承于Thread类的子类
class MyThread extends Thread{
	//重写Thread类的run()方法
	@Override
	public void run() {
		//run()方法内放置的是线程将要处理的任务
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++) {
			if(i%2 == 0 ) {
				System.out.println(Thread.currentThread().getName()+"："+i);
			}
		}
	}
}
