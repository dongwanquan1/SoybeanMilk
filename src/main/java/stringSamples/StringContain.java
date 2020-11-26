package stringSamples;

public class StringContain {

	public static void main(String[] args) {
		// http://blog.csdn.net/xiao__gui/article/details/11701893
		/***************************
		 *  int ALLOW_SELECT = 1 << 0; // 0001
		 *  int ALLOW_INSERT = 1 << 1; // 0010 
		 *  int ALLOW_UPDATE = 1 << 2; // 0100
		 *  int ALLOW_UPDATE = 1 << 3; // 0100
		 *  
		 *  similar to above privilege expression, we could allocate 1 at a spot to present have an 
		 *  ‘A’ , 'B' , 'C' ......
		 *  A = 1 << 0; // 0001
		 *  B = 1 << 1; // 0010 
		 *  C = 1 << 2; // 0100
		 *  D = 1 << 3; // 0100
		 *  and put the spots together by  hashCode=A|B|C|D.....
		 *  and use & to compare 2 strings
		 *  if only consider upper case letters we could use int which has 32 length 
		 *  if need to consider case sensitive condition, we could use long which have 64 length
		 *  if more need to split to multiple spot expression variables
		 */   
		//string a contain any char of b, return true, if not return false
		String a="CBEFGHI";
		String b="zG";
		// char number is the same as unite code, and we could define them as '\u0000'----'\uFFFF' 
		// char 0-255 is the same as ASC code, A-65,Z-90,a-97 z-122, 
		Character Z='A'; 
		Character Z1='\u0041';
//		System.out.println(Z+"-"+Z1+"-"+(Z+0));
		System.out.println("a contains b is " +((getHashCode(a)|getHashCode(b))==getHashCode(a)));
		
		// find Anagram 
//		An anagram is a word or phrase formed by changing the order of the letters in another word or phrase. For example, 'triangle' is an anagram of 'integral'.
//		normally give you a direction (word list), ask you to find anagrams in it.

	}
	
	private static int getHashCode(String str){
System.out.println(" get hash code ");		
		int hash=0;
		char[] strArray=str.toCharArray();
		for(int i=0;i<strArray.length;i++){
System.out.print((strArray[i]-'A')+",");
			hash|=1<<(strArray[i]-'A');//not the value of A,but the position of A
		}
		return hash;
	}
	

}
