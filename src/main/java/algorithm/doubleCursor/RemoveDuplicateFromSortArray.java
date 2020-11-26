package algorithm.doubleCursor;

public class RemoveDuplicateFromSortArray {
//N*logN
	public static int removeDuplicates(int[] srcArray) {
		if (srcArray.length < 2)return srcArray.length;
		
		int distinctNum = 1;
		for (int i = 1; i < srcArray.length; i++) {
			if (srcArray[i] != srcArray[i - 1]){
				srcArray[distinctNum] = srcArray[i];
				distinctNum++;
			}
				
		}
		int[] result=new int[distinctNum];
		System.arraycopy(srcArray, 0, result, 0, distinctNum);

		System.out.println(distinctNum);
		for(int i:result){
			System.out.print(i+",");
		}
		return distinctNum;
	}
//N平方，这个方法的思路是，从左到右依次判断，一旦发现元素有重复，就放弃这个元素
// 放弃的原因是，不管有多少重复的，最后一个肯定没有重复了，因为没人跟他重了 ·
	public static void solution2() {
		int[] array = {2,2,2, 3, 4, 4, 4, 8,9,2 };
		//out put
		String result="";
		int len = array.length;
		if (len < 2)
			return;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				 if (array[i] == array[j]){
					 i=i+1;
					 j=i;
					 continue;//如果发现当前i的值x与后面的重复，放弃当前的i,最后一个x肯定不会重，因为后面没了
				 }
				
			}
			 result=result+array[i]+",";
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		int[] src = {2,2, 3, 4, 4, 4, 8,9 };
//		removeDuplicates(src);
		solution2();
	}

}
