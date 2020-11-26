package mts;

public class threadInterrupt_m implements Runnable {
	private threadInterrupt ti=null;
	public threadInterrupt_m(threadInterrupt ti){
		this.ti=ti;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ti.monitor();
	}

}
