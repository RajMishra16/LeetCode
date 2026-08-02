class Solution
{
    public String removeDuplicateLetters(String s)
    {
        int[] freq = new int[26];
        Boolean[] visited = new Boolean[26];
        for(char ch : s.toCharArray())
            freq[ch-'a']++;
        StringBuilder stack = new StringBuilder();
        for(char ch : s.toCharArray())
        {
            freq[ch-'a']--;
            if(visited[ch-'a']!=null && visited[ch-'a'])
                continue;
            while(stack.length()>0 && stack.charAt(stack.length()-1)>ch && freq[stack.charAt(stack.length()-1)-'a']>0)
            {
                visited[stack.charAt(stack.length()-1)-'a'] = false;
                stack.deleteCharAt(stack.length()-1);
            }
            stack.append(ch);
            visited[ch-'a'] = true;
        }
        return stack.toString();
    }
}
