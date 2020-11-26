package commonSample;

public class DoubleCheckSingleton {
	private  static volatile DoubleCheckSingleton doubleCheckSingleton;
	
	private DoubleCheckSingleton(){
//		doubleCheckSingleton=null; 
	}
	//use local variable instance, could 
    public DoubleCheckSingleton getDoubleCheckSingleton() {
    	DoubleCheckSingleton instance = doubleCheckSingleton; // force syhc cache to memorty 
        if (instance == null) {
            synchronized(this) {
            	instance = doubleCheckSingleton;// force syhc cache to memorty 
                if (instance == null) {
                	doubleCheckSingleton = instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
	
}

