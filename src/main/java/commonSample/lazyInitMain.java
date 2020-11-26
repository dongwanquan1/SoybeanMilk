package commonSample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class lazyInitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		lazyInitSingleton ls=lazyInitSingleton.getInstance();
		
		//http://www.jianshu.com/p/2315dda64ad2  reflect invocation
//		http://www.jianshu.com/p/2315dda64ad2

		try {
			String className = "commonSample.lazyInitSingleton" ;
			Class clazz = Class.forName(className);
//		    Constructor constructor = clazz.getConstructor(); 
//			Object instance = constructor.newInstance(); //create a object
		    Method method = clazz.getMethod("getInstance", null);
		    //Method.invoke(Object target, Object … parameters)
		    Object o=method.invoke(null); 
		    System.out.println("Reflect -> " + ((lazyInitSingleton)o).init); 
		} catch (Exception e) { 
		    e.printStackTrace();
		} 
	}

}
