class Solution
{
    public int singleNonDuplicate(int[] nums)
    {
        int low = 0, high = nums.length - 1;

        if (nums.length == 1)
            return nums[0];

        while (low < high)
        {
            int mid = (low + high) / 2;

            if ((mid & 1) == 1)   // Odd index
                mid = mid - 1;

            if (nums[mid] == nums[mid + 1])
                low = mid + 2;
            else
                high = mid;
        }

        return nums[low];
    }
}