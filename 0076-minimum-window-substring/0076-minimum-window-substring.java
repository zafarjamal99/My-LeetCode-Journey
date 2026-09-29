class Solution {
    public String minWindow(String s, String t) {
        if (t.length()>s.length())
            return "";
        int required=t.length();
        int left=0,right=0,start=0;
        int freq[]=new int[128];
        int minlength=Integer.MAX_VALUE;
        for (int i=0;i<t.length();i++)
            freq[t.charAt(i)]++;
        while (right<s.length())
        {
            char ch=s.charAt(right);
            if (freq[ch]>0)
                required--;
            freq[ch]--;
            right++;
            while (required==0)
            {
                if (right-left<minlength)
                {
                    minlength=right-left;
                    start=left;
                }
                char leftchar=s.charAt(left);
                freq[leftchar]++;
                if (freq[leftchar]>0)
                    required++;
                left++;
            }
        }
        if (minlength==Integer.MAX_VALUE)
            return "";
        return s.substring(start,start+minlength);
    }
}