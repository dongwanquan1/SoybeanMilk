package mts;


public class TiTest {

	public static void main(String[] args) {
//		AtomicInteger ai=new AtomicInteger();
//		InterruptSleepWait();
		InterruptBlocking();
	}
	
	public static void sleep100(){
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void InterruptBlocking(){
		// once the thread turn from running to blocking, such as waiting for an lock. 
		threadInterrupt ti=new threadInterrupt();
		threadInterrupt_w tw=new threadInterrupt_w(ti);
		threadInterrupt_m tm=new threadInterrupt_m(ti);
		
		Thread thread_w=new Thread(tw,"tw");
		Thread thread_m=new Thread(tm,"tm");
		
		thread_w.start();
		sleep100();
		
		thread_m.start();
		sleep100();
		
		thread_m.interrupt();

	}
	public static void InterruptSleepWait(){
		 threadInterrupt ti=new threadInterrupt();
		 
		 Thread t=new Thread(ti);
		 t.start();
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 t.interrupt();
	}

}
