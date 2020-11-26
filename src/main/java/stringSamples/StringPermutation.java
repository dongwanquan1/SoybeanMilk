package stringSamples;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc";
		permutation(str.toCharArray(),0);
	}
	private static void permutation(char[] s,int from){
		if(s.length==1) { // only have one character
			System.out.println(s);
			return;
		}
        if(from == s.length-1){ // arrive to the last position and only have last position is not fixed, 
        	           // do need to swap anymore, just print
            System.out.println(s);
        } else{
                for(int i=from;i<=s.length-1;i++){
                	// swap the char at from position and sebsequent positions, 
                	// which means try any element at from position
                    swap(s,from,i);   
                    // from+1 means lock the first position and go to more deep, the next position, recursion again and again
                    permutation(s,from+1);
                    // after permutation reset to avoid mess up
                    swap(s,from,i);
//System.out.println("s reset is "+ new StringBuilder().append(s)+", from "+ from);                      
                    }
            }
        }
	
	
	private static void swap(char[] s,int i,int j){
		char tmp=s[i];
		s[i]=s[j];
		s[j]=tmp;
//		Thread.sleep(paramLong);
	}
	/**
	 * full combination of a set of character such as a,b and c have a full 
	 * combination a,b,c, ab,ac,bc and abc 
	 * leverage bit map to solve the combination problem, 
	 * if there are 3 character, we could use 000 to 111 identify 3 position, 
	 * and first position representative char-1, secondary representative char-2, third representative char-3
	 * first step we will create a loop from 0 to 111 which is 1<<charLength-1
	 * and inside the loop we need to pick up the position which is 1 means have value, there will be a inner loop
	 * 		for int j=0 to char length , and use 1<<j to representative a valued position such as 0010 
	 * 		and then & this value with outloop value like 1111101 & 0000100 ,so that to check first value contain a certain char or not
	 */
	private static void Combination(){}

}
