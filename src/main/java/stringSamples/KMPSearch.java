package stringSamples;

public class KMPSearch {
	
	public static void main(String[] args) {
		//
		//ABCDABDE
		GetNextArray("ABC1ABC2ABC1ABC1DD");
	}
	private static int[] GetNextArray(String patternStr){
		int sLen=patternStr.length();
		int[] nextArray=new int[patternStr.length()];
		char[] position=patternStr.toCharArray();
	    int k = nextArray[0] = -1;  // 初始化k
	    int j = 0;   // 模式串字符指针
	    while (j < sLen -1)  {   //核心： p[k]表示前缀，p[j]表示后缀  
	        if (k == -1){  //表示一次新的从头开始
	            nextArray[j+1] = 0;  //-1的下一个永远是0，比如第二位失配，肯定移动1位不需回退
	            k=0; //更新k大值为0
	            j=j+1;  // 光标后移
	            continue;
	        }  
	        // 如果前缀 p[k] 与后缀p[j] 相同，j+1的next 值就等于 k+1
	        // 例如 abcabd.在第二个a 之前 由于没有重复字符k 一直是0，
	        // 在第二个a的位置 发现 p[0]=p[3]='a' next[4]的值=0+1=1
	        if( position[j] == position[k]){
	        	 nextArray[j+1] = k+1; 
	             k=k+1;//update the maxvalue of K  
	             j=j+1;// cursor move on   
	            
	        }else{
	         // 如果前缀 p[k] 与 后缀  p[j] 不相同,重新开始。 k=next[k] 是为了不断的回归差异点
	         // 比如 abc1abc2abc1abc1 发现最后一个1跟2不同时，我们得到了一个 next[15]=7 
	         // 也就是退7个格，也就是从头数第8个出现差异了，回归的意思是返回去看看第8个字符的情况
	         // 因为有可能在前8个字符中，也有部分匹配，而第8个字符与其前面的第n个也对不上，而第n个恰好与p[15]能对上
	         // 第8个字符时，即p[7] 对应的 next值 next[7] 是3，说明确实有部分匹配，且最开头3个肯定没问题，
	         // 第8个字符对应的是第4个字符也就是 p[3]，p[15]跟p[7]对不上，也许跟p[3]能对上，
	         // 所以我们用 p[15] 继续跟 p[3] 比，对上了就在[p7]的k值3基础上加1
	         // 这个过程实际上相当于将 p[15] 带入到 p[7] 的场景，按p[7]的场景再次尝试
	            k = nextArray[k];  
	        }  
	    }
	    
	    // print out 
	    for(int i=0;i<sLen;i++){
	    	int nxt=nextArray[i];
	    	char p_k=' ';
	    	if(nxt>=0)p_k=position[nxt];
	    	System.out.println("p["+i+"] "+position[i]+" ,k=nxt["+i+"] is "+nxt+" ,P["+nxt+"] is "+p_k);
	    }
		return nextArray;
	}  
	
}
