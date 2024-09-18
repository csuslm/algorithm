package scn1.algh.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class GreedyTopics {

    public static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap<>();
        map.put("1","val");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        List<Integer> integers = list.subList(0, 2);
        for (Integer a : integers) {
            if(a == 1){
                list.add(19);
            }
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }
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
