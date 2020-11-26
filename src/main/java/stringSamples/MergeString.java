package stringSamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MergeString {

	public static void main(String[] args) {
		MergeString ms=new MergeString();
		Object o=new Object();
		String[] src={"abc","bumnd","ef","g","dh","fk"};
		ms.mergeStr(src);
	}
	private  List<String> mergeStr(String[] src){
		//step-1 create dictionary 
		Map<Character,groupIndicator> dict=new HashMap<Character,groupIndicator>();
		groupIndicator[] groupDict=new groupIndicator[src.length];
		//step-2 merge group in dictionary
		for(int i=0;i<src.length;i++){
			//for each group create a group indicator
			groupIndicator gi=new groupIndicator(i);
			groupDict[i]=gi;
System.out.println("group "+i+" :: "+gi);			
			//check chars in current group
			char[] elements=src[i].toCharArray();
			for(char c:elements){
				//check every char,is that existing in dictionary or not
				groupIndicator linkedGroups=dict.get(c);			
				//if find a group could be lined, replace the group value with current one
				if(linkedGroups!=null) {
					gi.merge(linkedGroups,groupDict);
					// and linked group may have other groups were already linked such as when checking group-4 ,we find conflict with group-2,
					// but group 2 already linked to group-1
System.out.println(i+" find linked group "+linkedGroups);	
				}
				dict.put(c, gi);
			}
		}
		//step-3 re-allocate chars to merged groups, 
		Map<LinkedList<Integer>,StringBuilder> mergedGroups=new HashMap<LinkedList<Integer>,StringBuilder>();
		for(Entry<Character, groupIndicator> ele:dict.entrySet()){
			LinkedList<Integer> groupHash=ele.getValue().gi;
			char currentC=ele.getKey();
//System.out.println("group # is "+group_nbr+" char is "+currentC);			
			if(!mergedGroups.containsKey(groupHash)){
				StringBuilder newStr=new StringBuilder();
				newStr.append(currentC);
				mergedGroups.put(groupHash, newStr);
			}else{
				mergedGroups.get(groupHash).append(currentC);
			}
		}
		//step-4 and convert to string list
		List<String> restult=new ArrayList<String>();
		for(StringBuilder str:mergedGroups.values()){
			restult.add(str.toString());
System.out.println(str);			
		}
//		
		return null;
	}
	 class groupIndicator{
		private LinkedList<Integer> gi;
		groupIndicator(int i){
			this.gi=new LinkedList<Integer>();
			gi.add(i);
		}
		private void merge(groupIndicator indicator,groupIndicator[] groupDict){
			
			if(indicator.gi==gi)return;
			
			for(int i:indicator.gi){
				if(!gi.contains(i)){
					gi.add(i);
				}
			}
			
			for(int i:gi){
				groupIndicator linked=groupDict[i];
				if(linked!=this)linked.reLoad(this);
			}
			
		}
		private void reLoad(groupIndicator indicator){
			this.gi=indicator.gi;
		}
		public String toString(){
			return gi.toString();
		}
		
	}
}

