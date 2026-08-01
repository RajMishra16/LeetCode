class Solution
{
    public int countConsistentStrings(String allowed, String[] words)
    {
        Boolean[] freq = new Boolean[26];
        for(char ch : allowed.toCharArray())
        {
            freq[ch-'a'] = true;
        }  
        int count = 0;
        for(String word : words)
        {
            Boolean flag = true;
            for(char ch : word.toCharArray())
            {
                if(freq[ch-'a'] == null)
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                count++;
        }
        return count;
    }
}
