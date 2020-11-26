package stringSamples;

public class PalindromeLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getPalindromeLength("lkjacdwewdcabade");
	}
	
	public static void getPalindromeLength(String str) {
		char[] oriStr=str.toCharArray();
		//first convert original string to split with #
		char[] newStr=new char[oriStr.length*2+1];
		// abc => #a#b#c#
	
		for(int i=0;i<oriStr.length;i++){
			newStr[2*i]='#';
			newStr[2*i+1]=oriStr[i];
		}
		// add last #, length n is from 0 to n-1
		newStr[oriStr.length*2]='#';
//System.out.println(new StringBuffer().append(newStr));		
		
		//this is the array of any spot's radius
		int [] rad = new int[newStr.length];
		//this is a known spot whose radius could cover 
		int id = -1;
		//the right end of id,in fact right=id+radius-1, minus 1 because radius contains spot itself.  
		int id_right = -1;
		for (int i = 0; i < newStr.length; i ++) {
            int r = 1; //init r to be 1, at least a spot have itself as a palindrome 
            if (i <= id_right) {//if the right side of a known spot radius could cover this spot
            	 // try to get a minimum radius of that
                r = Math.min( 
                		(rad[id]-(i - id)) // E1-----------id-----------i----E2 it's i to E2 
                    	, rad[id - (i-id)] // E1--i'-------id-----------i----E2 i'=id - (i-id),it's the radius of i'
                	);
            }// end if (i <= id_right)   

            // check could the minimum radius could extend more
            while (i - r >= 0 && i + r < newStr.length // the extension could't exceed left end nor right end
            		&& newStr[i - r] == newStr[i + r] //  compare left side and right side exceeded r
            		) {
                    r++; // extend one by one
            }

            //  now we get a radius of spot i
             
            rad[i] = r;
            // and check do me need to update the reference spot id
            // if the id_right more far than the old one, we will update it with the new one
            if (i + r - 1> id_right) {
            	id = i;
                id_right = i + r - 1;                   
            }

		} // end for (int i = 0; i < newStr.length; i ++)
		
//		get the max palindrome string,
		int max_radius=1;
		int max_spot=0;
		for(int i = 0; i < newStr.length; i ++){
			if(rad[i]>max_radius){
				max_radius=rad[i];
				max_spot=i;
			}
		}
		
		System.out.println("max parlingrome length is "+ (max_radius-1) );
		System.out.println("str is "+new StringBuffer().append(newStr).substring(max_spot-max_radius+1, max_spot+max_radius));
		
	}

}
