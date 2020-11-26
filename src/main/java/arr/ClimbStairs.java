package arr;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long routeNbr=getRoutes3(10);
		System.out.println(routeNbr);
	}
	public static int getRoutes(int stairNbr){
		if (stairNbr==1)return 1;
		if (stairNbr==2)return 2;
		return getRoutes(stairNbr-1)+getRoutes(stairNbr-2);
	}
	public static long getRoutes2(int n){
		long[] stairNbrs=new long[n+1];
		stairNbrs[0]=0;stairNbrs[1]=1;stairNbrs[2]=2;
		for(int i=3;i<=n;i++){
			stairNbrs[i]=stairNbrs[i-1]+stairNbrs[i-2];
		}
		
		return stairNbrs[n];
	}
	public static long getRoutes3(int n){
		if (n==1)return 1;
		if (n==2)return 2;
		long[] dp=new long[3];
		dp[0]=1;dp[1]=2;dp[2]=0;
		for(int i=3;i<=n;i++){
			dp[2]=dp[1]+dp[0];
			dp[0]=dp[1];
			dp[1]=dp[2];
		}
		return dp[2];
	}
}
