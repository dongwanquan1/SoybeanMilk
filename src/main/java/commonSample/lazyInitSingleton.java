package commonSample;

public class lazyInitSingleton {
	public volatile boolean init=false;
	private lazyInitSingleton(){
		init=true;
	}
		
		public static lazyInitSingleton getInstance() {
			return LazygHolder.lazyInitSingleton_instance;
		}
		
		private static class LazygHolder {			
			  public static final lazyInitSingleton lazyInitSingleton_instance = new lazyInitSingleton();
			  static{
				  System.out.println("lazyInitSingleton_instance is created "+lazyInitSingleton_instance.init);
			  }
		}
}
