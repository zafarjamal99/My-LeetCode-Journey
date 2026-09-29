class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        int left = 0;

        for (int right = 0; right < n; right++) {

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[right]) {
                dq.removeLast();
            }

            dq.addLast(right);

            // Remove elements outside the window
            if (dq.getFirst() < left) {
                dq.removeFirst();
            }

            // Window size is k
            if (right - left + 1 == k) {
                ans[left] = nums[dq.getFirst()];
                left++;
            }
        }

        return ans;
    }
}