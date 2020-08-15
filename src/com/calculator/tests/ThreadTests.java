/**
 * 
 */
package com.calculator.tests;

/**
 * @author devsw
 *
 */
@com.calculator.annotation.Core
public class ThreadTests {

	public static void main(String[] args) {
		
		//Test passed
		java.util.concurrent.ExecutorService exec = java.util.concurrent.Executors.newCachedThreadPool();
		java.util.concurrent.Future<Double> doubleThread = null;
		try {
			doubleThread = exec.submit(new com.calculator.thread.BasicThread.DoubleThread(com.calculator.function.Basic.Function.POWER, 20.0 , 203.0));
			System.out.println(doubleThread.get());
		} catch (InterruptedException | java.util.concurrent.ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
