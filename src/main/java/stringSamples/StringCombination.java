package stringSamples;

import java.util.ArrayList;
import java.util.Collection;

public class StringCombination {
	char[] str = null;
	
	public static void main(String[] args) {
		
		StringCombination sc=new StringCombination("abc".toCharArray());
		sc.listAllCombination();
	}
	public StringCombination(char [] str){
		this.str=str;
	}
	public void listAllCombination (){
		int strLength=str.length;
		int max_placeholder=1<<strLength;
		for(int i=1;i<max_placeholder;i++){
			System.out.println(Translate2String(i));		
		}		
	}
	
	private  String Translate2String(int placeHolder){
		StringBuffer sb=new StringBuffer();
		int strLength=str.length;
		for(int i=0;i<strLength;i++){
			int onePlace=1<<i; //try every position
			if( (placeHolder&onePlace)!=0){ // 1101&0001,onePlace only have one place others are 0
				sb.append(str[i]);
			}
		}
		return sb.toString();
	}
}
