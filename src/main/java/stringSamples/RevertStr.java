package stringSamples;

public class RevertStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="123456789";
		char[] strArray=s.toCharArray();
		reverseStr2(strArray);
		StringBuilder sb=new StringBuilder();
		String s1=sb.append(strArray).toString();
		System.out.println(s1);
	}
	
	private static void reverseStr2(char[] strArray){
		int start=0,to=strArray.length-1;
		int middle=(to-start)>>1;		
		for(int i=middle;i>=0;i--){
			char left=strArray[start+i];
			char right=strArray[to-i];
			strArray[start+i]=right;
			strArray[to-i]=left;
System.out.println((start+i)+":"+right+" , "+(to-i)+":"+left);			
		}
		
	}
	// from end point to middle, more clear way
    private static void reverseStrArray(char[] strArray){
    	int start=0,to=strArray.length-1;
    	while(start<to){
    		char tmp=strArray[start];
    		strArray[start]=strArray[to];
    		strArray[to]=tmp;
    		start++;
    		to--;
    	}
}


}
