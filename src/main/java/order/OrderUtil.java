package order;

import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub {49,38,65,97,76,13,27,43,49};
//		49,38,65,97,76,13,27,43
//		int[] arraytoSort={10,9,10,0,8,9,6,7,3,4,7,2,4,3,10,1,0,6,5,2};
		int[] arraytoSort={12,18,38,29,-8,8,9,7,107,48,69,49,38,65,97,76,13,27,43};
//		insertSort(arraytoSort);
//		int[] result=countSort(arraytoSort);
		bucketSort(arraytoSort);
		System.out.println(stringValue(arraytoSort));
	}
	
	/* 4,8,2,5,7,0,9,1
	 * 4,8,2,5,7,0,9,1  i=1 compare 8 & 4
	 * 2,4,8,5,7,0,9,1  i=2 compare 2 & 8, then 2 & 4
	 * 2,4,5,8,7,0,9,1  i=3 compare 5 & 8  
	 */
	public static void insertSort(Integer[] arraytoSort ){
        int temp;
        for(int i = 1; i<arraytoSort.length; i++){// from head to tail
            for(int j = i; j>0; j--){ // from current element to head
                if( arraytoSort[j] < arraytoSort[j-1] ){ //compare current one with prior, if behind < prior,interchange
                    temp = arraytoSort[j];             //switch
                    arraytoSort[j] = arraytoSort[j-1];
                    arraytoSort[j-1] = temp;
                }else{
                	break;
                }   
            }   
        }
    }
	public static void bubbleSort(int[] arraytoSort){
		int temp;
		int lastExchange=0;
		int ready_end_point=0;
		 for(int i=0;i<arraytoSort.length-1;i++){ // from head to tail   
			 	if(lastExchange==-1)break;
			 	ready_end_point=lastExchange;
			 	lastExchange=-1;
//			 	System.out.println("next_end_point is :: "+next_end_point);			 	
	            for(int j=arraytoSort.length-1;j>ready_end_point;j--){
	                if(arraytoSort[j]<arraytoSort[j-1]){
	                	lastExchange=j;
	                	temp = arraytoSort[j];
	                    arraytoSort[j] = arraytoSort[j-1];
	                    arraytoSort[j-1] = temp;
	                }
	            }
	        }
	}
	
	public static void selectSort(int[] arraytoSort){ 
        for(int i = 0; i<arraytoSort.length-1; i++){
            int min = i;
            int temp;
            //find min, every loop minus-1
            for(int j = i+1; j<arraytoSort.length ;j++){
                if(arraytoSort[j] <arraytoSort[min]){
                    min = j;
                    }
            }
            //swap the min with top one at the rest of un-order sequence
            temp = arraytoSort[min];
            arraytoSort[min] = arraytoSort[i];
            arraytoSort[i] = temp;
        }
    }
	

	/*
	 *        1-2-3-4-5-6-7-8
	 *       1-2-3-4    5-6-7-8
	 *      1-2   3-4  5-6   7-8
	 *     1  2  3   4 5  6  7   8
	 */
	public static void merge_sort(int[] arraytoSort){
		int len = arraytoSort.length;
		int[] result = new int[len];
		merge_sort_recursive(arraytoSort, result, 0, len - 1);
	}
	private static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
		if (start >= end) return; // splitting already arrive to the bottom 
		int len = end - start;
		// split to 2 portions, start to mid and mid+1 to end point, do that again and again till there is only 1 element in a group 
		int mid = (len >> 1) + start;
		int start_part_1 = start, end_part_1 = mid;
		int start_part_2 = mid + 1, end_part_2 = end;
System.out.println("Segment ["+start+" - "+end+"], split to part_1 ["+start_part_1+"-"+end_part_1+"], and part_2["+start_part_2+"-"+end_part_2+"]");		
		merge_sort_recursive(arr, result, start_part_1, end_part_1);
		merge_sort_recursive(arr, result, start_part_2, end_part_2);
		// start sort, 
		int k = start;
		//compare 2 group, pop up the small one from top every time, remember always compare the top of that 2 portion
		while (start_part_1 <= end_part_1 && start_part_2 <= end_part_2)
			result[k++] = arr[start_part_1] < arr[start_part_2] ? arr[start_part_1++] : arr[start_part_2++];
		//once one group already exhaust, just copy the rest to the end 	
		while (start_part_1 <= end_part_1)result[k++] = arr[start_part_1++];//once group1 left elements
		while (start_part_2 <= end_part_2)result[k++] = arr[start_part_2++];//once group2 left elements
		//copy sorted elements back to original array 
		for (k = start; k <= end; k++)
			arr[k] = result[k];
	}
	
	/*
	 * quick sort
	 * */
	public static void quickSort(int[] arraytoSort){
		quickSort(arraytoSort,0,arraytoSort.length-1);
	}
	private  static void quickSort(int[] arraytoSort, int head, int tail){
		//{49,38,65,97,76,13,27,49}
        if (head == tail || arraytoSort == null || arraytoSort.length <= 1) {
            return;
        }
        //(head + tail) >>1
        int i = head, j = tail, pivot = arraytoSort[head];
System.out.print("partion["+i+" - "+j+"] | pivot value is "+pivot);        
        while (i <= j) {
            while (arraytoSort[i] <pivot) { //compare head to pivot
                i++;                
            }
            while (arraytoSort[j] > pivot) { //compare tail to pivot
                j--;
            }
            if (i < j) {
System.out.print(" | switch i="+i+" and j="+j);            	
                int t = arraytoSort[i];
                arraytoSort[i] = arraytoSort[j];
                arraytoSort[j] = t;
                i++;
                j--;
            } else if (i == j) {         	
  System.out.print(" | i from "+i+" move to "+ (i+1));
                ++i;
            }
        }
String s="";
for(int k:arraytoSort){
	s+=k+",";
}
System.out.print("  | after sort s is "+s);
 System.out.println("i="+ i+", j= "+j);    
 		 quickSort(arraytoSort, head, j);
         quickSort(arraytoSort, i, tail);
	}
	
	/*
	 * Heap sort
	 *
	 * */
	
	private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void maxHeapifyABranch(int[] arr,int parent,int len){
    	// heapify from bottom to top
        int left = (parent << 1) + 1; // 2n+1
        int right = left + 1;           // 2n+2
        int cMax = left;             // assume left is the bigger one between left and right
        
        if(left > len) return;       // left child out of range means parent already at the bottom
        //if only have left child, don't need to compare left and right,
        //compare left and right when both exist
        if(right <= len && arr[right] > arr[left]) // right exist, left must exist. compare them 
            cMax = right;
        if(arr[cMax] > arr[parent]){
            swap(arr,cMax, parent);      // swap parent and max of left and right
            // if parent go down to child position, need to check could the new value sustain the max-heap structure again,
            // because the value may be small enough to go down to the bottom 
            maxHeapifyABranch(arr,cMax, len);   
        }
    }
    public static void heapSort(int[] arraytoSort){

        int len = arraytoSort.length - 1;
        int start = (len - 1) >> 1; //we don't need to start from the last one or even the bottom layer, just star from the last second 
        for(int i = start; i >= 0; i--){//meapify from bottom to top
        	maxHeapifyABranch(arraytoSort,i, len);
        }
        
        /*
         * switch the last one and top one, so the top one (biggest) will go to the last position
         * remove the last position (biggest value) from the heap structure
         * and there is a new heap top, heapify from top again and get the biggest value of the new heap
         * until the last one left 
         */
        for(int i = len; i > 0; i--){
            swap(arraytoSort,0, i);
            maxHeapifyABranch(arraytoSort,0, i - 1);
        }
    }
    private static String stringValue(int []arr){
        String s="";
		for(int k:arr){
			s+=k+",";
		}
		if(s.length()>1)s.substring(0,s.length()-1);
		return s;
    }
    private static String stringValue(Integer []arr){
        String s="";
		for(int k:arr){
			s+=k+",";
		}
		if(s.length()>1)s.substring(0,s.length()-1);
		return s;
    }
	/*
	 * Counter sort
	 *
	 * */
    public static int[] countSort(int[] array){
		int[] result = new int[array.length];
		int min = 0, max = 10;
		//数组一共有几个distinct value
		int value_i = max - min + 1;
		//额外数组，用于统计value
		int value_statistic[] = new int[value_i];
		for(int i = 0; i < array.length; ++i){
			//value 基于 min 的 offset 做下标，statistic 存统计值，每个value有几个
			value_statistic[array[i]-min] += 1;
		}
System.out.println(stringValue(value_statistic));	

		//计算出每个value的结束位置
		for(int i = 1; i < value_statistic.length; ++i){
			value_statistic[i] = value_statistic[i] + value_statistic[i-1];
		}
System.out.println(stringValue(value_statistic));		
		for(int i = array.length-1; i >= 0; --i){
			//从每组的结束位置开始赋值，每次赋值减一，移动一格，因为数组从0开始，所以先减再赋值
			value_statistic[array[i]-min]=value_statistic[array[i]-min]-1; //找到合适的位置 
			result[value_statistic[array[i]-min]] = array[i];//直接放到这个位置
		}
		return result;
	}
    
    public static void bucketSort(int[] array){
    	int min=1,max=100,bucketSize=10,bucketNumbers=(max-min)/bucketSize+3;
    	List<List<Integer>> buckets= new ArrayList<List<Integer>>();
    	//create buckets
    	for(int i=0;i<bucketNumbers;i++){
    		buckets.add(new ArrayList<Integer>());
    	}
    	// allocate every element to a proper bucket
    	for (int element:array){
    		int bucket_index=-1;
    		if(element<min){ // put it to underflow bucket in case it's less than min
    			bucket_index=0;
    		}else if(element > max){ // put it to overflow bucket in case it's bigger then max
    			bucket_index=bucketNumbers-1;
    		}else{
    			bucket_index=(element-min)/bucketSize+1;
    		}
    		buckets.get(bucket_index).add(element);
    	}
    	
    	// sort every bucket
    	int arr_index=0;
    	int bucket_index=0;
    	for(List<Integer> bucket:buckets){
    		Object o=bucket.toArray();  
    		Integer[] tmp=bucket.toArray(new Integer[0]);
if(tmp!=null){System.out.println("bucket-"+(bucket_index++)+" , "+stringValue(tmp));}
    		insertSort(tmp);
    		//after sort, put the ordered elements into original array
    		for(int ele:tmp){  			
    			array[arr_index++]=ele;
    		}
    	}
    }
    
    public static void radixSort(int[] array){
    	
    }
    
}
