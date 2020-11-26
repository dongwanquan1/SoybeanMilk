package stringSamples;

public class BitwiseNextN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer n=0b10011;//Integer.parseInt("10111", 2);
//		Integer nextN=NextN(n);
		System.out.println(NbrOf1(n));
//		System.out.println(Integer.toBinaryString(nextN));
	}
	private static int NbrOf1(int n){
		int i=0;
		while(n!=0){
			n=n&(n-1);
			i++;
		}
		return i;

	}
	public static int NextN(int n){
		// n&(-n) could identity the last 1 at right end
		// because  ~n change the first right side from 1 to 0, and all sebsequent 0 to 1, such as 1100 change to 0011
		// when ~n+1, the Carry arithmetic will stop at that point, just change the first 0 to 1, above number change to 0100
		// when n&(-n) left side of that position must be opposite and right side of that position must all be 0, only that position both have a 1
		// and that is the reason why complement's complement is origin code
	    int x = n&(-n);  // got the latest 1 position
	    System.out.println(Integer.toBinaryString(n));
	    int t = n + x; // do Carry arithmetic at last 1 position,
	    System.out.println("after carry ari t::"+Integer.toBinaryString(t));
	    System.out.println("difference::"+Integer.toBinaryString(((n^t)/x)));
	    System.out.println(Integer.toBinaryString(((n^t)/x)>>2));
	    //n exclusive OR t means to find out the difference between 
	    //why >> number is 2 ? because when do Carry arithmetic a 1 move from end to top of the impacted positions
	    // n^t)/x is how may position are impacted like 1111 means 4 position, and >>2 means minus the top and end 2,
	    int ans = t | ((n^t)/x)>>2; // t is the minimum carried number, base on that 
	    return ans;
	}
}
