package arr;


public class MaxSebsequence {
	private int maxValue=0;
	private int max_start=0,max_end=0;
	private int[] src= {1, -2, 3, 30, -34, 7, 22, 10};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSebsequence ms=new MaxSebsequence();
		ms.getMax3();
		System.out.println(ms.maxValue);
		ms.printMaxSebsequence();
	}
	public void printMaxSebsequence(){
//		for(int i:maxSebsequence){
//			System.out.print(i+",");
//		}
		for(int i=max_start;i<=max_end;i++){
			System.out.print(src[i]+",");
		}
		System.out.println(" ");
	}
	public void getMax1(){
		getMax1(0);
	}
	public  void getMax1(int start){
		if(start==src.length)return;
		int sum=0;
		for(int i=start;i<src.length;i++){
			sum+=src[i];
			if(sum>maxValue){
				maxValue=sum;
				max_start=start;
				max_end=i;
			}
			
		}
		getMax1(start+1);
	}
	
	public void getMax3(){
		int sum=0;
		int tmp_start=0;
		for(int i=0;i<src.length;i++){
			
			if(sum<=0){// if it's debt don't join the team 
				tmp_start=i;//update a tmp start position
				sum=src[i]; // refresh sum
			}else{// the team have benefit, join it
				sum+=src[i];
			}
			
			// now we got a new sum value , if bigger than max, refresh max value and start,end position
			if(sum>maxValue) {
				maxValue=sum;
				max_start=tmp_start;
				max_end=i;
			}
		}
	}
	

}
