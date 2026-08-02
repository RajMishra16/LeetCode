class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 1, hi = Integer.MAX_VALUE, n = time.length;
        for(int i=0; i<n; i++)
        {
            hi = Math.min(hi, time[i]);
        }
        hi *= totalTrips;
        if(n==1)
            return (long)totalTrips*time[0];
        while(lo < hi)
        {
            long mid = (lo+hi) / 2;


            if (feasible(time, mid, totalTrips)>=totalTrips)
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }
    private int feasible(int[] time, long mid, int totalTrips)
    {
        int total = 0;
        for(int i=0; i<time.length; i++)
        {
            total += (mid/time[i]);
            if(total >= totalTrips)
                break;
        }
        // System.out.println(total);
        return total;
    }
}
