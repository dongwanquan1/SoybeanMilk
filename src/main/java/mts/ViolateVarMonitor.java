package mts;

public class ViolateVarMonitor implements Runnable {
	ViolateVar vv=null; 
	public ViolateVarMonitor(ViolateVar vv){
		this.vv=vv;
	}
	@Override
	public void run() {
		while(this.vv.isCoincident()){
			System.out.println("volatile count keep in consistent");
			Thread.yield();
		}
		System.out.println("volatile count is not consistent anymore, statement is ruint");
		this.vv.shutdown=true;
	}
	
}
