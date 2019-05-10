package general;import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Practice{
	class Node{
		String to;
		String from;
		Node(String to,String from){
			this.to=to;
			this.from=from;
		}
	}
	
	public List<String> iternery(Node node[]){
		HashMap<String,Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<node.length;i++){
			map.put(node[i].to,(map.get(node[i].to)==null?0:map.get(node[i].to)+1));
			map.put(node[i].from,(map.get(node[i].from)==null?0:map.get(node[i].from)+1));
		}
		Set<Map.Entry<String,Integer>> set= map.entrySet();
		Iterator it=set.iterator();
		String start="";
		while(it.hasNext()){
			Map.Entry<String,Integer> entry=(Map.Entry)it.next();
			if(entry.getValue()==1){
				start=entry.getKey();
				break;
			}
		}
		HashMap<String,String> graph=new HashMap<String,String>();
		for(int i=0;i<node.length;i++){
			graph.put(node[i].to, node[i].from);
		}
		List<String> returnList=new LinkedList<String>();
		returnList.add(start);
		
		while(graph.get(start)!=null){
			returnList.add(graph.get(start));
			start=graph.get(start);	
		}
		return returnList;
	}
}