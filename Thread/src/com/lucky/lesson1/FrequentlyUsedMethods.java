package com.lucky.lesson1;

/**
 * start(): 启动当前线程，调用当前线程中的run()方法
 * run(): 通常需要重写run()方法，run()方法中声明了线程中要执行的内容
 * currentThread(): 获取当前执行的线程，静态方法
 * getName(): 获取当前线程的名称
 * setName(): 为当前线程设置名称，需放在start()前
 * yield(): 线程礼让，释放cpu的执行权
 * join(): 在线程A中调用线程B的join()方法，线程A会进入阻塞状态，直到线程B执行完后，线程A才结束阻塞状态
 * @author admin
 *
 */
public class FrequentlyUsedMethods {
	public static void main(String[] args) throws InterruptedException {
		TestThread testThread = new TestThread();
		
		testThread.setName("线程一");
		
		testThread.start();
		
		for(int i=0;i<100;i++) {
			if(i%2 == 0) {
				System.out.println(Thread.currentThread().getName()+"："+i);
			}
			if(i == 50) {
				testThread.join();
			}
		}
	}
	
	
	
}

class TestThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			if(i%2 == 0) {
				System.out.println(Thread.currentThread().getName()+"："+i);
			}
//			if(i%20 == 0) {
//				yield();
//			}
		}
	}
}








