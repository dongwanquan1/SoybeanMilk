package arr;

public class OddAndEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] src={2, 8,7, 1, 3, 5, 6, 4};
		sortOddAndEven(src);
		printArray(src);
	}
	private static void printArray(int[] src){
		for(int i:src){
			System.out.print(i+",");
		}
		System.out.println(" ");
	}
	private static boolean isOdd(int i){
		boolean isOdd=false;
		if((i&1)==1)isOdd=true;
		return isOdd;
	}
	private static void swap(int[] src, int j,int k){
		int tmp=src[j];
		src[j]=src[k];
		src[k]=tmp;
	}
	public static void sortOddAndEven(int[] src){
		// cursor-1 check even number from left
		int length=src.length-1;
		int i=0,j=length;
		
		while(i<j){
			//find even number from left
			while( isOdd(src[i]) ){
				i++;
			}
			//find Odd number from right
			while(!isOdd(src[j])){
				j--;
			}
			// once find a couple, swap them 

		    if(i<j){ // when cursors starting move, they must not cross, but when stopping, they may cross, 
		    	// such as starting i=3,j=5, when stopping i=4,j=2
		    	swap(src,i,j);
		    }

		}
		
	}

}
