package general;//import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class MyGraph {
	LinkedList<LinkedList<String>> vertices=new LinkedList<LinkedList<String>>();
	private Scanner sc;
public MyGraph(){
	System.out.println("Enter the number of vertices<Integer>");
	sc = new Scanner(System.in);
	int numvertices=sc.nextInt();
	int j;
	for(int i=1;i<=numvertices;i++)
	{
		System.out.println("Enter the vertex name<String>");
		String name=sc.next();
		LinkedList<String> ll=new LinkedList<String>();
		ll.add(name);
		System.out.println("Enter the number neighbours<Integer>");
		int neighbours=sc.nextInt();
		for(j=1;j<=neighbours;j++){
			System.out.println("Enter "+j+"th neighbour");
			String nb=sc.next();
			ll.add(nb);
		}
		vertices.add(ll);
		//vertices.add(name);
	}
	
}

public void print(){
	
	//int ind=0;
	/*while(!vertices.isEmpty()){
		LinkedList<String> vertex=vertices.get(ind);
		boolean first=true;
		for(String nb:vertex){
			if(first){
				System.out.println("Vertex "+nb);
				first=false;
				System.out.print(" Neighbors ");
			}
			else{
				
				System.out.print(" -> "+nb);
			}
			
		}
		System.out.println("\n");
		ind++;
	}*/
	System.out.println(vertices);
}
	public static void main(String[] args) {
		MyGraph g=new MyGraph();
		g.print();
	}

}
