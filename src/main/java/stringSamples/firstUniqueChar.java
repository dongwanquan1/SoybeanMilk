package stringSamples;

public class firstUniqueChar {
	/*
	 * give a string such as "abaccdeff", return b
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c=findUniqueChar("abaccdeffb");
		System.out.println("first unique char is "+c);
	}
	
	public static char findUniqueChar(String str){
		char uniqueC=0;
		char[] sourceChar=str.toCharArray();
		// if only have ascII visible chars use a fix length array, if not use hashmap instead
		int[] statistic_result=new int[128];
		for(char c:sourceChar){
			statistic_result[c]++;
		}
		for(char i=0;i<=128;i++){
			if(statistic_result[i]==1) return i;
		}
		return uniqueC;
	}

}
