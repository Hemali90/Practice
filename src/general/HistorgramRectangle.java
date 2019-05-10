package general;import java.util.Stack;


public class HistorgramRectangle {

	public static void main(String[] args)
	{
		int[] histos = {2,4,2,1};
		System.out.println("Largest rectangle size is "+LargestRectangle(histos));

		int[] histos2 = {2,4,2,1,10,6,10};
		System.out.println("Largest rectangle size is "+LargestRectangle(histos2));
		
		System.out.println("Largest rectangle size is "+maxHistogram(histos2));
		
	}
	
	public static int maxHistogram(int input[]){
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peek()] <= input[i]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peek() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peek() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    

	public static int LargestRectangle(int[] histos)
	{
		
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();
		int largestSize = 0;
		
		for(int i=0; i<histos.length; i++)
		{
			
			if(heights.isEmpty() || histos[i]>heights.peek())
			{
				heights.push(histos[i]);
				indexes.push(i);
			}
			else if(histos[i]<heights.peek())
			{
				int lastIndex = 0;
				while(!heights.isEmpty() && histos[i]<heights.peek())
				{
					lastIndex = indexes.pop();
					int tempAreaSize = heights.pop()*(i-lastIndex);
					if(largestSize<tempAreaSize)
						largestSize = tempAreaSize;
				}
				heights.push(histos[i]);
				indexes.push(lastIndex);
			}
		}
		while(!heights.isEmpty())
		{
			int tempAreaSize = heights.pop()*(histos.length - indexes.pop());
			if(largestSize<tempAreaSize)
				largestSize = tempAreaSize;
		}
		return largestSize;
	}
}

