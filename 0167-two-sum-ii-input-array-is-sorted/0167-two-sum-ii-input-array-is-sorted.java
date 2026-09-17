class Solution {
    public int BinarySearch(int[] numbers,int target,int low,int high)
    {
        if (low<=high)
        {
            int mid=low+(high-low)/2;
            if (numbers[mid]==target)
                return mid;
            else if (target>numbers[mid])
                return BinarySearch(numbers,target,mid+1,high);
            else
                return BinarySearch(numbers,target,low,mid-1);
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0;i<numbers.length;i++)
        {
            int t=target-numbers[i];
            int index=BinarySearch(numbers,t,i+1,numbers.length-1);
            if (index!=-1)
                return new int[]{i+1,index+1};
        }
        return new int[]{-1,-1};
    }
}