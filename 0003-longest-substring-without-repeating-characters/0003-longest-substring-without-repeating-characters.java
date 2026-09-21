class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int l=0,r=0,length=0,max=0;
        for (r=0;r<s.length();r++)
        {
            
            while (set.contains(s.charAt(r)))
            {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max=max>(r-l+1)?max:r-l+1;
        }
        return max;
    }
}