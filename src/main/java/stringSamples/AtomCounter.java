package stringSamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

public class AtomCounter {
	// count numbers of every atom in a molecular formula
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String molecule="S4(ON(Mg2C)2(Au2Si4)3)2".trim();

//		
		Map<String,Integer> results=getNbrsOfAtoms(molecule);
		for(Entry<String,Integer> ele:results.entrySet()){
System.out.println(ele.getKey()+"::"+ele.getValue());

		}
		
	}
	private static String getNextElement(String src){
		char[] carray=src.toCharArray();
		StringBuilder sb=new StringBuilder();
		boolean started=false;
		for(char c:carray){
			if(c=='('){
				if(started)break;
				sb.append(c);started=true;break;
			}
			if(c==')'){
				if(started)break;
				sb.append(c);started=true;continue;}
			if(c>='A' && c<='Z'){
				if(started)break;
				sb.append(c);started=true;continue;}
			if(c>='a' && c<='z'){sb.append(c);continue;}
			if(c>='0' && c<='9'){sb.append(c);continue;}
		}
		return sb.toString();
	}
	//merge a unit into the top of the stack
	private static void Recurrent2Parent(Stack<Map<String,Integer>> all,Map<String,Integer> unit,int multiplier){
		Map<String,Integer> top=all.peek();
		Set<Entry<String,Integer>> unit_elements =unit.entrySet();
		for(Entry<String,Integer> ele:unit_elements){
			String key=ele.getKey();
			Integer value=ele.getValue();
			if(top.containsKey(key)){
				top.put(key, top.get(key)+value*multiplier);
			}else{
				top.put(key,value*multiplier);
			}
		}
	} 
	private static Map<String,Integer> getNbrsOfAtoms(String molecule){
		// step-1 create a stack
		Stack<Map<String,Integer>> stack=new Stack<Map<String,Integer>>();
		Map<String,Integer> root=new HashMap<String,Integer>();
		stack.push(root);
		String mol=molecule.trim();
		while(mol.length()>0){
			String ele=getNextElement(mol);
System.out.println("Element is "+ele);			
			mol=mol.substring(ele.length());
			if(ele.startsWith("(")){
				//once meet a left Parentheses, means starting a new unit
				Map<String,Integer> newLayter=new HashMap<String,Integer>();
				stack.push(newLayter);
			}else if(ele.startsWith(")")){
				//once meet a right Parentheses, means ending a unit
				int multiplier_unit=1;
				if (ele.length()>1){
					multiplier_unit=Integer.parseInt(ele.substring(1));
				}
				// get current unit
				Map<String,Integer> current_unit=stack.pop();
				//recurrent to parent unit
				Recurrent2Parent(stack,current_unit,multiplier_unit);
			}else {
				// it's an Atom and may have multiplier in subsequent
				StringBuilder multiplierBuilder=new StringBuilder();
				char[] eleChars=ele.toCharArray();
				int atomMultiplier=1;
				for(int i=ele.length()-1;i>0;i--){
					char lastC=eleChars[i];
					if(lastC<'0' || lastC>'9') break;
					multiplierBuilder.insert(0,lastC );
				}
				String atomMultiplierS=multiplierBuilder.toString();
				String key=ele;
				if(!atomMultiplierS.equals("")){
					atomMultiplier=Integer.parseInt(atomMultiplierS);
					key=ele.substring(0,ele.length()-atomMultiplierS.length());
				}
				Map<String,Integer> top=stack.peek();
				if(top.containsKey(key)){
					top.put(key, top.get(key)+atomMultiplier);
				}else{
					top.put(key,atomMultiplier);
				}
				
			}
			
		}
		
		return root;
	}
	
}
