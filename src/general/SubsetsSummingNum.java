package general;
public class SubsetsSummingNum {

	private static void allSubsets(int num, String out) {
        if(num == 0){
            System.out.println(out);
        } 
            for(int i = 1; i <= num; i++)
                allSubsets(num - i, out + " " + Integer.toString(i));
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allSubsets(4, "");  
	}

}
