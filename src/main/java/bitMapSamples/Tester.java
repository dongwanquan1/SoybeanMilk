package bitMapSamples;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {
	    /**
     * count how may 1 in a decimal integer
     * 
     */
	private static int NbrOf1(int n){
		int i=0;
		while(n!=0){
			n=n&(n-1);
			i++;
		}
		return i;

	}
    /**
     * Complete the function below.
     * DONOT MODIFY anything outside this function!
     */
    static int[] rearrange(int[] elements) {
    	int len=elements.length;  	
		Integer[] ele=new Integer[len];
	for(int i=0;i<len;i++){
		ele[i]=elements[i];
		System.out.println(i+ "=="+ele[i]);
	}
	Arrays.sort(ele, new Comparator<Integer>() {
        @Override
        public int compare(Integer p1,Integer p2) {       	
        	int n1=NbrOf1(p1);
        	int n2=NbrOf1(p2);      	
            if(n1> n2) return 1;
            if(n1< n2) return -1;
            if (n1==n2) {
            	if(p1>p2) return 1;
            	if(p1<p2) return -1;
            	if(p1==p2) return 0;
            }
            return 0;
            
        }
    });
	
	ArrayList<Integer> result=new ArrayList<Integer> ();
	Integer previous=null;
	Integer current=null;
	for(int i=0;i<len;i++){
		current=ele[i];
		if(!current.equals(previous)){
			result.add(current);
			previous=current;
		}
	}
	
	int len2=result.size();
	int[] resultArray=new int[len2];
	for(int i=0;i<len2;i++){
		resultArray[i]=result.get(i);
	}
	return resultArray;
    
}

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {

        int[] elements = {5
        		,5
        		,3
        		,7
        		,10
        		,14};
 
        
        // call rearrange function
        int[] results = rearrange(elements);
        
        for (int i = 0; i < results.length; i++) {
            System.out.println(String.valueOf(results[i]));
        }
    }
}