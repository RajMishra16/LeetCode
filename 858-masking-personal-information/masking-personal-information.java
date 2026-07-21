class Solution
{
    public String maskPII(String s)
    {
        if(s.indexOf('@')!=-1)
        {
            //Email
            s = s.toLowerCase();
            int at = s.indexOf('@');
            return s.charAt(0) + "*****" + s.charAt(at-1) + s.substring(at);
        }
        else
        {
            //Phone number
            StringBuilder digits = new StringBuilder();
            for(char ch : s.toCharArray())
            {
                if(Character.isDigit(ch))
                    digits.append(ch);
            }
            int n = digits.length();
            String local = "***-***-";
            local = local+digits.substring(n-4);
            if(n==10)
                return local;
            StringBuilder country = new StringBuilder("+");
            for(int i=0; i<(n-10); i++)
            {
                country.append('*');
            }
            country.append('-');
            return country+local;
        }
    }
}
