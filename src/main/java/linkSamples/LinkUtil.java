package linkSamples;

import java.util.LinkedList;

public class LinkUtil {

	private LinkNode crossNode=new LinkNode("crossNode");
	
	private void createLineLink(LinkNode head,int length){
		createLineLink( head, length,false);
	}
	private void createLineLink(LinkNode head,int length,boolean crossed){
		LinkNode currentNode=head;
		String linkName=head.getNodeName();
		int crossPoint=length>>1;
		for(int i=0;i<length;i++){
			LinkNode tmp=new LinkNode(linkName+"-"+Integer.toString(i));
			if(crossed&&i==crossPoint){
				currentNode.setNextNode(crossNode);
				currentNode=crossNode;
			}
			currentNode.setNextNode(tmp);
			currentNode=tmp;
			
		}
	}
	private void createCycleLink(LinkNode head,int length){
		LinkNode currentNode=head;
		LinkNode jointNode=null;
		String linkName=head.getNodeName();
		int cyclePoint=length>>1;
		for(int i=0;i<length;i++){
			LinkNode tmp=new LinkNode(linkName+"-"+Integer.toString(i));
			currentNode.setNextNode(tmp);
			if(i==cyclePoint)jointNode=tmp;
			currentNode=tmp;
		}
		//link the tail to the jointNode
		currentNode.setNextNode(jointNode);
	}
	private LinkNode checkIsCycle(LinkNode header){
//		boolean isCycled = false;
		 LinkNode na=header;
//				 new LinkNode("A");
		 createCycleLink(na,21);
//		 createLineLink(na,21);
		 LinkNode goSLow=na;
		 LinkNode goFaster=na;
		 while(goSLow!=null&&goFaster!=null){
			 goSLow=goSLow.getNextNode();
			 goFaster=goFaster.getNextNode();
			 if(goFaster!=null ){
System.out.println("goSLow is "+goSLow.getNodeName()+", goFaster is "+goFaster.getNodeName());	
				 goFaster=goFaster.getNextNode();
			 }
		 
			 if(goSLow==goFaster){
				 return goSLow;
			 }
		 }
System.out.println("arrive to the bottom , it's a line link");		 
		return null;
	}
	/*
	 * method-1 joint point a=nr-x which means from header to a equals to the rests of cycle after catchPoint-x
	 * 
	 */
	private LinkNode getJointPointofCycle(){
		LinkNode na= new LinkNode("A");
		LinkNode meetPoint=checkIsCycle(na);
		if(meetPoint!=null){
			while(na!=meetPoint){
				na=na.getNextNode();
				meetPoint=meetPoint.getNextNode();
System.out.println("header move to "+na.getNodeName()+", meetPoint is "+meetPoint.getNodeName());	
			}
		}
System.out.println("Joint point of line and cycle is "+na.getNodeName());
		return na;
	}
	private LinkNode getJointPointofCycle2(){
		LinkNode na= new LinkNode("A");
		LinkNode catchPoint=checkIsCycle(na);
		
		return null;
	}
	private boolean checkIsCrossed(){
//		
		 LinkNode na=new LinkNode("A");
		 LinkNode nb=new LinkNode("B");
		 createLineLink(na,8,true);
		 createLineLink(nb,17,true);	
		 
		 LinkNode tailA=null,tailB=null;
		 
		 //loop link A and get the tail of A
		 while(na!=null){
			 tailA=na;
			 na=na.getNextNode();
		 }
		 // loop link B and get the tail of B
		 while(nb!=null){
			 tailB=nb;
			 nb=nb.getNextNode();
		 }
		 boolean isCrossed=(tailA==tailB);
System.out.println("is crossed ? "+ isCrossed);		 
		 return isCrossed;
	}
	private LinkNode getFirstIntersectNode(){
		 String link_str_1="",link_str_2="";
		 LinkNode na=new LinkNode("A");
		 LinkNode nb=new LinkNode("B");
		 LinkNode tmp=null;
		 createLineLink(na,7,true);
		 createLineLink(nb,17,true);
		 int l1=1, l2=1,length_gap=0;
		 tmp=na;
		 while(tmp!=null){
			 link_str_1+=","+tmp.getNodeName();
			 l1++;
			 tmp=tmp.getNextNode();
		 }
		 tmp=nb;
		 while(tmp!=null){
			 link_str_2+=","+tmp.getNodeName();
			 l2++;
			 tmp=tmp.getNextNode();
		 }
		 // move point to align 2 links
		 length_gap=l1-l2;
		 if(length_gap>0){
			 for(int i=0;i<length_gap;i++){
				 na=na.getNextNode();
			 }
		 }else{
			 length_gap=length_gap*-1;
			 for(int i=0;i<length_gap;i++){
				 nb=nb.getNextNode();
			 }
		 }
		 
		 while(na!=nb){
			 na=na.getNextNode();
			 nb=nb.getNextNode();
		 }
		 
System.out.println(link_str_1);
System.out.println(link_str_2);
System.out.println("First intersect node, "+na.getNodeName());

		 return na;
		 
	}
	public static void main(String[] args) {
		LinkUtil lu = new LinkUtil();
//		lu.checkIsCrossed();
//		lu.checkIsCycle();
		lu.getJointPointofCycle();
//		LinkedList list =new LinkedList();
//	list.iterator()
		
	}
}
