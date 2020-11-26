package mts;

import java.util.Observable;

public class numIncreaser extends Observable implements Runnable {
	volatile boolean shutdown=false;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		
		while(!shutdown){
			i++;
			if((i&1)==1){
				System.out.println("notify "+i+", "+Thread.currentThread().getName());
				this.setChanged();
				this.notifyObservers(i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
