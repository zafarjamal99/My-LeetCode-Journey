class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++)
        {
            int t=temperatures[i];
            while (!stack.isEmpty() && t>temperatures[stack.peek()])
            {
                int previndex=stack.pop();
                res[previndex]=i-previndex;
            }
            stack.push(i);
        }
        return res;
    }
}