package mts;

public class ViolateVar implements Runnable {
	public volatile int count=0;
	public volatile boolean shutdown=false;
	@Override
	public void run() {
		while(!shutdown){
			count++;
		}
		
	}
	
	public boolean isCoincident(){
		return count==count;
	}
	
}
