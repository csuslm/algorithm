package scn1.algh.greedy;

import java.util.Arrays;

public class GreedyTopics {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        for(int i=0;i<s.length && start < g.length;i++) {
            if(s[i] >= g[start]) {
                start++;
                res++;
            }
        }
        return res;
    }
}
