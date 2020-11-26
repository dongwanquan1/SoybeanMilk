package stringSamples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumStrWindow {
	//want the minimum subString from source which contains all the chars in target string
	//
	private static String sourceStr="lsansvkhscbdfouacwkljsdncasdsa;lfjebabccdwoinx,mn,jdcdaklwqewaohc,acbs[q[wqfjdsalakj[ndacsdbnf;weuoqcnanc,zmcbfejkhcpqawbqwfadls;fancas,vmn";
	private static String targetStr="abccd";
	public static String getMinStr(){
		char[] sourceChars=sourceStr.toCharArray();
		char[] targetChars=targetStr.toCharArray();
		int mod_counter_tgt=targetStr.length();
		//step-1 create a target dictionary
				Map<Character,Integer> tgt=new HashMap();
				Map<Character,Integer> processMap=new HashMap();
				for(char c:targetChars){
					Integer c_num=0;
					if((c_num=tgt.get(c))!=null){
						c_num++;
					}else{
						c_num=1;
						processMap.put(c,0);
					}
					tgt.put(c,c_num);
				}
		//step-2 prepare the legal char position indicator
				LinkedList<Integer> lcp=new LinkedList();

		//step-3 go through source string one by one
				int mod_counter=0;
				int start=0,end=0,min=sourceStr.length()+1;
				for(int i=0;i<sourceChars.length;i++){
					char c=sourceChars[i];
					Integer tgt_num=tgt.get(c);
					if(tgt_num==null)continue;// it's a illegal char skip it
					
					// it's a legal char,add it into position indicator
					lcp.add(i);
					//update counter in the process map
					int p_num=processMap.get(c)+1;
					processMap.put(c,p_num);
					//update mod_counter when fund a legal char, but don't update when fund more than we want
					if(p_num<=tgt_num)mod_counter++;
					
					//great! we fund a window,but still need to optimize it such as aaaaaabbbbc there are too much a and b
					if(mod_counter_tgt==mod_counter){ // check a legal sub string by mod counter
						int tgt_num_tmp=0,p_num_tmp=0;
						while(lcp.size()>0){
							int k=lcp.pop();	//pop up a position					
							char legalC=sourceChars[k];	//and get the corresponding char	
							tgt_num_tmp=tgt.get(legalC); // check the target # of that char
							p_num_tmp=processMap.get(legalC); // check the 
							processMap.put(legalC, p_num_tmp-1);//pass through the position, reduce counter	of that char in process Map
							
							if(tgt_num_tmp==p_num_tmp){ // when the processing count match up with target,good job, hit the target,we get a final sub string
								mod_counter--; //pass through a integrant element, reduce mod counter  
								if((i-k+1)<min){
									start=k;end=i; min=i-k+1;
								}
								break;//optimization complete, stop cursor 2 here, and go back to move cursor 1
							}
							
						}
					}
				}
System.out.println("start is "+start);		
System.out.println("end is "+end);
		return sourceStr.substring(start,end+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String minS=getMinStr();
		System.out.println(minS);
	}

}
