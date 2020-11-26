package stringSamples;

public class PalindromeCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ABCCDCD
		//ABACDEDCABA
		PalindromeCut pc=new PalindromeCut();
		System.out.println("min cut is "+pc.minCut("ABAABA"));
	}
    public int minCut(String s) {  
        if(s == null||s.length() == 0)  
            return 0;  
        int[] dp=new int[s.length()];  
        //dp[i]存放(0,i)即以i的字符结束的子串的最小切割数，则所求为dp[s.length()-1];  
        dp[0]=0;//一个字符，不需要切割  
        for(int i=1;i<s.length();i++) {  
        	String tmp=s.substring(0,i+1);
        	boolean isP=is_palindrome(tmp);
            //dp[i]赋初值  
            dp[i]=isP?0:i;  
System.out.println("i="+i+", tem is "+tmp+" is_palindrome ? "+isP+" dp["+i+"]= i+1 = "+dp[i]);            
            //  1=<j<=i的子串回文判定  
            for(int j=i;j>=1;j--)  {  
            	tmp=s.substring(j,i+1);
            	isP = is_palindrome(tmp);
System.out.println("            sub tem is "+tmp+" is_palindrome ? "+isP);            	
            	if(is_palindrome(s.substring(j,i+1))){  
            	  int old_dpi=dp[i];
                  dp[i]=Math.min(dp[i],dp[j-1]+1);  
System.out.println("                    Min(dp["+i+"] = "+old_dpi+" ,dp["+(j-1)+"]+1 = "+(dp[j-1]+1)+")="+dp[i]);                                       
                }  
            }  
System.out.println(" ================================================================   ");             
        }  
        return dp[s.length()-1];  
    }  
    //判断回文串例程  
    public boolean is_palindrome(String s)  
        {  
        int begin=0;  
        int end=s.length()-1;  
        while(begin<end)  
            {  
            if(s.charAt(begin)!=s.charAt(end))  
                return false;  
            begin++;  
            end--;              
        }  
        return true;  
    } 

}
