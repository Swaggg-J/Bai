package com.lucky.lesson2;
/**
 * 创建线程方式二：实现Runnable接口
 * 1、创建一个实现Runnable接口的实现类
 * 2、实现类实现Runnable接口中的run()方法
 * 3、创建一个实现类的实例对象出来
 * 4、以该对象为参数传入到Therad类的构造器中，创建一个Thread类的对象出来
 * 5、通过Thread类的对象调用start()方法
 * @author Lucky
 *
 */
public class HowToCreateThread2 {
	public static void main(String[] args) {
		
		//3、创建一个实现类的实例对象出来
		MyRunnable myRunnable = new MyRunnable();
		
		//4、以实现类的实例对象为参数传入到Thread类的构造器中，创建一个Thread对象
		Thread thread = new Thread(myRunnable);
		
		//5、Thread类的对象调用start()方法
		thread.start();
	}
}

//1、创建一个实现了Runnable接口的实现类出来
class MyRunnable implements Runnable{
	
	//2、实现类实现Runnable的run()方法
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			if(i%2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
	
}