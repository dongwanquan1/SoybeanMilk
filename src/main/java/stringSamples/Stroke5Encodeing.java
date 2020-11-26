package stringSamples;

public class Stroke5Encodeing {
	 private static final int[] POSITION_FULL_PERMUTATION_NUMBER=new int[4];
	 private static final int[] POSITION_IDX_FROM=new int[4];
	 static{
		 POSITION_FULL_PERMUTATION_NUMBER[0]=25*25*25+25*25+25+1;
		 POSITION_IDX_FROM[0]=0;
		 POSITION_FULL_PERMUTATION_NUMBER[1]=25*25+25+1;
		 POSITION_IDX_FROM[1]=1;
		 POSITION_FULL_PERMUTATION_NUMBER[2]=25+1;
		 POSITION_IDX_FROM[2]=1;
		 POSITION_FULL_PERMUTATION_NUMBER[3]=1;	
		 POSITION_IDX_FROM[3]=1;
		 
	 }
	 public static int endcoding(String s){
		 char[] source=s.toCharArray();
		 int idx=0;
		 for(int i=0;i<s.length();i++){
			 int offset_nbr=source[i]-'a';
			 int current_start_index=POSITION_IDX_FROM[i]+offset_nbr*POSITION_FULL_PERMUTATION_NUMBER[i];
			 idx=idx+current_start_index;
		 }
System.out.println(s+" index is "+idx);		 
		 return idx;
	 }
	 private static String decoding(int idx){
		 StringBuilder sb=new StringBuilder();
		 int offset=0;
		 int remaining=idx;
		 int position=0;
		 do {
			 remaining=remaining-POSITION_IDX_FROM[position];
			 if(remaining==0){
				 sb.append('a');break;
			 };
			 offset=remaining/POSITION_FULL_PERMUTATION_NUMBER[position];
			 sb.append((char)('a'+offset));
			 remaining=remaining%POSITION_FULL_PERMUTATION_NUMBER[position];
			 position++;
		 } while (remaining>0);
		 
System.out.println("index "+idx+" correspond to "+sb.toString());
		 return sb.toString();
	 } 
	 public static void main(String[] args) {
		 endcoding("aaab");
		 decoding(16331);
	 }
	 
}
