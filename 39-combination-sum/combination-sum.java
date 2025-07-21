class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> currList,
                     List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(currList));
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];

            if (num > target) break;

            currList.add(num);

            dfs(candidates, target - num, i, currList, res);

            currList.remove(currList.size() - 1);
        }

    }
}