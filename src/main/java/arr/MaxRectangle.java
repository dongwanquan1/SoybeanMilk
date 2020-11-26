package arr;

public class MaxRectangle {
	int max_area;
	int max_start=0;
	int max_end=0;
	int[] planks={5,3,9,2,4,5,0,7,8,4,6};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxRectangle mr=new MaxRectangle();
		mr.getMaxArea(0, mr.planks.length-1);
		System.out.println(mr.max_area);
		mr.printList();
	}
	private void printList(){
		for(int i=max_start;i<=max_end;i++){
			System.out.print(planks[i]+",");
		}
		System.out.print(" ");
	}
	private  int getShortestIndex(int start,int end){
		int shortest=planks[end];
		int shortestIndex=end;
		for(int i=start;i<end;i++){
			if(planks[i]<shortest){
				shortest=planks[i];
				shortestIndex=i;
			}
		}
		return shortestIndex;
	}
	public void getMaxArea(int start,int end){
		if(start>end)return;
		int shortestIndex=this.getShortestIndex(start, end);
		int width=end-start+1;
		int area=planks[shortestIndex]*width;
		if(area>max_area){// once find a new maximum value, refresh max values
			max_area=area;
			max_start=start;
			max_end=end;
System.out.println(max_area+","+max_start+","+max_end);			
		}
		
		// detach the shortest plank, try left and right side
		getMaxArea(start,end-1);//left
		getMaxArea(shortestIndex+1,end);
	}
	
}
