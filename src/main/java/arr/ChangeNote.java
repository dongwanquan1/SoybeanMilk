package arr;

public class ChangeNote {
	static int[] COINS={1,2,5,10};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k= getPermutation(3);
		System.out.println(k);
	}
	public static int getPermutation(int amount){
		int[] dp=new int[amount+1];
		dp[0] = 1;
		for (int i = 0; i < COINS.length; ++i){
		    for (int j = COINS[i]; j <= amount; ++j){
		    	dp[j] = dp[j]+dp[j - COINS[i]];
		    }
		}
		System.out.println(dp[amount]);
		return dp[amount];
	}

}
