package stringSamples;

import java.util.HashMap;
import java.util.Map;


public class Bitwise {

	public static void main(String[] args) {

		
		System.out.println("reverse code    "+Integer.toBinaryString(11&10));
		System.out.println("source code     "+supplement0(Integer.toBinaryString((11&10)^11))); // source code
		System.out.println("reverse code    "+Integer.toBinaryString(-11&11)); //reverse code
//		System.out.println(getReverseCode(supplement0(Integer.toBinaryString(5))));
		// in Java negative integer = positive integer's complement code, and the first position must be 1
//		System.out.println("complement code "+Integer.toBinaryString(~2)); //complement code = reverse code +1

		if(true)return;
		//the max int's first position is 0, 
		System.out.println(Integer.MAX_VALUE+":::   "+supplement0(Integer.toBinaryString(Integer.MAX_VALUE)));
		// >> 1 move to right 1 position, and supplement 0 at left for positive number
		// for positive number, >>1 it's value = number*2,>>2 = number*4.....
		// and <<1 value=number/2,<<2 value=number/4
		System.out.println("**************************** 5 and 5>>1");
		System.out.println(supplement0(Integer.toBinaryString(5)));
		System.out.println(supplement0(Integer.toBinaryString(5>>1))); // source code
		// >> 1 move to right 1 position, and supplement 1 at left for negative number
		System.out.println("**************************** -5 ,-5>>1 and -5>>>1");
		System.out.println(Integer.toBinaryString(-5)); //reverse code
		System.out.println(Integer.toBinaryString(-5>>1)); //reverse code
		//>>>1 move to right 1 position, but supplement 0 for negative number
		System.out.println(supplement0(Integer.toBinaryString(-5>>>1)));
		
		System.out.println("**************************** byte,short,char,int,long ****************************");
		showDECS();
	}
	public static String getReverseCode(String src){
		char[] srcChar=src.toCharArray();
		int len = srcChar.length-1;//array start with 0
		int k=(len>>1)-1;//From head and trail approach to median, array start with 0
		boolean have_median_number=k+1==(len-k)?false:true;
		if(have_median_number){
			srcChar[k+1]=srcChar[k+1]=='0'?'1':'0';	
		}
		for (int i = k; i >= 0; i--) {//From head and trail approach to median
			char tmp=srcChar[i];;
			srcChar[i]=tmp=='0'?'1':'0';		
			srcChar[len-i]=srcChar[len-i]=='0'?'1':'0';
			
//System.out.println(i+":::"+srcChar[i]);	
//System.out.println(len-i+":::"+srcChar[len-i]);
		}
		
		return new StringBuilder().append(srcChar).toString();
	}
	public static String supplement0(String src){
		return supplement0(src,32);
	}
	public static String supplement0(String src,int length){
		int binaryLength=length;
		int supplmentL=binaryLength-src.length();
//  	example :  String.format("%04d", 99)
		if(supplmentL==0)return src;
		String ret=String.format("%0"+supplmentL+"d", 0)+src;
		
		return ret;
	}
	public static void showDECS(){
		byte b=Byte.MAX_VALUE;
		short s=Short.MAX_VALUE;
		char c=Character.MAX_VALUE;
		int i=Integer.MAX_VALUE;
		long l=Long.MAX_VALUE;
		
		System.out.println(supplement0(Integer.toBinaryString(b))+" byte");
		System.out.println(supplement0(Integer.toBinaryString(s))+" short");
		System.out.println(supplement0(Integer.toBinaryString(c))+" char");
		System.out.println(supplement0(Integer.toBinaryString(i))+" int");
		System.out.println(supplement0(Long.toBinaryString(l),64)+" long");
	}

}
