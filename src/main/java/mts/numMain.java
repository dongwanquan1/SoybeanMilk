package mts;



public class numMain {

	public static void main(String[] args) {
		numIncreaser ni=new numIncreaser();
		numMonitor   nm=new numMonitor();
		ni.addObserver(nm);
		Thread t1=new Thread(ni,"numIncreaser");
		Thread t2=new Thread(nm,"numMonitor");
//		t1.start();
//		t2.start();
		
		ConcurrentHashMap();

	
	}
	
	public static void ConcurrentHashMap()
	  {
		int paramInt1=16;float paramFloat=0.75F;int paramInt2=16;



	    int i = 0;
	    int j = 1;
	    while (j < paramInt2) {
	      ++i;
	      j <<= 1;
	    }
	    int segmentShift = (32 - i);
	    int segmentMask = (j - 1);
	    
System.out.println("32 is  "+Integer.toBinaryString(32));
System.out.println("i= "+Integer.toBinaryString(i));		    
System.out.println("segmentShift is "+segmentShift);	
System.out.println("j= "+Integer.toBinaryString(j));	
System.out.println("segmentMask is "+Integer.toBinaryString(segmentMask));	


	    int k = paramInt1 / j;
	    if (k * j < paramInt1)
	      ++k;
	    int l = 2;
	    while (l < k) {
	      l <<= 1;
	    }
	    System.out.println("L = "+l);
	    //Segment localSegment = new Segment(paramFloat, (int)(l * paramFloat), (HashEntry[])new HashEntry[l]);

//	    Segment[] arrayOfSegment = (Segment[])new Segment[j];
//	    UNSAFE.putOrderedObject(arrayOfSegment, SBASE, localSegment);
//	    this.segments = arrayOfSegment;
	  }

}


 
