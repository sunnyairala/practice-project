package com.wipro.eb.entity;

public class Domestic extends Connection{
    
    public Domestic(int previousReading, int currentReading, float[] slabs) {
   	 super(previousReading, currentReading, slabs);
    }

    
    
    //slabs-3 -2.3,4.2,5.5
    //120->50-2.3  50-4.2 20->5.5
    //90->50	40
    @Override
    public float computeBill() {
   	 float amount=0;
   	 int consumed=currentReading-previousReading;
   	 if(consumed<=50) {
   		 amount=consumed*slabs[0];
   	 }
   	 //90
   	 else if(consumed>50 && consumed<=100) {
   		 amount=50*slabs[0]+(consumed-50)*slabs[1];
   		 //50*2.3        	90-50=40*4.2
   	 }
   	 else {
   	   amount=50*slabs[0]+50*slabs[1]+(consumed-100)*slabs[2];
   		 
   	 }
   	 return amount;
   	 
    }
}
