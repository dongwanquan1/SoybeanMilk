package arr;

import java.util.ArrayList;
import java.util.List;

public class Backpack01 {

	
	 class Valuable {
		int weight;
		int value;
		private Valuable(int w,int v){
			this.weight=w;
			this.value=v;
		}
		public String toString(){
			return "["+weight+","+value+"]";
		}
	}
	public int[][] getMaxValue(Valuable[] valuables,int BagCapacity){
		int v_nbr=valuables.length-1;
		int[][] maxValueCube=new int[v_nbr+1][BagCapacity+1];

		int weight_i;
		int value_i;
		for(int i=0;i<=v_nbr;i++){
			weight_i=valuables[i].weight;
			value_i=valuables[i].value;
			for(int v=0;v<=BagCapacity;v++){// list conditions of under every free spaces, so that next item could refer to  
				if(i==0||v==0){
					maxValueCube[i][v]=0;
System.out.print("i="+i+",v="+v+", "+maxValueCube[i][v]+"    ");					
					continue;
				}
				
				if(v<weight_i){ 
					// if the free space is not enough, which means could not drop this item in that small space,
					// inherit the maximum value from prior line  
					maxValueCube[i][v]=maxValueCube[i-1][v];
System.out.print("i="+i+",v="+v+", "+maxValueCube[i][v]+"    ");					
					continue;
				}
				
				if(v>=weight_i){
					//okay, now we have enough space for this item, for this space, need to compare didn't pick this item and 
					// pick it, maxValueCube[i-1][v] VS maxValueCube[i-1][v-weight_i]+value_i
					maxValueCube[i][v]=Math.max(maxValueCube[i-1][v], maxValueCube[i-1][v-weight_i]+value_i);
				}
System.out.print("i="+i+",v="+v+", "+maxValueCube[i][v]+"    ");				
			}
System.out.println(" ");			
		}
		return maxValueCube;
	}
	
	public List<Valuable> getPickedItems(Valuable[] valuables,int[][] max){ //backtrack
		List<Valuable> picked=new ArrayList<>();
		int i=max.length-1; //item numbers
		int w=max[0].length-1;// remained capacity
//		int remainValue=max[i][w]; // top value, reach the last item and had all capacity,no limit
		
		while(i>0){
			if (i>0&&max[i][w]==max[i-1][w]) { // means this item was not picked, max value was inherit from prior
				i--;
			}else{// this line value is no the same as prior one at capacity w, means it was picked
				Valuable tmpItem=valuables[i];
				picked.add(tmpItem);
				i--;//go to up layer
			    w=w-tmpItem.weight;	// go back to remaining weight column			
			}
		}
		

		return picked;
	}
/*
i=0,v=0, 0    i=0,v=1, 0    i=0,v=2, 0    i=0,v=3, 0    i=0,v=4, 0    i=0,v=5, 0    i=0,v=6, 0    i=0,v=7, 0     
i=1,v=0, 0    i=1,v=1, 0    i=1,v=2, 18    i=1,v=3, 18    i=1,v=4, 18    i=1,v=5, 18    i=1,v=6, 18    i=1,v=7, 18     
i=2,v=0, 0    i=2,v=1, 0    i=2,v=2, 18    i=2,v=3, 21    i=2,v=4, 21    i=2,v=5, 39    i=2,v=6, 39    i=2,v=7, 39     
i=3,v=0, 0    i=3,v=1, 0    i=3,v=2, 18    i=3,v=3, 21    i=3,v=4, 21    i=3,v=5, 39    i=3,v=6, 39    i=3,v=7, 39     
i=4,v=0, 0    i=4,v=1, 0    i=4,v=2, 18    i=4,v=3, 21    i=4,v=4, 27    i=4,v=5, 39    i=4,v=6, 45    i=4,v=7, 48     
max = 48
 */

	public static void main(String[] args) {
		Backpack01 bp=new Backpack01();
		int capacity=7;  
        int num=4;   
        Valuable[] valuables=new Valuable[num+1];
        valuables[0]=bp.new Valuable(0,  0);
        valuables[1]=bp.new Valuable(2, 19);
        valuables[2]=bp.new Valuable(3, 21);
        valuables[3]=bp.new Valuable(3, 18);
        valuables[4]=bp.new Valuable(4, 27);
        
        int[][] max=bp.getMaxValue(valuables, capacity);
        
System.out.println("max value at right bottom, max["+num+"]["+capacity+"] = "+max[num][capacity]);     
	List<Valuable> picked=bp.getPickedItems(valuables,max);
	
	for(Valuable v:picked)	{
		System.out.print(v+", ");
	}
	}
}
