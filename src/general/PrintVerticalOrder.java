//import java.util.Map;
//
//import java.util.*;
//public class PrintVerticalOrder {
//
//	public static void printVerticalOrderUtil(TreeNode root ){
//        Map<Integer, List<Integer>> hashMap=new HashMap<Integer,List<Integer>>();
//        printVerticalOrder(root,hashMap,0);
//        Map<Integer, List<Integer>> treeMap=new TreeMap<Integer, List<Integer>>(hashMap);
//        printMap(treeMap);        
//    }
//    public static void printMap(Map<Integer,List<Integer>> map){
//        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
//            int key=entry.getKey();
//            List<Integer> list=map.get(key);
//            Iterator itr=list.iterator();
//            while(itr.hasNext()){
//                System.out.print(itr.next()+" "); 
//            }
//            System.out.println();
//        }
//    }
//    public static void printVerticalOrder(TreeNode root, Map hashMap, int position){
//        if(root==null)
//            return;
//        printVerticalOrder(root.left,hashMap,position-1);
//        printVerticalOrder(root.right, hashMap, position+1);
//        if(!hashMap.containsKey(position)){
//            List<Integer> list=new ArrayList<Integer>();
//            list.add(root.nodeValue);
//            hashMap.put(position, list);
//        } else{
//            List<Integer> list=(List)hashMap.get(position);
//            list.add(root.nodeValue);
//            hashMap.put(position, list);
//        }        
//    }
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
