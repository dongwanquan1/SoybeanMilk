package mts;

public class threadInterrupt implements Runnable {
	public Object lock=new Object();
	
	 public static void main(String[] args) {
//		  Character.MAX_VALUE
		 
	 }
	 
	 public void monitor(){
		 while(true){ 
			 System.out.println("monitor.......run....");
	        	synchronized(lock){
	        			System.out.println("monitor.......");
	        	}	
	        System.out.println("monitor.......interrupted!!!!!!!!");	
		 }
	 }
	 public void working(){
	        	synchronized(lock){
	        	  while(true){ 	
		        			System.out.println("working.........");
							lock.notifyAll();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	        		 }
	        	}	
		 
	 }
	@Override
	public void run() {
//		 while (true){
		  while (!Thread.currentThread().isInterrupted()) {  
		        try{  	
		        	synchronized(lock){
		        		lock.notifyAll();
		        		System.out.println("sleep, zzZ");
		        		lock.wait();
		        	}		        		
//		        		Thread.sleep(1000);
		        } catch (InterruptedException ie){
		        	System.out.println("after wake up "+Thread.currentThread().isInterrupted());
		        	Thread.currentThread().interrupt();
		            ie.printStackTrace();  
		        }  
		    }  
	}

}
