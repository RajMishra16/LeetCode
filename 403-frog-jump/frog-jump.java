import java.util.*;

class Solution {

    public boolean canCross(int[] stones) {

        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for (int stone : stones)
            dp.put(stone, new HashSet<>());

        dp.get(0).add(0);

        for (int stone : stones) {

            for (int jump : dp.get(stone)) {

                for (int nextjump = jump - 1; nextjump <= jump + 1; nextjump++) {

                    if (nextjump > 0 && dp.containsKey(stone + nextjump))
                        dp.get(stone + nextjump).add(nextjump);
                }
            }
        }

        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}