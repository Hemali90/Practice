package general;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
class GNode{
	String name;
	boolean visited=false;
	GNode(String n){
		name=n;
		visited=false;
	}
}

public class HashMapEx {
   HashMap<String,Integer[]> hm=new HashMap<String,Integer[]>();
   HashMap<GNode,LinkedList<String>> graph=new HashMap<GNode,LinkedList<String>>();
   public void example(){
	   Integer arr[]={1,5,6};
	   hm.put("A", arr);
	   Integer arr1[]={4,5,7};
	   hm.put("D", arr1);
	   Integer arr2[]={3,6,9};
	   hm.put("C", arr2);
	Set<Map.Entry<String,Integer[]>> set=hm.entrySet();
	for(Map.Entry<String, Integer[]> me:set){
		System.out.println("Key:"+me.getKey());
		Integer a[]=me.getValue();
		System.out.print(" Value:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");	
		}
		System.out.print("\n");
	}
	
   }
   public void graphex(){
	   System.out.println("Enter the number of nodes");
	   Scanner sc=new Scanner(System.in);
	   int num=sc.nextInt();
	   for(int i=1;i<=num;i++){
		   System.out.println("Enter the name of node "+i);
		   String str=sc.next();
		   System.out.println("Enter the number of neighnors");
		   int nbor=sc.nextInt();
		  LinkedList<String> ls=new LinkedList<String>();
		  for(int j=0;j<nbor;j++){
			  System.out.println("Enter neighbor "+(j+1));
			  String nb=sc.next();
			  ls.add(nb);
		  }
		  GNode g=new GNode(str);
		  graph.put(g, ls);
	   }   
	   System.out.println(graph);   
	   Set <Map.Entry<GNode, LinkedList<String>>> set =graph.entrySet();
	   //Stack<GNode> st=new Stack<GNode>();
	   for(Map.Entry<GNode, LinkedList<String>> me:set){
		   GNode key=me.getKey();
		   LinkedList<String> values=me.getValue();
		   System.out.println("Node "+key.name);
		   System.out.println("Neighbors");
		   //in index=0;
		   for(String nodes:values){
			   System.out.println(nodes);
		   }
		  
	   }
	   
	   sc.close();
	   
   }
   
   public void dfs(){
	   Set <Map.Entry<GNode, LinkedList<String>>> set =graph.entrySet();
	   Stack<GNode> st=new Stack<GNode>();
	   for(Map.Entry<GNode, LinkedList<String>> me:set){
		   GNode key=me.getKey();
		   if(key.visited==false){
			   st.push(key);
		   System.out.println(key.name);
		   key.visited=true;
		   }
		   
		   while(!st.isEmpty()){
			   GNode verify=st.pop();
			   LinkedList<String> nbr=graph.get(verify);
			   for(String nodes:nbr){
				 //  int index=0;
				   GNode gt=new GNode(nodes);
				   if(graph.containsKey(gt)){if(gt.visited==false)st.push(gt);}
				 
					  //System.out.println(nodes);
				  }
		   }
		   }
   }
   
   public boolean route(String a,String b){
	   
	   
	   Stack<GNode> st=new Stack<GNode>();
	   GNode first=new GNode(a);
	   st.push(first);
while(!st.isEmpty()){
	GNode check=st.pop();
	if(check.visited==false){
		System.out.println(check.name);
		check.visited=true;
	LinkedList<String> ll=graph.get(check);
	for(String s:ll){
		GNode g=new GNode(s);
		if(graph.containsKey(g)){
			if(g.visited==false){
			st.push(g);
			if(g.name.equals(b)){
				return true;
			}
		}
		}
		
	}
	
	}
    }
			   
		return false;   
   }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    HashMapEx ex=new HashMapEx();
    ex.example();
    ex.graphex();
    System.out.println("DFS");
    ex.dfs();
    System.out.println("Route");
    System.out.println(ex.route("A", "E"));
	}

}
