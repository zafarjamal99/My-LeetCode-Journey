class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0;
        Set<Integer> set=new HashSet<>();
        for (int num:nums)
        {
            set.add(num);
        }
        for (int num:set)
        {
            if (!set.contains(num-1))
            {
                int current=num,streak=0;
                while (set.contains(current))
                {
                    current++;
                    streak++;
                }
                res=Math.max(res,streak);
            }
        }
        return res;
    }
}