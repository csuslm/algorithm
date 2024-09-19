package scn1.algh.greedy;

import javax.management.monitor.Monitor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GreedyTopics {

    public static void main(String []args){
        Scanner sca=new Scanner(System.in);
        int n=sca.nextInt();
        int k=sca.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;++i){
            a[i]=sca.nextInt();
        }
        Arrays.sort(a);
        int l=0,r=0;
        int ans=0;
        while(r<n){
            if((a[r]-a[l])>k){
                l++;
            }
            //记录下最大的能选数字数量
            ans=Math.max(ans,r-l+1);
            //右指针移动
            r++;
        }
        System.out.println(ans);
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
