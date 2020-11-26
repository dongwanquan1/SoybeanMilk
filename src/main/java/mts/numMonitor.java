package mts;

import java.util.Observable;
import java.util.Observer;

public class numMonitor implements Runnable,Observer {
	Thread workingThread=null;
	Object lock= new Object();
	boolean shutdown=false;
	int currentNum=0;
	@Override
	public void update(Observable paramObservable, Object paramObject) {
		currentNum=(int)paramObject;
		System.out.println("update execute by "+Thread.currentThread().getName());
		workingThread.interrupt();
	}

	@Override
	public void run() {
		while(!shutdown){
			if(workingThread==null)workingThread=Thread.currentThread();
			if(currentNum!=0){
				System.out.println(currentNum+", output by "+Thread.currentThread().getName());
				System.out.println(" ");
			}
			synchronized (lock){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
			}

		}
	}
	
}
