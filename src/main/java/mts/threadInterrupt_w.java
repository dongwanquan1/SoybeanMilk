package mts;

import java.util.concurrent.ConcurrentHashMap;

public class threadInterrupt_w implements Runnable {
	private threadInterrupt ti=null;
	private final int kkk;
	public threadInterrupt_w(threadInterrupt ti){
		this.ti=ti;
		kkk=1;
	}
	@Override
	public void run() {
		
		ConcurrentHashMap curHmp=new ConcurrentHashMap();
		// TODO Auto-generated method stub
		ti.working();
	}
}
