package mts;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {
	private final List<String> a=new ArrayList<String>();
	public ImmutableClass(){
		a.add("a");a.add("b");a.add("c");
	}
	public final boolean contain(String s){
		return a.contains(s);
	}
}
