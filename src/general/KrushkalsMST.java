package general;import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Edge implements Comparable<Edge>{
	int ed1;
	int ed2;
	Integer rank;
	public int compareTo(Edge b){
		return this.rank.compareTo(b.rank);
	}
}
public class KrushkalsMST {
	DisjointSet set=new DisjointSet();
	
public boolean checkDisjoint(Edge e){
	long root1 = set.findSet(e.ed1);
    long root2 = set.findSet(e.ed2);

    //check if the vertices are in same set or different set
    //if verties are in same set then ignore the edge
    if (root1 == root2) {
       return false;
    } else {
        //if vertices are in different set then add the edge to result and union these two sets into one 
        set.union(e.ed1, e.ed2);
        return true;
    }	
	}
	
public void KruskalMST(Edge edge[]){
	List<Edge> mst=new LinkedList<Edge>();
	Arrays.sort(edge);
	
	for(int i=0;i<edge.length;i++)
	{set.makeSet(edge[i].ed1);
	set.makeSet(edge[i].ed2);}
	
	for(int i=0;i<edge.length; i++){
		if(checkDisjoint(edge[i])){
			mst.add(edge[i]);
		}
	}
}
}
