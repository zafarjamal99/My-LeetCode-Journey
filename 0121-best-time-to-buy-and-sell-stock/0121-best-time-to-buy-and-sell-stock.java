class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,l=0,r=1,max=0;
        while (r<prices.length)
        {
            if (prices[l]<prices[r])
            {
                profit=prices[r]-prices[l];
                max=max>profit?max:profit;
            }
            else
            {
                l=r;
            }
            r++;
        }
        return max;
    }
}