package mts;

public class VolatileMain {
	public static void main(String[] args) {
		ViolateVar volatileVar=new ViolateVar();
		ViolateVarMonitor volatileMoi=new ViolateVarMonitor(volatileVar);
		Thread t1=new Thread(volatileVar,"tvv");
		Thread t2=new Thread(volatileMoi,"tm");
		t1.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
	}
	
}
