package general;/*This program covers DFS 
 * and a program to find out whether there is route between two nodes.Have to 
 * work on the second program*/

import java.util.LinkedList;
//import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//import javax.swing.text.html.HTMLDocument.Iterator;

class Neighbor{
	LinkedList<String> neighbor;
	public Neighbor(LinkedList<String> l){
		neighbor=l;
	}
}

class Vertex{
	
	String name;
	Neighbor nb;
	boolean visited;
	public Vertex(String s,Neighbor n){
		
		name=s;
		nb=n;
		visited=false;
	}
	
}

public class Graph{
	
Scanner sc;
static Vertex v[];
private static Scanner sc1;
public Graph(int num){
	 v=new Vertex[num];
	sc = new Scanner(System.in);
	
	for(int i=0;i<v.length;i++){
		System.out.println("Enter the "+ (i+1) +" vertex name");
		String name=sc.next();
		System.out.println("Enter the number of neighbors");
		int neighbor=sc.nextInt();
		LinkedList<String> l=new LinkedList<String>();
		for(int j=0;j<neighbor;j++){	
			System.out.println("Enter the "+ (j+1)+" neighbor name");
			String n=sc.next();
			l.add(n);
		}
		Neighbor nlist=new Neighbor(l);
		v[i]=new Vertex(name,nlist);
	}
}

public void print(){
	for(int i=0;i<v.length;i++){
		String n=v[i].name;
		Neighbor list=v[i].nb;
		System.out.println("Vertex "+n);
		LinkedList<String> temp=list.neighbor;
		System.out.println("Neighbours");
		for(String listmem:temp){
			System.out.println(listmem);
		}
	}
}

/*public void dfs(Vertex vert){
	Neighbor n=vert.nb;
	LinkedList<String> l=n.neighbor;
    vert.visited=true;
    System.out.println("Visiting"+vert.name);
    for(String vname:l){
    	for(int i=0;i<v.length;i++){
    		if(v[i].name.equals(vname)){
    			if(v[i].visited==false){dfs(v[i]);}
    		}
    	}
    }*/
public void dfs(Vertex vert){
	Stack<Vertex> st=new Stack<Vertex>();
	if(vert.visited==false){
		st.push(vert);
	}
	while(!st.isEmpty()){
		Vertex n=st.pop();
		if(n.visited==false)System.out.println("Vertex"+n.name);
		Neighbor nn=n.nb;
		LinkedList<String> ln=nn.neighbor;
		Vertex verify;
		for(String vname:ln){
		verify=getVertex(vname);
		if(verify.visited==false){st.push(verify);}
		}
		n.visited=true;
	}
    
    
}

public void bfs(Vertex vert){
	
	LinkedList<Vertex> q=new LinkedList<Vertex>();
	q.add(vert);
	while(!q.isEmpty()){
		Vertex first=q.removeLast();
		if(first.visited==false){System.out.println("Vertex "+first.name );}
		Neighbor nbr=first.nb;
		LinkedList<String> ll=nbr.neighbor;
		for(String vname:ll){
			Vertex temp=getVertex(vname);
			if(temp.visited==false){q.add(temp);}
		}
		first.visited=true;
	}
}

public boolean route(Vertex a,Vertex b){
	
	Stack<Vertex> st=new Stack<Vertex>();
	st.push(a);
	while(!st.isEmpty()){
		Vertex temp=st.pop();//Remove top vertex from the stack
		System.out.println("Vertex "+ temp.name);
		Neighbor nb=temp.nb;
		LinkedList<String> ll=nb.neighbor;
		for(String str:ll){   //examine its neighbors to see if any of them is same as destination node
			Vertex vr=getVertex(str);
			if(vr.name.equals(b.name)){
				if(vr.visited==false)
				{System.out.println("Vertex "+b.name);
				return true;}
			}
			else{
				st.push(vr);
			}
			
		}
		temp.visited=true; //after the popped vertex is examined for all its neighbor nodes set it to visited
	}
	return false;
}


public Vertex getVertex(String name){
	for(int i=0;i<v.length;i++){
		if(v[i].name.equals(name)){
			return v[i];
		}
	}
	return null;
}



public static void main(String args[]){
	System.out.println("Enter the number of vertices");
	sc1 = new Scanner(System.in);
int num=sc1.nextInt();
	
	Graph g=new Graph(num);
	g.print();
	System.out.println("\nDFS");
	for(int i=0;i<v.length;i++){
	    if(v[i].visited==false)
		g.dfs(v[i]);}


for(int i=0;i<v.length;i++){
	v[i].visited=false;
}
System.out.println("\nRoute");
 System.out.println("There is a route?"+g.route(v[0], v[3]));
 for(int i=0;i<v.length;i++){
		v[i].visited=false;
	}

 System.out.println("\n\nBFS");
 for(int i=0;i<v.length;i++){
	    if(v[i].visited==false)
		g.bfs(v[i]);}


}
}