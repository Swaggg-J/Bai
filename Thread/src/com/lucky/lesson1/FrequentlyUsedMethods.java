package com.lucky.lesson1;

/**
 * start(): 启动当前线程，调用当前线程中的run()方法
 * run(): 通常需要重写run()方法，run()方法中声明了线程中要执行的内容
 * currentThread(): 获取当前执行的线程，静态方法
 * getName(): 获取当前线程的名称
 * setName(): 为当前线程设置名称，需放在start()前
 * yield(): 线程礼让，释放cpu的执行权
 * join(): 在线程A中调用线程B的join()方法，线程A会进入阻塞状态，直到线程B执行完后，线程A才结束阻塞状态
 * stop(): 强行结束当前线程，已弃用
 * sleep(long milliTime): 让当前线程在指定时间内休眠milliTime，在此期间该线程处于阻塞状态
 * isAlive(): 判断线程是否存活
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
		
		System.out.println(testThread.isAlive());
	}
	
	
	
}

class TestThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			if(i%2 == 0) {
				/*因为该run()方法是继承于Thread类的run()方法，java规定子类重写父类方法时子类方法
				 * 抛出异常等级不能大于父类方法，Thread类中run()方法没有抛出异常，所以只能用
				 * try/catch来捕捉异常
				 */
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"："+i);
			}
//			if(i%20 == 0) {
//				yield();
//			}
		}
	}
}








