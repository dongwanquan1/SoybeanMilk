package stringSamples;


public class StringReverse {
	/*****************
	 * ask space complexity=O(1) which means only allow at most 1 variable 
	 * and time complexity=O(n) which means loop times can't bigger than original string length 
		since revert only need 1 variable and 1/2*N loop times, local revert+global revert totally need
		N loop times, this approach could meet the requirement 
		
	 * original ::           head_1+tail_1+head_2+tail_2
	 * step1 local revert::: tail_1+head_1+tail2+head_2
	 * step2 global revert:: head_2+tail_2+head_1+tail_2
	 * 
	 */
    public static void main(String[] args) {
    	String originStr="abcde";
//    	String str=new StringBuilder(originStr).reverse().toString();
//    	System.out.println(str);
    	String str1=reverseStr( // step3=cde+ab
    			               reverseStr( //step2= ba+edc
    			                         reverseStr(originStr,0,2), // step1=ba+cde
    			                         2,
    			                         originStr.length()
    			                         ),
    			               0,
    			               originStr.length()
    			               );
    		
System.out.println(str1);

		String str2=MoveToTrail_1(originStr);
System.out.println(str2);		
    }
    
    private static String reverseStr(String str,int start,int to){
    	char[] str_cs=str.toCharArray();
    	/***********
    	 * core idea:::: use Symmetric switching instead of move
    	 * ab*cd a<--exchange position-->d,b<--exchange position->c, * don't need to move
    	 * from middle to the end point
    	 * please refer to StringBuilder.reverse
    	 */
    	for(int i=(to-start-2)>>1;i>=0;i--){
    		char temp=str_cs[i+start];
    		str_cs[i+start]=str_cs[to-i-1]; // a[1],a[3] exchange,  a[0],a[4] exchange , a[2] in the middle no impact 
    		str_cs[to-i-1]=temp;    		
    	}
    	return new StringBuilder().append(str_cs).toString();
    }
    
    private static String MoveToTrail_1(String str){
    	/***********
    	 * core idea:::: use Symmetric switching instead of move
    	 * move ab to the end
    	 * step-1 reverse ab, abcdefg => ba--cdefg
    	 * step-2 reverse the rest cdefg bacdefg => ba--gfed
    	 * step-3 reverse the whole bagfed => defgab
    	 */
    	char[] str_cs=str.toCharArray();
    	reverseStrArray(str_cs,0,1);
    	reverseStrArray(str_cs,2,str.length()-1);
    	reverseStrArray(str_cs,0,str.length()-1);
    	return new StringBuilder().append(str_cs).toString();
    }

// from end point to middle, more clear way
    private static void reverseStrArray(char[] strArray,int start,int to){
    	while(start<to){
    		char tmp=strArray[start];
    		strArray[start]=strArray[to];
    		strArray[to]=tmp;
    		start++;
    		to--;
    	}
    }
    
}
