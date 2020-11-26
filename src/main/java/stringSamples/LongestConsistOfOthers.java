package stringSamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//https://www.nowcoder.com/ta/cracking-the-coding-interview
public class LongestConsistOfOthers {
	private HashMap<String,Boolean> checkMap=new HashMap<String,Boolean>();
	private String[] strList;
//	private String currentStr=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("i = "+ ((9-0-2)>>1));		
		String[] arr={"ab","abc","bc","cd","abceefg","e","fg"};
		LongestConsistOfOthers lco=new LongestConsistOfOthers(arr);
		String s=lco.getLongestOne();
		System.out.println(s);
	}
	public LongestConsistOfOthers(String[] input){
		this.strList=input;
	}
	public String getLongestOne(){
		//step-1 sort by length desc
		Arrays.sort(strList, new Comparator<String>() {
					            public int compare(String o1, String o2) {
					                return o2.length() - o1.length();
					            }
					         }
		);
		//step-2 create check list
		for(String str:strList){
			checkMap.put(str, true);
		}
		//step-3 check element one by one
		for(String str:strList){
			checkMap.remove(str);
			if(couldBuild2(str)){
				return str;
			}
		}
		return null;
	}
	
	private boolean couldBuild(String tmp){	
		// if tail portion could be found,directly return true
		if(checkMap.containsKey(tmp)) return true;
		int tmpLength=tmp.length();
		//otherwise,continue split, checking header, and recursive checking tail
		for(int i=1;i<tmpLength;i++){
			String checking=tmp.substring(0,i);
			String remaining=tmp.substring(i,tmpLength);
			if(checkMap.containsKey(checking)&&couldBuild(remaining)){
				return true;
			}
		}
		return false;
	}
	
	private boolean couldBuild2(String tmp){
System.out.println("tmp is "+tmp);
		if(tmp.equals(""))return true;
		int tmpLength=tmp.length();
		for(int i=tmpLength;i>0;i--){
			String checking=tmp.substring(0,i);
			String remaining=tmp.substring(i,tmpLength);
			if(checkMap.containsKey(checking)&&couldBuild2(remaining)){
				return true;
			}
		}
		return false;
	}
	
}
