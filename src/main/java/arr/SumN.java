package arr;

import java.util.LinkedList;
import java.util.List;

public class SumN {
	public static LinkedList<Integer> route=new LinkedList<>();
	
	public static void main(String[] args) {
		sumOfNbr(11,7);
	}
	private static void push(int i){
		route.push(i);
		System.out.println(" push "+ i);
	}
	private static void pop(){
		int i=route.pop();
		System.out.println(" pop "+ i);
	}
	private static void printList(){
	String str="";
		for(Integer i:route){
			str+=i+",";
		}
	System.out.println("======================================="+str);	
	}
	public static void sumOfNbr(int sum, int n){
//	    horizontal ： select N, go sumOfNbr(sum - n, Math.min((sum-n),n-1));
//		vertical   : don't select N ,sumOfNbr(sum, n - 1);  
		
System.out.println("sum is "+sum+"  n is "+n);	
		if(sum==0)return; // horizontal direction reach to edge, means there is no space left
		if(n*(n+1)/2<sum){ //vertical direction reach to edge, means it's impossible to get the sum value from this value on
           System.out.println("               impossible!!");		
			return;
		}
	    
		push(n);
		if (sum == n){
			printList();
	    }
		sumOfNbr(sum - n, Math.min((sum-n),n-1));   //select n,push and pop the a bigger number, before and after go deep
		pop();
		
		sumOfNbr(sum, n - 1);   // don't select n, so for the same sum value, try n-1
	}
}
