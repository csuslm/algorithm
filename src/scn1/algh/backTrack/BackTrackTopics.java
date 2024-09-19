package scn1.algh.backTrack;

import java.util.ArrayList;
import java.util.List;

public class BackTrackTopics {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }

    public void backTrackCombine(List<Integer> state, int curNum, List<List<Integer>> res, int k, int n) {
        if (state.size() == k) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = curNum; i <= n - k + 1; i++) {
            state.add(i);
            backTrackCombine(state, i + 1, res, k, n);
            state.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }
    public void backTrack(List<Integer> states,int[] choices,List<List<Integer>> res){

    }

}
