package arr;

public class MinimumDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void minimumSwap(int[] arr1,int[] arr2){
		int sum1=this.sumOfArray(arr1);
		int sum2=this.sumOfArray(arr2);
		int diff=Math.abs(sum1-sum2);
		if(sum1>sum2){
			minimumSwapWithOrder(arr1,arr2,diff);
		}else{
			minimumSwapWithOrder(arr2,arr1,diff);
		}
	}
	public void minimumSwapWithOrder(int[] A,int[] B,int diff){
		int anticipateDiff=-1;
		int tmp=0,target_i=0,target_j=0;
		
		for(int i=0;i<A.length;i++){
			for(int j=0;i<B.length;j++){
				tmp=A[i]-B[j];
				if(tmp>0&tmp<diff){
					
				}
			}
		}
		if(anticipateDiff==-1)return;
		
	}
	private void swap(int[] A,int index_a,int[] B, int index_b){
		int tmp=A[index_a];
		A[index_a]=B[index_b];
		B[index_b]=tmp;
	}
	private int sumOfArray(int[] arr){
		int sumValue=0;
		for(int i:arr){
			sumValue+=i;
		}
		return sumValue;
	}
}
