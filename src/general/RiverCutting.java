package general;import java.util.HashMap; 
import java.util.Map; 

public class RiverCutting {

	

	/** 
	* @author shashi 
	* 
	*Constructing Bridges: 
	A River that cuts through a set of cities above and below it. Each city above the river is matched with a city below the river. 
	Construct as many Non-Crossing Bridges as possible. 
	Input: 
	Above Bank >> 7 4 3 6 2 1 5 
	Below Bank >> 5 3 2 4 6 1 7 
	are given in pairs: (7,5) (4,3) (3,2) (6,4) (2,6) (1,1) (5,7) 
	Output: 
	(1,1) (3,2) (4,3) (6,4) (7,5) 
	*/ 
	 

	public static void main(String[] args) 
	{ 
	//get the above and below banks 
	int aboveBank[]={7 ,4, 3, 6, 2, 1, 5}; 
	int belowBank[]={ 5, 3, 2, 4, 6, 1, 7}; 

	//now create a Map for storing Pairs 
	Map<Integer, Integer> myMap=new HashMap<Integer, Integer>(); 
	//base condition 
	if(aboveBank.length !=belowBank.length) 
	{ 
	//River flow is not correct way 
	System.out.print("Your river is not flowing in correct way"); 
	} 
	//if not 
	for(int i=0;i<aboveBank.length-1;i++)//you can also use below.length 
	{ 
	if(aboveBank[i]>=belowBank[i]) 
	{ 
	//pair for bridge is founded so add to map 
	myMap.put(aboveBank[i], belowBank[i]); 
	} 
	} 
	//now print map elements 
	for(Map.Entry<Integer, Integer> entry:myMap.entrySet()) 
	{ 
	int key=entry.getKey(); 
	int val=entry.getValue(); 
	System.out.print("("+key+","+val+")"+" " ); 
	} 

	} 
	
	

}
